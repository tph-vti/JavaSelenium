package pages;

import org.openqa.selenium.By;

import core.BasePage;
import locator.HomeLocator;

public class HomePage extends BasePage {
    public HomePage() {
        super();
    }
    public String getCategoryTitle() {
        By locator = By.xpath(String.format(HomeLocator.CATEGORY_TITLE));
        return getElementText(locator);
    }
}
