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
import projekat.webpages.post.AddPostPage;
import projekat.webpages.post.ListPostPage;
import projekat.webpages.postcategories.AddPostCategoriesPage;

class PostJUnitTestCase {

	private static WebDriver driver;
	private static String firstPostTitle;
	private static String firstPostDescription;
	private static String firstPostContent;
	private static String secondPostTitle;
	private static String secondPostDescription;
	private static String secondPostContent;
	private static String thirdPostTitle;
	private static String thirdPostDescription;
	private static String thirdPostContent;
	private static String fourthPostTitle;
	private static String fifthPostTitle;
	private static String fifthPostDescription;
	private static String fifthPostContent;
	private static String sixthPostTitle;
	private static String sixthPostDescription;
	private static String sixthPostContent;
	private static String seventhPostTitle;
	private static String seventhPostDescription;
	private static String seventhPostContent;
	private static String eighthPostTitle;
	private static String eighthPostDescription;
	private static String eighthPostContent;
	
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		driver = MyWebDriver.getInstance().getDriver("chrome");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		firstPostTitle = Utils.getRandomPostTitle();
		firstPostDescription = Utils.getRandomPostDescription();
		firstPostContent = Utils.getRandomPostContent();
		secondPostTitle = Utils.getRandomPostTitle();
		secondPostDescription = Utils.getRandomPostDescription();
		secondPostContent = Utils.getRandomPostContent();
		thirdPostTitle = Utils.getRandomPostTitle();
		thirdPostDescription = Utils.getRandomPostDescription();
		thirdPostContent = Utils.getRandomPostContent();
		fourthPostTitle = Utils.getRandomPostTitle();
		fifthPostTitle = Utils.getRandomPostTitle();
		fifthPostDescription = Utils.getRandomPostDescription();
		fifthPostContent = Utils.getRandomPostContent();
		sixthPostTitle = Utils.getRandomPostTitle();
		sixthPostDescription = Utils.getRandomPostDescription();
		sixthPostContent = Utils.getRandomPostContent();
		seventhPostTitle = Utils.getRandomPostTitle();
		seventhPostDescription = Utils.getRandomPostDescription();
		seventhPostContent = Utils.getRandomPostContent();
		eighthPostTitle = Utils.getRandomPostTitle();
		eighthPostDescription = Utils.getRandomPostDescription();
		eighthPostContent = Utils.getRandomPostContent();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginSuccess();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.userLogOut();
		driver.quit();
	}

	@BeforeEach
	void setUp() throws Exception {
		//driver.get(URLConstant.POST_ADD);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void tc01() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.insertPostTitle("");
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POST_ADD);
		assertEquals(addPostPage.isTitleErrorDisplayed(), true, "Title error element is not displayed.");
		assertEquals(addPostPage.getTitleErrorText(), "This field is required.", "Title error message is not displayed.");
		assertEquals(addPostPage.isDescriptionErrorDisplayed(), true, "Description error element is not displayed.");
		assertEquals(addPostPage.getDescriptionErrorText(), "This field is required.", "Description error message is not displayed.");
		assertEquals(addPostPage.isTagErrorDisplayed(), true, "Tag error element is not displayed.");
		assertEquals(addPostPage.getTagErrorText(), "This field is required.", "Tag error message is not displayed.");

	}
	
	@Test
	void tc02() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.insertPostDescription("");
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POST_ADD);
		assertEquals(addPostPage.isTitleErrorDisplayed(), true, "Title error element is not displayed.");
		assertEquals(addPostPage.getTitleErrorText(), "This field is required.", "Title error message is not displayed.");
		assertEquals(addPostPage.isDescriptionErrorDisplayed(), true, "Description error element is not displayed.");
		assertEquals(addPostPage.getDescriptionErrorText(), "This field is required.", "Description error message is not displayed.");
		assertEquals(addPostPage.isTagErrorDisplayed(), true, "Tag error element is not displayed.");
		assertEquals(addPostPage.getTagErrorText(), "This field is required.", "Tag error message is not displayed.");
	}
	
	@Test
	void tc03() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.chooseTag();
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POST_ADD);
		assertEquals(addPostPage.isTitleErrorDisplayed(), true, "Title error element is not displayed.");
		assertEquals(addPostPage.getTitleErrorText(), "This field is required.", "Title error message is not displayed.");
		assertEquals(addPostPage.isDescriptionErrorDisplayed(), true, "Description error element is not displayed.");
		assertEquals(addPostPage.getDescriptionErrorText(), "This field is required.", "Description error message is not displayed.");
	}
	
	@Test
	void tc04() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.insertPostTitle("");
		addPostPage.insertPostDescription("");
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POST_ADD, "URL is not good.");
		assertEquals(addPostPage.isTitleErrorDisplayed(), true, "Title error element is not displayed.");
		assertEquals(addPostPage.getTitleErrorText(), "This field is required.", "Title error message is not displayed.");
		assertEquals(addPostPage.isDescriptionErrorDisplayed(), true, "Description error element is not displayed.");
		assertEquals(addPostPage.getDescriptionErrorText(), "This field is required.", "Description error message is not displayed.");
		assertEquals(addPostPage.isTagErrorDisplayed(), true, "Tag error element is not displayed.");
		assertEquals(addPostPage.getTagErrorText(), "This field is required.", "Tag error message is not displayed.");
	}
	
	@Test
	void tc05() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.insertPostTitle("");
		addPostPage.insertPostDescription("");
		addPostPage.clickOnCancel();
		assertEquals(driver.getCurrentUrl(), URLConstant.POSTS_LIST, "URL is not good");
	}
	@Test
	void tc06() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.insertPostTitle("galileogalilej");
		addPostPage.insertPostDescription("");
		addPostPage.chooseTag();
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POST_ADD, "URL is not good.");
		assertEquals(addPostPage.isTitleMinCharErrorDisplayed(), true, "Title minChar error element is not displayed.");
		assertEquals(addPostPage.getTitleMinCharErrorText(), "Please enter at least 20 characters.", "Title minChar error message is not displayed.");
		assertEquals(addPostPage.isDescriptionErrorDisplayed(), true, "Description error element is not displayed.");
		assertEquals(addPostPage.getDescriptionErrorText(), "This field is required.", "Description error message is not displayed.");
	}
	
	@Test
	void tc07() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.insertPostTitle("galileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilej");
		addPostPage.insertPostDescription("");
		addPostPage.chooseTag();
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POST_ADD, "URL is not good.");
		assertEquals(addPostPage.isTitleMaxCharErrorDisplayed(), true, "Title maxChar error element is not displayed.");
		assertEquals(addPostPage.getTitleMaxCharErrorText(), "Please enter no more than 255 characters.", "Title maxChar error message is not displayed.");
		assertEquals(addPostPage.isDescriptionErrorDisplayed(), true, "Description error element is not displayed.");
		assertEquals(addPostPage.getDescriptionErrorText(), "This field is required.", "Description error message is not displayed.");
	}
	
	@Test
	void tc08() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.insertPostTitle("");
		addPostPage.insertPostDescription("galileogalilej");
		addPostPage.chooseTag();
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POST_ADD, "URL is not good.");
		assertEquals(addPostPage.isTitleErrorDisplayed(), true, "Title error element is not displayed.");
		assertEquals(addPostPage.getTitleErrorText(), "This field is required.", "Title error message is not displayed.");
		assertEquals(addPostPage.isDescriptionMinCharErrorDisplayed(), true, "Description minChar error element is not displayed.");
		assertEquals(addPostPage.getDescriptionMinCharErrorText(), "Please enter at least 50 characters.", "Description minChar error message is not displayed.");
	}
	
	@Test
	void tc09() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.insertPostTitle("");
		addPostPage.insertPostDescription("galileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilej");
		addPostPage.chooseTag();
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POST_ADD, "URL is not good.");
		assertEquals(addPostPage.isTitleErrorDisplayed(), true, "Title error element is not displayed.");
		assertEquals(addPostPage.getTitleErrorText(), "This field is required.", "Title error message is not displayed.");
	}
	
	@Test
	void tc10() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.insertPostTitle("galileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilej");
		addPostPage.insertPostDescription("galileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilej");
		addPostPage.chooseTag();
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POST_ADD, "URL is not good.");
		assertEquals(addPostPage.isTitleMaxCharErrorDisplayed(), true, "Title maxChar error element is not displayed.");
		assertEquals(addPostPage.getTitleMaxCharErrorText(), "Please enter no more than 255 characters.", "Title maxChar error message is not displayed.");
	}

	@Test
	void tc11() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.insertPostTitle("galileogalilej");
		addPostPage.insertPostDescription("galileogalilej");
		addPostPage.chooseTag();
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POST_ADD, "URL is not good.");
		assertEquals(addPostPage.isTitleMinCharErrorDisplayed(), true, "Title minChar error element is not displayed.");
		assertEquals(addPostPage.getTitleMinCharErrorText(), "Please enter at least 20 characters.", "Title minChar error message is not displayed.");
		assertEquals(addPostPage.isDescriptionMinCharErrorDisplayed(), true, "Description minChar error element is not displayed.");
		assertEquals(addPostPage.getDescriptionMinCharErrorText(), "Please enter at least 50 characters.", "Description minChar error message is not displayed.");
	}
	
	@Test
	void tc12() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.insertPostTitle("galileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilej");
		addPostPage.insertPostDescription("galileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilej");
		addPostPage.chooseTag();
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POST_ADD, "URL is not good.");
		assertEquals(addPostPage.isTitleMaxCharErrorDisplayed(), true, "Title maxChar error element is not displayed.");
		assertEquals(addPostPage.getTitleMaxCharErrorText(), "Please enter no more than 255 characters.", "Title maxChar error message is not displayed.");
		assertEquals(addPostPage.isDescriptionMaxCharErrorDisplayed(), true, "Description maxChar error element is not displayed.");
		assertEquals(addPostPage.getDescriptionMaxCharErrorText(), "Please enter no more than 500 characters.", "Description maxChar error message is not displayed.");
	}
	
	@Test
	void tc13() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.insertPostTitle("galileogalilejgalileogalilej");
		addPostPage.insertPostDescription("galileogalilejgalileogalilejgalileogalilejgalileogalilejgalileogalilej");
		addPostPage.chooseTag();
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POST_ADD, "URL is not good.");
		assertEquals(addPostPage.isContentErrorDisplayed(), true, "Content error element is not displayed.");
		assertEquals(addPostPage.getContentErrorText(), "The content field is required.", "Content error message is not displayed.");
	}
	
	@Test
	void tc14() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.chooseCategory();
		addPostPage.insertPostDescription(firstPostDescription);
		addPostPage.clickOnImportantYes();
		addPostPage.chooseTag();
		addPostPage.chooseThirdNewFile();
		addPostPage.insertPostContent(firstPostContent);
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POST_ADD, "URL is not good.");
		assertEquals(addPostPage.isTitleErrorDisplayed(), true, "Title error element is not displayed.");
		assertEquals(addPostPage.getTitleErrorText(), "This field is required.", "Title error message is not displayed.");
	}
	
	@Test
	void tc15() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.chooseCategory();
		addPostPage.insertPostTitle(firstPostTitle);
		addPostPage.clickOnImportantYes();
		addPostPage.chooseTag();
		addPostPage.chooseThirdNewFile();
		addPostPage.insertPostContent(firstPostContent);
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POST_ADD, "URL is not good.");
		assertEquals(addPostPage.isDescriptionErrorDisplayed(), true, "Description error element is not displayed.");
		assertEquals(addPostPage.getDescriptionErrorText(), "This field is required.", "Description error message is not displayed.");
	}
	
	@Test
	void tc16() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.chooseCategory();
		addPostPage.insertPostTitle(firstPostTitle);
		addPostPage.insertPostDescription(firstPostDescription);
		addPostPage.clickOnImportantYes();
		addPostPage.chooseThirdNewFile();
		addPostPage.insertPostContent(firstPostContent);
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POST_ADD, "URL is not good.");
		assertEquals(addPostPage.isTagErrorDisplayed(), true, "Tag error element is not displayed.");
		assertEquals(addPostPage.getTagErrorText(), "This field is required.", "Tag error message is not displayed.");
		ListPostPage listPostPage = new ListPostPage(driver);
		assertEquals(listPostPage.countPostWithTitle(firstPostTitle), 0, "Post appears in the list.");
	}
	
	@Test
	void tc17() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.chooseCategory();
		addPostPage.insertPostTitle(firstPostTitle);
		addPostPage.insertPostDescription(firstPostDescription);
		addPostPage.clickOnImportantYes();
		addPostPage.chooseTag();
		addPostPage.chooseThirdNewFile();
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POST_ADD, "URL is not good.");
		assertEquals(addPostPage.isContentErrorDisplayed(), true, "Content error element is not displayed.");
		assertEquals(addPostPage.getContentErrorText(), "The content field is required.", "Content error message is not displayed.");
	}
	
	@Test
	void tc18() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.insertPostTitle(firstPostTitle);
		addPostPage.insertPostDescription(firstPostDescription);
		addPostPage.chooseTag();
		addPostPage.insertPostContent(firstPostContent);
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POSTS_LIST, "URL is not good.");
		ListPostPage listPostPage = new ListPostPage(driver);
		listPostPage.insertTitleToSearchPosts(firstPostTitle);
		listPostPage.chooseImportantNoToSearchPosts();
		assertEquals(listPostPage.countPostWithTitle(firstPostTitle), 1, "Post doesn't appear in the list or there are more of them.");
	}
	
	@Test
	void tc19() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.chooseCategory();
		addPostPage.insertPostTitle(secondPostTitle);
		addPostPage.insertPostDescription(secondPostDescription);
		addPostPage.clickOnImportantYes();
		addPostPage.chooseTag();
		addPostPage.chooseFirstNewFile();
		addPostPage.insertPostContent(secondPostContent);
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POSTS_LIST, "URL is not good.");
		ListPostPage listPostPage = new ListPostPage(driver);
		listPostPage.insertTitleToSearchPosts(secondPostTitle);
		assertEquals(listPostPage.countPostWithTitle(secondPostTitle), 1, "Post doesn't appear in the list or there are more of them.");
	}
	
	@Test
	void tc20() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.chooseCategory();
		addPostPage.insertPostTitle(thirdPostTitle);
		addPostPage.insertPostDescription(thirdPostDescription);
		addPostPage.clickOnImportantYes();
		addPostPage.chooseTag();
		addPostPage.chooseFourthNewFile();
		addPostPage.insertPostContent(thirdPostContent);
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POST_ADD, "URL is not good.");
		assertEquals(addPostPage.isChooseFileErrorDisplayed(), true, "Choose file error element is not displayed.");
		assertEquals(addPostPage.getChooseFileErrorText(), "The photo must be an image.", "Choose file error message is not displayed.");
	}
	
	@Test
	void tc21() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.chooseCategory();
		addPostPage.insertPostTitle(thirdPostTitle);
		addPostPage.insertPostDescription(thirdPostDescription);
		addPostPage.clickOnImportantYes();
		addPostPage.chooseTag();
		addPostPage.chooseSixthNewFile();
		addPostPage.insertPostContent(thirdPostContent);
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POST_ADD, "URL is not good.");
		assertEquals(addPostPage.isChooseFileErrorDisplayed(), true, "Choose file error element is not displayed.");
		assertEquals(addPostPage.getChooseFileErrorText(), "The photo must be an image.", "Choose file error message is not displayed.");
	}
	
	@Test
	void tc22() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.chooseCategory();
		addPostPage.insertPostTitle(thirdPostTitle);
		addPostPage.insertPostDescription(thirdPostDescription);
		addPostPage.clickOnImportantYes();
		addPostPage.chooseTag();
		addPostPage.chooseSecondNewFile();
		addPostPage.insertPostContent(thirdPostContent);
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POSTS_LIST, "URL is not good.");
		ListPostPage listPostPage = new ListPostPage(driver);
		listPostPage.insertTitleToSearchPosts(thirdPostTitle);
		assertEquals(listPostPage.countPostWithTitle(thirdPostTitle), 1, "Post doesn't appear in the list or there are more of them.");
		listPostPage.updatePost(thirdPostTitle);
		addPostPage.insertPostTitle(fourthPostTitle);
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POSTS_LIST, "URL is not good.");
		listPostPage.insertTitleToSearchPosts(fourthPostTitle);
		assertEquals(listPostPage.countPostWithTitle(fourthPostTitle), 1, "Post doesn't appear in the list or there are more of them.");
	}
	
	@Test
	void tc23() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.chooseCategory();
		addPostPage.insertPostTitle(thirdPostTitle);
		addPostPage.insertPostDescription(thirdPostDescription);
		addPostPage.clickOnImportantYes();
		addPostPage.chooseTag();
		addPostPage.chooseSecondNewFile();
		addPostPage.insertPostContent(thirdPostContent);
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POSTS_LIST, "URL is not good.");
		ListPostPage listPostPage = new ListPostPage(driver);
		listPostPage.insertTitleToSearchPosts(thirdPostTitle);
		assertEquals(listPostPage.countPostWithTitle(thirdPostTitle), 1, "Post doesn't appear in the list or there are more of them.");
		listPostPage.deletePost(thirdPostTitle);
		listPostPage.clickOnDeleteDialogDelete();
		assertEquals(driver.getCurrentUrl(), URLConstant.POSTS_LIST, "URL is not good.");
		listPostPage.insertTitleToSearchPosts(thirdPostTitle);
		assertEquals(listPostPage.countPostWithTitle(thirdPostTitle), 0, "Post appears in the list.");
	}
	
	@Test
	void tc24() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.chooseCategory();
		addPostPage.insertPostTitle(fifthPostTitle);
		addPostPage.insertPostDescription(fifthPostDescription);
		addPostPage.clickOnImportantYes();
		addPostPage.chooseTag();
		addPostPage.chooseThirdNewFile();
		addPostPage.insertPostContent(fifthPostContent);
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POSTS_LIST, "URL is not good.");
		ListPostPage listPostPage = new ListPostPage(driver);
		listPostPage.insertTitleToSearchPosts(fifthPostTitle);
		assertEquals(listPostPage.countPostWithTitle(fifthPostTitle), 1, "Post doesn't appear in the list or there are more of them.");
		listPostPage.updatePost(fifthPostTitle);
		addPostPage.insertPostTitle(sixthPostTitle);
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POSTS_LIST, "URL is not good.");
		listPostPage.insertTitleToSearchPosts(sixthPostTitle);
		assertEquals(listPostPage.countPostWithTitle(sixthPostTitle), 1, "Post doesn't appear in the list or there are more of them.");
		listPostPage.deletePost(sixthPostTitle);
		listPostPage.clickOnDeleteDialogDelete();
		assertEquals(listPostPage.countPostWithTitle(sixthPostTitle), 0, "Post appears in the list.");
	}
	
	@Test
	void tc25() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.chooseCategory();
		addPostPage.insertPostTitle(sixthPostTitle);
		addPostPage.insertPostDescription(sixthPostDescription);
		addPostPage.clickOnImportantYes();
		addPostPage.chooseTag();
		addPostPage.chooseThirdNewFile();
		addPostPage.insertPostContent(sixthPostContent);
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POSTS_LIST, "URL is not good.");
		ListPostPage listPostPage = new ListPostPage(driver);
		listPostPage.insertTitleToSearchPosts(sixthPostTitle);
		listPostPage.chooseImportantYesToSearchPosts();
		listPostPage.chooseCategoryToSearchPosts();
		listPostPage.chooseAuthorToSearchPosts();
		assertEquals(listPostPage.countPostWithTitle(sixthPostTitle), 1, "Post doesn't appear in the list or there are more of them.");
	}
	
	@Test
	void tc26() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.chooseCategory();
		addPostPage.insertPostTitle(seventhPostTitle);
		addPostPage.insertPostDescription(seventhPostDescription);
		addPostPage.clickOnImportantNo();
		addPostPage.chooseTag();
		addPostPage.chooseSecondNewFile();
		addPostPage.insertPostContent(seventhPostContent);
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POSTS_LIST, "URL is not good.");
		ListPostPage listPostPage = new ListPostPage(driver);
		listPostPage.chooseImportantNoToSearchPosts();
		listPostPage.chooseAuthorToSearchPosts();
		listPostPage.insertTitleToSearchPosts(seventhPostTitle);
		assertEquals(listPostPage.countPostWithTitle(seventhPostTitle), 1, "Post doesn't appear in the list or there are more of them.");
		listPostPage.updatePost(seventhPostTitle);
		addPostPage.insertPostTitle(eighthPostTitle);
		addPostPage.insertPostDescription(eighthPostDescription);
		addPostPage.clickOnImportantYes();
		addPostPage.deletePhotoOnUpdatingPost();
		assertEquals(addPostPage.isDeletePhotoErrorDisplayed(), true, "Delete photo error element is not displayed.");
		assertEquals(addPostPage.getDeletePhotoErrorText(), "Error while deleteing photo", "Delete photo error message is not displayed.");
		addPostPage.insertPostContent(eighthPostContent);
		//addPostPage.chooseFirstNewFile();		// ne da da se izabere slika
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POSTS_LIST, "URL is not good.");
		listPostPage.chooseImportantYesToSearchPosts();
		listPostPage.insertTitleToSearchPosts(eighthPostTitle);
		assertEquals(listPostPage.countPostWithTitle(eighthPostTitle), 1, "Post doesn't appear in the list or there are more of them.");
	}
	
	@Test
	void tc27() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.chooseCategory();
		addPostPage.insertPostTitle(seventhPostTitle);
		addPostPage.insertPostDescription(seventhPostDescription);
		addPostPage.clickOnImportantNo();
		addPostPage.chooseTag();
		addPostPage.chooseSecondNewFile();
		addPostPage.insertPostContent(seventhPostContent);
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POSTS_LIST, "URL is not good.");
		ListPostPage listPostPage = new ListPostPage(driver);
		listPostPage.chooseImportantNoToSearchPosts();
		listPostPage.chooseAuthorToSearchPosts();
		listPostPage.insertTitleToSearchPosts(seventhPostTitle);
		assertEquals(listPostPage.countPostWithTitle(seventhPostTitle), 1, "Post doesn't appear in the list or there are more of them.");
		listPostPage.updatePost(seventhPostTitle);
		addPostPage.insertPostTitle(eighthPostTitle);
		addPostPage.insertPostDescription(eighthPostDescription);
		addPostPage.clickOnImportantYes();
		addPostPage.deletePhotoOnUpdatingPost();
		assertEquals(addPostPage.isDeletePhotoErrorDisplayed(), true, "Delete photo error element is not displayed.");
		assertEquals(addPostPage.getDeletePhotoErrorText(), "Error while deleteing photo", "Delete photo error message is not displayed.");
		addPostPage.insertPostContent(eighthPostContent);
		addPostPage.chooseFirstNewFile();		// ne da da se izabere slika
		addPostPage.clickOnSave();
		assertEquals(driver.getCurrentUrl(), URLConstant.POSTS_LIST, "URL is not good.");
		listPostPage.chooseImportantYesToSearchPosts();
		listPostPage.insertTitleToSearchPosts(eighthPostTitle);
		assertEquals(listPostPage.countPostWithTitle(eighthPostTitle), 1, "Post doesn't appear in the list or there are more of them.");
	}
	
	@Test
	void tc28(){
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.clickOnSidebarSlidersList();
		assertEquals(driver.getCurrentUrl(), URLConstant.SLIDERS_LIST, "URL is not good.");
	}
	
	@Test
	void tc29() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.clickOnSidebarAddSlider();
		assertEquals(driver.getCurrentUrl(), URLConstant.SLIDER_ADD, "URL is not good.");
	}
	
	@Test
	void tc30() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.clickOnSidebarPostCategoriesList();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORIES_LIST, "URL is not good.");
	}
	
	@Test
	void tc31() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.clickOnSidebarAddPostCategory();
		assertEquals(driver.getCurrentUrl(), URLConstant.CATEGORY_ADD, "URL is not good.");
	}
	
	@Test
	void tc32() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.clickOnSidebarTagsList();
		assertEquals(driver.getCurrentUrl(), URLConstant.TAGS_LIST, "URL is not good.");
	}
	
	@Test
	void tc33() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.clickOnSidebarAddTag();
		assertEquals(driver.getCurrentUrl(), URLConstant.TAG_ADD, "URL is not good.");
	}
	
	@Test
	void tc34() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.clickOnSidebarPostsList();
		assertEquals(driver.getCurrentUrl(), URLConstant.POSTS_LIST, "URL is not good.");
	}
	
	@Test
	void tc35() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.clickOnSidebarAddPost();
		assertEquals(driver.getCurrentUrl(), URLConstant.POST_ADD, "URL is not good.");
	}
	
	@Test
	void tc36() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.clickOnSidebarCommentsList();
		assertEquals(driver.getCurrentUrl(), URLConstant.COMMENTS, "URL is not good.");
	}
	
	@Test
	void tc37() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.clickOnSidebarUsersList();
		assertEquals(driver.getCurrentUrl(), URLConstant.USERS_LIST, "URL is not good.");
	}
	
	@Test
	void tc38() {
		AddPostPage addPostPage = new AddPostPage(driver);
		addPostPage.clickOnSidebarAddUser();
		assertEquals(driver.getCurrentUrl(), URLConstant.USER_ADD, "URL is not good.");
	}
	
}
