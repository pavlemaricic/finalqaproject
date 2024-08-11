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
import projekat.webpages.login.LoginPage;

class LoginJUnitTestCase {

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
		loginPage.insertEmail("");
		loginPage.insertPassword("");
		loginPage.clickOnSignIn();
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.isPasswordErrorDisplayed(), true, "Password error element is not displayed.");
		assertEquals(loginPage.getEmailErrorText(), "Email* is required field", "Email error message is not displayed.");
		assertEquals(loginPage.getPasswordErrorText(), "Password* is required field", "Password error message is not displayed.");	
	}
	
	@Test
	void tc02() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("pavle");
		loginPage.insertPassword("");
		loginPage.clickOnSignIn();
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.isPasswordErrorDisplayed(), true, "Password error element is not displayed.");
		assertEquals(loginPage.getEmailErrorText(), "Please, enter the valid Email address", "Email error message is not displayed.");
		assertEquals(loginPage.getPasswordErrorText(), "Password* is required field", "Password error message is not displayed.");	
	}
	
	@Test
	void tc03() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("");
		loginPage.insertPassword("pavle");
		loginPage.clickOnSignIn();		
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.getEmailErrorText(), "Email* is required field", "Email error message is not displayed.");
	}
	
	@Test
	void tc04() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("pavle");
		loginPage.insertPassword("pavle");
		loginPage.clickOnSignIn();
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.getEmailErrorText(), "Please, enter the valid Email address", "Email error message is not displayed.");
	}
	
	@Test
	void tc05() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("pavle pavle");
		loginPage.insertPassword("");
		loginPage.clickOnSignIn();
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.isPasswordErrorDisplayed(), true, "Password error element is not displayed.");
		assertEquals(loginPage.getEmailErrorText(), "Please, enter the valid Email address", "Email error message is not displayed.");
		assertEquals(loginPage.getPasswordErrorText(), "Password* is required field", "Password error message is not displayed.");	
	}
	
	@Test
	void tc06() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("");
		loginPage.insertPassword("pavle pavle");
		loginPage.clickOnSignIn();
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.getEmailErrorText(), "Email* is required field", "Email error message is not displayed.");
	}
	
	@Test
	void tc07() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("pavle pavle");
		loginPage.insertPassword("pavle pavle");
		loginPage.clickOnSignIn();
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.getEmailErrorText(), "Please, enter the valid Email address", "Email error message is not displayed.");
	}
	
	@Test
	void tc08() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("pavle pavle");
		loginPage.insertPassword("cubesqa");
		loginPage.clickOnSignIn();
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.getEmailErrorText(), "Please, enter the valid Email address", "Email error message is not displayed.");
	}
	
	@Test
	void tc09() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("kursqa @cubes.edu.rs");
		loginPage.insertPassword("");
		loginPage.clickOnSignIn();
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.isPasswordErrorDisplayed(), true, "Password error element is not displayed.");
		assertEquals(loginPage.getEmailErrorText(), "Please, enter the valid Email address", "Email error message is not displayed.");
		assertEquals(loginPage.getPasswordErrorText(), "Password* is required field", "Password error message is not displayed.");	
	}
	
	@Test
	void tc10() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("kursqa @cubes.edu.rs");
		loginPage.insertPassword("cubesqa");
		loginPage.clickOnSignIn();
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.getEmailErrorText(), "Please, enter the valid Email address", "Email error message is not displayed.");
	}
	
	@Test
	void tc11() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("kursqa@cubes.edu.rs");
		loginPage.insertPassword("cubes qa");
		loginPage.clickOnSignIn();	
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailError2Displayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.getEmailError2Text(), "These credentials do not match our records.", "Email error message is not displayed.");
	}
	
	@Test
	void tc12() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("pakimaricic@gmail. com");
		loginPage.insertPassword("");
		loginPage.clickOnSignIn();
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.isPasswordErrorDisplayed(), true, "Password error element is not displayed.");
		assertEquals(loginPage.getEmailErrorText(), "Please, enter the valid Email address", "Email error message is not displayed.");
		assertEquals(loginPage.getPasswordErrorText(), "Password* is required field", "Password error message is not displayed.");	
	}
	
	@Test
	void tc13() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("pakimaricic@gmail. com");
		loginPage.insertPassword("cubesqa");
		loginPage.clickOnSignIn();
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.getEmailErrorText(), "Please, enter the valid Email address", "Email error message is not displayed.");
	}
	
	@Test
	void tc14() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("kursqa@cubes");
		loginPage.insertPassword("");
		loginPage.clickOnSignIn();
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isPasswordErrorDisplayed(), true, "Password error element is not displayed.");
		assertEquals(loginPage.getPasswordErrorText(), "Password* is required field", "Password error message is not displayed.");
	}
	
	@Test
	void tc15() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("kursqa@cubes.pavle");
		loginPage.insertPassword("");
		loginPage.clickOnSignIn();
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good");
		assertEquals(loginPage.isPasswordErrorDisplayed(), true, "Password error element is not displayed.");
		assertEquals(loginPage.getPasswordErrorText(), "Password* is required field", "Password error message is not displayed.");
	}
	
	@Test
	void tc16() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("pakimaricic!!!!!@gmail.com");
		loginPage.insertPassword("");
		loginPage.clickOnSignIn();
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good");
		assertEquals(loginPage.isPasswordErrorDisplayed(), true, "Password error element is not displayed.");
		assertEquals(loginPage.getPasswordErrorText(), "Password* is required field", "Password error message is not displayed.");
	}
	
	@Test
	void tc17() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("paki#maricic@gmail.com");
		loginPage.insertPassword("cubesqa");
		loginPage.clickOnSignIn();	
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailError2Displayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.getEmailError2Text(), "These credentials do not match our records.", "Email error message is not displayed.");
	}
	
	@Test
	void tc18() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("");
		loginPage.insertPassword("cubesqa");
		loginPage.clickOnSignIn();
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.getEmailErrorText(), "Email* is required field", "Email error message is not displayed.");
	}
	
	@Test
	void tc19() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("kursqa@cubes.edu.rs");
		loginPage.insertPassword("");
		loginPage.clickOnSignIn();
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good");
		assertEquals(loginPage.isPasswordErrorDisplayed(), true, "Password error element is not displayed.");
		assertEquals(loginPage.getPasswordErrorText(), "Password* is required field", "Password error message is not displayed.");
	}
	
	@Test
	void tc20() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("asdasdasd");
		loginPage.insertPassword("cubesqa");
		loginPage.clickOnSignIn();
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.getEmailErrorText(), "Please, enter the valid Email address", "Email error message is not displayed.");
	}
	
	@Test
	void tc21() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("kursqa@cubes.edu.rs");
		loginPage.insertPassword("asdasdasd");
		loginPage.clickOnSignIn();	
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailError2Displayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.getEmailError2Text(), "These credentials do not match our records.", "Email error message is not displayed.");
	}

	@Test
	void tc22() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("AASsdasSdfaS");
		loginPage.insertPassword("asdasdasd");
		loginPage.clickOnSignIn();
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.getEmailErrorText(), "Please, enter the valid Email address", "Email error message is not displayed.");
	}

	@Test
	void tc23() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("AASsdasSdfaS");
		loginPage.insertPassword("cubesqa");
		loginPage.clickOnSignIn();
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.getEmailErrorText(), "Please, enter the valid Email address", "Email error message is not displayed.");
	}

	@Test
	void tc24() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("AASsdasSdfaS");
		loginPage.insertPassword("");
		loginPage.clickOnSignIn();
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.isPasswordErrorDisplayed(), true, "Password error element is not displayed.");
		assertEquals(loginPage.getEmailErrorText(), "Please, enter the valid Email address", "Email error message is not displayed.");
		assertEquals(loginPage.getPasswordErrorText(), "Password* is required field", "Password error message is not displayed.");	
	}

	@Test
	void tc25() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("pakimaricic@gmail.com");
		loginPage.insertPassword("asdasdasd");
		loginPage.clickOnSignIn();	
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailError2Displayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.getEmailError2Text(), "These credentials do not match our records.", "Email error message is not displayed.");
	}

	@Test
	void tc26() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("pakimaricic@gmail.com");
		loginPage.insertPassword("");
		loginPage.clickOnSignIn();
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isPasswordErrorDisplayed(), true, "Password error element is not displayed.");
		assertEquals(loginPage.getPasswordErrorText(), "Password* is required field", "Password error message is not displayed.");	
	}

	@Test
	void tc27() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("pakimaricic@gmail.com");
		loginPage.insertPassword("cubesqa");
		loginPage.clickOnSignIn();		
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailError2Displayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.getEmailError2Text(), "These credentials do not match our records.", "Email error message is not displayed.");
	}
	
	@Test
	void tc28() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("pakimaricic@gmail.com");
		loginPage.insertPassword("cubesqa");
		loginPage.clickOnSignIn();
		loginPage.insertEmail("");
		loginPage.clickOnSignIn();		
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.getEmailErrorText(), "Password* is required field", "Email error message is not displayed.");
	}

	@Test
	void tc29() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("paKIMariCIC@gmail.com");
		loginPage.insertPassword("asdasdasd");
		loginPage.clickOnSignIn();		
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailError2Displayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.getEmailError2Text(), "These credentials do not match our records.", "Email error message is not displayed.");
	}

	@Test
	void tc30() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("paKIMariCIC@gmail.com");
		loginPage.insertPassword("");
		loginPage.clickOnSignIn();
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isPasswordErrorDisplayed(), true, "Password error element is not displayed.");
		assertEquals(loginPage.getPasswordErrorText(), "Password* is required field", "Password error message is not displayed.");	
	}

	@Test
	void tc31() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("paKIMariCIC@gmail.com");
		loginPage.insertPassword("cubesqa");
		loginPage.clickOnSignIn();	
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailError2Displayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.getEmailError2Text(), "These credentials do not match our records.", "Email error message is not displayed.");
	}
	
	@Test
	void tc32() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("kursqacubes.edu.rs");
		loginPage.insertPassword("");
		loginPage.clickOnSignIn();		
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.isPasswordErrorDisplayed(), true, "Password error element is not displayed.");
		assertEquals(loginPage.getEmailErrorText(), "Please, enter the valid Email address", "Email error message is not displayed.");
		assertEquals(loginPage.getPasswordErrorText(), "Password* is required field", "Password error message is not displayed.");	
	}
	
	@Test
	void tc33() {
		LoginPage loginPage = new LoginPage(driver);	
		loginPage.insertEmail("kursqacubes.edu.rs");
		loginPage.insertPassword("cubesqa");
		loginPage.clickOnSignIn();		
		assertEquals(driver.getCurrentUrl(), URLConstant.LOGIN, "URL is not good.");
		assertEquals(loginPage.isEmailErrorDisplayed(), true, "Email error element is not displayed.");
		assertEquals(loginPage.getEmailErrorText(), "Please, enter the valid Email address", "Email error message is not displayed.");
	}
	
	@Test
	void tc34() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.insertEmail("kursqa@cubes.edu.rs");
		loginPage.insertPassword("cubesqa");
		loginPage.clickOnSignIn();
		assertEquals(driver.getCurrentUrl(), URLConstant.ADMIN_PAGE, "URL is not good.");
	}
	
}
