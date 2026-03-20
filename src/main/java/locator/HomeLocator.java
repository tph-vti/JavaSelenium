package locator;

import org.openqa.selenium.By;

public class HomeLocator {
    public static final By HOME_TITLE = By.xpath("//h2[contains(text(), 'Full-Fledged practice website for Automation Engineers')]");
    public static final By CATEGORY_TITLE = By.xpath("//h2[contains(text(), ' Category')]");
    public static final By RECOMMENDED_ITEMS_TITLE = By.xpath("//h2[contains(text(), 'recommended items')]");

}
