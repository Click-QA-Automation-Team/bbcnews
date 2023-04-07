package lib.ui.android;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "id:bbc.mobile.news.ww:id/action_search";
        SEARCH_INPUT = "id:bbc.mobile.news.ww:id/search";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@text='{SUBSTRING}']";
        SEARCH_CANCEL_BUTTON = "id:bbc.mobile.news.ww:id/search_cancel";
        ARTICLE_TITLE = "id:bbc.mobile.news.ww:id/content_card_title";
    }

    public AndroidSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
