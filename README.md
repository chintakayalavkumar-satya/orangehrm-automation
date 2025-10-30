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