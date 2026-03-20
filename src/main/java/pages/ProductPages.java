package pages;

import core.BasePage;
import locator.ProductLocator;

import java.util.List;

public class ProductPages extends BasePage {

    public ProductPages() {
        super(); // lấy driver từ DriverManager
    }

    // ===== ALL PRODUCTS PAGE =====

    public boolean verifyAllProductsPage() {
        logger.info("Verify 'All Products' page is displayed by checking title element");
        verifyElementVisible(ProductLocator.txtAllProductsTitle, "All Products");
        return true;
    }

    public boolean verifyProductListVisible() {
        logger.info("Get list of all products displayed on page");
        int totalProduct = getListElement(ProductLocator.listProducts).size();

        logger.info("Total products found: {}", totalProduct);
        logger.info("Verify product list is NOT empty");

        return totalProduct > 0;
    }

    public void clickViewProduct(int index) {
        logger.info("Click 'View Product' button at index: {}", index);

        // Dynamic locator để click đúng sản phẩm theo index
        click(ProductLocator.btnViewProduct(index));
    }

    // ===== PRODUCT DETAIL PAGE =====

    public boolean verifyProductDetailPageByUrl() {
        logger.info("Get current URL to verify navigation to product detail page");

        String currentUrl = driver.getCurrentUrl();
        logger.info("Current URL: {}", currentUrl);

        logger.info("Verify URL contains '/product_details/'");

        return currentUrl.contains("/product_details/");
    }

    public boolean verifyProductDetailInfo() {

        logger.info("Verify product name is displayed");
        verifyElementVisible(ProductLocator.txtProductName, "Product Name");

        logger.info("Verify product category is displayed");
        verifyElementVisible(ProductLocator.txtCategory, "Category");

        logger.info("Verify product price is displayed");
        verifyElementVisible(ProductLocator.txtPrice, "Price");

        logger.info("Verify product availability is displayed");
        verifyElementVisible(ProductLocator.txtAvailability, "Availability");

        logger.info("Verify product condition is displayed");
        verifyElementVisible(ProductLocator.txtCondition, "Condition");

        logger.info("Verify product brand is displayed");
        verifyElementVisible(ProductLocator.txtBrand, "Brand");

        logger.info("All product detail information is displayed correctly");

        return true;
    }


        // ===== SEARCH PRODUCT =====

    public void searchProduct(String productName) {
        logger.info("Enter product name: {}", productName);
        enterText(ProductLocator.txtSearchInput, productName);

        logger.info("Click Search button");
        click(ProductLocator.btnSearch);
    }

    public boolean verifySearchedProductsTitle() {
        verifyElementVisible(ProductLocator.txtSearchedProductsTitle, "Searched Products");
        return true;
    }

    public boolean verifySearchResultListVisible() {
        int size = getListElement(ProductLocator.listSearchedProducts).size();
        return size > 0;
    }

    public boolean verifyAllSearchResultsContainKeyword(String keyword) {
        logger.info("Verify all products contain keyword: {}", keyword);

        List<String> productNames = getTextElements(ProductLocator.txtProductNames);

        for (String name : productNames) {
            if (!name.toLowerCase().contains(keyword.toLowerCase())) {
                logger.error("Product '{}' does NOT contain keyword '{}'", name, keyword);
                return false;
            }
        }
        return true;
    }

}