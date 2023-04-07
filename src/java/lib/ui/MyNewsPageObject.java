package lib.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyNewsPageObject extends MainPageObject {
    public static String
            MY_NEWS_BTN,
            MY_TOPICS_BTN,
            MY_NEWS_TITLE_TEXT,
            GET_STARTED_BTN,
            ADD_TOPICS,
            TOPIC_NAME_BY_SUBSTRING_TPL,
            ADDED_TOPIC_NAME_BY_SUBSTRING_TPL,
            DELETE_TOPIC_BTN,
            NEWS_ITEM_TITLE,
            TITLE_ITEM_NAME,
            TOPIC_EDIT_BTN,
            EDIT_TOPIC_WINDOW_TEXT,
            NEWS_ITEM_CONTAINER,
            BBC_LOGO,
            TOP_STORIES,
    // WEB LOCATORS
            MY_NEWS_LOGO,
            BURGER_BTN,
            NEWS_BURGER_BTN;

    public MyNewsPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    /* TEMPLATE METHODS */
    private static String getTopicNameElement(String substring) {
        return TOPIC_NAME_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getAddedTopicNameElement(String substring) {
        return ADDED_TOPIC_NAME_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    /* TEMPLATE METHODS */

    /* WEB */

    public void clickToBurgerBtn(){
        this.waitForElementAndClick(
                BURGER_BTN,
                "Cannot find burger button by its locator: "+BURGER_BTN,
                5
        );
    }

    public void clickOnNewsOption(){
        this.tryToClickOnElementWithFewAttempts(
                MY_NEWS_BTN,
                "Cannot click on news button by its locator: "+MY_NEWS_LOGO,
                5
        );
    }

    private void tryToClickOnElementWithFewAttempts(String locator, String errorMessage, int amountOfAttempts){
        int currentAttempts = 0;
        boolean needMoreAttempts = false;

        while (needMoreAttempts){
            try{
                this.waitForElementAndClick(
                        locator,
                        errorMessage,
                        1
                );
                needMoreAttempts = false;
            }catch (Exception e){
                if(currentAttempts > amountOfAttempts){
                    this.waitForElementAndClick(
                            locator,
                            errorMessage,
                            1
                    );
                }
            }
            ++currentAttempts;
        }
    }

    public void clickOnNewsBurgerBtn(){
        this.waitForElementAndClick(
                NEWS_BURGER_BTN,
                "Cannot find burger menu button which related with 'My' section by its locator: "+ NEWS_BURGER_BTN,
                5
        );
    }

    public void waitForTopicNamePresentBySubstring(String articleTitle){
        String neededArticle = this.getTopicNameElement(articleTitle);
        this.waitForElementPresent(
                neededArticle,
                "Cannot find needed article by its locator: "+neededArticle,
                5
        );
    }

    /* WEB */
    public void clickToMyNewsBtn() {
        this.waitForElementAndClick(
                MY_NEWS_BTN,
                "Cannot find my news button by its locator: " + MY_NEWS_BTN,
                5
        );
    }

    public void clickToMyTopicsBtn() {
        this.waitForElementAndClick(
                MY_TOPICS_BTN,
                "Cannot find my topics button by its locator: " + MY_TOPICS_BTN,
                5
        );
    }

    public void waitForMyNewsEmptyScreenOpens() {
        this.waitForElementPresent(
                MY_NEWS_TITLE_TEXT,
                "Cannot find add topic text by its locator: " + MY_NEWS_TITLE_TEXT,
                5
        );
    }

    public void waitForMyNewsWebScreenOpens(){
        this.waitForElementPresent(
              MY_NEWS_LOGO,
              "Cannot find news image logo by its locator: "+MY_NEWS_LOGO,
              15
        );
    }

    public void clickToGetStartedBtn() {
        this.waitForElementAndClick(
                GET_STARTED_BTN,
                "Cannot find get started button by its locator: " + GET_STARTED_BTN,
                5
        );
    }

    public void waitForAddTopicsWindow() {
        this.waitForElementPresent(
                ADD_TOPICS,
                "Cannot find add topics window by its locator: " + ADD_TOPICS,
                5
        );
    }

    public void scrollToTopic(String topic) {
        String topicName = this.getTopicNameElement(topic);
        this.scrollUpToElement(
                topicName,
                "Cannot find topic by its locator: " + topicName,
                10
        );
    }

    public void addTopicToMyTopicsList(String topic) {
        String topicName = this.getTopicNameElement(topic);
        this.waitForElementAndClick(
                topicName,
                "Cannot find topic by name: " + topicName,
                5
        );
    }

    public void waitForTopicNotPresent(String topic) {
        String topicName = this.getTopicNameElement(topic);
        this.waitForElementNotPresent(
                topicName,
                "This topic shouldn't be displayed: " + topicName,
                5
        );
    }

    public void waitForTopicPresent(String topic) {
        String topicName = this.getTopicNameElement(topic);
        this.waitForElementPresent(
                topicName,
                "Cannot find added topic by its locator: " + topicName,
                5
        );
    }

    public void waitForNewsItemTitle() {
        this.waitForElementPresent(
                NEWS_ITEM_TITLE,
                "Cannot find news item title by its locator: " + NEWS_ITEM_TITLE,
                5
        );
    }

    public WebElement waitForNewsItemTitleElement() {
        return this.waitForElementPresent(
                NEWS_ITEM_TITLE,
                "Cannot find news item title: " + NEWS_ITEM_TITLE,
                15
        );
    }

    public String getNewsItemTitleText() {
        WebElement webElement = this.waitForNewsItemTitleElement();
        return webElement.getText();
    }

    public void clickToDeleteTopicBtn(String topic) {
        this.waitForElementAndClick(
                DELETE_TOPIC_BTN,
                "Cannot find delete button by its locator: " + DELETE_TOPIC_BTN,
                5
        );
    }

    public void clickToAddedTopicInMyTopicsList(String topic) {
        String topicName = this.getAddedTopicNameElement(topic);
        this.waitForElementAndClick(
                topicName,
                "Cannot find topic by name: " + topicName,
                5
        );
    }

    public void clickToTopicEditBtn() {
        this.waitForElementAndClick(
                TOPIC_EDIT_BTN,
                "Cannot find topic edit button by its locator: " + TOPIC_EDIT_BTN,
                5
        );
    }
}
