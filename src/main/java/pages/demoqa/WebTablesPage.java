package pages.demoqa;

import core.BasePage;
import models.WebTableRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.StringHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class WebTablesSelector {

    // ===== Buttons =====
    public static final By btnAdd =
            By.id("addNewRecordButton");

    public static final By txtSearch =
            By.id("searchBox");

    // ===== Registration Form =====
    public static final By txtFirstName =
            By.id("firstName");

    public static final By txtLastName =
            By.id("lastName");

    public static final By txtEmail =
            By.id("userEmail");

    public static final By txtAge =
            By.id("age");

    public static final By txtSalary =
            By.id("salary");

    public static final By txtDepartment =
            By.id("department");

    public static final By btnSubmit =
            By.id("submit");

    // ===== Table =====
    public static By rowByEmail(String email) {
        return By.xpath("//div[@role='row']//div[text()='" + email + "']/ancestor::div[@role='row']");
    }

    public static By editButtonByEmail(String email) {
        return By.xpath("//div[text()='" + email + "']/following-sibling::div//span[contains(@id,'edit-record')]");
    }

    public static By deleteButtonByEmail(String email) {
        return By.xpath("//div[text()='" + email + "']/following-sibling::div//span[contains(@id,'delete-record')]");
    }

    // All headers
    public static final By headers =
            By.xpath("//div[@role='columnheader']//div[contains(@class,'rt-resizable-header-content')]");

    public static By headerByName(String header) {
        return By.xpath(
                "//div[@role='columnheader']//div[normalize-space()='" + header + "']"
        );
    }


    // Cells by column index
    public static By cellsByColumnIndex(int index) {
        return By.xpath(
                "//div[@role='row' and not(contains(@class,'-padRow'))]" +
                        "/div[@role='gridcell'][" + (index + 1) + "]"
        );
    }

    // Pagination
    public static final By btnPrevious = By.cssSelector(".-pagination .-previous button");
    public static final By btnNext = By.cssSelector(".-pagination .-next button");
    public static final By txtPageJump = By.cssSelector(".-pagination .-pageJump input");
    public static final By lblTotalPages = By.cssSelector(".-pagination .-totalPages");
    public static final By ddlRowPerPage = By.cssSelector(".-pagination select");

    public static final By tableLoading = By.cssSelector(".-loading");
}

public class WebTablesPage extends BasePage {

    // ===== BASIC ACTIONS =====

    public void openAddNewRecordForm() {
        click(WebTablesSelector.btnAdd);
    }

    public void search(String keyword) {
        clearText(WebTablesSelector.txtSearch);
        enterText(WebTablesSelector.txtSearch, keyword);
    }

    // ===== ENTER FORM (giống PracticeForm) =====

    public void enterWebTableRecord(
            String firstName,
            String lastName,
            String email,
            String age,
            String salary,
            String department
    ) {
        logger.info("Entering Web Table record");

        if (StringHelper.isNotBlank(firstName))
            clearAndEnterText(WebTablesSelector.txtFirstName, firstName);

        if (StringHelper.isNotBlank(lastName))
            clearAndEnterText(WebTablesSelector.txtLastName, lastName);

        if (StringHelper.isNotBlank(email))
            clearAndEnterText(WebTablesSelector.txtEmail, email);

        if (StringHelper.isNotBlank(age))
            clearAndEnterText(WebTablesSelector.txtAge, age);

        if (StringHelper.isNotBlank(salary))
            clearAndEnterText(WebTablesSelector.txtSalary, salary);

        if (StringHelper.isNotBlank(department))
            clearAndEnterText(WebTablesSelector.txtDepartment, department);

        click(WebTablesSelector.btnSubmit);
    }

    // ===== HIGH LEVEL FLOWS =====

    public void addNewRecord(
            String firstName,
            String lastName,
            String email,
            String age,
            String salary,
            String department
    ) {
        openAddNewRecordForm();
        enterWebTableRecord(firstName, lastName, email, age, salary, department);
    }

    public void editRecordByEmail(
            String email,
            String newFirstName,
            String newLastName,
            String newAge,
            String newSalary,
            String newDepartment
    ) {
        click(WebTablesSelector.editButtonByEmail(email));
        enterWebTableRecord(newFirstName, newLastName, null, newAge, newSalary, newDepartment);
    }

    public void deleteRecordByEmail(String email) {
        click(WebTablesSelector.deleteButtonByEmail(email));
    }

    private int getColumnIndexByHeader(String headerName) {

        List<WebElement> headers =
                driver.findElements(WebTablesSelector.headers);

        for (int i = 0; i < headers.size(); i++) {
            if (headers.get(i).getText().trim().equalsIgnoreCase(headerName)) {
                return i;
            }
        }

        throw new IllegalArgumentException(
                "Header not found: " + headerName
        );
    }

    private String getCellValueByHeader(String email, String headerName) {
        int index = getColumnIndexByHeader(headerName);

        return driver.findElement(
                By.xpath(
                        "//div[text()='" + email + "']/ancestor::div[@role='row']" +
                                "/div[@role='gridcell'][" + (index + 1) + "]"
                )
        ).getText().trim();
    }

