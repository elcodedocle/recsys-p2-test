recsys-p2-test
==============

Coursera UMN Intro to Recommender Systems - Programming Assigment 2 TestNG Test

To enable testng on your maven project add the following dependency to pom.xml dependencies section:
```xml
<dependency>
  <groupId>org.grouplens.lenskit</groupId>
  <artifactId>lenskit-core</artifactId>
  <version>${lenskit.version}</version>
</dependency>
<dependency>
```

The test runs for both unweighted and weighted profiles. Provided `CBFMain` and `Weighted` classes and `WeightedFlag` parameter annotation add support for profile type selection using the first command line argument (Values `weighted` or `unweighted`), as long as you properly inyect the configuration parameter on `TFDIFItemScorer`'s constructor like this:
```java
private final Boolean weighted;

@Inject
public TFIDFItemScorer(UserEventDAO dao, TFIDFModel m, @WeightedFlag Weighted weighted) {
    this.dao = dao;
    model = m;
    this.weighted = weighted.flag;
}
```
Then you will be able to modify the user profile creation section of the scorer on `TFIDFItemScorer` like this:
```java
if (weighted){
    if (p != null){
        //weighted profiler here
    }
} else {
    if (p != null && p.getValue() >= 3.5) {
        //unweighted (default) profiler here
    }
}
```
(More on guice dependency inyection at https://code.google.com/p/google-guice/wiki/GettingStarted)

Have fun.
