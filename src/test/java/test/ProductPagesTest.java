package test;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePages;
import pages.ProductPages;
import utils.Constants;

public class ProductPagesTest extends BaseTest {

    @BeforeMethod
    public void preCondition() {
        HomePages homePage = new HomePages();

        logger.info("STEP 1: Open Home Page");
        homePage.openSite();

        logger.info("STEP 2: Click 'Products' menu");
        homePage.clickMenu("Products");
    }

    @Test
    public void TC08_ViewProductDetail() {

        ProductPages productPage = new ProductPages();

        logger.info("STEP 3: Verify user is navigated to ALL PRODUCTS page");
        Assert.assertTrue(productPage.verifyAllProductsPage());

        logger.info("STEP 4: Verify product list is visible");
        Assert.assertTrue(productPage.verifyProductListVisible());

        logger.info("STEP 5: Click 'View Product' of first product");
        productPage.clickViewProduct(1);

        logger.info("STEP 6: Verify user is landed to product detail page");
        Assert.assertTrue(productPage.verifyProductDetailPageByUrl());

        logger.info("STEP 7: Verify product detail info is visible");
        Assert.assertTrue(productPage.verifyProductDetailInfo());
    }

    @Test
    public void TC09_SearchProduct() {

        ProductPages productPage = new ProductPages();

        logger.info("STEP 3: Verify ALL PRODUCTS page");
        Assert.assertTrue(productPage.verifyAllProductsPage());

        logger.info("STEP 4: Enter product name and click search");
        String keyword = Constants.SEARCH_KEY;
        productPage.searchProduct(keyword);

        logger.info("STEP 5: Verify 'SEARCHED PRODUCTS' is visible");
        Assert.assertTrue(productPage.verifySearchedProductsTitle());

        logger.info("STEP 6: Verify searched product list is visible");
        Assert.assertTrue(productPage.verifySearchResultListVisible());

        logger.info("STEP 7: Verify all results contain keyword");
        Assert.assertTrue(productPage.verifyAllSearchResultsContainKeyword(keyword));
    }
}