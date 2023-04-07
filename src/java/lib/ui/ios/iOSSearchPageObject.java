package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSSearchPageObject extends SearchPageObject {
    static {
        // Here should be declared iOS locators
    }

    public iOSSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
