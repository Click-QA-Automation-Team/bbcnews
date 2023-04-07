package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class PopularPageObject extends MainPageObject {
    public static String
            POPULAR_BTN,
            THE_MOST_POPUlAR_ARTICLE,
            POPULAR_LIST_ITEM;

    public PopularPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void clickToPopularBtn() {
        this.waitForElementAndClick(
                POPULAR_BTN,
                "Cannot find popular button by its locator: " + POPULAR_BTN,
                5
        );
    }

    public void chooseTheMostPopularArticle() {
        this.waitForElementAndClick(
                THE_MOST_POPUlAR_ARTICLE,
                "Cannot find the most popular article by its locator: " + THE_MOST_POPUlAR_ARTICLE,
                5
        );
    }
    public void waitForPopularListItem(){
        this.waitForElementPresent(
                POPULAR_LIST_ITEM,
                "Cannot find popular list items container by its lacotor: "+ POPULAR_LIST_ITEM,
                10
        );
    }
}