    public List<String> getAllValuesByHeader(String headerName) {

        int columnIndex = getColumnIndexByHeader(headerName);

        return driver.findElements(
                        WebTablesSelector.cellsByColumnIndex(columnIndex)
                ).stream()
                .map(e -> e.getText().trim())
                .filter(text -> !text.isEmpty())
                .toList();
    }

    public WebTableRecord getRecordByEmail(String email) {
        return new WebTableRecord(
                getCellValueByHeader(email, "First Name"),
                getCellValueByHeader(email, "Last Name"),
                getCellValueByHeader(email, "Age"),
                getCellValueByHeader(email, "Email"),
                getCellValueByHeader(email, "Salary"),
                getCellValueByHeader(email, "Department")
        );
    }

    // ===== VERIFY =====

    public void verifyRecordMatches(String email, WebTableRecord expected) {
        WebTableRecord actual = getRecordByEmail(email);
        verifyEquals(actual.toString(), expected.toString(), "Record data mismatch");
    }

    public void verifyRecordDisplayed(String email) {
        verifyElementVisible(
                WebTablesSelector.rowByEmail(email),
                "Record with email " + email + " is not displayed"
        );
    }

    public void verifyRecordNotDisplayed(String email) {
        verifyTrue(
                driver.findElements(WebTablesSelector.rowByEmail(email)).isEmpty(),
                "Record with email " + email + " is still displayed"
        );
    }

    public String getCurrentPage() {
        return findVisibleElement(WebTablesSelector.txtPageJump)
                .getDomAttribute("value");
    }

    public String getTotalPage() {
        return findVisibleElement(WebTablesSelector.lblTotalPages)
                .getText();
    }

    public void goToNextPage() {
        if (findVisibleElement(WebTablesSelector.btnNext).isEnabled()) {
            click(WebTablesSelector.btnNext);
        }
    }

    public void goToPreviousPage() {
        if (findVisibleElement(WebTablesSelector.btnPrevious).isEnabled()) {
            click(WebTablesSelector.btnPrevious);
        }
    }

    public void goToPage(String pageNumber) {
        clearAndEnterText(WebTablesSelector.txtPageJump, pageNumber);
    }

    public void setRowsPerPage( String row) {
        Select select = new Select(findVisibleElement(WebTablesSelector.ddlRowPerPage));
        select.selectByValue(row);
    }

    public void goToLastPage() {
        goToPage(getTotalPage());
    }


    public List<WebTableRecord> getAllRecordsAcrossPage() {
        List<WebTableRecord> allRecords = new ArrayList<>();
        String totalPages = getTotalPage();
        for (int page =1 ; page <= Integer.parseInt(totalPages); page++) {
            goToPage(String.valueOf(page));
            for (String email: getAllValuesByHeader("Email")) {
                allRecords.add(getRecordByEmail(email));
            }
        }
        return allRecords;
    }

    //SORT

    private enum SortOrder {
        ASC, DESC
    }
    public void sortByHeader(String header, String order) {
        SortOrder sortOrder = SortOrder.valueOf(order.toUpperCase());
        click(WebTablesSelector.headerByName(header));
        if (sortOrder == SortOrder.DESC) {
            click(WebTablesSelector.headerByName(header));
        }
    }

    private boolean isStringSorted(List<String> values, SortOrder order) {
        List<String> sorted = new ArrayList<>(values);
        sorted.sort(String::compareToIgnoreCase);

        if (order == SortOrder.DESC) {
            Collections.reverse(sorted);
        }
        return values.equals(sorted);
    }

    private boolean isNumberSorted(List<String> values, SortOrder order) {
        List<Integer> nums = values.stream()
                .map(Integer::parseInt)
                .toList();

        List<Integer> sorted = new ArrayList<>(nums);
        sorted.sort(Integer::compareTo);

        if (order == SortOrder.DESC) {
            Collections.reverse(sorted);
        }
        return nums.equals(sorted);
    }

    public boolean isSorted(String header, String order) {
        SortOrder sortOrder = SortOrder.valueOf(order.toUpperCase());
        List<String> values = getAllValuesByHeader(header);

        if (header.equalsIgnoreCase("Age")
                || header.equalsIgnoreCase("Salary")) {
            return isNumberSorted(values, sortOrder);
        }
        return isStringSorted(values, sortOrder);
    }

    private boolean isNumericColumn(String header) {
        return header.equalsIgnoreCase("Age")
                || header.equalsIgnoreCase("Salary");
    }

    public void verifySorted(String header, String order) {

        SortOrder sortOrder = SortOrder.valueOf(order.toUpperCase());
        List<String> values = getAllValuesByHeader(header);

        boolean isSorted;

        if (isNumericColumn(header)) {
            isSorted = isNumberSorted(values, sortOrder);
        } else {
            isSorted = isStringSorted(values, sortOrder);
        }

        verifyTrue(
                isSorted,
                String.format("Column '%s' is not sorted %s", header, order)
        );
    }

}