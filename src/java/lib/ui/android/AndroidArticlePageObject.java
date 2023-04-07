package lib.ui.android;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidArticlePageObject extends ArticlePageObject {
    static {
        SEARCH_ELEMENT_BY_TEXT_TPL = "xpath://*[@text='{SUBSTRING}']";
        ARTICLE_HEADLINE_TITLE = "id:bbc.mobile.news.ww:id/headline_title";
        FOOTER_ELEMENT = "id:bbc.mobile.news.ww:id/copyright_item_title";
        NEWS_ITEM_TITLE = "id:bbc.mobile.news.ww:id/activity_news_index_title";
    }

    public AndroidArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
