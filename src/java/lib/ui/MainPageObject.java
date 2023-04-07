package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import lib.CoreTestCase;
import lib.Platform;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Pattern;

public class MainPageObject extends CoreTestCase {

    protected RemoteWebDriver driver;

    public MainPageObject(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementPresent(String locator, String errorMessage, long timeoutInSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorMessage);
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    public WebElement waitForElementAndClick(String locator, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, errorMessage, timeoutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(String locator, String errorMessage, String value, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, errorMessage, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    public WebElement waitForElementAndClear(String locator, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, errorMessage, timeoutInSeconds);
        element.clear();
        return element;
    }

    public boolean waitForElementNotPresent(String locator, String errorMessage, long timeoutInSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    private void waitForArticleTitle(String articleTitle) {
        waitForElementPresent(
                articleTitle,
                "Cannot find any article title",
                10
        );
    }

    public void scrollUpMethod(int scrollDuration) {
        if (driver instanceof AppiumDriver) {
            TouchAction touchAction = new TouchAction((AppiumDriver) driver);
            // Set coordinates for scroll
            // Getting window size of device
            Dimension deviceWindowSize = this.driver.manage().window().getSize();
            // Set center-point of width
            int x = deviceWindowSize.width / 2;
            // from 80%-point of device window
            int startForY = (int) (deviceWindowSize.height * 0.8);
            // to 20%-point of device window
            int endForY = (int) (deviceWindowSize.height * 0.2);
            touchAction
                    .press(PointOption.point(x, startForY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(scrollDuration)))
                    .moveTo(PointOption.point(x, endForY))
                    .release().perform();
        } else {
            System.out.println("Method 'scrollUpMethod' does nothing for platform: " + Platform.getInstance().getPlatformVar());
        }
    }

    public void scrollDownMethod(int scrollDuration) {
        if (driver instanceof AppiumDriver) {
            TouchAction touchAction = new TouchAction((AppiumDriver) driver);
            // Set coordinates for scroll
            // Getting window size of device
            Dimension deviceWindowSize = this.driver.manage().window().getSize();
            // Set center-point of width
            int x = deviceWindowSize.width / 2;
            // from 80%-point of device window
            int startForY = (int) (deviceWindowSize.height * 0.2);
            // to 20%-point of device window
            int endForY = (int) (deviceWindowSize.height * 0.8);
            touchAction
                    .press(PointOption.point(x, startForY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(scrollDuration)))
                    .moveTo(PointOption.point(x, endForY))
                    .release().perform();
        } else {
            System.out.println("Method 'scrollDownMethod' does nothing for platform: " + Platform.getInstance().getPlatformVar());
        }
    }

    public void scrollUpToArticle(String locator, String errorMessage, String articleTitle, int maxNumberOfSwipes) {
        By by = this.getLocatorByString(locator);
        int swipes = 0;
        while (this.driver.findElements(by).size() == 0) {
            if (swipes > maxNumberOfSwipes) {
                waitForElementPresent(
                        locator,
                        "Cannot find element\n" + errorMessage,
                        0
                );
                return;
            }
            this.waitForArticleTitle(articleTitle);
            scrollUpMethod(1000);
            ++swipes;
        }
    }

    public void scrollUpToElement(String locator, String errorMessage, int maxNumberOfSwipes) {
        By by = this.getLocatorByString(locator);
        int swipes = 0;
        while (this.driver.findElements(by).size() == 0) {
            if (swipes > maxNumberOfSwipes) {
                waitForElementPresent(
                        locator,
                        "Cannot find element\n" + errorMessage,
                        0
                );
                return;
            }
            scrollUpMethod(1000);
            ++swipes;
        }
    }

    public void scrollDownToElement(String locator, String errorMessage, int maxNumberOfSwipes) {
        By by = this.getLocatorByString(locator);
        int swipes = 0;
        while (this.driver.findElements(by).size() == 0) {
            if (swipes > maxNumberOfSwipes) {
                waitForElementPresent(
                        locator,
                        "Cannot find element\n" + errorMessage,
                        0
                );
                return;
            }
            scrollDownMethod(1000);
            ++swipes;
        }
    }

    /* WEB */
    public void scrollWebPageUp() {
        if (Platform.getInstance().isAndroidMobileWeb()) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("window.scrollBy(0, 250)");
        } else {
            System.out.println("Method 'scrollWebPageUp' does nothing for platform: " + Platform.getInstance().getPlatformVar());
        }
    }

    public void scrollWebPageDown() {
        if (Platform.getInstance().isAndroidMobileWeb()) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("window.scrollBy(250, 0)");
        } else {
            System.out.println("Method 'scrollWebPageUp' does nothing for platform: " + Platform.getInstance().getPlatformVar());
        }
    }

    public void scrollWebPageTillElementNotVisible(String locator, String errorMessage, int maxSwipes) {
        int alreadySwiped = 0;
        WebElement webElement = this.waitForElementPresent(
                locator,
                errorMessage,
                5
        );
        while (!this.isElementLocatedOnTheScreen(locator)) {
            scrollWebPageUp();
            ++alreadySwiped;
            if (alreadySwiped > maxSwipes) {
                Assert.assertTrue(errorMessage, webElement.isDisplayed());
            }
        }
    }

    public void scrollWebPageDownTillElementNotVisible(String locator, String errorMessage, int maxSwipes) {
        int alreadySwiped = 0;
        WebElement webElement = this.waitForElementPresent(
                locator,
                errorMessage,
                5
        );
        while (!this.isElementLocatedOnTheScreen(locator)) {
            scrollWebPageDown();
            ++alreadySwiped;
            if (alreadySwiped > maxSwipes) {
                Assert.assertTrue(errorMessage, webElement.isDisplayed());
            }
        }
    }
    /* WEB */

    /* iOS */
    public boolean isElementLocatedOnTheScreen(String locator) {
        int elementLocationByY = this.waitForElementPresent(
                locator,
                "Cannot find element by locator.\nLocator: " + locator,
                1
        ).getLocation().getY();
        if (Platform.getInstance().isAndroidMobileWeb()) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            Object jsResult = javascriptExecutor.executeScript("return window.pageYOffset");
            elementLocationByY -= Integer.parseInt(jsResult.toString());
        }
        int screenSizeByY = this.driver.manage().window().getSize().getHeight();
        return elementLocationByY < screenSizeByY;
    }

