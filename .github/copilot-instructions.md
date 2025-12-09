# Copilot Instructions - JUnit 5 + Selenium Test Automation Framework

## Architecture Overview

This is a **Selenium-based test automation framework** using **JUnit 5** with **Page Object Model (POM)** design pattern. The project follows a layered architecture:

- **`core/`** - Core framework components:
  - `DriverManager` - WebDriver lifecycle management with browser factory pattern (Chrome, Firefox, Edge)
  - `BasePage` - Page Object base class with common web interactions and explicit waits
  - `BaseTest` - Test foundation class with JUnit 5 lifecycle hooks (`@BeforeAll`, `@AfterAll`)
  - `TestSettings` - Centralized configuration from `.env` and JSON
- **`pages/`** - Page Object Model implementations organized by application (e.g., `applitools/`, `guru/`)
- **`modals/`** - Data models (POJOs) like `BookModal`, `AddressModal`
- **`utils/`** - Helper utilities:
  - `Helper` - Base class providing logging (Log4j2) and JSON file loading
  - `CSVHelper`, `JsonHelper` - Data parsing utilities
  - `Constants` - Centralized path constants
- **`src/test/java/`** - Test classes organized by application feature

**Key Pattern**: Core classes extend `Helper` to inherit logging and utility methods.

## Critical Development Workflows

### Build & Test Execution
```bash
# Compile project (Java 25)
mvn clean compile

# Run all tests with Surefire
mvn test

# Run tests for specific environment
mvn clean test -Denv=GURU

# Run tests with specific browser
mvn clean test -Dbrowser=firefox

# Run tests with both options
mvn clean test -Denv=APPLITOOLS -Dbrowser=chrome
```

### Environment Configuration
- **`.env` file** in project root (optional) - can override defaults:
  ```properties
  TEST_ENV=GURU
  BROWSER=chrome
  ```
- **`TestData.json`** in `src/main/resources/` - contains environment-specific configurations:
  ```json
  {
    "GURU": {
      "base_url": "https://demo.guru99.com/..."
    },
    "APPLITOOLS": {
      "base_url": "https://demo.applitools.com/..."
    }
  }
  ```
- `TestSettings` class loads configuration from:
  1. System properties (`-Denv=`, `-Dbrowser=`)
  2. `.env` file (if present)
  3. Hardcoded defaults
- All file paths use `Constants.java` - never hardcode paths

### Browser Configuration
- Default: **Chrome (non-headless)**
- Supported: `chrome`, `firefox`, `edge`
- Configuration in `DriverManager.initializeDriver()`:
  - Screen resolution: `1920,1080`
  - Headless mode: `false` (change `TestSettings.HEADLESS` to enable)
- Browser options managed via `ChromeOptions`, `FirefoxOptions`, etc.

## Project-Specific Conventions

### Class Naming & Structure
- **Modals not Models** - Data classes are in `modals/` package (e.g., `BookModal`, `AddressModal`)
- **Helper base class** - Core classes extend `Helper` for logging and JSON utilities
- **Static WebDriver** - `DriverManager` uses `ThreadLocal<WebDriver>` for thread safety
- **Page Object pattern** - All page classes extend `BasePage` which provides:
  - WebDriver access via `DriverManager.getDriver()`
  - Common interactions: `clickButton()`, `enterText()`, `getElementAttribute()`
  - Explicit waits via `getWait()` method

### Data Handling Patterns
```java
// JSON configuration loading (via TestSettings)
String baseUrl = TestSettings.BASE_URL; // Reads from TestData.json

// CSV reading with OpenCSV
CSVHelper csv = new CSVHelper(Constants.ADDRESSES_FILE_PATH);
List<String[]> data = csv.getCsvData();

// JSON parsing
Helper helper = new Helper();
JSONObject json = helper.loadJsonFile(Constants.JSON_DATA_PATH);

// All file paths use Constants.java
String resourcesPath = Constants.RESOURCES_PATH;
String csvPath = Constants.ADDRESSES_FILE_PATH;
```

### Test Data Resources
Located in `src/main/resources/` (copied to `target/classes/` during build):
- **`TestData.json`** - Environment-specific URLs and configuration
- **`addresses.csv`** - CSV test data
- **`log4j2.xml`** - Log4j2 configuration

