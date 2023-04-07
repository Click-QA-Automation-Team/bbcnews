package lib.ui;

import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ArticlePageObject extends MainPageObject {
    public static String
            SEARCH_ELEMENT_BY_TEXT_TPL,
            ARTICLE_HEADLINE_TITLE,
            NEWS_ITEM_TITLE,
            HEADER_ELEMENT,
            FOOTER_ELEMENT,
            ARTICLE_FOOTER_ELEMENT;

    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    /* TEMPLATE METHODS */
    private static String getResultSearchElementByText(String substring) {
        return SEARCH_ELEMENT_BY_TEXT_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATE METHODS */

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(
                ARTICLE_HEADLINE_TITLE,
                "Cannot find article title: " + ARTICLE_HEADLINE_TITLE,
                15
        );
    }

    public String getArticleTitle() {
        WebElement webElement = this.waitForTitleElement();
        return webElement.getText();
    }

    public void openArticleByTextSubstring(String substring) {
        String searchByText = this.getResultSearchElementByText(substring);
        this.waitForElementAndClick(
                searchByText,
                "Cannot find element by text " + searchByText,
                15
        );
    }

    public void swipeToHeader() {
        if(Platform.getInstance().isAndroid()){
            this.scrollDownToElement(
                    ARTICLE_HEADLINE_TITLE,
                    "Cannot find the beginning of article",
                    20
            );
        }
        else if (Platform.getInstance().isIOS()) {
            this.scrollDownToElementMethodForIOS(
                    ARTICLE_HEADLINE_TITLE,
                    "Cannot find the beginning of article",
                    10
            );
        } else if(Platform.getInstance().isAndroidMobileWeb()){
            this.scrollWebPageDownTillElementNotVisible(
                    ARTICLE_HEADLINE_TITLE,
                    "Cannot find the beginning of page",
                    10
            );
        }
    }

    public void swipeToFooter() {
        if (Platform.getInstance().isAndroid()) {
            this.scrollUpToElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    20
            );
        } else if (Platform.getInstance().isIOS()) {
            this.scrollUpToElementMethodForIOS(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    10
            );
        } else {
            this.scrollWebPageTillElementNotVisible(
                    FOOTER_ELEMENT,
                    "Cannot find the end of page",
                    10
            );
        }
    }
    public void swipeToArticleFooter(){
        this.scrollWebPageTillElementNotVisible(
                ARTICLE_FOOTER_ELEMENT,
                "Cannot find the end of article",
                10
        );
    }
}
