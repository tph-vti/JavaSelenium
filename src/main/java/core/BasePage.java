package core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import utils.Helper;

import java.util.Set;


/**
 * BasePage provides common web interaction methods for all Page Objects.
 * All page classes should extend this class to inherit WebDriver access and utility methods.
 */
public class BasePage extends Helper {
    private String crrWindow;
    protected WebDriver driver;
    public BasePage(){
        driver = DriverManager.getDriver();
    }

    public void openSite() {
        logger.info("Navigating to URL: {}", TestSettings.BASE_URL);
        this.driver.get(TestSettings.BASE_URL);
        logger.info("Navigation to URL: {} completed", TestSettings.BASE_URL);
    }

    public void openSite(String url) {
        logger.info("Navigating to URL: {}", url);
        this.driver.get(url);
        logger.info("Navigation to URL: {} completed", url);
    }

    protected WebElement findVisibleElement(By selector) {
        return getWait(TestSettings.WAIT_ELEMENT)
                .until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    protected WebElement findPresentElement(By selector) {
        return getWait(TestSettings.WAIT_ELEMENT)
                .until(ExpectedConditions.presenceOfElementLocated(selector));
    }

    public WebDriverWait getWait(long waitTime) {
        return new WebDriverWait(this.driver, Duration.ofSeconds(waitTime));
    }

    protected void waitForElementInvisible(By selector) {
        getWait(TestSettings.WAIT_ELEMENT).until(ExpectedConditions.invisibilityOfElementLocated(selector));
    }

    private WebElement waitForElementClickable(By selector) {
        return getWait(TestSettings.WAIT_ELEMENT).until(ExpectedConditions.elementToBeClickable(selector));
    }

    protected void enterText(By selector, String text) {
        logger.info("Entering text {}", text);
        findVisibleElement(selector).sendKeys(text);
    }

    protected void enterTextWithoutWait(By selector, String text) {
        logger.info("Entering text {}", text);
        this.driver.findElement(selector).sendKeys(text);
    }

    protected String getElementAttribute(By selector, String attributeName) {
        logger.info("Getting attribute {} from element {}", attributeName, selector);
        return findPresentElement(selector).getDomAttribute(attributeName);
    }

   protected String getElementValue(By selector) {
       logger.info("Getting value from element {}", selector);
       WebElement element = findPresentElement(selector);
       return element.getText().isEmpty() ? element.getDomProperty("value") : element.getText();
   }

    protected void click(By selector) {
        logger.info("Clicking {}", selector);
        waitForElementClickable(selector).click();
    }

    protected void clearText(By selector) {
        logger.info("Clearing text of element {}", selector);
        WebElement element = findVisibleElement(selector);
        element.clear();
    }

    protected void pressEnter(By selector) {
        logger.info("Pressing ENTER on element {}", selector);
        WebElement element = findVisibleElement(selector);
        element.sendKeys(org.openqa.selenium.Keys.ENTER);
    }

    protected void clearAndEnterText(By selector, String text) {
        logger.info("Clearing and entering text {} into {}", text, selector);
        WebElement element = findVisibleElement(selector);
        element.clear();
        element.sendKeys(text);
    }

    protected void executeJavaScript(String script) {
        logger.info("Executing JavaScript: {}", script);
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript(script);
    }

    protected String getElementText(By selector) {
        String text = findPresentElement(selector).getText();
        logger.info("Retrieved text '{}' from element {}", text, selector);
        return text;
    }

    protected boolean isElementSelected(By selector) {
        return findPresentElement(selector).isSelected();
    }

    public void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

//    protected void verifyTrue(boolean condition, String message) {
//        logger.info("Verifying condition is true");
//        assertTrue(condition, message);
//    }
//
//    protected void verifyFalse(boolean condition, String message) {
//        logger.info("Verifying condition is false");
//        assertFalse(condition, message);
//    }
//
//    protected void verifyEquals(Object expected, Object actual, String message) {
//        logger.info("Verifying equality of expected and actual values");
//        assertEquals(expected, actual, message);
//    }

    protected void verifyElementVisible(By selector, String errorMessage) {
        logger.info("Verifying visibility of element {}", selector);
        try {
            getWait(TestSettings.WAIT_ELEMENT).until(ExpectedConditions.visibilityOfElementLocated(selector));
            logger.info("Element {} is visible", selector);
        } catch (Exception e) {
            logger.error("Element {} is not visible: {}", selector, errorMessage);
            throw new AssertionError(errorMessage);
        }
    }

    protected void hoverElement(By selector) {
        logger.info("Hovering over element {}", selector);
        WebElement element = findPresentElement(selector);
        // Init action object
        Actions actions = new Actions(this.driver);

        // Perform hover action
        actions.moveToElement(element).perform();
    }

    protected void dragAndDrop(By sourceEleBy, By targetEleBy) {
        logger.info("Dragging element from {} to {}", sourceEleBy, targetEleBy);
        WebElement sourceElement = findVisibleElement(sourceEleBy);
        WebElement targetElement = findVisibleElement(targetEleBy);

        // Init action object
        Actions actions = new Actions(this.driver);

        // Perform drag and drop action
        actions.dragAndDrop(sourceElement, targetElement).perform();
    }

    protected Alert switchToAlert() {
        logger.info("Switching to alert");
        return this.driver.switchTo().alert();
    }

    protected void acceptAlertAction(Alert alert) {
        logger.info("Accepting alert");
        alert.accept();
    }
    protected void dismissAlertAction(Alert alert) {
        logger.info("Dismissing alert");
        alert.dismiss();
    }

    protected WebDriver swithToNewWindow(){
        logger.info("Switching to new window");
        this.crrWindow = this.driver.getWindowHandle();
        logger.info("Current window: {}", this.crrWindow);
        for (String windowHandle : this.driver.getWindowHandles()) {
            if (!windowHandle.equals(this.crrWindow)) {
                this.driver.switchTo().window(windowHandle);
                logger.info("Switched to new window: {}", windowHandle);
                return this.driver;
            }
        }
        logger.warn("No new window found to switch to");
        return this.driver;
    }

//    public void verifyTitle(String expectedTitle) {
//        logger.info("Verifying page title is: {}", expectedTitle);
//        String actualTitle = this.driver.getTitle();
//        verifyEquals(expectedTitle, actualTitle, String.format("Expected title '%s' but found '%s'", expectedTitle, actualTitle));
//    }

    public void switchBackToOriginalWindow() {
        logger.info("Switching back to original window: {}", this.crrWindow);
        Set<String> arrString = this.driver.getWindowHandles();
        for (String windowHandle : arrString) {
            if (!windowHandle.equals(this.crrWindow)) {
                this.driver.switchTo().window(windowHandle);
                logger.info("Switched to new window: {}", windowHandle);
                this.driver.close();
            }
        }
        this.driver.switchTo().window(this.crrWindow);
    }

    public boolean isElementDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }

    public void sendKeys(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }
}

