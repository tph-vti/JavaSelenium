package test;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static core.Constants.*;

public class ProductTest extends BaseTest {
    @Test(description = "TC8: Verify All Products and product detail page")
    public void testVerifyProductDetails() {

        logStep("3. Verify that home page is visible successfully");
        commonPage.clickHomeButton();
        expectedResult = HOME_PAGE_LINK;
        actualResult = commonPage.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("4. Click on 'Products' button");
        commonPage.clickProduct();
        
        logStep("5. Verify user is navigated to ALL PRODUCTS page successfully");
        expectedResult = ALL_PRODUCTS_TITLE;
        actualResult = productPage.getAllProductsTitle();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("6. The products list is visible");
        Assert.assertTrue(productPage.isProductListVisible());

        logStep("7.  Click on 'View Product' of first product");
        productPage.clickViewProductButton();

        logStep("8. User is landed to product detail page");

        logStep("9. Verify that detail detail is visible: product name, category, price, availability, condition, brand");
        String productName = productPage.getProductName();
        String productPrice = productPage.getProductPrice();
        String productAvailability = productPage.getProductAvailability();
        String productCondition = productPage.getProductCondition();
        String productBrand = productPage.getProductBrand();
        String productCategory = productPage.getProductCategory();

        Assert.assertFalse(productName.isEmpty(), "Product name should not be empty");
        Assert.assertFalse(productPrice.isEmpty(), "Product price should not be empty");
        Assert.assertFalse(productAvailability.isEmpty(), "Product availability should not be empty");
        Assert.assertFalse(productCondition.isEmpty(), "Product condition should not be empty");
        Assert.assertFalse(productBrand.isEmpty(), "Product brand should not be empty");
        Assert.assertFalse(productCategory.isEmpty(), "Product category should not be empty");
    }

    @Test(description = "TC9: Search product")
    public void testSearchProduct() {
        logStep("3. Verify that home page is visible successfully");
        commonPage.clickHomeButton();
        expectedResult = HOME_PAGE_LINK;
        actualResult = commonPage.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("4. Click on 'Products' button");
        commonPage.clickMenu("Products");
        
        logStep("5. Verify user is navigated to ALL PRODUCTS page successfully");
        expectedResult = ALL_PRODUCTS_TITLE;
        actualResult = productPage.getAllProductsTitle();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("6. Enter product name in search input and click search button");
        productPage.enterSearchProduct(PRODUCT_NAME);
        productPage.clickSearchButton();

        logStep("7.  Verify 'SEARCHED PRODUCTS' is visible");
        expectedResult = SEARCHED_PRODUCTS_TITLE;
        actualResult = productPage.getSearchedProductsTitle();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("8. Verify all the products related to search are visible");
        Assert.assertTrue(productPage.isProductListVisible());
    }
}
