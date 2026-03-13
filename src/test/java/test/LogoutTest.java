package test;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.HeaderPage;

public class LogoutTest extends BaseTest {

    @Test(description = "Verify that the user can logout successfully")
    public void testLogout(){
        registerAndGetCredentials();

        HeaderPage header = new HeaderPage();
        header.clickLogout();
    }
}
