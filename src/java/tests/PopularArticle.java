package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MyNewsPageObject;
import lib.ui.NavigationUI;
import lib.ui.PopularPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyNewsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.PopularPageObjectFactory;
import org.junit.Test;

public class PopularArticle extends CoreTestCase {
    PopularPageObject popularPageObject;
    NavigationUI navigationUI;
    ArticlePageObject articlePageObject;
    MyNewsPageObject myNewsPageObject;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        popularPageObject = PopularPageObjectFactory.get(driver);
        navigationUI = NavigationUIFactory.get(driver);
        articlePageObject = ArticlePageObjectFactory.get(driver);
        myNewsPageObject = MyNewsPageObjectFactory.get(driver);
    }

    @Test
    public void testReadTheMostPopularArticle() {
        navigationUI.waitForMainScreenOpens();
        if(Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()){
            popularPageObject.clickToPopularBtn();
            popularPageObject.chooseTheMostPopularArticle();
            articlePageObject.swipeToFooter();
            articlePageObject.swipeToHeader();
        }
        if(Platform.getInstance().isAndroidMobileWeb()){
            myNewsPageObject.clickToBurgerBtn();
            myNewsPageObject.clickToMyNewsBtn();
            myNewsPageObject.waitForMyNewsWebScreenOpens();
            popularPageObject.clickToPopularBtn();
            popularPageObject.waitForPopularListItem();
            popularPageObject.chooseTheMostPopularArticle();
            articlePageObject.swipeToArticleFooter();
        }
    }
}
