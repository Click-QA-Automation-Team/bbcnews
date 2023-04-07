package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSArticlePageObject extends ArticlePageObject {
    static {
        // Here should be declared iOS locators
    }
    public iOSArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
