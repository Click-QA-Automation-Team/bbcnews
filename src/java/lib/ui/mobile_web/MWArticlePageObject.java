package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        SEARCH_ELEMENT_BY_TEXT_TPL = "xpath://p[contains(@class, 'ssrcss-6arcww-PromoHeadline')]//span[text()='{SUBSTRING}']/../../..";
        ARTICLE_HEADLINE_TITLE = "css:div.br-masthead__title a";
        FOOTER_ELEMENT = "css:div.orb-footer";
        ARTICLE_FOOTER_ELEMENT = "css:footer#footer-content";
        NEWS_ITEM_TITLE = "";
    }
    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
