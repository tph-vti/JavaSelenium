package pages;

import core.BasePage;
import locator.ProductLocator;

import java.util.List;

public class ProductPages extends BasePage {

    public ProductPages() {
        super();
    }

    public void verifyAllProductsPage() {
        logger.info("Verify 'All Products' page is displayed");
        verifyElementVisible(ProductLocator.txtAllProductsTitle, "All Products");
    }

    public void verifyProductListVisible() {
        logger.info("Verify product list is displayed");
        int totalProduct = getListElement(ProductLocator.listProducts).size();
        if (totalProduct == 0) {
            throw new AssertionError("Product list is EMPTY");
        }
    }

    public void clickViewProduct(int index) {
        logger.info("Click 'View Product' button at index: {}", index);
        click(ProductLocator.btnViewProduct(index));
    }

    public void verifyProductDetailPageByUrl() {
        logger.info("Verify navigation to product detail page");
        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.contains("/product_details/")) {
            throw new AssertionError("Not navigated to Product Detail Page. URL: " + currentUrl);
        }
    }

    public void verifyProductDetailInfo() {
        logger.info("Verify product detail information");
        verifyElementVisible(ProductLocator.txtProductName, "Product Name");
        verifyElementVisible(ProductLocator.txtCategory, "Category");
        verifyElementVisible(ProductLocator.txtPrice, "Price");
        verifyElementVisible(ProductLocator.txtAvailability, "Availability");
        verifyElementVisible(ProductLocator.txtCondition, "Condition");
        verifyElementVisible(ProductLocator.txtBrand, "Brand");
        logger.info("All product detail information displayed correctly");
    }

    public void searchProduct(String productName) {
        logger.info("Enter product name: {}", productName);
        enterText(ProductLocator.txtSearchInput, productName);
        logger.info("Click Search button");
        click(ProductLocator.btnSearch);
    }

    public void verifySearchedProductsTitle() {
        logger.info("Verify 'Searched Products' title");
        verifyElementVisible(ProductLocator.txtSearchedProductsTitle, "Searched Products");
    }

    public void verifySearchResultListVisible() {
        logger.info("Verify search result list");
        int size = getListElement(ProductLocator.listSearchedProducts).size();
        if (size == 0) {
            throw new AssertionError("Search result list is EMPTY");
        }
    }

    public void verifyAllSearchResultsContainKeyword(String keyword) {
        logger.info("Verify all products contain keyword: {}", keyword);
        List<String> productNames = getTextElements(ProductLocator.txtProductNames);
        for (String name : productNames) {
            if (!name.toLowerCase().contains(keyword.toLowerCase())) {
                throw new AssertionError(
                        "Product '" + name + "' does NOT contain keyword '" + keyword + "'"
                );
            }
        }
    }
}