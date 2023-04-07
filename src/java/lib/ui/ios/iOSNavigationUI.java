package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSNavigationUI extends NavigationUI {
    static {
        // Here should be declared iOS locators
    }

    public iOSNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
