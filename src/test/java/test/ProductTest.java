package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import core.BaseTest;
import pages.CommonPage;
import pages.HomePage;
import pages.ProductPage;
import static core.Constants.*;

public class ProductTest extends BaseTest {
    @Test(description = "TC8: Verify All Products and product detail page")
    public void testVerifyProductDetails() {
        ProductPage productPage = new ProductPage();
        CommonPage commonPage = new CommonPage();
        HomePage homePage = new HomePage();
        String expectedTitle;
        String actualTitle;

        logger.info("3. Verify that home page is visible successfully");
        expectedTitle = RECOMMENDED_ITEMS_TITLE;
        actualTitle = homePage.getRecommendedItemsTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        logger.info("4. Click on 'Products' button");
        commonPage.clickMenu("Products");
        
        logger.info("5. Verify user is navigated to ALL PRODUCTS page successfully");
        expectedTitle = ALL_PRODUCTS_TITLE;
        actualTitle = productPage.getAllProductsTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

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
