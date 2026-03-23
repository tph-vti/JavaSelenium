package locator;

import org.openqa.selenium.By;

public class ProductLocator {

    // ===== PRODUCT =====;

    // Title ALL PRODUCTS
    public static By txtAllProductsTitle = By.xpath( "//h2[text()='All Products']");

    // URL check (nếu cần)
    //public static By urlProducts = By.xpath("/products");

    public static  By listProducts = By.xpath("//div[@class='features_items']//div[@class='product-image-wrapper']");

    public static By btnViewProduct(int index) {
        return By.xpath("(//a[text()='View Product'])[" + index + "]");
    };

    // ===== VIEW PRODUCT =====;

    public static By txtProductName = By.xpath("//div[@class='product-information']//h2");

    public static By txtCategory = By.xpath("//div[@class='product-information']//p[contains(text(),'Category')]");

    public static By txtPrice = By.xpath("//div[@class='product-information']//span/span");

    public static By txtAvailability = By.xpath("//div[@class='product-information']//p[b[text()='Availability:']]");

    public static By txtCondition = By.xpath("//div[@class='product-information']//p[b[text()='Condition:']]");

    public static By txtBrand = By.xpath("//div[@class='product-information']//p[b[text()='Brand:']]");

    // ===== SEARCH PRODUCT =====

    public static By txtSearchInput = By.xpath("//input[@id='search_product']");

    public static By btnSearch = By.xpath("//button[@id='submit_search']");

    public static By txtSearchedProductsTitle = By.xpath("//h2[text()='Searched Products']");

    public static By listSearchedProducts = By.xpath("//div[@class='features_items']//div[@class='product-image-wrapper']");

    public static By txtProductNames = By.xpath("//div[@class='productinfo text-center']//p");
}
