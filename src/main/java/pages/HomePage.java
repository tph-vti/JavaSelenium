package pages;

import core.BasePage;
import locator.HomeLocator;

public class HomePage extends BasePage {
    public HomePage() {
        super();
    }

    public String getHomeTitle() {
        logger.info("Getting 'Home' title");
        if(isElementDisplayed(HomeLocator.HOME_TITLE)) {
            return getElementText(HomeLocator.HOME_TITLE);
        }
        return "";
    }

    public String getCategoryTitle() {
        logger.info("Getting 'Category' title");
        if(isElementDisplayed(HomeLocator.CATEGORY_TITLE)) {
            return getElementText(HomeLocator.CATEGORY_TITLE);
        }
        return "";
    }

    public String getRecommendedItemsTitle() {
        logger.info("Getting 'Recommended Items' title");
        if(isElementDisplayed(HomeLocator.RECOMMENDED_ITEMS_TITLE)) {
            return getElementText(HomeLocator.RECOMMENDED_ITEMS_TITLE);
        }
        return "";
    }
}
