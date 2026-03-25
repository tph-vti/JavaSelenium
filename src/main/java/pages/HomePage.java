package pages;

import core.BasePage;
import locator.HomePageLocator;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    public void clickMenu(String menuName){
        click(By.xpath(String.format(HomePageLocator.MENU, menuName)));
    }

    public boolean verifyMenu(String menuName){
        return findVisibleElement(
                By.xpath(String.format(HomePageLocator.MENU, menuName))
        ).isDisplayed();
    }
}