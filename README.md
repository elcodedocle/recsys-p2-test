recsys-p2-test
==============

Coursera UMN Intro to Recommender Systems - Programming Assigment 2 TestNG Test

To enable testng on your maven project add the following dependency to `pom.xml` dependencies section:
```xml
<dependency>
  <groupId>org.testng</groupId>
  <artifactId>testng</artifactId>
  <version>6.8.7</version>
</dependency>
```

The test runs for both unweighted and weighted profiles. Provided `CBFMain` and `Weighted` classes and `WeightedFlag` parameter annotation add support for profile type selection using the first command line argument (Values `weighted` or `unweighted`), as long as you properly inject the configuration parameter on `TFDIFItemScorer`'s constructor like this:
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
- More on lenskit dependency injection (Grapht): https://github.com/grouplens/grapht
- Grapht works pretty much like Google Guice, which has a very good [_getting started guide_](https://code.google.com/p/google-guice/wiki/GettingStarted)

Have fun.
