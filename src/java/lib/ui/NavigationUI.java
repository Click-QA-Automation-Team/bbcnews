package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUI extends MainPageObject {
    public static String
            BBC_LOGO,
            NO_THANKS;

    public NavigationUI(RemoteWebDriver driver) {
        super(driver);
    }

    public void waitForMainScreenOpens() {
        this.waitForElementPresent(
                BBC_LOGO,
                "Cannot find BBC logo by its locator: " + BBC_LOGO,
                10
        );
    }

    public void clickToNoThanksBtn() {
        this.waitForElementAndClick(
                NO_THANKS,
                "asd",
                10
        );
    }
}