    public void scrollUpToElementMethodForIOS(String locator, String errorMessage, int maxNumberOfSwipes) {
        int swipes = 0;
        while (!this.isElementLocatedOnTheScreen(locator)) {
            if (swipes > maxNumberOfSwipes) {
                Assert.assertTrue(errorMessage, this.isElementLocatedOnTheScreen(locator));
            }
            scrollUpMethod(200);
            ++swipes;
        }
    }

    public void scrollDownToElementMethodForIOS(String locator, String errorMessage, int maxNumberOfSwipes) {
        int swipes = 0;
        while (!this.isElementLocatedOnTheScreen(locator)) {
            if (swipes > maxNumberOfSwipes) {
                Assert.assertTrue(errorMessage, this.isElementLocatedOnTheScreen(locator));
            }
            scrollDownMethod(200);
            ++swipes;
        }
    }

    /* iOS */

    private By getLocatorByString(String locatorWithType) {
        String[] explodedLocator = locatorWithType.split(Pattern.quote(":"), 2);
        String byType = explodedLocator[0];
        String locator = explodedLocator[1];

        if (byType.equals("xpath")) {
            return By.xpath(locator);
        } else if (byType.equals("id")) {
            return By.id(locator);
        } else if (byType.equals("css")) {
            return By.cssSelector(locator);
        } else {
            throw new IllegalArgumentException("Can not get type of locator. Locator " + locatorWithType);
        }
    }
}