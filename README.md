recsys-p2-test
==============

Coursera UMN Intro to Recommender Systems - Programming Assigment 2 TestNG Test


In order to inyect dependecies to test both unweighted and weighted profiles modify TFDIFItemScorer constructor:

```java
    @Inject
    public TFIDFItemScorer(UserEventDAO dao, TFIDFModel m, @WeightedFlag Weighted weighted) {
        this.dao = dao;
        model = m;
        this.weighted = weighted.flag;
    }
```

Have fun.
