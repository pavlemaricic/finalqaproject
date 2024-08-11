package projekat.test.post;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import projekat.driver.MyWebDriver;
import projekat.main.URLConstant;
import projekat.main.Utils;
import projekat.webpages.login.LoginPage;
import projekat.webpages.postcategories.AddPostCategoriesPage;
import projekat.webpages.postcategories.ListPostCategoriesPage;

class PostCategoryJUnitTestCase {
	
	private static WebDriver driver;
	
	private static String zeroPostCategoryName;
	private static String zeroPostCategoryDescription;
	private static String firstPostCategoryName;
	private static String firstPostCategoryDescription;
	private static String secondPostCategoryName;
	private static String secondPostCategoryDescription;
	private static String thirdPostCategoryName;
	private static String thirdPostCategoryDescription;
	private static String fourthPostCategoryName;
	private static String fourthPostCategoryDescription;
	private static String fifthPostCategoryName;
	private static String fifthPostCategoryDescription;
	private static String sixthPostCategoryName;

	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		driver = MyWebDriver.getInstance().getDriver("chrome");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		zeroPostCategoryName = Utils.getRandomPostCategoryName();
		zeroPostCategoryDescription = Utils.getRandomPostCategoryDescription();
		firstPostCategoryName = Utils.getRandomPostCategoryName();
		firstPostCategoryDescription = Utils.getRandomPostCategoryDescription();
		secondPostCategoryName = Utils.getRandomPostCategoryName();
		secondPostCategoryDescription = Utils.getRandomPostCategoryDescription();
		thirdPostCategoryName = Utils.getRandomPostCategoryName();
		thirdPostCategoryDescription = Utils.getRandomPostCategoryDescription();
		fourthPostCategoryName = Utils.getRandomPostCategoryName();
		fourthPostCategoryDescription = Utils.getRandomPostCategoryDescription();
		fifthPostCategoryName = Utils.getRandomPostCategoryName();
		fifthPostCategoryDescription = Utils.getRandomPostCategoryDescription();
		sixthPostCategoryName = Utils.getRandomPostCategoryName();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginSuccess();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.userLogOut();
		driver.quit();
	}

	@BeforeEach
	void setUp() throws Exception {
		driver.get(URLConstant.CATEGORIES_LIST);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void tc01() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("");
		addPostCategoriesPage.insertPostCategoryDescription("");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
		assertEquals(addPostCategoriesPage.isNameErrorDisplayed(), true, "Name error element is not displayed.");
		assertEquals(addPostCategoriesPage.getNameErrorText(), "This field is required.", "Name error message is not displayed.");
		assertEquals(addPostCategoriesPage.isDescriptionErrorDisplayed(), true, "Description error element is not displayed.");
		assertEquals(addPostCategoriesPage.getDescriptionErrorText(), "This field is required.",
				"Description error message is not displayed.");
	}
	
	@Test
	void tc02() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("");
		addPostCategoriesPage.insertPostCategoryDescription("");
		addPostCategoriesPage.clickOnCancel();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORIES_LIST, "URL is not good.");
	}
	
	@Test
	void tc03() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("k");
		addPostCategoriesPage.insertPostCategoryDescription("");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
		assertEquals(addPostCategoriesPage.isDescriptionErrorDisplayed(), true, "Description error element is not displayed.");
		assertEquals(addPostCategoriesPage.getDescriptionErrorText(), "This field is required.",
				"Description error message is not displayed.");
	}
	
	@Test
	void tc04() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("kategorija");
		addPostCategoriesPage.insertPostCategoryDescription("");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
		assertEquals(addPostCategoriesPage.isDescriptionErrorDisplayed(), true, "Description error element is not displayed.");
		assertEquals(addPostCategoriesPage.getDescriptionErrorText(), "This field is required.",
				"Description error message is not displayed.");
	}
	
	@Test
	void tc05() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("KATEGORIJA");
		addPostCategoriesPage.insertPostCategoryDescription("");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
		assertEquals(addPostCategoriesPage.isDescriptionErrorDisplayed(), true, "Description error element is not displayed.");
		assertEquals(addPostCategoriesPage.getDescriptionErrorText(), "This field is required.",
				"Description error message is not displayed.");
	}
	
	@Test
	void tc06() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("123");
		addPostCategoriesPage.insertPostCategoryDescription("");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
		assertEquals(addPostCategoriesPage.isDescriptionErrorDisplayed(), true, "Description error element is not displayed.");
		assertEquals(addPostCategoriesPage.getDescriptionErrorText(), "This field is required.",
				"Description error message is not displayed.");
	}
	
	@Test
	void tc07() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("qwe123");
		addPostCategoriesPage.insertPostCategoryDescription("");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
		assertEquals(addPostCategoriesPage.isDescriptionErrorDisplayed(), true, "Description error element is not displayed.");
		assertEquals(addPostCategoriesPage.getDescriptionErrorText(), "This field is required.",
				"Description error message is not displayed.");
	}
	
	@Test
	void tc08() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("a1!!!@");
		addPostCategoriesPage.insertPostCategoryDescription("");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
		assertEquals(addPostCategoriesPage.isDescriptionErrorDisplayed(), true, "Description error element is not displayed.");
		assertEquals(addPostCategoriesPage.getDescriptionErrorText(), "This field is required.",
				"Description error message is not displayed.");
	}
	
	@Test
	void tc09() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("kursqa@cubes.edu.rs");
		addPostCategoriesPage.insertPostCategoryDescription("");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
		assertEquals(addPostCategoriesPage.isDescriptionErrorDisplayed(), true, "Description error element is not displayed.");
		assertEquals(addPostCategoriesPage.getDescriptionErrorText(), "This field is required.",
				"Description error message is not displayed.");
	}
	
	@Test
	void tc10() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("qwertyasdfqwertyasdfqwertyasdfqwertyasdfqwertyasdfqwertyasdf");
		addPostCategoriesPage.insertPostCategoryDescription("");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
		assertEquals(addPostCategoriesPage.isDescriptionErrorDisplayed(), true, "Description error element is not displayed.");
		assertEquals(addPostCategoriesPage.getDescriptionErrorText(), "This field is required.",
				"Description error message is not displayed.");
	}
	
	@Test
	void tc11() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("AsDfGqWeRtY");
		addPostCategoriesPage.insertPostCategoryDescription("");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
		assertEquals(addPostCategoriesPage.isDescriptionErrorDisplayed(), true, "Description error element is not displayed.");
		assertEquals(addPostCategoriesPage.getDescriptionErrorText(), "This field is required.",
				"Description error message is not displayed.");
	}
	
	@Test
	void tc12() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("kategorija - 1000$^^");
		addPostCategoriesPage.insertPostCategoryDescription("");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
		assertEquals(addPostCategoriesPage.isDescriptionErrorDisplayed(), true, "Description error element is not displayed.");
		assertEquals(addPostCategoriesPage.getDescriptionErrorText(), "This field is required.",
				"Description error message is not displayed.");
	}
	
	@Test
	void tc13() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("-------=====+++++++");
		addPostCategoriesPage.insertPostCategoryDescription("");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
		assertEquals(addPostCategoriesPage.isDescriptionErrorDisplayed(), true, "Description error element is not displayed.");
		assertEquals(addPostCategoriesPage.getDescriptionErrorText(), "This field is required.",
				"Description error message is not displayed.");
	}
	
	@Test
	void tc14() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("");
		addPostCategoriesPage.insertPostCategoryDescription("k");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
		assertEquals(addPostCategoriesPage.isNameErrorDisplayed(), true, "Name error element is not displayed.");
		assertEquals(addPostCategoriesPage.getNameErrorText(), "This field is required.", "Name error message is not displayed.");
	}
	
	@Test
	void tc15() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("");
		addPostCategoriesPage.insertPostCategoryDescription("kategorija");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
		assertEquals(addPostCategoriesPage.isNameErrorDisplayed(), true, "Name error element is not displayed.");
		assertEquals(addPostCategoriesPage.getNameErrorText(), "This field is required.", "Name error message is not displayed.");
	}
	
	@Test
	void tc16() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("");
		addPostCategoriesPage.insertPostCategoryDescription("KATEGORIJA");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
		assertEquals(addPostCategoriesPage.isNameErrorDisplayed(), true, "Name error element is not displayed.");
		assertEquals(addPostCategoriesPage.getNameErrorText(), "This field is required.", "Name error message is not displayed.");
	}
	
	@Test
	void tc17() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("");
		addPostCategoriesPage.insertPostCategoryDescription("123");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
		assertEquals(addPostCategoriesPage.isNameErrorDisplayed(), true, "Name error element is not displayed.");
		assertEquals(addPostCategoriesPage.getNameErrorText(), "This field is required.", "Name error message is not displayed.");
	}
	
	@Test
	void tc18() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("");
		addPostCategoriesPage.insertPostCategoryDescription("qwe123");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
		assertEquals(addPostCategoriesPage.isNameErrorDisplayed(), true, "Name error element is not displayed.");
		assertEquals(addPostCategoriesPage.getNameErrorText(), "This field is required.", "Name error message is not displayed.");
	}
	
	@Test
	void tc19() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("");
		addPostCategoriesPage.insertPostCategoryDescription("a1!!!@");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
		assertEquals(addPostCategoriesPage.isNameErrorDisplayed(), true, "Name error element is not displayed.");
		assertEquals(addPostCategoriesPage.getNameErrorText(), "This field is required.", "Name error message is not displayed.");
	}
	
	@Test
	void tc20() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("");
		addPostCategoriesPage.insertPostCategoryDescription("kursqa@cubes.edu.rs");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
		assertEquals(addPostCategoriesPage.isNameErrorDisplayed(), true, "Name error element is not displayed.");
		assertEquals(addPostCategoriesPage.getNameErrorText(), "This field is required.", "Name error message is not displayed.");
	}
	
	@Test
	void tc21() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("");
		addPostCategoriesPage.insertPostCategoryDescription("qwertyasdfqwertyasdfqwertyasdfqwertyasdfqwertyasdfqwertyasdf");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
		assertEquals(addPostCategoriesPage.isNameErrorDisplayed(), true, "Name error element is not displayed.");
		assertEquals(addPostCategoriesPage.getNameErrorText(), "This field is required.", "Name error message is not displayed.");
	}
	
	@Test
	void tc22() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("");
		addPostCategoriesPage.insertPostCategoryDescription("AsDfGqWeRtY");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
		assertEquals(addPostCategoriesPage.isNameErrorDisplayed(), true, "Name error element is not displayed.");
		assertEquals(addPostCategoriesPage.getNameErrorText(), "This field is required.", "Name error message is not displayed.");
	}
	
	@Test
	void tc23() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("");
		addPostCategoriesPage.insertPostCategoryDescription("kategorija - 1000$^^");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
		assertEquals(addPostCategoriesPage.isNameErrorDisplayed(), true, "Name error element is not displayed.");
		assertEquals(addPostCategoriesPage.getNameErrorText(), "This field is required.", "Name error message is not displayed.");
	}
	
	@Test
	void tc24() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("");
		addPostCategoriesPage.insertPostCategoryDescription("-------=====+++++++");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
		assertEquals(addPostCategoriesPage.isNameErrorDisplayed(), true, "Name error element is not displayed.");
		assertEquals(addPostCategoriesPage.getNameErrorText(), "This field is required.", "Name error message is not displayed.");
	}
	
	@Test
	void tc25() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("kategorija");
		addPostCategoriesPage.insertPostCategoryDescription("kategorija");
		addPostCategoriesPage.clickOnCancel();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORIES_LIST, "URL is not good.");
		ListPostCategoriesPage listPostCategoriesPage = new ListPostCategoriesPage(driver);
		assertEquals(listPostCategoriesPage.countPostCategoryWithName("kategorija"), 0, 
				"Tag appears in the list or there are more of them.");
	}
	
	@Test
	void tc26() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("kategorija");
		addPostCategoriesPage.insertPostCategoryDescription("kategorija");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
		assertEquals(addPostCategoriesPage.isDescriptionErrorMinCharDisplayed(), true, "Description error element is not displayed.");
		assertEquals(addPostCategoriesPage.getDescriptionErrorMinCharText(), "The description must be at least 50 characters.",
				"Description charError message is not displayed.");
	}
	
	@Test
	void tc27() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("kategorija");
		addPostCategoriesPage.insertPostCategoryDescription("kategorijakategorijakategorijakategorijakategorija");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORIES_LIST, "URL is not good.");
		ListPostCategoriesPage listPostCategoriesPage = new ListPostCategoriesPage(driver);
		assertEquals(listPostCategoriesPage.countPostCategoryWithName("kategorija"), 1, 
				"Tag doesn't appear in the list or there are more of them.");
	}
	
	@Test
	void tc28() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("1234567890");
		addPostCategoriesPage.insertPostCategoryDescription("12345678901234567890123456789012345678901234567890");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORIES_LIST, "URL is not good.");
		ListPostCategoriesPage listPostCategoriesPage = new ListPostCategoriesPage(driver);
		assertEquals(listPostCategoriesPage.countPostCategoryWithName("1234567890"), 1, 
				"Tag doesn't appear in the list or there are more of them.");
	}
	
	@Test
	void tc29() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("kategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakatego");
		addPostCategoriesPage.insertPostCategoryDescription("");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
		assertEquals(addPostCategoriesPage.isNameCharErrorDisplayed(), true, "Name error3 element is not displayed.");
		assertEquals(addPostCategoriesPage.isDescriptionErrorDisplayed(), true, "Description error element is not displayed.");
		assertEquals(addPostCategoriesPage.getNameCharErrorText(), "Please enter no more than 255 characters.", 
				"Name error3 message is not displayed.");
		assertEquals(addPostCategoriesPage.getDescriptionErrorText(), "This field is required.", 
				"Description error message is not displayed.");		
	}
	
	@Test
	void tc30() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.insertPostCategoryName("bancaintesa");
		addPostCategoriesPage.insertPostCategoryDescription("kategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijakategorijaa");
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
		assertEquals(addPostCategoriesPage.isDescriptionErrorMaxCharDisplayed(), true, "Description error element is not displayed.");
		assertEquals(addPostCategoriesPage.getDescriptionErrorMaxCharText(), "Please enter no more than 500 characters.", 
				"Description error message is not displayed.");		
	}
	
	@Test
	void tc31() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.addNewPostCategory(zeroPostCategoryName, zeroPostCategoryDescription);
		addPostCategoriesPage.clickOnSave();
		ListPostCategoriesPage listPostCategoriesPage = new ListPostCategoriesPage(driver);
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORIES_LIST, "URL is not good.");
		assertEquals(listPostCategoriesPage.countPostCategoryWithName(zeroPostCategoryName), 1, "Post category doesn't appear in the list or there are more of them.");
	}
	
	@Test
	void tc32() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.addNewPostCategory(firstPostCategoryName, firstPostCategoryDescription);
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORIES_LIST, "URL is not good.");
		ListPostCategoriesPage listPostCategoriesPage = new ListPostCategoriesPage(driver);
		listPostCategoriesPage.updatePostCategoryName(firstPostCategoryName);
		addPostCategoriesPage.insertPostCategoryName(sixthPostCategoryName);
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORIES_LIST, "URL is not good.");
		assertEquals(listPostCategoriesPage.countPostCategoryWithName(firstPostCategoryName), 0, "Post category appears in the list or there are more of them.");
		assertEquals(listPostCategoriesPage.countPostCategoryWithName(sixthPostCategoryName), 1, "Post category doesn't appear in the list or there are more of them.");
	}
	
	@Test
	void tc33() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.addNewPostCategory(secondPostCategoryName, secondPostCategoryDescription);
		addPostCategoriesPage.clickOnCancel();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORIES_LIST, "URL is not good.");
		ListPostCategoriesPage listPostCategoriesPage = new ListPostCategoriesPage(driver);
		assertEquals(listPostCategoriesPage.countPostCategoryWithName(secondPostCategoryName), 0, "Post category appears in the list or there are more of them.");
	}
	
	@Test
	void tc34() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.addNewPostCategory(secondPostCategoryName, secondPostCategoryDescription);
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORIES_LIST, "URL is not good.");
		ListPostCategoriesPage listPostCategoriesPage = new ListPostCategoriesPage(driver);
		assertEquals(listPostCategoriesPage.countPostCategoryWithName(secondPostCategoryName), 1, "Post category doesn't appear in the list or there are more of them.");
		listPostCategoriesPage.deletePostCategory(secondPostCategoryName);
		assertEquals(listPostCategoriesPage.countPostCategoryWithName(secondPostCategoryName), 0, "Post category appears in the list or there are more of them.");
	}
	
	@Test
	void tc35() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.addNewPostCategory(secondPostCategoryName, secondPostCategoryDescription);
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORIES_LIST, "URL is not good.");
		ListPostCategoriesPage listPostCategoriesPage = new ListPostCategoriesPage(driver);
		assertEquals(listPostCategoriesPage.countPostCategoryWithName(secondPostCategoryName), 1, "Post category doesn't appear in the list or there are more of them.");
		listPostCategoriesPage.updatePostCategoryName(secondPostCategoryName);	
		addPostCategoriesPage.addNewPostCategory(thirdPostCategoryName, thirdPostCategoryDescription);
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORIES_LIST, "URL is not good.");
		assertEquals(listPostCategoriesPage.countPostCategoryWithName(thirdPostCategoryName), 1, "Post category doesn't appear in the list or there are more of them.");
	}
	
	@Test
	void tc36() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.addNewPostCategory(fourthPostCategoryName, fourthPostCategoryDescription);
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORIES_LIST, "URL is not good.");
		ListPostCategoriesPage listPostCategoriesPage = new ListPostCategoriesPage(driver);
		assertEquals(listPostCategoriesPage.countPostCategoryWithName(fourthPostCategoryName), 1, "Post category doesn't appear in the list or there are more of them.");
		listPostCategoriesPage.updatePostCategoryName(fourthPostCategoryName);
		addPostCategoriesPage.addNewPostCategory("raiffeisen", "raiffeisenraiffeisen");
		addPostCategoriesPage.clickOnSave();
		assertEquals(listPostCategoriesPage.countPostCategoryWithName("raiffeisen"), 0, "Post category appears in the list or there are more of them.");
		assertEquals(addPostCategoriesPage.isDescriptionErrorMinCharDisplayed(), true, "Description error element is not displayed.");
		assertEquals(addPostCategoriesPage.getDescriptionErrorMinCharText(), "The description must be at least 50 characters.", 
				"Description error message is not displayed.");
		addPostCategoriesPage.addNewPostCategory("raiffeisen", "");
		addPostCategoriesPage.clickOnSave();
		assertEquals(listPostCategoriesPage.countPostCategoryWithName("raiffeisen"), 0, "Post category appears in the list or there are more of them.");
		assertEquals(addPostCategoriesPage.isDescriptionErrorDisplayed(), true);
		assertEquals(addPostCategoriesPage.getDescriptionErrorText(), "The description must be at least 50 characters.",
				"Description error message is not displayed.");
	}
	
	@Test
	void tc37() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.addNewPostCategory(fifthPostCategoryName, fifthPostCategoryDescription);
		addPostCategoriesPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORIES_LIST, "URL is not good.");
		ListPostCategoriesPage listPostCategoriesPage = new ListPostCategoriesPage(driver);
		assertEquals(listPostCategoriesPage.countPostCategoryWithName(fifthPostCategoryName), 1, "Post category doesn't appear in the list or there are more of them.");
		listPostCategoriesPage.seePostCategory(fifthPostCategoryName);
	}	
		
	@Test
	void tc38(){
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.clickOnSidebarSlidersList();
		assertEquals(driver.getCurrentUrl(), URLConstant.SLIDERS_LIST, "URL is not good.");
	}
	
	@Test
	void tc39() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.clickOnSidebarAddSlider();
		assertEquals(driver.getCurrentUrl(), URLConstant.SLIDER_ADD, "URL is not good.");
	}
	
	@Test
	void tc40() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.clickOnSidebarPostCategoriesList();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORIES_LIST, "URL is not good.");
	}
	
	@Test
	void tc41() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.clickOnSidebarAddPostCategory();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
	}
	
	@Test
	void tc42() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.clickOnSidebarTagsList();
		assertEquals(driver.getCurrentUrl(), URLConstant.TAGS_LIST, "URL is not good.");
	}
	
	@Test
	void tc43() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.clickOnSidebarAddTag();
		assertEquals(driver.getCurrentUrl(), URLConstant.TAG_ADD, "URL is not good.");
	}
	
	@Test
	void tc44() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.clickOnSidebarPostsList();
		assertEquals(driver.getCurrentUrl(), URLConstant.POSTS_LIST, "URL is not good.");
	}
	
	@Test
	void tc45() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.clickOnSidebarAddPost();
		assertEquals(driver.getCurrentUrl(), URLConstant.POST_ADD, "URL is not good.");
	}
	
	@Test
	void tc46() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.clickOnSidebarCommentsList();
		assertEquals(driver.getCurrentUrl(), URLConstant.COMMENTS, "URL is not good.");
	}
	
	@Test
	void tc47() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.clickOnSidebarUsersList();
		assertEquals(driver.getCurrentUrl(), URLConstant.USERS_LIST, "URL is not good.");
	}
	
	@Test
	void tc48() {
		AddPostCategoriesPage addPostCategoriesPage = new AddPostCategoriesPage(driver);
		addPostCategoriesPage.clickOnSidebarAddUser();
		assertEquals(driver.getCurrentUrl(), URLConstant.USER_ADD, "URL is not good.");
	}
	
}
