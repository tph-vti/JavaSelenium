# Selenium Test Automation Framework

A robust **Selenium-based test automation framework** using **JUnit 5** with **Page Object Model (POM)** design pattern. Built for scalable, maintainable, and thread-safe web automation testing.

[![Java](https://img.shields.io/badge/Java-25-orange.svg)](https://www.oracle.com/java/)
[![Selenium](https://img.shields.io/badge/Selenium-4.27.0-green.svg)](https://www.selenium.dev/)
[![JUnit](https://img.shields.io/badge/JUnit-5-blue.svg)](https://junit.org/junit5/)
[![Maven](https://img.shields.io/badge/Maven-3.x-red.svg)](https://maven.apache.org/)
[![Log4j2](https://img.shields.io/badge/Log4j2-2.24.3-purple.svg)](https://logging.apache.org/log4j/2.x/)

## 📋 Table of Contents

- [Features](#-features)
- [Architecture](#-architecture)
- [Prerequisites](#-prerequisites)
- [Installation](#-installation)
- [Quick Start](#-quick-start)
- [Configuration](#-configuration)
- [Project Structure](#-project-structure)
- [Usage](#-usage)
- [Running Tests](#-running-tests)
- [Creating Tests](#-creating-tests)
- [Test Reports](#-test-reports)
- [Logging](#-logging)
- [Best Practices](#-best-practices)
- [Troubleshooting](#-troubleshooting)
- [Technologies](#-technologies)
- [Contributing](#-contributing)

## ✨ Features

- **Multi-Browser Support** - Chrome, Firefox, and Edge with browser factory pattern
- **Thread-Safe Execution** - ThreadLocal WebDriver for parallel test execution
- **Page Object Model** - Clean separation of test logic and page elements
- **Environment Configuration** - Flexible configuration via `.env` and JSON files
- **Comprehensive Logging** - Log4j2 integration with detailed test execution logs
- **Data-Driven Testing** - Support for CSV and JSON test data
- **Explicit Waits** - Intelligent waiting strategies using WebDriverWait
- **JUnit 5 Integration** - Modern test framework with lifecycle hooks
- **Maven Build Tool** - Dependency management and test execution via Surefire

## 🏗️ Architecture

The framework follows a **layered architecture** with clear separation of concerns:

```
┌─────────────────────────────────────────────┐
│           Test Layer (JUnit 5)              │
│        (AppliToolTest, GutuTest)            │
└────────────────┬────────────────────────────┘
                 │ extends
┌────────────────▼────────────────────────────┐
│          BaseTest (Test Foundation)         │
│   - @BeforeAll/@AfterAll Lifecycle Hooks    │
│   - DriverManager Initialization            │
└────────────────┬────────────────────────────┘
                 │ uses
┌────────────────▼────────────────────────────┐
│      Page Object Layer (POM Pattern)        │
│   LoginPage, DashBoardPage, ManagerPage     │
└────────────────┬────────────────────────────┘
                 │ extends
┌────────────────▼────────────────────────────┐
│     BasePage (Common Page Interactions)     │
│   - clickButton(), enterText()              │
│   - getWait(), verifyElementVisible()       │
└────────────────┬────────────────────────────┘
                 │ uses
┌────────────────▼────────────────────────────┐
│    DriverManager (WebDriver Lifecycle)      │
│   - ThreadLocal WebDriver Management        │
│   - Browser Factory Pattern                 │
└────────────────┬────────────────────────────┘
                 │ extends
┌────────────────▼────────────────────────────┐
│         Helper (Base Utilities)             │
│   - Log4j2 Logger, JSON File Loading        │
└─────────────────────────────────────────────┘
```

### Key Components

#### **Core Layer** (`core/`)
- **`DriverManager`** - WebDriver lifecycle management with browser factory pattern (Chrome, Firefox, Edge)
- **`BasePage`** - Base class for all Page Objects with common web interactions and explicit waits
- **`BaseTest`** - Test foundation class with JUnit 5 lifecycle hooks (`@BeforeAll`, `@AfterAll`)
- **`TestSettings`** - Centralized configuration from `.env` and JSON files

#### **Page Object Layer** (`pages/`)
- Page Object Model implementations organized by application
- Each page class extends `BasePage` and encapsulates page elements and actions
- Examples: `LoginPage`, `DashBoardPage`, `ManagerPage`

#### **Utils Layer** (`utils/`)
- **`Helper`** - Base class providing logging (Log4j2) and JSON file loading
- **`Constants`** - Centralized path constants for resources, logs, and data files
- **`CSVHelper`**, **`JsonHelper`** - Data parsing utilities

#### **Data Models** (`modals/`)
- POJOs for test data (e.g., `BookModal`, `AddressModal`)

## 📦 Prerequisites

- **Java 25** or higher
- **Maven 3.x** or higher
- **Chrome/Firefox/Edge** browser installed
- **Git** (for cloning the repository)

## 🚀 Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/mxstudios-dn/at_2503.git
   cd at_2503
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Verify installation**
   ```bash
   mvn clean test
   ```

## 🚀 Quick Start

Get started with a simple test in under a minute:

```bash
# Run a single test class
mvn clean test -Dtest=AppliToolTest

# Run tests with specific browser
mvn clean test -Dbrowser=chrome

# Run tests for specific environment
mvn clean test -Denv=GURU
```

Check test results:
- **HTML Report**: Open `target/reports/surefire.html` in your browser
- **Logs**: View `target/logs/` for detailed execution logs
- **Console**: Real-time output during test execution

## ⚙️ Configuration

### Environment Configuration

The framework supports flexible configuration through multiple sources:

#### 1. **`.env` File** (Optional)
Create a `.env` file in the project root:

```properties
TEST_ENV=GURU
BROWSER=chrome
```

#### 2. **`TestData.json`** (Required)
Located at `src/main/resources/TestData.json`:

```json
{
  "GURU": {
    "base_url": "https://demo.guru99.com/"
  },
  "APPLITOOLS": {
    "base_url": "https://demo.applitools.com/"
  }
}
```

#### 3. **System Properties** (Runtime Override)
Override via command line:

```bash
mvn clean test -Denv=APPLITOOLS -Dbrowser=firefox
```

### Configuration Hierarchy
1. **System Properties** (`-Denv=`, `-Dbrowser=`)
2. **`.env` File** (if present)
3. **Default Values** (hardcoded in `TestSettings`)

### Browser Configuration

Supported browsers:
- **Chrome** (default)
- **Firefox**
- **Edge**

Browser settings in `DriverManager`:
- **Screen Resolution**: `1920x1080`
- **Headless Mode**: `false` (configurable via `TestSettings.HEADLESS`)
  - To enable headless mode: Modify `TestSettings.HEADLESS = true` in `TestSettings.java`
  - Useful for CI/CD pipelines and background test execution

### Adding New Environments

To add a new test environment:

1. **Update `TestData.json`**:
   ```json
   {
     "PRODUCTION": {
       "base_url": "https://production.example.com/"
     }
   }
   ```

2. **Run tests with new environment**:
   ```bash
   mvn clean test -Denv=PRODUCTION
   ```

### Timeout Settings

Configured in `TestSettings.java`:
- **Default Timeout**: 30 seconds
- **Element Wait**: 10 seconds

## 📁 Project Structure

```
at_2503/
├── pom.xml                          # Maven configuration
├── .env                             # Environment variables (optional)
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── core/                # Framework core components
│   │   │   │   ├── BasePage.java
│   │   │   │   ├── BaseTest.java
│   │   │   │   ├── DriverManager.java
│   │   │   │   └── TestSettings.java
│   │   │   ├── pages/               # Page Object Model
│   │   │   │   ├── applitools/
│   │   │   │   │   ├── LoginPage.java
│   │   │   │   │   └── DashBoardPage.java
│   │   │   │   └── guru/
│   │   │   │       ├── LoginPage.java
│   │   │   │       └── ManagerPage.java
│   │   │   ├── modals/              # Data models (POJOs)
│   │   │   └── utils/               # Utilities
│   │   │       ├── Helper.java
│   │   │       └── Constants.java
│   │   └── resources/
│   │       ├── TestData.json        # Environment configurations
│   │       ├── addresses.csv        # CSV test data
│   │       └── log4j2.xml           # Log4j2 configuration
│   └── test/
│       └── java/
│           ├── applitools/          # Applitools test cases
│           │   └── AppliToolTest.java
│           └── guru/                # Guru99 test cases
│               └── GutuTest.java
└── target/
    ├── logs/                        # Test execution logs
    └── surefire-reports/            # Test reports
```

## 💡 Usage

### Basic Test Example

```java
package applitools;

import org.junit.jupiter.api.Test;
import core.BaseTest;
import pages.applitools.LoginPage;
import pages.applitools.DashBoardPage;

public class AppliToolTest extends BaseTest {
    
    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        
        // Navigate to site
        loginPage.openSite();
        
        // Perform login
        loginPage.login("user@example.com", "password123");
        
        // Verify dashboard
        DashBoardPage dashBoardPage = new DashBoardPage();
        dashBoardPage.verifyDashboardPageLoaded();
    }
}
```

### Creating a Page Object

```java
package pages.applitools;

import core.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    
    // Locators as private final By variables
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    
    // Action methods using BasePage utilities
    public LoginPage enterUsername(String username) {
        enterText(usernameField, username);
        return this;
    }
    
    public LoginPage enterPassword(String password) {
        enterText(passwordField, password);
        return this;
    }
    
    public DashBoardPage clickLogin() {
        clickButton(loginButton);
        return new DashBoardPage();
    }
    
    // Method chaining for fluent interface
    public DashBoardPage login(String username, String password) {
        return enterUsername(username)
                .enterPassword(password)
                .clickLogin();
    }
}
```

## 🧪 Running Tests

### Run All Tests
```bash
mvn clean test
```

### Run Tests for Specific Environment
```bash
mvn clean test -Denv=GURU
mvn clean test -Denv=APPLITOOLS
```

### Run Tests with Specific Browser
```bash
mvn clean test -Dbrowser=chrome
mvn clean test -Dbrowser=firefox
mvn clean test -Dbrowser=edge
```

### Run Tests with Combined Options
```bash
mvn clean test -Denv=APPLITOOLS -Dbrowser=firefox
```

### Run Specific Test Class
```bash
mvn test -Dtest=AppliToolTest
mvn test -Dtest=GutuTest
```

### Run Tests with Tags
```bash
mvn test -Dgroups=applitools
```

## 📈 Test Reports

After test execution, comprehensive reports are automatically generated:

### Report Locations

- **HTML Report**: `target/reports/surefire.html`
  - User-friendly visual report with test results
  - Open in any web browser for easy viewing
  - Shows pass/fail status, execution time, and error details

- **XML Reports**: `target/surefire-reports/*.xml`
  - Machine-readable format for CI/CD integration
  - Compatible with Jenkins, GitLab CI, GitHub Actions
  - Files: `TEST-{TestClassName}.xml`

- **Text Reports**: `target/surefire-reports/*.txt`
  - Plain text summary of test execution
  - Quick review of test results

- **Logs**: `target/logs/`
  - Detailed execution logs via Log4j2
  - Debug information and error traces

### Viewing Reports

```bash
# Open HTML report (macOS)
open target/reports/surefire.html

# View text summary
cat target/surefire-reports/guru.GuruTest.txt

# Check logs
tail -f target/logs/*.log
```

### CI/CD Integration

Reports can be published in CI/CD pipelines:

```yaml
# Example: GitHub Actions
- name: Publish Test Report
  uses: dorny/test-reporter@v1
  if: always()
  with:
    name: Test Results
    path: target/surefire-reports/*.xml
    reporter: java-junit
```

## 📝 Creating Tests

### Test Class Guidelines

1. **Extend `BaseTest`**
   ```java
   public class MyTest extends BaseTest {
       // Test methods here
   }
   ```

2. **Use JUnit 5 Annotations**
   ```java
   @Test
   public void testCase01() {
       // Test implementation
   }
   ```

3. **Inherit Logger from Helper**
   ```java
   logger.info("Starting test execution");
   logger.debug("Debug information");
   logger.error("Error occurred", exception);
   ```

### Page Object Guidelines

1. **Define locators as `private final By` variables**
   ```java
   private final By submitButton = By.id("submit");
   ```

2. **Prefer specific locator strategies**
   - `By.id()` - Best performance
   - `By.cssSelector()` - Flexible and fast
   - `By.xpath()` - Use sparingly

3. **Return types for method chaining**
   - Return `this` for actions on same page
   - Return new `PageObject` for navigation

4. **Use BasePage inherited methods**
   - `enterText(By selector, String text)`
   - `clickButton(By selector)`
   - `getElementText(By selector)`
   - `getElementAttribute(By selector, String attribute)`
   - `verifyElementVisible(By selector, String message)`

5. **Never use `Thread.sleep()`**
   - Use `getWait()` for explicit waits
   - `BasePage` provides `getWait(long seconds)` method

## 📊 Logging

The framework uses **Log4j2** for comprehensive logging:

### Log Levels
- **INFO** - General test flow information
- **DEBUG** - Detailed debugging information
- **ERROR** - Error messages and exceptions

### Log Output
- **Console** - Real-time test execution logs
- **File** - Persistent logs in `target/logs/` directory

### Usage in Tests
```java
logger.info("Starting login test");
logger.debug("Entering username: {}", username);
logger.error("Login failed", exception);
```

### Log Configuration
Edit `src/main/resources/log4j2.xml` to customize:
- Log levels
- Output formats
- File appenders

## 🎯 Best Practices

### 1. **Locator Strategy**
   - Always use `private final By` for locators
   - Prefer ID and CSS selectors over XPath
   - Group related locators together

### 2. **Wait Strategy**
   - Use explicit waits from `BasePage.getWait()`
   - Never use `Thread.sleep()` (except 1-second post-click stabilization for DOM updates)
   - Wait for element visibility before interaction
   - **Note**: The 1-second post-click wait allows the DOM to stabilize after JavaScript-heavy interactions

### 3. **Code Organization**
   - One page class per web page
   - Group tests by application/feature
   - Use meaningful test and method names

### 4. **Data Management**
   - Store test data in `src/main/resources/`
   - Use `Constants.java` for all file paths
   - Never hardcode URLs or credentials

### 5. **Error Handling**
   - Use JUnit assertions for verification
   - Log all important actions and errors
   - Provide meaningful error messages

### 6. **Thread Safety**
   - `DriverManager` uses `ThreadLocal<WebDriver>`
   - Safe for parallel test execution
   - Each thread gets its own WebDriver instance

## 🔧 Troubleshooting

### Common Issues and Solutions

#### Browser Driver Issues

**Problem**: `SessionNotCreatedException` or driver version mismatch

**Solution**:
- Ensure browser is updated to the latest version
- Selenium WebDriver automatically manages compatible drivers
- If issues persist, manually update browser:
  ```bash
  # Chrome (macOS)
  brew upgrade --cask google-chrome
  
  # Firefox (macOS)
  brew upgrade --cask firefox
  ```

#### Test Failures

**Problem**: Tests fail intermittently or consistently

**Solution**:
1. **Check logs**: Review `target/logs/` for detailed error messages
2. **Review reports**: Open `target/reports/surefire.html` for visual test results
3. **Verify selectors**: Ensure page locators are still valid (website changes)
4. **Increase timeouts**: Adjust `TestSettings.DEFAULT_TIMEOUT` if elements load slowly
5. **Check environment**: Verify `TestData.json` has correct URLs

#### Environment Configuration Issues

**Problem**: Tests use wrong environment or browser

**Solution**:
- Verify `.env` file format (no quotes around values):
  ```properties
  # Correct
  TEST_ENV=GURU
  BROWSER=chrome
  
  # Incorrect
  TEST_ENV="GURU"
  BROWSER='chrome'
  ```
- Check system properties override: `-Denv=GURU -Dbrowser=firefox`
- Ensure `TestData.json` is valid JSON (use JSON validator)

#### Maven Build Issues

**Problem**: `mvn clean test` fails to compile

**Solution**:
```bash
# Clean and rebuild
mvn clean install -U

# Skip tests during build
mvn clean install -DskipTests

# Verify Java version
java -version  # Should be Java 25 or higher
```

#### Element Not Found Errors

**Problem**: `NoSuchElementException` during test execution

**Solution**:
1. Use explicit waits before interacting with elements
2. Verify element locator is correct using browser DevTools
3. Check if element is in an iframe (switch context if needed)
4. Ensure page is fully loaded before action
5. Add logging to track element state:
   ```java
   logger.debug("Waiting for element: {}", selector);
   getWait(10).until(ExpectedConditions.visibilityOfElementLocated(selector));
   ```

#### Headless Mode Issues

**Problem**: Tests pass in normal mode but fail in headless mode

**Solution**:
- Some websites block headless browsers
- Add user agent to browser options in `DriverManager`
- Increase wait times (headless can be slower)
- Take screenshots for debugging: `driver.getScreenshotAs(OutputType.FILE)`

#### Log Files Not Generated

**Problem**: No logs appearing in `target/logs/`

**Solution**:
- Verify `log4j2.xml` is in `src/main/resources/`
- Check file appender configuration in `log4j2.xml`
- Ensure proper Log4j2 dependencies in `pom.xml`
- Run with verbose logging: `-Dlog4j.debug=true`

### Getting Help

If you encounter issues not covered here:

1. **Check logs**: `target/logs/` contains detailed error traces
2. **Review test reports**: `target/reports/surefire.html`
3. **Enable debug logging**: Set log level to DEBUG in `log4j2.xml`
4. **GitHub Issues**: [Report bugs or ask questions](https://github.com/mxstudios-dn/at_2503/issues)

## 🛠️ Technologies

| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 25 | Programming language |
| Selenium WebDriver | 4.27.0 | Browser automation |
| JUnit Jupiter | 6.0.1 | Test framework |
| Maven | 3.x | Build tool |
| Log4j2 | 2.24.3 | Logging framework |
| OpenCSV | 5.12.0 | CSV data parsing |
| JSON | 20240303 | JSON data handling |
| Dotenv | 3.2.0 | Environment configuration |
| Surefire Plugin | 3.5.4 | Test execution |

## 📄 Maven Dependencies

```xml
<dependencies>
    <!-- Selenium WebDriver -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.27.0</version>
    </dependency>
    
    <!-- JUnit 5 -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>6.0.1</version>
        <scope>test</scope>
    </dependency>
    
    <!-- Log4j2 -->
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-core</artifactId>
        <version>2.24.3</version>
    </dependency>
    
    <!-- OpenCSV -->
    <dependency>
        <groupId>com.opencsv</groupId>
        <artifactId>opencsv</artifactId>
        <version>5.12.0</version>
    </dependency>
    
    <!-- JSON -->
    <dependency>
        <groupId>org.json</groupId>
        <artifactId>json</artifactId>
        <version>20240303</version>
    </dependency>
    
    <!-- Dotenv -->
    <dependency>
        <groupId>io.github.cdimascio</groupId>
        <artifactId>dotenv-java</artifactId>
        <version>3.2.0</version>
    </dependency>
</dependencies>
```

## 🤝 Contributing

Contributions are welcome! Please follow these guidelines:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Code Standards
- Follow existing code style and patterns
- Add logging for all important actions
- Write meaningful commit messages
- Update documentation for new features

## 📞 Support

For issues, questions, or contributions:
- **Issues**: [GitHub Issues](https://github.com/mxstudios-dn/at_2503/issues)
- **Repository**: [GitHub Repository](https://github.com/mxstudios-dn/at_2503)

## 📝 License

This project is part of VTI Academy training program.

---

**Happy Testing! 🚀**
