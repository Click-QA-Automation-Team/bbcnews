package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchPageObject extends MainPageObject {

    public static String
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_INPUT_SUBMIT_BTN,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_CANCEL_BUTTON,
            ARTICLE_TITLE,
            TOPIC_TITLE;

    public SearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    /* TEMPLATES METHODS */
    public void waitForSearchInputPresent() {
        this.waitForElementPresent(
                SEARCH_INPUT,
                "Cannot find search init element after clicking on it",
                10
        );
    }

    public void initSearchInput() {
        this.waitForElementAndClick(
                SEARCH_INIT_ELEMENT,
                "Cannot find and click on search init element",
                10
        );
        this.waitForSearchInputPresent();
    }

    public void typeSearchLine(String searchLine) {
        this.waitForElementAndSendKeys(
                SEARCH_INPUT,
                "Cannot find and enter value into search input field",
                searchLine,
                10
        );
    }

    public void clearInputField(){
        this.waitForElementAndClear(
                SEARCH_INPUT,
                "Cannot find and clear value into search input filed",
                5
        );
    }

    public void waitForSearchResult(String substring) {
        String searchResultXpath = getResultSearchElement(substring);
        this.waitForElementPresent(
                searchResultXpath,
                "Cannot find search result with substring: " + substring,
                15
        );
    }

    public void clickOnCancelSearchBtn() {
        this.waitForElementAndClick(
                SEARCH_CANCEL_BUTTON,
                "Cannot find search cancel button",
                5
        );
    }

    public void waitForCancelButtonDisappears() {
        this.waitForElementNotPresent(
                SEARCH_CANCEL_BUTTON,
                "Search cancel button element is still present",
                5
        );
    }

    public void searchArticleBySwipingUp(String substring) {
        String searchResultXpath = getResultSearchElement(substring);
        if(Platform.getInstance().isAndroid() || Platform.getInstance().isIOS()){
            this.scrollUpToArticle(
                    searchResultXpath,
                    "Cannot find article by swiping: " + searchResultXpath,
                    ARTICLE_TITLE,
                    15
            );
        }if(Platform.getInstance().isAndroidMobileWeb()){
            this.scrollWebPageTillElementNotVisible(
                    searchResultXpath,
                    "Cannot find article by swiping: " + searchResultXpath,
                    15
            );
        }
    }

    public void clickOnSearchInputSubmitBtn(){
        this.waitForElementAndClick(
                SEARCH_INPUT_SUBMIT_BTN,
                "Cannot find search input submit button by its locator: "+SEARCH_INPUT_SUBMIT_BTN,
                5
        );
    }
}
