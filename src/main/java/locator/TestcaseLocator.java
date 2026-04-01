package locator;

import org.openqa.selenium.By;

public class TestcaseLocator {

    public static final By txtTestCasesTitle = By.xpath("//b[contains(text(),'Test Cases')]");

    public static final By listTestCases = By.xpath("//div[@class='panel-group']");
}
