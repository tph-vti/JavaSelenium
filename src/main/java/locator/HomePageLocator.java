package locator;

import org.openqa.selenium.By;

public class HomePageLocator {
    public static final String MENU = "//div[contains(@class,'shop-menu')]//a[contains(text(),'%s')]";
    public static final By homeLogo = By.xpath("//img[@alt='Website for automation practice']");;

    public static By menu(String menuName) {
        return By.xpath(String.format(MENU, menuName));

    }
}
