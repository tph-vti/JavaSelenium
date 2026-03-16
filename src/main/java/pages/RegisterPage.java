package pages;

import locator.LoginLocator;
import locator.RegisterLocator;
import locator.HomeLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class RegisterPage {
    static WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyRegisterTitle(){
        return driver.findElement(RegisterLocator.registerTitle).isDisplayed();
    }

    public void fillAccountInformation(String password, String day, String month, String year){

        driver.findElement(RegisterLocator.titleMr).click();
        driver.findElement(RegisterLocator.password).sendKeys(password);

        Select dayDropdown = new Select(driver.findElement(RegisterLocator.dayDropdown));
        dayDropdown.selectByVisibleText(day);

        Select monthDropdown = new Select(driver.findElement(RegisterLocator.monthDropdown));
        monthDropdown.selectByVisibleText(month);

        Select yearDropdown = new Select(driver.findElement(RegisterLocator.yearDropdown));
        yearDropdown.selectByVisibleText(year);
    }

    public void clickNewsletterCheckbox(){
        driver.findElement(RegisterLocator.newsletterCheckbox).click();
    }

    public void clickOffersCheckbox(){
        driver.findElement(RegisterLocator.offersCheckbox).click();
    }

    // STEP 12: Fill address information
    public void fillAddressInformation(
            String firstName,
            String lastName,
            String company,
            String address1,
            String address2,
            String country,
            String state,
            String city,
            String zipcode,
            String mobile
    ){

        driver.findElement(RegisterLocator.firstName).sendKeys(firstName);
        driver.findElement(RegisterLocator.lastName).sendKeys(lastName);
        driver.findElement(RegisterLocator.company).sendKeys(company);

        driver.findElement(RegisterLocator.address1).sendKeys(address1);
        driver.findElement(RegisterLocator.address2).sendKeys(address2);

        Select countryDropdown = new Select(driver.findElement(RegisterLocator.countryDropdown));
        countryDropdown.selectByVisibleText(country);

        driver.findElement(RegisterLocator.state).sendKeys(state);
        driver.findElement(RegisterLocator.city).sendKeys(city);

        driver.findElement(RegisterLocator.zipcode).sendKeys(zipcode);
        driver.findElement(RegisterLocator.mobileNumber).sendKeys(mobile);
    }

    public void clickCreateAccountButton(){
        driver.findElement(RegisterLocator.createAccountButton).click();
    }

    public boolean verifyAccountCreatedTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));

        WebElement title = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//b[contains(text(),'Account Created!')]")
                )
        );

        return title.isDisplayed();
    }

    public void clickContinue(){
        driver.findElement(RegisterLocator.btnContinue).click();
    }


}
