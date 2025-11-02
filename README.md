# OrangeHRM Automation 🚀

[![Maven Tests](https://github.com/chintakayalavkumar-satya/orangehrm-automation/actions/workflows/maven-tests.yml/badge.svg)](https://github.com/chintakayalavkumar-satya/orangehrm-automation/actions/workflows/maven-tests.yml)

Automated testing framework for [OrangeHRM](https://opensource-demo.orangehrmlive.com/) built using:
- **Selenium WebDriver**
- **TestNG**
- **Java 17**
- **Maven**
- **Allure Reports**
- **GitHub Actions CI/CD**

### 📊 Reports
- Local HTML report generated at:  
  `target/site/allure-maven-plugin/index.html`
- GitHub Actions uploads Allure reports automatically in workflow artifacts.

### ⚙️ Commands
```bash
# Run all tests
mvn clean test

# Generate local Allure report
mvn allure:report

![Maven Tests](https://github.com/chintakayalavkumar-satya/orangehrm-automation/actions/workflows/maven-tests.yml/badge.svg)

# OrangeHRM Automation

![Maven Tests](https://github.com/chintakayalavkumar-satya/orangehrm-automation/actions/workflows/maven-tests.yml/badge.svg)

> Java + Selenium + TestNG mini framework built from scratch with Page Objects, suite runner, and screenshot-on-failure. Two flows automated (Login, Logout) against the OrangeHRM demo. Designed to be interview-ready and easy to extend.

# OrangeHRM Automation (Java + Selenium + TestNG)

**Stack:** Java 17, Selenium 4.26, TestNG  
**Design:** Page Object Model, TestNG suite, screenshot-on-failure listener  
**Browsers:** Firefox (offline-first via local `geckodriver.exe`)

## How to run (Eclipse)
1) Place `geckodriver.exe` at `C:\drivers\geckodriver.exe`.
2) Right-click `testng.xml` → **Run As → TestNG Suite**.
3) On failure, see `test-output/artifacts/` (screenshot + HTML + URL).

## Structure
src/main/java/com/vj/framework
├─ core/ (BaseTest, DriverFactory, Config)
└─ pages/ (LoginPage, DashboardPage, HeaderBar)
src/test/java/com/vj/framework/tests
├─ LoginTest.java
├─ LogoutTest.java
└─ TestListener.java