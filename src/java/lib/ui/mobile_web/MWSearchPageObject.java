package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "css:div.orb-nav-section a#orbit-search-button";
        SEARCH_INPUT = "css:input#search-input";
        SEARCH_INPUT_SUBMIT_BTN = "css:button.ssrcss-1pgdoq4-Button";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://p[contains(@class, 'ssrcss-6arcww-PromoHeadline')]//span[text()='{SUBSTRING}']";
        SEARCH_CANCEL_BUTTON = "";
        ARTICLE_TITLE = "";
    }
    public MWSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
