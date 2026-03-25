package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonLocator {

    public static final String MENU = "//div[contains(@class,'shop-menu')]//a[contains(text(),'%s')]";
    public static final By homeLogo = By.xpath("//img[@alt='Website for automation practice']");;

    public static By menu(String menuName) {
        return By.xpath(String.format(MENU, menuName));

    }

    public static class HomePage extends BasePage {

        public HomePage() {
            super();
        }
        public static boolean isHomePageVisible() {
            return !driver.findElements(homeLogo).isEmpty();
        }

        public static void clickMenu(String menuName){
            click(By.xpath(String.format(CommonLocator.MENU, menuName)));
        }

        public static boolean verifyMenu(String menuName){
            return findVisibleElement(
                    By.xpath(String.format(CommonLocator.MENU, menuName))
            ).isDisplayed();
        }
    }
}