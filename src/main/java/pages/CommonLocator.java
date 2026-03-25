package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonLocator {

    public static final String MENU = "//div[contains(@class,'shop-menu')]//a[contains(text(),'%s')]";

    public static By menu(String menuName) {
        return By.xpath(String.format(MENU, menuName));
    }

    public static class HomePage extends BasePage {

        public HomePage() {
            super();
        }

        public void clickMenu(String menuName){
            click(By.xpath(String.format(CommonLocator.MENU, menuName)));
        }

        public boolean verifyMenu(String menuName){
            return findVisibleElement(
                    By.xpath(String.format(CommonLocator.MENU, menuName))
            ).isDisplayed();
        }
    }
}