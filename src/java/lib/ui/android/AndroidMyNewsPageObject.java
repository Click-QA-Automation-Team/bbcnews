package lib.ui.android;

import lib.ui.MyNewsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidMyNewsPageObject extends MyNewsPageObject {
    static {
        MY_NEWS_BTN = "xpath://android.widget.LinearLayout[@content-desc='My News']";
        MY_TOPICS_BTN = "xpath://android.widget.LinearLayout[@content-desc='My Topics']";
        MY_NEWS_TITLE_TEXT = "xpath://*[@text='Add Topics to create your own personal news feed']";
        GET_STARTED_BTN = "id:bbc.mobile.news.ww:id/button";
        ADD_TOPICS = "xpath://android.widget.LinearLayout[@content-desc='Add Topics']";
        TOP_STORIES = "xpath://android.widget.LinearLayout[@content-desc='Top Stories']";
        TOPIC_NAME_BY_SUBSTRING_TPL = "xpath://*[@text='{SUBSTRING}']";
        ADDED_TOPIC_NAME_BY_SUBSTRING_TPL = "xpath://*[@resource-id='bbc.mobile.news.ww:id/title_item_name'][@text='{SUBSTRING}']";
        DELETE_TOPIC_BTN = "id:bbc.mobile.news.ww:id/button_tick";
        NEWS_ITEM_TITLE = "id:bbc.mobile.news.ww:id/activity_news_index_title";
        TITLE_ITEM_NAME = "id:bbc.mobile.news.ww:id/title_item_name";
        TOPIC_EDIT_BTN = "id:bbc.mobile.news.ww:id/menu_edit_followed";
        EDIT_TOPIC_WINDOW_TEXT = "xpath://*[@text='To reorder topics, hold down and move.']";
        NEWS_ITEM_CONTAINER = "id:bbc.mobile.news.ww:id/button_tick";
        BBC_LOGO = "id:bbc.mobile.news.ww:id/logo";
    }

    public AndroidMyNewsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
