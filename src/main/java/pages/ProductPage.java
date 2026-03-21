package pages;

import core.BasePage;
import locator.ProductLocator;
import static common.Constants.*;

public class ProductPage extends BasePage {
    public ProductPage() {
        super();
        openSite(AUTOMATION_EXERCISE_BASE_URL);
        removeAds();
    }

    public void clickViewProductButton() {
        logger.info("Clicking 'View Product' button");
        clickButtonJS(ProductLocator.VIEW_PRODUCT_BUTTON);
    }

    public void clickViewProductButtonRandom() {
        logger.info("Clicking random 'View Product' button");
        clickButtonJS(ProductLocator.VIEW_PRODUCT_BUTTON_RANDOM);
    }

    public String getAllProductsTitle(){
        logger.info("Getting 'All Products' title");
        if(isElementDisplayed(ProductLocator.ALL_PRODUCTS_TITLE)) {
            return getElementText(ProductLocator.ALL_PRODUCTS_TITLE);
        }
        return "";
    }

    public boolean isProductListVisible() {
        logger.info("Checking if product list is visible");
        return isElementDisplayed(ProductLocator.PRODUCT_LIST);
    }

    public String getProductName() {
        logger.info("Getting product name");
        return getElementText(ProductLocator.PRODUCT_NAME);
    }

    public String getProductPrice() {
        logger.info("Getting product price");
        return getElementText(ProductLocator.PRODUCT_PRICE);
    }

    public String getProductAvailability() {
        logger.info("Getting product availability");
        return getElementText(ProductLocator.PRODUCT_AVAILABILITY);
    }

    public String getProductCondition() {
        logger.info("Getting product condition");
        return getElementText(ProductLocator.PRODUCT_CONDITION);
    }

    public String getProductBrand() {
        logger.info("Getting product brand");
        return getElementText(ProductLocator.PRODUCT_BRAND);
    }

    public String getProductCategory() {
        logger.info("Getting product category");
        return getElementText(ProductLocator.PRODUCT_CATEGORY);
    }
}
