package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import core.BaseTest;
import static core.Constants.*;

public class ProductTest extends BaseTest {
    @Test(description = "TC8: Verify All Products and product detail page")
    public void testVerifyProductDetails() {

        logger.info("3. Verify that home page is visible successfully");
        expectedResult = HOME_PAGE_LINK;
        actualResult = commonPage.getCurrentUrl();
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

        Assert.assertTrue(!productName.isEmpty());
        Assert.assertTrue(!productPrice.isEmpty());
        Assert.assertTrue(!productAvailability.isEmpty());
        Assert.assertTrue(!productCondition.isEmpty());
        Assert.assertTrue(!productBrand.isEmpty());
        Assert.assertTrue(!productCategory.isEmpty());
    }

    @Test(description = "TC9: Search product")
    public void testSearchProduct() {
        logger.info("3. Verify that home page is visible successfully");
        expectedResult = HOME_PAGE_LINK;
        actualResult = commonPage.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);

        logger.info("4. Click on 'Products' button");
        commonPage.clickMenu("Products");
        
        logger.info("5. Verify user is navigated to ALL PRODUCTS page successfully");
        expectedResult = ALL_PRODUCTS_TITLE;
        actualResult = productPage.getAllProductsTitle();
        Assert.assertEquals(actualResult, expectedResult);

        logger.info("6. Enter product name in search input and click search button");
        productPage.enterSearchProduct(PRODUCT_NAME);
        productPage.clickSearchButton();

        logger.info("7.  Verify 'SEARCHED PRODUCTS' is visible");
        expectedResult = SEARCHED_PRODUCTS_TITLE;
        actualResult = productPage.getSearchedProductsTitle();
        Assert.assertEquals(actualResult, expectedResult);

        logger.info("8. Verify all the products related to search are visible");
        Assert.assertTrue(productPage.isProductListVisible());
    }
}
