package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyNewsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyNews extends CoreTestCase {
    NavigationUI navigationUI;
    MyNewsPageObject myNewsPageObject;
    SearchPageObject searchPageObject;
    ArticlePageObject articlePageObject;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        navigationUI = NavigationUIFactory.get(driver);
        myNewsPageObject = MyNewsPageObjectFactory.get(driver);
        searchPageObject = SearchPageObjectFactory.get(driver);
        articlePageObject = ArticlePageObjectFactory.get(driver);
    }

    @Test
    public void testOpenMyNewsScreen(){
        if(Platform.getInstance().isAndroidMobileWeb()){
            navigationUI.waitForMainScreenOpens();
            myNewsPageObject.clickToBurgerBtn();
            myNewsPageObject.clickToMyNewsBtn();
            myNewsPageObject.waitForMyNewsWebScreenOpens();
            articlePageObject.swipeToFooter();
        }
    }

    @Test
    public void testSearchTopicInNewsSideList(){
        if(Platform.getInstance().isAndroidMobileWeb()){
            String topicNameToSearch = "Long Reads";

            navigationUI.waitForMainScreenOpens();
            myNewsPageObject.clickToBurgerBtn();
            myNewsPageObject.clickToMyNewsBtn();
            myNewsPageObject.waitForMyNewsWebScreenOpens();
            myNewsPageObject.clickOnNewsBurgerBtn();
            myNewsPageObject.waitForTopicNamePresentBySubstring(topicNameToSearch);
        }
    }

    @Test
    public void testAddAndRemoveOneTopicFromMyNews() {
        if(Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()){
            String topicNameToSearch = "Around the BBC";
            String topicNameToAdd = "BBC Worklife";

            navigationUI.waitForMainScreenOpens();
            myNewsPageObject.clickToMyNewsBtn();
            myNewsPageObject.waitForMyNewsEmptyScreenOpens();
            myNewsPageObject.clickToGetStartedBtn();
            myNewsPageObject.waitForAddTopicsWindow();
            myNewsPageObject.scrollToTopic(topicNameToSearch);
            myNewsPageObject.addTopicToMyTopicsList(topicNameToAdd);
            myNewsPageObject.waitForTopicNotPresent(topicNameToAdd);
            myNewsPageObject.clickToMyTopicsBtn();
            myNewsPageObject.waitForTopicPresent(topicNameToAdd);
            myNewsPageObject.clickToDeleteTopicBtn(topicNameToAdd);
            myNewsPageObject.waitForTopicNotPresent(topicNameToAdd);
        }
    }

    @Test
    public void testAddOpenAndRemoveTopic() {
        if(Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()){
            String topicNameToSearch = "World topics";
            String topicNameToAdd = "Australia";
            String topicTitle;

            navigationUI.waitForMainScreenOpens();
            myNewsPageObject.clickToMyNewsBtn();
            myNewsPageObject.waitForMyNewsEmptyScreenOpens();
            myNewsPageObject.clickToGetStartedBtn();
            myNewsPageObject.waitForAddTopicsWindow();
            myNewsPageObject.scrollToTopic(topicNameToSearch);
            myNewsPageObject.addTopicToMyTopicsList(topicNameToAdd);
            myNewsPageObject.waitForTopicNotPresent(topicNameToAdd);
            this.clickToSystemBack();
            myNewsPageObject.waitForTopicPresent(topicNameToAdd);
            myNewsPageObject.clickToAddedTopicInMyTopicsList(topicNameToAdd);
            myNewsPageObject.waitForNewsItemTitle();

            topicTitle = myNewsPageObject.getNewsItemTitleText();
            assertEquals(
                    "Article titles are not equal",
                    topicNameToAdd,
                    topicTitle
            );

            this.clickToSystemBack();
            myNewsPageObject.clickToTopicEditBtn();
            myNewsPageObject.clickToDeleteTopicBtn(topicNameToAdd);
        }
    }
}
