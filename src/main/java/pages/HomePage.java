package pages;

import core.BasePage;
import locator.HomeLocator;

public class HomePage extends BasePage {
    public HomePage() {
        super();
    }

    public String getHomeTitle() {
        logger.info("Getting 'Home' title");
        return getElementText(HomeLocator.HOME_TITLE);
    }

    public String getCategoryTitle() {
        logger.info("Getting 'Category' title");
        return getElementText(HomeLocator.CATEGORY_TITLE);
    }

    public String getRecommendedItemsTitle() {
        logger.info("Getting 'Recommended Items' title");
        return getElementText(HomeLocator.RECOMMENDED_ITEMS_TITLE);
    }
}
