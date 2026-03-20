package locator;

import org.openqa.selenium.By;

public class TestcaseLocator {
    public static final By TEST_CASE_TITLE = By.xpath("//h2[contains(@class, 'title text-center')]//b[text()='Test Cases']");
}
