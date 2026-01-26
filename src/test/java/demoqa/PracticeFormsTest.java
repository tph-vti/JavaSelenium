package demoqa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import core.BaseTest;
import pages.demoqa.PracticeFormsPage;

import java.util.List;

/**
 * Test class for QA Auto demo site.
 */
public class PracticeFormsTest extends BaseTest {
    PracticeFormsPage practiceFormsPage;

    @BeforeEach
    public void setUpPages() {
        practiceFormsPage = new PracticeFormsPage();
    }

//    @Test
    @Tag("demoqa")
    public void testGender() {
        practiceFormsPage.openSite("https://demoqa.com/automation-practice-form");
        practiceFormsPage.verifyPracticeFormsDisplays();
        practiceFormsPage.enterPracticeForm(
                "John",
                "Doe",
                "john@gmail.com",
                "Male",
                "0123456789",
                "10 Oct 1990",
                List.of("Maths", "Physics"),
                List.of("Sports", "Music"),
                "123 Le Duan, Da Nang",
                "NCR",
                "Delhi"
        );
    }
}
