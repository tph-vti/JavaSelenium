package locator;

import org.openqa.selenium.By;

public class ProductLocator {
    public static final By ALL_PRODUCTS_TITLE = By.xpath("//h2[text()='All Products']");
    public static final By PRODUCT_LIST = By.cssSelector(".features_items");
    public static final By VIEW_PRODUCT_BUTTON = By.xpath("(//div[@class='features_items']//a[contains(text(),'View Product')])[1]");
    public static final By PRODUCT_NAME = By.cssSelector(".product-information h2");
    public static final By PRODUCT_PRICE = By.cssSelector(".product-information span span");
    public static final By PRODUCT_AVAILABILITY = By.xpath("//div[@class='product-information']//b[contains(text(),'Availability')]");
    public static final By PRODUCT_CONDITION = By.xpath("//div[@class='product-information']//b[contains(text(),'Condition')]");
    public static final By PRODUCT_BRAND = By.xpath("//div[@class='product-information']//b[contains(text(),'Brand')]");
    public static final By PRODUCT_CATEGORY = By.xpath("//div[@class='product-information']//p[contains(text(),'Category')]");
    public static final By SEARCH_INPUT = By.id("search_product");
    public static final By SEARCH_BUTTON = By.id("submit_search");
    public static final By SEARCHED_PRODUCTS_TITLE = By.xpath("//h2[text()='Searched Products']");
    public static final By VIEW_CART_BUTTON = By.xpath("//a//u[text()='View Cart']");
    public static final By CONTINUE_SHOPPING_BUTTON = By.xpath("//button[text()='Continue Shopping']");

    /**
     * Returns a locator for a random 'View Product' button.
     * Fixed: Math.random() in static final only evaluates once at class load.
     * Now returns a fresh random value each time it's called.
     *
     * @return By locator for a random product view button
     */
    public static By getRandomViewProductButton() {
        int index = (int) (Math.random() * 6 + 1);
        return By.xpath("(//div[@class='features_items']//a[contains(text(),'View Product')])[" + index + "]");
    }

    public static By getAddToCartProductOverlay(int index) {
        return By.xpath("//div[@class='overlay-content']//a[@data-product-id='" + index + "']");
    }

    public static By getAddToCartProductInfo(int index) {
        return By.xpath("//div[@class='productinfo text-center']//a[@data-product-id='" + index + "']");
    }
}
