package pages;

import core.BasePage;
import locator.HomeLocator;
import org.openqa.selenium.By;

public class HomePages extends BasePage {

    public HomePages() {
        super(); // lấy driver từ DriverManager
    }

    public void clickMenu(String menuName){
        click(By.xpath(String.format(HomeLocator.MENU, menuName)));
    }

    public boolean verifyMenu(String menuName){
        return findVisibleElement(
                By.xpath(String.format(HomeLocator.MENU, menuName))
        ).isDisplayed();
    }
}
