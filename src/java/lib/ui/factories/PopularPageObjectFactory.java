package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.PopularPageObject;
import lib.ui.android.AndroidPopularPageObject;
import lib.ui.ios.iOSPopularPageObject;
import lib.ui.mobile_web.MWPopularPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PopularPageObjectFactory {
    public static PopularPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidPopularPageObject(driver);
        } else if (Platform.getInstance().isIOS()) {
            return new iOSPopularPageObject(driver);
        } else {
            return new MWPopularPageObject(driver);
        }
    }
}
