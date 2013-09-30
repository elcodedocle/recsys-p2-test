recsys-p2-test
==============

Coursera UMN Intro to Recommender Systems - Programming Assigment 2 TestNG Test


In order to test both unweighted and weighted profiles, use provided CBFMain and Weighted classes and Weighted flag parameter annotation and inyect profile type on TFDIFItemScorer constructor:

```java
    @Inject
    public TFIDFItemScorer(UserEventDAO dao, TFIDFModel m, @WeightedFlag Weighted weighted) {
        this.dao = dao;
        model = m;
        this.weighted = weighted.flag;
    }
```

More on guice dependency inyection at https://code.google.com/p/google-guice/wiki/GettingStarted

Have fun.
