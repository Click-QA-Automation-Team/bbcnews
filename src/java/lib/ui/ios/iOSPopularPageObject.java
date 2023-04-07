package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.PopularPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSPopularPageObject extends PopularPageObject {
    static {
        // Here should be declared iOS locators
    }

    public iOSPopularPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
