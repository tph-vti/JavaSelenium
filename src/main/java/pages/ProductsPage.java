package pages;

import core.BasePage;
import locator.ProductsPageLocator;

import java.util.List;

public class ProductsPage extends BasePage {

    public ProductsPage() {
        super();
    }

    public void verifyAllProductsPage() {
        logger.info("Verify 'All Products' page is displayed");
        verifyElementVisible(ProductsPageLocator.txtAllProductsHeader, "All Products");
    }

    public void verifyProductListVisible() {
        logger.info("Verify product list is displayed");

        int totalProduct = getListElement(ProductsPageLocator.listProducts).size();

        if (totalProduct == 0) {
            throw new AssertionError("Product list is EMPTY");
        }
    }

    public void clickViewProduct(int index) {
        logger.info("Click 'View Product' button at index: {}", index);

        click(ProductsPageLocator.btnViewProduct(index));
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

        verifyElementVisible(ProductsPageLocator.txtProductName, "Product Name");
        verifyElementVisible(ProductsPageLocator.txtCategory, "Category");
        verifyElementVisible(ProductsPageLocator.txtPrice, "Price");
        verifyElementVisible(ProductsPageLocator.txtAvailability, "Availability");
        verifyElementVisible(ProductsPageLocator.txtCondition, "Condition");
        verifyElementVisible(ProductsPageLocator.txtBrand, "Brand");

        logger.info("All product detail information displayed correctly");
    }

    public void searchProduct(String productName) {
        logger.info("Enter product name: {}", productName);
        enterText(ProductsPageLocator.txtSearchInput, productName);

        logger.info("Click Search button");
        click(ProductsPageLocator.btnSearch);
    }

    public void verifySearchedProductsTitle() {
        logger.info("Verify 'Searched Products' title");
        verifyElementVisible(ProductsPageLocator.txtSearchedProductsTitle, "Searched Products");
    }

    public void verifySearchResultListVisible() {
        logger.info("Verify search result list");

        int size = getListElement(ProductsPageLocator.listSearchedProducts).size();

        if (size == 0) {
            throw new AssertionError("Search result list is EMPTY");
        }
    }

    public void verifyAllSearchResultsContainKeyword(String keyword) {
        logger.info("Verify all products contain keyword: {}", keyword);

        List<String> productNames = getTextElements(ProductsPageLocator.txtProductNames);

        for (String name : productNames) {
            if (!name.toLowerCase().contains(keyword.toLowerCase())) {
                throw new AssertionError(
                        "Product '" + name + "' does NOT contain keyword '" + keyword + "'"
                );
            }
        }
    }
}
