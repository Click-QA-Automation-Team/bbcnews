package lib.ui.mobile_web;

import lib.ui.MyNewsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyNewsPageObject extends MyNewsPageObject {
    static {
        MY_NEWS_BTN = "css:ul.more-international>li.orb-nav-newsdotcom>a>span";
        BURGER_BTN = "css:a[aria-label='All BBC destinations menu']";
        NEWS_BURGER_BTN = "css:button.nw-c-nav__narrow-headerbutton--closed";
        MY_TOPICS_BTN = "";
        MY_NEWS_TITLE_TEXT = "";
        GET_STARTED_BTN = "";
        ADD_TOPICS = "";
        TOP_STORIES = "";
        TOPIC_NAME_BY_SUBSTRING_TPL = "xpath://a[contains(@class, 'nw-o-link')]/span[text()='{SUBSTRING}']";
        ADDED_TOPIC_NAME_BY_SUBSTRING_TPL = "";
        DELETE_TOPIC_BTN = "";
        NEWS_ITEM_TITLE = "";
        TITLE_ITEM_NAME = "";
        TOPIC_EDIT_BTN = "";
        EDIT_TOPIC_WINDOW_TEXT = "";
        NEWS_ITEM_CONTAINER = "";
        BBC_LOGO = "css:a#homepage-link";
        MY_NEWS_LOGO = "css:div.nw-c-news-navigation>a#brand";
    }
    public MWMyNewsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
