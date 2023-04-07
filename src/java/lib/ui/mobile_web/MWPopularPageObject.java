package lib.ui.mobile_web;

import lib.ui.PopularPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWPopularPageObject extends PopularPageObject {
    static {
        POPULAR_BTN = "xpath://div[contains(@id, 'site-container')]//button[text()='Most Read']";
        THE_MOST_POPUlAR_ARTICLE = "css:div#most-read-tab-container li[data-entityid='most-popular-read-1']";
        POPULAR_LIST_ITEM = "css:div.nw-c-most-read__items";
    }
    public MWPopularPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
