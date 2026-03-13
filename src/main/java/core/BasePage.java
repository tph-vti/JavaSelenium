package core;

import core.base.NetworkHelper;

public class BasePage extends NetworkHelper {

    public BasePage() {
        // driver is initialized in ElementFinder via DriverManager.getDriver()
    }

    // ═══════════════════ NAVIGATION ═══════════════════

    /**
     * Opens the base URL configured in TestSettings.
     */
    public void openSite() {
        logger.info("Navigating to URL: {}", TestSettings.BASE_URL);
        this.driver.get(TestSettings.BASE_URL);
        logger.info("Navigation to URL: {} completed", TestSettings.BASE_URL);
    }

    /**
     * Opens a specific URL.
     *
     * @param url the URL to navigate to
     */
    public void openSite(String url) {
        logger.info("Navigating to URL: {}", url);
        this.driver.get(url);
        logger.info("Navigation to URL: {} completed", url);
    }

    // ═══════════════════ UTILITY ═══════════════════

    /**
     * Creates a dynamic XPath {@link org.openqa.selenium.By} from a template.
     * Reduces boilerplate in Page classes for parameterised locators.
     *
     * @param xpathTemplate a format string with {@code %s} placeholders
     * @param args           values to substitute
     * @return By.xpath with substituted values
     */
    protected org.openqa.selenium.By getDynamicXpath(String xpathTemplate, String... args) {
        String xpath = String.format(xpathTemplate, (Object[]) args);
        return org.openqa.selenium.By.xpath(xpath);
    }

    // ═══════════════════ AD HANDLING ═══════════════════

    /**
     * Removes all visible ad elements from the page using JavaScript.
     * Targets iframes and elements with known ad-related identifiers.
     */
    public void removeAds() {
        logger.info("Removing ads using JavaScript");
        String script = "var ads = document.querySelectorAll('iframe, ins, .adsbygoogle, div[id*=\"google_ads\"], div[class*=\"google_ads\"]');" +
                        "ads.forEach(function(ad) { ad.remove(); });" +
                        "document.querySelectorAll('body > div:last-child').forEach(function(el) {" +
                        "  if(el.style.zIndex > 1000) el.remove();" +
                        "});";
        try {
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(script);
        } catch (Exception e) {
            logger.warn("Failed to remove ads: {}", e.getMessage());
        }
    }

    /**
     * Specifically handles Google Vignette ads that often block page transitions.
     */
    public void handleVignette() {
        try {
            // Check if the URL contains #google_vignette which indicates a blocking ad
            if (driver.getCurrentUrl().contains("#google_vignette")) {
                logger.info("Google Vignette detected via URL, refreshing page");
                driver.navigate().refresh();
                waitForPageStable();
            }
            // Also check for common vignette close buttons or overlays
            String script = "var closeBtn = document.querySelector('#dismiss-button');" +
                            "if(closeBtn) closeBtn.click();" +
                            "var frames = document.querySelectorAll('iframe[id^=\"aswift_\"]');" +
                            "frames.forEach(f => { if(f.contentDocument && f.contentDocument.querySelector('#dismiss-button')) f.contentDocument.querySelector('#dismiss-button').click(); });";
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(script);
        } catch (Exception e) {
            logger.debug("Vignette check/close failed: {}", e.getMessage());
        }
    }

    /**
     * Clicks an element using JavaScript to avoid 'ElementClickIntercepted' errors.
     * Useful when ads or overlays are present.
     */
    public void clickButtonJS(org.openqa.selenium.By selector) {
        logger.info("Clicking button via JS: {}", selector);
        try {
            org.openqa.selenium.WebElement element = findElementPresent(selector);
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            logger.error("Failed to click button via JS: {}", selector, e);
            throw e;
        }
    }
}
