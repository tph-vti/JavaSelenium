package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUpPageSelector extends BasePage {
    WebDriver driver;

    public SignUpPageSelector (WebDriver driver) {
        this.driver = driver;
    }

    public static final By title_Mr = By.id("id_gender1");
    public static final By title_Mrs = By.id("id_gender2");
    public static final By password = By.id("password");

    public static final By days = By.id("days");
    public static final By months= By.id("months");
    public static final By years = By.id("years");

    public static final By newsletter = By.id("newsletter");
    public static final By option = By.id("option");

    public static final By firstName = By.id("first_name");
    public static final By lastName = By.id("last_name");
    public static final By address1 = By.id("address1");
    public static final By address2 = By.id("address2");

    public static final By country = By.id("country");
    public static final By state = By.id("state");
    public static final By city = By.id("city");
    public static final By zipcode = By.id("zipcode");
    public static final By mobile = By.id("mobile_number");

    public static final By createBtn = By.cssSelector("button[data-qa='create-account']");


    public static class SignupPage {
        WebDriver driver;

    }
    //radio button Title
    public void selectTitleMr(){
        click(SignUpPageSelector.title_Mr);
    }
    public void selectTitleMrs(){
        click(SignUpPageSelector.title_Mrs);
    }

    public void enterPassword(String password) {
        enterText(SignUpPageSelector.password, password);
    }

    public void selectDay(String day) {
        new Select(driver.findElement(SignUpPageSelector.days))
                .selectByValue(day);
    }

    public void selectMonth(String month) {
        new Select(driver.findElement(SignUpPageSelector.months))
                .selectByValue(month);
    }

    public void selectYear(String year) {
        new Select(driver.findElement(SignUpPageSelector.years))
                .selectByValue(year);
    }

    public void fillAddress(String fname, String lname, String addr, String ctry) {
        enterText(SignUpPageSelector.firstName, fname);
        enterText(SignUpPageSelector.lastName, lname);
        enterText(SignUpPageSelector.address1, addr);
    }

    public void clickCreate() {
        driver.findElement(createBtn).click();
    }
}
