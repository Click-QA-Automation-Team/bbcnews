package lib.ui.android;

import lib.ui.PopularPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidPopularPageObject extends PopularPageObject {
    static {
        POPULAR_BTN = "xpath://android.widget.LinearLayout[@content-desc='Popular']";
        THE_MOST_POPUlAR_ARTICLE = "xpath://*[@resource-id='bbc.mobile.news.ww:id/content_card_ordered_badge'][@text='1']";
    }

    public AndroidPopularPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
