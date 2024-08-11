package projekat.webpages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import projekat.main.URLConstant;

public class LoginPage {

	private WebDriver driver;
	
	@FindBy(name = "email")
	private WebElement weEmail;
	@FindBy(name = "password")
	private WebElement wePassword;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement weSignIn;
	@FindBy(tagName = "label")
	private WebElement weRememberMe;
	@FindBy(partialLinkText = "forgot")
	private WebElement weForgotPassword;
	@FindBy(xpath = "//a[@href='#']")
	private WebElement weCubesSchool;
	@FindBy(xpath = "//p[@id='email-error']")
	private WebElement weEmailError;
	@FindBy(xpath = "//input[@type='hidden']")
	private WebElement weEmailError2;
	@FindBy(xpath = "//p[@id='password-error']")
	private WebElement wePasswordError;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().window().maximize();
		this.driver.get(URLConstant.LOGIN);
				
		PageFactory.initElements(driver, this);
	}
	
	public void openPage() {
		this.driver.get(URLConstant.LOGIN);
	}
	
	public void insertEmail(String email) {
		weEmail.clear();
		weEmail.sendKeys(email);
	}
	
	public void insertPassword(String password) {
		wePassword.clear();
		wePassword.sendKeys(password);
	}

	public void clickOnSignIn() {
		weSignIn.click();
	}
	
	public void clickOnRememberMe() {
		weRememberMe.click();
	}
	
	public void clickOnForgotPassword() {
		weForgotPassword.click();
	}
	
	public void clickOnCubesSchool() {
		weCubesSchool.click();
	}
	
	public boolean isEmailErrorDisplayed() {
		return weEmailError.isDisplayed();
	}
	public String getEmailErrorText() {
		return weEmailError.getText();
	}
	public boolean isEmailError2Displayed() {
		return weEmailError2.isDisplayed();
	}
	public String getEmailError2Text() {
		return weEmailError2.getText();
	}
	public boolean isPasswordErrorDisplayed() {
		return wePasswordError.isDisplayed();
	}
	public String getPasswordErrorText() {
		return wePasswordError.getText();
	}
	
	
	public void login(String email, String password) {
		insertEmail(email);
		insertPassword(password);
		clickOnSignIn();
	}
	
	public void loginRememberUser(String email, String password) {
		insertEmail(email);
		insertPassword(password);
		clickOnRememberMe();
		clickOnSignIn();
	}
	
	public void loginSuccess() {
		login("kursqa@cubes.edu.rs", "cubesqa");
	}
	
}
