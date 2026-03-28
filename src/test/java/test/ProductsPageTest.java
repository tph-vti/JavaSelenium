package test;

import core.BasePage;
import core.BaseTest;
import core.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.RegisterPage;
import utils.Constants;

import java.net.MalformedURLException;


public class ProductsPageTest extends BaseTest {

    HomePage homePage;
    ProductsPage productsPage;

    @BeforeMethod
    public void setup() throws MalformedURLException {

        new DriverManager();

        homePage = new HomePage();
        productsPage = new ProductsPage();

        logger.info("STEP 1: Open Home Page");
        homePage.openSite();

        logger.info("STEP 2: Click 'Products' menu");
        homePage.clickMenu("Products");
    }

    @Test (description = "TC08: View Product Detail")
    public void TC08_ViewProductDetail() {

        ProductsPage productsPage = new ProductsPage();

        logger.info("STEP 3: Verify user is navigated to ALL PRODUCTS page");
        productsPage.verifyAllProductsPage();

        logger.info("STEP 4: Verify product list is visible");
        productsPage.verifyProductListVisible();

        logger.info("STEP 5: Click 'View Product' of first product");
        productsPage.clickViewProduct(1);

        logger.info("STEP 6: Verify user is landed to product detail page");
        productsPage.verifyProductDetailPageByUrl();

        logger.info("STEP 7: Verify product detail info is visible");
        productsPage.verifyProductDetailInfo();
    }

    @Test (description = "TC09: Search Product")
    public void TC09_SearchProduct() {

        ProductsPage productsPage = new ProductsPage();

        logger.info("STEP 3: Verify ALL PRODUCTS page");
        productsPage.verifyAllProductsPage();

        logger.info("STEP 4: Enter product name and click search");
        String keyword = Constants.SEARCH_KEY;
        productsPage.searchProduct(keyword);

        logger.info("STEP 5: Verify 'SEARCHED PRODUCTS' is visible");
        productsPage.verifySearchedProductsTitle();

        logger.info("STEP 6: Verify searched product list is visible");
        productsPage.verifySearchResultListVisible();

        logger.info("STEP 7: Verify all results contain keyword");
        productsPage.verifyAllSearchResultsContainKeyword(keyword);
    }
}
