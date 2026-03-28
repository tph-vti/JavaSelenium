package locator;

import org.openqa.selenium.By;

public class TestCasesPageLocator {
    public static final By btnTestCases = By.xpath("//div[@class='shop-menu pull-right']//a[contains(text(),'Test Cases')]");
    public static final By lblTestCasesHeader = By.xpath("//a[@href='/test_cases']");
}
