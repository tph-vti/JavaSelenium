package test;

import core.BaseTest;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    @Test(description = "TC8: Verify All Products and product detail page")
    public void testVerifyProductDetails() {

        logStep("3. Verify that home page is visible successfully");
        commonPage.clickHomeButton();
        expectedResult = constants.HOME_PAGE_LINK;
        actualResult = commonPage.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("4. Click on 'Products' button");
        commonPage.clickProduct();
        
        logStep("5. Verify user is navigated to ALL PRODUCTS page successfully");
        expectedResult = constants.ALL_PRODUCTS_TITLE;
        actualResult = productPage.getAllProductsTitle();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("6. The products list is visible");
        Assert.assertTrue(productPage.isProductListVisible());

        logStep("7.  Click on 'View Product' of first product");
        productPage.clickViewProductButton();
        // productPage.clickViewProductButtonRandom();

        logStep("8. User is landed to product detail page");

        logStep("9. Verify that detail detail is visible: product name, category, price, availability, condition, brand");
        String productName = productPage.getProductName();
        String productPrice = productPage.getProductPrice();
        String productAvailability = productPage.getProductAvailability();
        String productCondition = productPage.getProductCondition();
        String productBrand = productPage.getProductBrand();
        String productCategory = productPage.getProductCategory();

        Assert.assertTrue(!productName.isEmpty());
        Assert.assertTrue(!productPrice.isEmpty());
        Assert.assertTrue(!productAvailability.isEmpty());
        Assert.assertTrue(!productCondition.isEmpty());
        Assert.assertTrue(!productBrand.isEmpty());
        Assert.assertTrue(!productCategory.isEmpty());
    }

    @Test(description = "TC9: Search product")
    public void testSearchProduct() {
        logStep("3. Verify that home page is visible successfully");
        commonPage.clickHomeButton();
        expectedResult = constants.HOME_PAGE_LINK;
        actualResult = commonPage.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("4. Click on 'Products' button");
        commonPage.clickMenu("Products");
        
        logStep("5. Verify user is navigated to ALL PRODUCTS page successfully");
        expectedResult = constants.ALL_PRODUCTS_TITLE;
        actualResult = productPage.getAllProductsTitle();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("6. Enter product name in search input and click search button");
        productPage.enterSearchProduct(constants.PRODUCT_NAME);
        productPage.clickSearchButton();

        logStep("7.  Verify 'SEARCHED PRODUCTS' is visible");
        expectedResult = constants.SEARCHED_PRODUCTS_TITLE;
        actualResult = productPage.getSearchedProductsTitle();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("8. Verify all the products related to search are visible");
        Assert.assertTrue(productPage.isProductListVisible());
    }
}
