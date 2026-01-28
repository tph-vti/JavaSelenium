package demoqa;

import core.BaseTest;
import models.WebTableRecord;
import utils.RandomDataHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.demoqa.WebTablesPage;

import java.util.List;

public class WebTablesTest extends BaseTest {

    private WebTablesPage webTablesPage;

    @BeforeEach
    public void setUpPages() {
        webTablesPage = new WebTablesPage();
    }

    @Test
    @Tag("demoqa")
    public void testAddNewEditDeleteRecord() {

        webTablesPage.openSite("https://demoqa.com/webtables");

        // ================= ADD =================
        String email = RandomDataHelper.randomEmail();

        WebTableRecord addRecord = new WebTableRecord(
                RandomDataHelper.randomFirstName(),
                RandomDataHelper.randomLastName(),
                RandomDataHelper.randomAge(),
                email,
                RandomDataHelper.randomSalary(),
                RandomDataHelper.randomDepartment()
        );

        webTablesPage.addNewRecord(
                addRecord.getFirstName(),
                addRecord.getLastName(),
                addRecord.getEmail(),
                addRecord.getAge(),
                addRecord.getSalary(),
                addRecord.getDepartment()
        );

        webTablesPage.verifyRecordDisplayed(email);
        webTablesPage.verifyRecordMatches(email, addRecord);

        // ================= EDIT =================
        WebTableRecord updatedRecord = new WebTableRecord(
                "EditedFirst",
                "EditedLast",
                "35",
                email,
                "9000",
                "QA"
        );

        webTablesPage.editRecordByEmail(
                email,
                updatedRecord.getFirstName(),
                updatedRecord.getLastName(),
                updatedRecord.getAge(),
                updatedRecord.getSalary(),
                updatedRecord.getDepartment()
        );

        webTablesPage.verifyRecordDisplayed(email);
        webTablesPage.verifyRecordMatches(email, updatedRecord);

        // ================= DELETE =================
        webTablesPage.deleteRecordByEmail(email);
        webTablesPage.verifyRecordNotDisplayed(email);

        // ================= GET COLUMN VALUES =================
        List<String> firstNames =
                webTablesPage.getAllValuesByHeader("First Name");
        System.out.println("First Names: " + firstNames);

        List<String> lastNames =
                webTablesPage.getAllValuesByHeader("Last Name");
        System.out.println("Last Names: " + lastNames);

        List<String> ages =
                webTablesPage.getAllValuesByHeader("Age");
        System.out.println("Ages: " + ages);

        List<String> emails =
                webTablesPage.getAllValuesByHeader("Email");
        System.out.println("Emails: " + emails);


        // ================= SORT =================
        webTablesPage.sortByHeader("First Name", "ASC");
        webTablesPage.verifySorted("First Name", "ASC");

        webTablesPage.sortByHeader("Last Name", "DESC");
        webTablesPage.verifySorted("Last Name", "DESC");

        webTablesPage.sortByHeader("Age", "ASC");
        webTablesPage.verifySorted("Age", "ASC");

        webTablesPage.sortByHeader("Salary", "DESC");
        webTablesPage.verifySorted("Salary", "DESC");


    }
}
