package pages;

import org.openqa.selenium.By;
import static pages.CommonLocator.driver;

public class AccountDeletedPage {
    public static final By accountDeletedHeader =
            By.xpath("//b[text()='Account Deleted!']");

    public static boolean isAccountDeletedVisible() {
        return !driver.findElements(accountDeletedHeader).isEmpty();
    }
}
