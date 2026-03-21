package locator;

import org.openqa.selenium.By;

public class ProductLocator {
    public static final By ALL_PRODUCTS_TITLE = By.xpath("//h2[text()='All Products']");
    public static final By PRODUCT_LIST = By.xpath("//div[@class='features_items']");
    public static final By VIEW_PRODUCT_BUTTON = By.xpath("(//div[@class='features_items']//a[contains(text(),'View Product')])[1]");
    public static final By VIEW_PRODUCT_BUTTON_RANDOM = By.xpath("(//div[@class='features_items']//a[contains(text(),'View Product')])[" + (int) (Math.random() * 6 + 1) + "]");
    public static final By PRODUCT_NAME = By.xpath("//div[@class='product-information']//h2");
    public static final By PRODUCT_PRICE = By.xpath("//div[@class='product-information']//span//span[contains(text(),'Rs. ')]");
    public static final By PRODUCT_AVAILABILITY = By.xpath("//div[@class='product-information']//b[contains(text(),'Availability')]");
    public static final By PRODUCT_CONDITION = By.xpath("//div[@class='product-information']//b[contains(text(),'Condition')]");
    public static final By PRODUCT_BRAND = By.xpath("//div[@class='product-information']//b[contains(text(),'Brand')]");
    public static final By PRODUCT_CATEGORY = By.xpath("//div[@class='product-information']//p[contains(text(),'Category')]");
}
