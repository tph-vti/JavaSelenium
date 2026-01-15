package pages.demoqa;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

class PracticeFormsSelector {
    public static final By txtFirstName = By.id("firstName");
    public static final By txtLastName = By.id("lastName");
    public static final By txtEmail = By.id("userEmail");

    public static final By genderLbl(String gender) {
        return By.xpath("//label[@for=(//input[@name='gender' and @value='"+gender+"']/@id)]");
    }
    public static final By genderRdo(String gender) {
        return By.xpath("//input[@name='gender' and @value='"+gender+"']");
    }


    public static final By number = By.id("userNumber");
    public static final By dateDateOfBirth = By.id("dateOfBirthInput");
    public static final By txtSubjects = By.id("subjectsInput");

    public static By hobbyLabel(String hobby) {
        return By.xpath("//label[normalize-space()='" + hobby + "']");
    }

    public static By hobbyCheckbox(String hobby) {
        return By.xpath(
                "//label[normalize-space()='" + hobby + "']/preceding-sibling::input"
        );
    }

    public static final By btnChooseFile = By.id("uploadPicture");
    public static final By txtAreaCurrentAddress = By.id("currentAddress");
    public static final By ddlSelectState = By.xpath("//div[contains(@id,'react-select-3-option')]");
    public static final By btnSubmit = By.id("submit");
}


public class PracticeFormsPage extends BasePage {

    public void enterFirstName(String firstName) {
        logger.info("Input firstname: {}", firstName);
        enterText(PracticeFormsSelector.txtFirstName, firstName);
    }

    public void enterLastName(String firstName) {
        logger.info("Input firstname: {}", firstName);
        enterText(PracticeFormsSelector.txtFirstName, firstName);
    }

    public void selectGender(String gender) {
        logger.info("Selecting gender: {}", gender);
        WebElement genderElement = driver.findElement(
                PracticeFormsSelector.genderLbl(gender)
        );
        scrollToElement(driver, genderElement);
        genderElement.click();
    }
    public boolean isGenderSelected(String gender) {
        return isElementSelected(PracticeFormsSelector.genderRdo(gender));
    }

    public void verifyGenderSelected(String gender) {
        verifyTrue(
                isGenderSelected(gender),
                String.format("Gender %s is not selected", gender)
        );
    }
}