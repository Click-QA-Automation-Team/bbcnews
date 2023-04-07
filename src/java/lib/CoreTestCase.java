package lib;

import junit.framework.TestCase;
import lib.ui.NavigationUI;
import lib.ui.factories.NavigationUIFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CoreTestCase extends TestCase {
    protected RemoteWebDriver driver;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        driver = Platform.getInstance().getDriver();
        this.systemPermissionAccept();
        this.closeNotificationAlert();
        this.openAndroidWebBBCNewsPage();
    }

    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }

    protected void clickToSystemBack() {
        driver.navigate().back();
    }

    public void systemPermissionAccept() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception ignored) {
        }
    }

    public void closeNotificationAlert() {
        if (Platform.getInstance().isAndroid()) {
            try {
                NavigationUI navigationUI = NavigationUIFactory.get(driver);
                navigationUI.clickToNoThanksBtn();
            } catch (Exception ignored) {
            }
        }
    }

    protected void openAndroidWebBBCNewsPage() {
        if (Platform.getInstance().isAndroidMobileWeb()) {
            driver.get("https://www.bbc.com/");
        } else {
            System.out.println("Method 'openWikiPageForMobileWeb' does nothing for platform: " + Platform.getInstance().getPlatformVar());
        }
    }
}
