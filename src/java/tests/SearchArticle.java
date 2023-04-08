package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class SearchArticle extends CoreTestCase {
    //NavigationUI navigationUI;
    //SearchPageObject searchPageObject;
    //ArticlePageObject articlePageObject;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        navigationUI = NavigationUIFactory.get(driver);
        searchPageObject = SearchPageObjectFactory.get(driver);
        articlePageObject = ArticlePageObjectFactory.get(driver);
    }

    @Test
    public void testSearchArticle() {
        String articleTitle;
        String searchText = "Sony";
        String searchArticle = "The Everyday Hustle with Sonya Barlow";

        if(Platform.getInstance().isAndroidMobileWeb()){
            navigationUI.waitForMainScreenOpens();
            searchPageObject.initSearchInput();
            searchPageObject.typeSearchLine(searchText);
            searchPageObject.clearInputField();
            searchPageObject.typeSearchLine(searchText);
            searchPageObject.clickOnSearchInputSubmitBtn();
            articlePageObject.openArticleByTextSubstring(searchArticle);
            articleTitle = articlePageObject.getArticleTitle();
            assertEquals(
                    "Article titles are not equal",
                    searchArticle,
                    articleTitle
            );
            this.clickToSystemBack();
            searchPageObject.waitForSearchInputPresent();
        }
        if(Platform.getInstance().isAndroid() || Platform.getInstance().isIOS()){
            navigationUI.waitForMainScreenOpens();
            searchPageObject.initSearchInput();
            searchPageObject.typeSearchLine(searchText);
            searchPageObject.waitForSearchResult(searchArticle);
            searchPageObject.clickOnCancelSearchBtn();
            searchPageObject.waitForCancelButtonDisappears();
            searchPageObject.typeSearchLine(searchText);
            searchPageObject.waitForSearchResult(searchArticle);
            articlePageObject.openArticleByTextSubstring(searchArticle);
            articleTitle = articlePageObject.getArticleTitle();
            assertEquals(
                    "Article titles are not equal",
                    searchArticle,
                    articleTitle
            );
            this.clickToSystemBack();
            searchPageObject.waitForSearchInputPresent();
        }
    }

    @Test
    public void testSearchArticleBySwiping() {
        String articleTitle;
        String searchText = "Asia";
        String searchArticle = "Weather Bulletin: Asia";

        navigationUI.waitForMainScreenOpens();
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchText);

        if(Platform.getInstance().isAndroidMobileWeb()){
            searchPageObject.clickOnSearchInputSubmitBtn();
        }

        searchPageObject.searchArticleBySwipingUp(searchArticle);
        articlePageObject.openArticleByTextSubstring(searchArticle);
        articleTitle = articlePageObject.getArticleTitle();
        assertEquals(
                "Article titles are not equal",
                searchArticle,
                articleTitle
        );
        articlePageObject.swipeToFooter();
        articlePageObject.swipeToHeader();
        this.clickToSystemBack();
        searchPageObject.waitForSearchInputPresent();
    }
}
