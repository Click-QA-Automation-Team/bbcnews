package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.MyNews;
import tests.PopularArticle;
import tests.SearchArticle;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        MyNews.class,
        PopularArticle.class,
        SearchArticle.class
})

public class TestSuite {
}
