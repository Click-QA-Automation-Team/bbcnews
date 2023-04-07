package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyNewsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSMyNewsPageObject extends MyNewsPageObject {
    static {
        // Here should be declared iOS locators
    }

    public iOSMyNewsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
