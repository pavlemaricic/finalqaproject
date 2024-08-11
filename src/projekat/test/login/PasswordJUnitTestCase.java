package projekat.test.login;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import projekat.driver.MyWebDriver;
import projekat.main.URLConstant;
import projekat.webpages.login.ForgotPasswordPage;
import projekat.webpages.login.LoginPage;

class PasswordJUnitTestCase {

	private static WebDriver driver;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		driver = MyWebDriver.getInstance().getDriver("chrome");
		driver.manage().window().maximize();
		driver.get(URLConstant.LOGIN);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void tc01() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickOnForgotPassword();
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
		forgotPasswordPage.insertEmail("");
		forgotPasswordPage.clickOnRequest();
		assertEquals(driver.getCurrentUrl(), URLConstant.PASSWORD_RESET, "URL is not good.");
		assertEquals(forgotPasswordPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(forgotPasswordPage.getEmailErrorText(), "Email* is required field", "Email error message is not displayed.");
	}
	
	@Test
	void tc02() {
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
		forgotPasswordPage.insertEmail("pavle");
		forgotPasswordPage.clickOnRequest();
		assertEquals(driver.getCurrentUrl(), URLConstant.PASSWORD_RESET, "URL is not good.");
		assertEquals(forgotPasswordPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(forgotPasswordPage.getEmailErrorText(), "Please, enter the valid Email address", "Email error message is not displayed.");
	}
	
	@Test
	void tc03() {
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
		forgotPasswordPage.insertEmail("pavle pavle");
		forgotPasswordPage.clickOnRequest();
		assertEquals(driver.getCurrentUrl(), URLConstant.PASSWORD_RESET, "URL is not good.");
		assertEquals(forgotPasswordPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(forgotPasswordPage.getEmailErrorText(), "Please, enter the valid Email address", "Email error message is not displayed.");
	}
	
	@Test
	void tc04() {
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
		forgotPasswordPage.insertEmail("pakimaricic@gmail.com");
		forgotPasswordPage.clickOnRequest();
		assertEquals(driver.getCurrentUrl(), URLConstant.PASSWORD_RESET, "URL is not good.");
		assertEquals(forgotPasswordPage.isEmailError2Displayed(), true, "Email error element is not displayed.");
		assertEquals(forgotPasswordPage.getEmailError2Text(), "We can't find a user with that email address.", "Email error message is not displayed.");
	}
	
	@Test
	void tc05() throws InterruptedException {
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
		forgotPasswordPage.insertEmail("pakimaricic@gmail.com");
		forgotPasswordPage.clickOnRequest();
		forgotPasswordPage.insertEmail("");
		forgotPasswordPage.clickOnRequest();
		assertEquals(driver.getCurrentUrl(), URLConstant.PASSWORD_RESET, "URL is not good.");
		assertEquals(forgotPasswordPage.isEmailError2Displayed(), true, "Email error element is not displayed.");
		assertEquals(forgotPasswordPage.getEmailError2Text(), "We can't find a user with that email address.", "Email error message is not displayed.");
	}

	@Test
	void tc06() {
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
		forgotPasswordPage.insertEmail("pakimaricic @gmail.com");
		forgotPasswordPage.clickOnRequest();	
		assertEquals(driver.getCurrentUrl(), URLConstant.PASSWORD_RESET, "URL is not good.");
		assertEquals(forgotPasswordPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(forgotPasswordPage.getEmailErrorText(), "Please, enter the valid Email address", "Email error message is not displayed.");
	}
	
	@Test
	void tc07() {
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
		forgotPasswordPage.insertEmail("pakimaricic@gmail .com");
		forgotPasswordPage.clickOnRequest();	
		assertEquals(driver.getCurrentUrl(), URLConstant.PASSWORD_RESET, "URL is not good.");
		assertEquals(forgotPasswordPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(forgotPasswordPage.getEmailErrorText(), "Please, enter the valid Email address", "Email error message is not displayed.");
	}
	
	@Test
	void tc08() {
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
		forgotPasswordPage.insertEmail("pakimaricic!!!!!@gmail.com");
		forgotPasswordPage.clickOnRequest();
		assertEquals(driver.getCurrentUrl(), URLConstant.PASSWORD_RESET, "URL is not good.");
		assertEquals(forgotPasswordPage.isEmailError2Displayed(), true, "Email error element is not displayed.");
		assertEquals(forgotPasswordPage.getEmailError2Text(), "We can't find a user with that email address.", "Email error message is not displayed.");
	}
	
	@Test
	void tc09() {
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
		forgotPasswordPage.insertEmail("kursqa @cubes.edu.rs");
		forgotPasswordPage.clickOnRequest();
		assertEquals(driver.getCurrentUrl(), URLConstant.PASSWORD_RESET, "URL is not good.");
		assertEquals(forgotPasswordPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(forgotPasswordPage.getEmailErrorText(), "Please, enter the valid Email address", "Email error message is not displayed.");
	}
	
	@Test
	void tc10() {
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
		forgotPasswordPage.insertEmail("kursqa@cubes.ed u.rs");
		forgotPasswordPage.clickOnRequest();
		assertEquals(driver.getCurrentUrl(), URLConstant.PASSWORD_RESET, "URL is not good.");
		assertEquals(forgotPasswordPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(forgotPasswordPage.getEmailErrorText(), "Please, enter the valid Email address", "Email error message is not displayed.");
	}
	
	@Test
	void tc11() {
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
		forgotPasswordPage.insertEmail("kursqa@cubes.edu,rs");
		forgotPasswordPage.clickOnRequest();
		assertEquals(driver.getCurrentUrl(), URLConstant.PASSWORD_RESET, "URL is not good.");
		assertEquals(forgotPasswordPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(forgotPasswordPage.getEmailErrorText(), "Please, enter the valid Email address", "Email error message is not displayed.");
	}
	
	@Test
	void tc12() {
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
		forgotPasswordPage.insertEmail("kursqacubes.edu.rs");
		forgotPasswordPage.clickOnRequest();	
		assertEquals(driver.getCurrentUrl(), URLConstant.PASSWORD_RESET, "URL is not good.");
		assertEquals(driver.getCurrentUrl(), URLConstant.PASSWORD_RESET, "URL is not good.");
		assertEquals(forgotPasswordPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(forgotPasswordPage.getEmailErrorText(), "Please, enter the valid Email address", "Email error message is not displayed.");
	}
	
	@Test
	void tc13() {
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
		forgotPasswordPage.insertEmail("kursqa@cubes.edu.rs");
		forgotPasswordPage.clickOnRequest();
		assertEquals(driver.getCurrentUrl(), URLConstant.PASSWORDEMAIL_RESET, "URL is not good.");
	}
	
	@Test
	void tc14() {
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
		forgotPasswordPage.goToLoginPage();	
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN,"URL is not good.");
	}
	
}
