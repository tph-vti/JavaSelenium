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

        logger.info("STEP 1: Open Home Page");
        homePage.openSite();

        logger.info("STEP 2: Click 'Products' menu");
        homePage.clickMenu("Products");
    }

    @Test (description = "TC08: View Product Detail")
    public void TC08_ViewProductDetail() {

        logger.info("STEP 3: Verify user is navigated to ALL PRODUCTS page");
        productPages.verifyAllProductsPage();

        logger.info("STEP 4: Verify product list is visible");
        productPages.verifyProductListVisible();

        logger.info("STEP 5: Click 'View Product' of first product");
        productPages.clickViewProduct(1);

        logger.info("STEP 6: Verify user is landed to product detail page");
        productPages.verifyProductDetailPageByUrl();

        logger.info("STEP 7: Verify product detail info is visible");
        productPages.verifyProductDetailInfo();
    }

    @Test (description = "TC09: Search Product")
    public void TC09_SearchProduct() {

        logger.info("STEP 3: Verify ALL PRODUCTS page");
        productPages.verifyAllProductsPage();

        logger.info("STEP 4: Enter product name and click search");
        String keyword = Constants.SEARCH_KEY;
        productPages.searchProduct(keyword);

        logger.info("STEP 5: Verify 'SEARCHED PRODUCTS' is visible");
        productPages.verifySearchedProductsTitle();

        logger.info("STEP 6: Verify searched product list is visible");
        productPages.verifySearchResultListVisible();

        logger.info("STEP 7: Verify all results contain keyword");
        productPages.verifyAllSearchResultsContainKeyword(keyword);
    }
}