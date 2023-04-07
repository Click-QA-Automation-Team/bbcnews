package lib.ui.android;

import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidNavigationUI extends NavigationUI {

    static {
        BBC_LOGO = "id:bbc.mobile.news.ww:id/logo";
        NO_THANKS = "xpath://*[@text='NO, THANKS.']";
    }

    public AndroidNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
