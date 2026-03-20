package locator;

import org.openqa.selenium.By;

public class HomeLocator {

    public static final String MENU = "//div[contains(@class,'shop-menu')]//a[contains(text(),'%s')]";

    public static By menu(String menuName){
        return By.xpath(String.format(MENU, menuName));
    }

}
