package org.grouplens.mooc.cbf;
/**
 * User: Gael Abadin
 * Date: 30/09/13
 * Time: 01:09
 */

import java.util.List;

import org.grouplens.lenskit.RecommenderBuildException;
import org.grouplens.lenskit.scored.ScoredId;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TFIDFPersonalizedRecommenderTest {

    @DataProvider(name="mainInputArgsAndExpectedOutputProvider")
    public Object[][] createMainArgsSet(){
        return new Object[][]{
            new Object[]{
                new String[]{"unweighted", "4045", "144", "3855", "1637", "2919"},
                new Integer[][]{
                    {   11,   63,  807,  187, 2164},
                    {   11,  585,   38,  141,  807},
                    { 1892, 1894,   63, 2164,  604},
                    { 2164,  141,  745,  601,  807},
                    {   11, 1891,  640,  424,  180}
                },
                new Double[][]{
                    {0.3596,0.2612,0.2363,0.2059,0.1899},
                    {0.3715,0.2512,0.1908,0.1861,0.1748},
                    {0.4303,0.2958,0.2226,0.2119,0.1941},
                    {0.2272,0.2225,0.2067,0.1995,0.1846},
                    {0.3659,0.3278,0.1958,0.1840,0.1527}
                }
            },
            new Object[]{
                new String[]{"weighted", "4045", "144", "3855", "1637", "2919"},
                new Integer[][]{
                    {  807,   63,  187,   11,  641},
                    {   11,  585,  671,  672,  141},
                    { 1892, 1894,  604,  462,10020},
                    {  393,   24, 2164,  601, 5503},
                    {  180,   11, 1891,  424, 2501}
                },
                new Double[][]{
                    {0.1932,0.1438,0.0947,0.0900,0.0471},
                    {0.1394,0.1229,0.1130,0.0878,0.0436},
                    {0.2243,0.1465,0.1258,0.1050,0.0898},
                    {0.1976,0.1900,0.1522,0.1334,0.0992},
                    {0.1454,0.1238,0.1172,0.1074,0.0973}
                }
            }
        };
    }

    @Test(dataProvider="mainInputArgsAndExpectedOutputProvider")
    public void shouldReturnGivenRecommendations(String[] mainArgs, Integer[][] mids, Double[][] scores) throws RecommenderBuildException {
        CBFMain.main(mainArgs);
        List<ScoredId> recs;
        System.out.println(mainArgs.length);
        for (int i=0;i<mainArgs.length-1;i++){
            recs = CBFMain.getRecommendations(Long.parseLong(mainArgs[i+1]), mids.length);
            for (int j=0;j<mids.length;j++){
                assertEquals(recs.get(j).getId(),(long) mids[i][j]);
                assertEquals(scores[i][j], (double)Math.round(recs.get(j).getScore()*10000)/10000);
            }
        }
    }

}

