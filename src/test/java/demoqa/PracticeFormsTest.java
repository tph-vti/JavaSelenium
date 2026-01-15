package demoqa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import core.BaseTest;
import pages.demoqa.PracticeFormsPage;

/**
 * Test class for QA Auto demo site.
 */
public class PracticeFormsTest extends BaseTest {
    PracticeFormsPage practiceFormsPage;

    @BeforeEach
    public void setUpPages() {
        practiceFormsPage = new PracticeFormsPage();
    }

    @Test
    @Tag("demoqa")
    public void testGender() {
        practiceFormsPage.openSite("https://demoqa.com/automation-practice-form");
        practiceFormsPage.selectGender("Male");
        practiceFormsPage.verifyGenderSelected("Male");

        practiceFormsPage.selectGender("Female");
        practiceFormsPage.verifyGenderSelected("Female");

        practiceFormsPage.selectGender("Other");
        practiceFormsPage.verifyGenderSelected("Other");
    }
}
