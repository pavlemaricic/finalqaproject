package projekat.test.tag;

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
import projekat.webpages.tag.AddTagPage;
import projekat.webpages.tag.ListTagPage;

class TagJUnitTestCase {

	private static WebDriver driver;
	private static String tagName;
	private static String updatedTagName;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		driver = MyWebDriver.getInstance().getDriver("chrome");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		tagName = Utils.getRandomTagName();
		updatedTagName = Utils.getRandomTagName();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginSuccess();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		AddTagPage addTagPage = new AddTagPage(driver,true);
		addTagPage.userLogOut();
		driver.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		driver.get(URLConstant.TAGS_LIST);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void tc01() {
		AddTagPage addTagPage = new AddTagPage(driver, true);
		addTagPage.insertTagName("");
		addTagPage.clickOnSave();		
		assertEquals(driver.getCurrentUrl(), URLConstant.TAG_ADD, "URL is not good.");
		assertEquals(addTagPage.isNameErrorDisplayed(), true, "Name-error element is not displayed.");
		assertEquals(addTagPage.getNameErrorText(), "This field is required.", "Name-error message is not displayed.");
	}
	
	@Test
	void tc02() {
		AddTagPage addTagPage = new AddTagPage(driver, true);
		addTagPage.insertTagName("");
		addTagPage.clickOnCancel();		
		assertEquals(driver.getCurrentUrl(), URLConstant.TAGS_LIST, "URL is not good.");
	}
	
	@Test
	void tc03() throws InterruptedException {
		AddTagPage addTagPage = new AddTagPage(driver, true);
		addTagPage.insertTagName(tagName);
		addTagPage.clickOnCancel();
		assertEquals(driver.getCurrentUrl(), URLConstant.TAGS_LIST, "URL is not good.");
		ListTagPage listTagPage = new ListTagPage(driver);
		assertEquals(listTagPage.countTagWithName(tagName), 0, "Tag appears in the list.");
	}
	
	@Test
	void tc04() {
		AddTagPage addTagPage = new AddTagPage(driver, true);
		addTagPage.insertTagName(tagName);
		addTagPage.clickOnSave();		
		assertEquals(driver.getCurrentUrl(), URLConstant.TAGS_LIST, "URL is not good.");
		ListTagPage listTagPage = new ListTagPage(driver);
		assertEquals(listTagPage.countTagWithName(tagName), 1, "Tag doesn't appear in the list or there are more of them.");

	}
	
	@Test
	void tc05() {
		ListTagPage listTagPage = new ListTagPage(driver);
		listTagPage.clickOnUpdateTag(tagName);
		AddTagPage addTagPage = new AddTagPage(driver, false);
		assertEquals(tagName, addTagPage.getTagNameText(), "Not a good tag name.");
		addTagPage.clickOnCancel();
		assertEquals(driver.getCurrentUrl(), URLConstant.TAGS_LIST, "URL is not good.");
		assertEquals(listTagPage.countTagWithName(tagName), 1, "Old tag appeared in the list.");
	}
	
	@Test
	void tc06() {
		ListTagPage listTagPage = new ListTagPage(driver);
		listTagPage.clickOnUpdateTag(tagName);
		AddTagPage addTagPage = new AddTagPage(driver, false);
		assertEquals(tagName, addTagPage.getTagNameText(), "Not a good tag name.");
		addTagPage.insertTagName("");
		addTagPage.clickOnSave();
		addTagPage.getNameErrorText();
		assertEquals(addTagPage.isNameErrorDisplayed(), true, "Name-error element is not displayed.");
		assertEquals(addTagPage.getNameErrorText(), "This field is required.", "Name-error message is not displayed.");
	}
	
	@Test
	void tc07() {
		AddTagPage addTagPage = new AddTagPage(driver, true);
		String secondTagName = addTagPage.addNewTag();
		ListTagPage listTagPage = new ListTagPage(driver);
		listTagPage.clickOnUpdateTag(tagName);
		assertEquals(tagName, addTagPage.getTagNameText(), "Not a good tag name.");
		addTagPage.insertTagName(secondTagName);
		addTagPage.clickOnSave();
		assertEquals(addTagPage.isNameErrorDisplayed(), true, "Name-error element is not displayed.");
		assertEquals(addTagPage.getNameErrorText(), "The name has already been taken.", "Name-error message is not displayed.");
		addTagPage.clickOnCancel();
		listTagPage.deleteTag(secondTagName);
	}
	
