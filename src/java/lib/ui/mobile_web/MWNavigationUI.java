package lib.ui.mobile_web;

import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationUI extends NavigationUI {
    static {
        BBC_LOGO = "css:a#homepage-link";
        NO_THANKS = "xpath://*[@text='NO, THANKS.']";
    }
    public MWNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
