# Java Selenium SDET Automation Framework

A Java-based test automation framework built using Selenium WebDriver, TestNG, Cucumber BDD, Maven, and ExtentReports. This project demonstrates UI test automation, reusable page objects, configuration management, and test reporting.

## Tech Stack

- **Language:** Java 17+
- **UI Automation:** Selenium WebDriver
- **Test Framework:** TestNG
- **BDD:** Cucumber
- **Build Tool:** Maven
- **Design Pattern:** Page Object Model (POM)
- **Reporting:** ExtentReports and Cucumber HTML/JSON reports
- **Version Control:** Git and GitHub

## Project Features

- Automated UI testing of the SauceDemo application
- Cucumber feature files written in Gherkin
- Reusable page objects and step definitions
- Configuration-based test execution
- Smoke and regression test tags
- Screenshot capture for failed scenarios
- HTML and JSON test reports
- Maven-based test execution

## Application Under Test

SauceDemo — https://www.saucedemo.com/

## Prerequisites

- Java JDK 17 or later
- Maven
- Google Chrome
- IntelliJ IDEA or another Java IDE

## Run the Tests

Clone the repository:

```bash
git clone https://github.com/rsaravana776/selenium-java-sdet-framework.git
```

Navigate to the project directory:

```bash
cd selenium-java-sdet-framework
```

Run the test suite:

```bash
mvn clean test
```

## Test Configuration

Test configuration files are located under `src/test/resources/config/`. Review the configuration before executing tests in a different environment.

## Reports

After execution, check the generated reports under the `reports/` directory. Report availability depends on the configured reporting plugins and test execution.

## Project Purpose

This project demonstrates practical skills in Java, Selenium WebDriver, BDD, test automation framework design, Maven, and test reporting.

---

**Author:** Saravanan R  
**GitHub:** https://github.com/rsaravana776
