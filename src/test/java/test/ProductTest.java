package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import core.BaseTest;
import static core.Constants.*;

public class ProductTest extends BaseTest {
    @Test(description = "TC8: Verify All Products and product detail page")
    public void testVerifyProductDetails() {

        logger.info("3. Verify that home page is visible successfully");
        expectedResult = RECOMMENDED_ITEMS_TITLE;
        actualResult = homePage.getRecommendedItemsTitle();
        Assert.assertEquals(actualResult, expectedResult);

        logger.info("4. Click on 'Products' button");
        commonPage.clickMenu("Products");
        
        logger.info("5. Verify user is navigated to ALL PRODUCTS page successfully");
        expectedResult = ALL_PRODUCTS_TITLE;
        actualResult = productPage.getAllProductsTitle();
        Assert.assertEquals(actualResult, expectedResult);

        logger.info("6. The products list is visible");
        Assert.assertTrue(productPage.isProductListVisible());

        logger.info("7.  Click on 'View Product' of first product");
        productPage.clickViewProductButton();
        // productPage.clickViewProductButtonRandom();

        logger.info("8. User is landed to product detail page");

        logger.info("9. Verify that detail detail is visible: product name, category, price, availability, condition, brand");
        String productName = productPage.getProductName();
        String productPrice = productPage.getProductPrice();
        String productAvailability = productPage.getProductAvailability();
        String productCondition = productPage.getProductCondition();
        String productBrand = productPage.getProductBrand();
        String productCategory = productPage.getProductCategory();

        Assert.assertFalse(productName.isEmpty());
        Assert.assertFalse(productPrice.isEmpty());
        Assert.assertFalse(productAvailability.isEmpty());
        Assert.assertFalse(productCondition.isEmpty());
        Assert.assertFalse(productBrand.isEmpty());
        Assert.assertFalse(productCategory.isEmpty());
    }
}
