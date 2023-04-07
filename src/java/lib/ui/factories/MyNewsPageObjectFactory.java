package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.MyNewsPageObject;
import lib.ui.android.AndroidMyNewsPageObject;
import lib.ui.ios.iOSMyNewsPageObject;
import lib.ui.mobile_web.MWMyNewsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyNewsPageObjectFactory {
    public static MyNewsPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidMyNewsPageObject(driver);
        } else if (Platform.getInstance().isIOS()){
            return new iOSMyNewsPageObject(driver);
        } else{
            return new MWMyNewsPageObject(driver);
        }
    }
}
