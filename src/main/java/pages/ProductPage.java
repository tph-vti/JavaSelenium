package pages;

import core.BasePage;
import locator.ProductLocator;

public class ProductPage extends BasePage {
    public ProductPage() {
        super();
    }

    public void clickViewProductButton() {
        logger.info("Clicking 'View Product' button");
        clickButtonJS(ProductLocator.VIEW_PRODUCT_BUTTON);
    }

    public void clickViewProductButtonRandom() {
        logger.info("Clicking random 'View Product' button");
        clickButtonJS(ProductLocator.VIEW_PRODUCT_BUTTON_RANDOM);
    }

    public String getAllProductsTitle() {
        logger.info("Getting 'All Products' title");
        return getElementText(ProductLocator.ALL_PRODUCTS_TITLE);

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

    public void enterSearchProduct(String productName) {
        logger.info("Entering product name");
        enterText(ProductLocator.SEARCH_INPUT, productName);
    }

    public void clickSearchButton() {
        logger.info("Clicking search button");
        clickButton(ProductLocator.SEARCH_BUTTON);
    }

    public String getSearchedProductsTitle() {
        logger.info("Getting 'Searched Products' title");
        return getElementText(ProductLocator.SEARCHED_PRODUCTS_TITLE);
    }
}
