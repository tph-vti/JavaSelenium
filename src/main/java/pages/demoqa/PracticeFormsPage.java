package pages.demoqa;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

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

    public static final By txtPhoneNumber = By.id("userNumber");
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
    public static final By ddlSelectState = By.id("state");
    public static final By btnSubmit = By.id("submit");

    public static final By ddlMonth =
            By.cssSelector("select.react-datepicker__month-select");

    public static final By ddlYear =
            By.cssSelector("select.react-datepicker__year-select");

    public static By day(String day) {
        return By.xpath(
                "//div[contains(@class,'react-datepicker__day') " +
                        "and not(contains(@class,'react-datepicker__day--outside-month')) " +
                        "and text()='" + day + "']"
        );
    }

    public static final By ddlSelectCity = By.id("city");

    public static By cityOption(String city) {
        return By.xpath(
                "//div[contains(@id,'react-select') and text()='" + city + "']"
        );
    }
}


public class PracticeFormsPage extends BasePage {

    public void setDateOfBirth(String dateOfBirth) {
        logger.info("Setting date of birth: {}", dateOfBirth);
        click(PracticeFormsSelector.dateDateOfBirth);
        clearText(PracticeFormsSelector.dateDateOfBirth);
        enterText(PracticeFormsSelector.dateDateOfBirth, dateOfBirth);
        pressEnter(PracticeFormsSelector.dateDateOfBirth);
    }

    public void selectHobbies(List<String> hobbies) {
        logger.info("Selecting hobbies: {}", hobbies);
        for (String hobby : hobbies) {
            click(PracticeFormsSelector.hobbyLabel(hobby));
        }
    }

    public void selectState(String state) {
        logger.info("Selecting state: {}", state);
        click(PracticeFormsSelector.ddlSelectState);
        click(By.xpath("//div[contains(@id,'react-select') and text()='" + state + "']"));
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

    public void enterCurrentAddress(String address) {
        logger.info("Entering current address");

        if (address != null && !address.isEmpty()) {
            enterText(PracticeFormsSelector.txtAreaCurrentAddress, address);
        }
    }

    public void selectSubjects(List<String> subjects) {
        logger.info("Selecting subjects: {}", subjects);

        for (String subject : subjects) {
            enterText(PracticeFormsSelector.txtSubjects, subject);
            pressEnter(PracticeFormsSelector.txtSubjects);
        }
    }

    private void selectDateOfBirth(String date) {
        logger.info("Selecting date of birth: {}", date);

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);
        LocalDate localDate = LocalDate.parse(date, formatter);

        int day = localDate.getDayOfMonth();
        int month = localDate.getMonthValue(); // 1–12
        int year = localDate.getYear();

        click(PracticeFormsSelector.dateDateOfBirth);

        Select yearSelect =
                new Select(findVisibleElement(PracticeFormsSelector.ddlYear));
        yearSelect.selectByVisibleText(String.valueOf(year));

        Select monthSelect =
                new Select(findVisibleElement(PracticeFormsSelector.ddlMonth));
        monthSelect.selectByIndex(month - 1);

        click(PracticeFormsSelector.day(String.valueOf(day)));
    }

    public void selectCity(String city) {
        logger.info("Selecting city: {}", city);

        click(PracticeFormsSelector.ddlSelectCity);
        click(PracticeFormsSelector.cityOption(city));
    }

    public void enterPracticeForm(
            String firstName,
            String lastName,
            String email,
            String gender,
            String phoneNumber,
            String dateOfBirth,     // ✅ String
            List<String> subjects,
            List<String> hobbies,
            String currentAddress,
            String state,
            String city
    ) {
        logger.info("Entering Practice Form information");

        if (firstName != null && !firstName.isEmpty())
            enterText(PracticeFormsSelector.txtFirstName, firstName);

        if (lastName != null && !lastName.isEmpty())
            enterText(PracticeFormsSelector.txtLastName, lastName);

        if (email != null && !email.isEmpty())
            enterText(PracticeFormsSelector.txtEmail, email);

        if (gender != null && !gender.isEmpty())
            selectGender(gender);

        if (phoneNumber != null && !phoneNumber.isEmpty())
            enterText(PracticeFormsSelector.txtPhoneNumber, phoneNumber);

        // ✅ Date Picker via String
        if (dateOfBirth != null && !dateOfBirth.isEmpty())
            selectDateOfBirth(dateOfBirth);

        if (subjects != null && !subjects.isEmpty())
            selectSubjects(subjects);

        if (hobbies != null && !hobbies.isEmpty())
            selectHobbies(hobbies);

        if (currentAddress != null && !currentAddress.isEmpty())
            enterText(PracticeFormsSelector.txtAreaCurrentAddress, currentAddress);

        if (state != null && !state.isEmpty())
            selectState(state);

        if (city != null && !city.isEmpty())
            selectCity(city);
    }

    public void verifyPracticeFormsDisplays() {
        verifyElementVisible(PracticeFormsSelector.txtFirstName, "First Name text-box does not display");
        verifyElementVisible(PracticeFormsSelector.txtLastName, "Last Name text-box does not display");
        verifyElementVisible(PracticeFormsSelector.txtEmail, "Email text-box does not display");
        verifyElementVisible(PracticeFormsSelector.genderLbl("Male"), "Male radio button does not display");
        verifyElementVisible(PracticeFormsSelector.genderLbl("Female"), "Female radio button does not display");
        verifyElementVisible(PracticeFormsSelector.genderLbl("Other"), "Other radio button does not display");
        verifyElementVisible(PracticeFormsSelector.txtPhoneNumber, "Phone text-box does not display");
        verifyElementVisible(PracticeFormsSelector.dateDateOfBirth, "Date of Birth picker does not display");
        verifyElementVisible(PracticeFormsSelector.txtSubjects, "Subject text-box does not display");
        verifyElementVisible(PracticeFormsSelector.hobbyLabel("Sports"), "Sports hobby does not display");
        verifyElementVisible(PracticeFormsSelector.hobbyLabel("Reading"), "Reading hobby does not display");
        verifyElementVisible(PracticeFormsSelector.hobbyLabel("Music"), "Music hobby does not display");
        verifyElementVisible(PracticeFormsSelector.btnChooseFile, "Choose File button does not display");
        verifyElementVisible(PracticeFormsSelector.txtAreaCurrentAddress, "Current Address area text-box does not display");
        verifyElementVisible(PracticeFormsSelector.ddlSelectState, "Select State dropdown does not display");
        verifyElementVisible(PracticeFormsSelector.ddlSelectCity, "Select City dropdown does not display");
        verifyElementVisible(PracticeFormsSelector.btnSubmit, "Submit button does not display");
    }
}