	@Test
	void tc08() {
		ListTagPage listTagPage = new ListTagPage(driver);
		listTagPage.clickOnUpdateTag(tagName);
		AddTagPage addTagPage = new AddTagPage(driver, false);
		assertEquals(tagName, addTagPage.getTagNameText(), "Not a good tag name.");
		addTagPage.insertTagName(updatedTagName);
		addTagPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.TAGS_LIST, "URL is not good.");
		assertEquals(listTagPage.countTagWithName(tagName), 0, "Old tag appeared in the list.");
		assertEquals(listTagPage.countTagWithName(updatedTagName), 1, "New tag is not created.");
	}
	
	@Test
	void tc09() {
		ListTagPage listTagPage = new ListTagPage(driver);
		listTagPage.clickOnDeleteTag(updatedTagName);
		listTagPage.clickOnDeleteDialogCancel();
		assertEquals(driver.getCurrentUrl(), URLConstant.TAGS_LIST, "URL is not good.");
		assertEquals(listTagPage.countTagWithName(updatedTagName), 2, "Tag is deleted.");
	}
	
	@Test
	void tc10() {
		ListTagPage listTagPage = new ListTagPage(driver);
		listTagPage.clickOnDeleteTag(updatedTagName);
		listTagPage.clickOnDeleteDialogDelete();
		assertEquals(driver.getCurrentUrl(), URLConstant.TAGS_LIST, "URL is not good.");
		assertEquals(listTagPage.countTagWithName(updatedTagName), 0, "Tag is not deleted.");
	}
	
	@Test
	void tc11() {
		AddTagPage addTagPage = new AddTagPage(driver, true);
		addTagPage.ClickOnHomeButton();	
		assertEquals(driver.getCurrentUrl(), URLConstant.ADMIN_PAGE, "URL is not goood.");
	}
	
	@Test
	void tc12() {
		AddTagPage addTagPage = new AddTagPage(driver, true);
		addTagPage.clickOnTagsButton();		
		assertEquals(driver.getCurrentUrl(), URLConstant.TAGS_LIST, "URL is not good.");
	}
	
	@Test
	void tc13() {
		AddTagPage addTagPage = new AddTagPage(driver, true);
		addTagPage.clickOnCubesSchoolButton();		
		assertEquals(driver.getCurrentUrl(), URLConstant.CUBES_SCHOOLPAGE, "URL is not good");
	}
	
	@Test
	void tc14() {
		AddTagPage addTagPage = new AddTagPage(driver, true);
		addTagPage.clickOnBlogButton();	
		assertEquals(driver.getCurrentUrl(), URLConstant.CUBES_BLOGPAGE, "URL is not good.");
	}
	
	@Test
	void tc15() {
		AddTagPage addTagPage = new AddTagPage(driver, true);
		addTagPage.clickOnSidebarSlidersList();
		assertEquals(driver.getCurrentUrl(), URLConstant.SLIDERS_LIST, "URL is not good.");
	}
	
	@Test
	void tc16() {
		AddTagPage addTagPage = new AddTagPage(driver, true);
		addTagPage.clickOnSidebarAddSlider();
		assertEquals(driver.getCurrentUrl(), URLConstant.SLIDER_ADD, "URL is not good.");
	}
	
	@Test
	void tc17() {
		AddTagPage addTagPage = new AddTagPage(driver, true);
		addTagPage.clickOnSidebarPostCategoriesList();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORIES_LIST, "URL is not good.");
	}
	
	@Test
	void tc18() {
		AddTagPage addTagPage = new AddTagPage(driver, true);
		addTagPage.clickOnSidebarAddPostCategory();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
	}
	
	@Test
	void tc19() {
		AddTagPage addTagPage = new AddTagPage(driver, true);
		addTagPage.clickOnSidebarTagsList();
		assertEquals(driver.getCurrentUrl(), URLConstant.TAGS_LIST, "URL is not good.");
	}
	
	@Test
	void tc20() {
		AddTagPage addTagPage = new AddTagPage(driver, true);
		addTagPage.clickOnSidebarAddTag();
		assertEquals(driver.getCurrentUrl(), URLConstant.TAG_ADD, "URL is not good.");
	}
	
	@Test
	void tc21() {
		AddTagPage addTagPage = new AddTagPage(driver, true);
		addTagPage.clickOnSidebarPostsList();
		assertEquals(driver.getCurrentUrl(), URLConstant.POSTS_LIST, "URL is not good.");
	}
	
	@Test
	void tc22() {
		AddTagPage addTagPage = new AddTagPage(driver, true);
		addTagPage.clickOnSidebarAddPost();
		assertEquals(driver.getCurrentUrl(), URLConstant.POST_ADD, "URL is not good.");
	}
	
	@Test
	void tc23() {
		AddTagPage addTagPage = new AddTagPage(driver, true);
		addTagPage.clickOnSidebarCommentsList();
		assertEquals(driver.getCurrentUrl(), URLConstant.COMMENTS, "URL is not good.");
	}
	
	@Test
	void tc24() {
		AddTagPage addTagPage = new AddTagPage(driver, true);
		addTagPage.clickOnSidebarUsersList();
		assertEquals(driver.getCurrentUrl(), URLConstant.USERS_LIST, "URL is not good.");
	}
	
	@Test
	void tc25() {
		AddTagPage addTagPage = new AddTagPage(driver, true);
		addTagPage.clickOnSidebarAddUser();
		assertEquals(driver.getCurrentUrl(), URLConstant.USER_ADD, "URL is not good.");
	}
	
}
