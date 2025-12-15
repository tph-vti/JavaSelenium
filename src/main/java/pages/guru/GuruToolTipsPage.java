package pages.guru;

import org.openqa.selenium.By;

import core.BasePage;

class GuruToolTipsPageSelector {
    public static final By btnDownloadNow = By.id("download_now");
    public static final By imgEyes = By.xpath("//img[@src='img/eye.png']");
}

public class GuruToolTipsPage extends BasePage {

    public GuruToolTipsPage() {
        super();
        openSite("https://demo.guru99.com/test/tooltip.html");
    }
    
    public void hoverToDownloadNowButton() {
        logger.info("Hovering to 'Download now' button");
        hoverElement(GuruToolTipsPageSelector.btnDownloadNow);
    }
    
    public void verifyTooltipTextIsDisplayed() {
        logger.info("Verifying tooltip text is displayed for 'Download now' button");
        verifyElementVisible(GuruToolTipsPageSelector.imgEyes, "Tooltip image is not visible");
    }
}
