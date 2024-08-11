package projekat.webpages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import projekat.main.URLConstant;

public class ForgotPasswordPage {

	private WebDriver driver;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement weRequestNewPassword;
	@FindBy(id = "email")
	private WebElement weEmail;
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement weLogin;
	@FindBy(xpath = "//p[@id='email-error']")
	private WebElement weEmailError;
	@FindBy(xpath = "//input[@type='hidden']")
	private WebElement weEmailError2;
	
	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().window().maximize();
		this.driver.get(URLConstant.PASSWORD_RESET);
		
		PageFactory.initElements(driver, this);
	}
		
	public void insertEmail(String email) {
		weEmail.clear();
		weEmail.sendKeys(email);
	}
	
	public void clickOnRequest() {
		weRequestNewPassword.click();
	}
	
	public void clickOnLogin() {
		weLogin.click();
	}
	
	
	public boolean isEmailErrorDisplayed() {
		return weEmailError.isDisplayed();
	}
	public boolean isEmailError2Displayed() {
		return weEmailError2.isDisplayed();
	}
	public String getEmailError2Text() {
		return weEmailError2.getText();
	}
	public String getEmailErrorText() {
		return weEmailError.getText();
	}
	
	
	public void requestNewPassword(String email) {
		insertEmail(email);
		clickOnRequest();
	}

	public void goToLoginPage() {
		clickOnLogin();
	}
	
}