## Current Implementation Status

### Completed Features
- ✅ JUnit 5 integration with `@BeforeAll` and `@AfterAll` lifecycle hooks
- ✅ Multi-browser support (Chrome, Firefox, Edge)
- ✅ Environment-based configuration via `.env` and `TestData.json`
- ✅ Page Object Model with `BasePage` providing common interactions
- ✅ Explicit waits using WebDriverWait and ExpectedConditions
- ✅ Log4j2 integration for comprehensive logging
- ✅ ThreadLocal WebDriver for thread-safe test execution
- ✅ CSV and JSON data parsing utilities
- ✅ Working test examples: `AppliToolTest`, `GutuTest`

### Implementation Notes
- `BaseTest` uses `@BeforeAll`/`@AfterAll` for class-level setup (runs once per test class)
- `DriverManager` is static and thread-safe using `ThreadLocal<WebDriver>`
- All waits use `ExpectedConditions` - **NO `Thread.sleep()` except for 1-second post-click stabilization**
- Logging is available in all classes via `logger` inherited from `Helper`

## Coding Guidelines

### When Creating Tests
- Extend `BaseTest` class
- Place in `src/test/java/` with feature-based package structure (e.g., `applitools/`, `guru/`)
- Use `Constants.java` for all file paths - **never hardcode paths**
- `@BeforeAll` and `@AfterAll` are already implemented in `BaseTest` - don't override unless needed
- Tests inherit `driverManager` from `BaseTest`

### When Creating Page Objects
```java
public class LoginPage extends BasePage {
    // 1. Define locators as private final By variables
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    
    // 2. No constructor needed - BasePage handles initialization
    
    // 3. Create action methods using BasePage utilities
    public LoginPage enterUsername(String username) {
        enterText(usernameField, username);
        return this;
    }
    
    public LoginPage enterPassword(String password) {
        enterText(passwordField, password);
        return this;
    }
    
    public DashboardPage clickLogin() {
        clickButton(loginButton);
        return new DashboardPage(); // Return next page object
    }
    
    // 4. Use method chaining for fluent interface
    public DashboardPage login(String username, String password) {
        return enterUsername(username)
                .enterPassword(password)
                .clickLogin();
    }
}
```

**Key Rules for Page Objects:**
- **All locators** must be `private final By` variables
- **Prefer** `By.id()` and `By.cssSelector()` over `By.xpath()`
- **Return types**: `this` for chaining, or next `PageObject` on navigation
- **Use inherited methods** from `BasePage`: `enterText()`, `clickButton()`, `getElementAttribute()`, `findElement()`, `getWait()`
- **NO `Thread.sleep()`** - use `getWait()` for explicit waits

### When Adding Test Data
- JSON/CSV files go in `src/main/resources/`
- Add path constants to `Constants.java`
- Use `CSVHelper` for CSV files, `Helper.loadJsonFile()` for JSON
- Parse to modal objects (`BookModal`, `AddressModal`)

### Logging Best Practices
```java
// All classes extending Helper have access to logger
logger.info("Starting test for user: {}", username);
logger.debug("Clicking element: {}", selector);
logger.error("Failed to find element", exception);
```

## Key Files Reference

- **`core/DriverManager.java`** - ThreadLocal WebDriver initialization with browser factory (Chrome/Firefox/Edge)
- **`core/BasePage.java`** - Base class for all Page Objects with common interactions
- **`core/BaseTest.java`** - JUnit 5 test foundation with `@BeforeAll`/`@AfterAll` hooks
- **`core/TestSettings.java`** - Configuration management (env, browser, timeouts, URLs)
- **`utils/Helper.java`** - Base class providing Log4j2 logging and JSON loading to all components
- **`utils/Constants.java`** - Central path constants (`PROJECT_ROOT_PATH`, `RESOURCES_PATH`, `JSON_DATA_PATH`)
- **`pom.xml`** - Maven dependencies and Surefire plugin configuration

## Maven Dependencies

```xml
<!-- Current versions -->
Selenium WebDriver: 4.38.0
JUnit Jupiter: 6.0.1
Surefire Plugin: 3.5.4
Log4j2: 2.24.3
OpenCSV: 5.12.0
JSON: 20240303
Dotenv: 3.2.0
Java Version: 25
```
