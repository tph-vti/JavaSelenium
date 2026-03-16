package locator;

import org.openqa.selenium.By;

public class RegisterLocator {
    public static By registerTitle = By.xpath("//b[contains(text(),'Enter Account Information')]");

    public static By titleMr = By.id("id_gender1");
    public static By titleMrs = By.id("id_gender2");

    public static By name = By.id("name");
    public static By email = By.id("email");
    public static By password = By.id("password");

    public static By dayDropdown = By.id("days");
    public static By monthDropdown = By.id("months");
    public static By yearDropdown = By.id("years");

    public static By newsletterCheckbox = By.id("newsletter");
    public static By offersCheckbox = By.id("optin");


    public static By firstName = By.id("first_name");
    public static By lastName = By.id("last_name");
    public static By company = By.id("company");

    public static By address1 = By.id("address1");
    public static By address2 = By.id("address2");

    public static By countryDropdown = By.id("country");

    public static By state = By.id("state");
    public static By city = By.id("city");

    public static By zipcode = By.id("zipcode");
    public static By mobileNumber = By.id("mobile_number");

    public static By createAccountButton = By.xpath("//button[@data-qa='create-account']");

    public static By accountCreatedTitle = By.xpath("//b[contains(text(),'Account Created!')]");

    public static By btnContinue = By.xpath("//a[@data-qa='continue-button']");

}