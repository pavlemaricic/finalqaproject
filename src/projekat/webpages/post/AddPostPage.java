package projekat.webpages.post;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import projekat.main.URLConstant;
import projekat.main.Utils;

public class AddPostPage {

	private WebDriver driver;
		
	//CATEGORY
	@FindBy(name = "post_category_id")
	private WebElement weChooseCategory;
	@FindBy(xpath = "//option[text()='-- Choose Category --']")
	private WebElement weChooseWithoutCategory;
	
	//TITLE
	@FindBy(name = "title")
	private WebElement weInsertPostTitle;
	@FindBy(id = "title-error")
	private WebElement wePostTitleError;
	@FindBy(xpath = "//span[text()='Please enter at least 20 characters.']")
	private WebElement wePostTitleMinCharError;
	@FindBy(xpath = "//span[text()='Please enter no more than 255 characters.']")
	private WebElement wePostTitleMaxCharError;
	
	//DESCRIPTION
	@FindBy(name = "description")
	private WebElement weInsertPostDescription;
	@FindBy(id = "description-error")
	private WebElement wePostDescriptionError;
	@FindBy(xpath = "//span[text()='Please enter at least 50 characters.']")
	private WebElement wePostDescriptionMinCharError;
	@FindBy(xpath = "//span[text()='Please enter no more than 500 characters.']")
	private WebElement wePostDescriptionMaxCharError;
	
	//CONTENT
	@FindBy(xpath = "//div[.='The content field is required.']")
	private WebElement wePostContentError;
	@FindBy(xpath = "//div[@id='cke_1_contents']//descendant::iframe[1]")
	private WebElement wePostContent;
	
	//IMPORTANT
	@FindBy(xpath = "//label[text()='No']")
	private WebElement weChooseImportantNo;
	@FindBy(xpath = "//label[text()='Yes']")
	private WebElement weChooseImportantYes;
	
	//TAGS
	@FindBy(xpath = "//input[@value='8085']")
	private WebElement weChooseTags;
	@FindBy(id = "tag_id[]-error")
	private WebElement weChooseTagsError;
		
	//CHOOSE NEW PHOTO
	@FindBy(name = "photo")
	private WebElement weChooseNewFile;
	@FindBy(xpath = "//div[.='The photo must be an image.']")
	private WebElement weChooseFileError;
	@FindBy(xpath = "//button[@data-action='delete-photo']")
	private WebElement weDeletePhoto;
	@FindBy(xpath = "//div[@class='toast-message']")
	private WebElement weDeletePhotoText;

	//SAVE,CANCEL
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement weSavePost;
	@FindBy(xpath = "//a[text()='Cancel']")
	private WebElement weCancelPost;
	
	@FindBy(xpath = "//a[text()='Home']")
	private WebElement weHomeButton;
	@FindBy(xpath = "//a[text()='Post']")
	private WebElement wePostButton;
	@FindBy(xpath = "//a[text()='Cubes School']")
	private WebElement weCubesSchoolButton;
	@FindBy(xpath = "//i[@class='far fa-user']")
	private WebElement weUserIcon;
	
	@FindBy(xpath = "//a[@data-widget='pushmenu']")
	private WebElement weSidebarMenu;
	@FindBy(xpath = "//span[text()='Blog']")
	private WebElement weBlogButton;
	@FindBy(partialLinkText = "Sliders")
	private WebElement weSidebarSliders;
	@FindBy(partialLinkText = "Post Categories")
	private WebElement weSidebarPostCategories;
	@FindBy(partialLinkText = "Tags")
	private WebElement weSidebarTags;
	@FindBy(partialLinkText = "Posts")
	private WebElement weSidebarPosts;
	@FindBy(partialLinkText = "Comments")
	private WebElement weSidebarComments;
	@FindBy(partialLinkText = "Users")
	private WebElement weSidebarUsers;
	
	
	public AddPostPage(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().window().maximize();
		this.driver.get(URLConstant.POST_ADD);
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void clickOnSave()  {
		WebElement weSave = driver.findElement(By.xpath("//button[text()='Save']"));
		Utils.scrollToElement(driver, weSave);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

		}
//		WebDriverWait waitAction = new WebDriverWait(driver, Duration.ofSeconds(2));
//		waitAction.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary']")));
		weSavePost.click();
	}
	public void clickOnCancel() {
		Utils.scrollToElement(driver, weCancelPost);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

		}
		//WebDriverWait waitAction = new WebDriverWait(driver, Duration.ofSeconds(2));
		//waitAction.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Cancel']")));
		weCancelPost.click();
	}
	
	
	
	public void chooseCategory() {
		weChooseCategory.click();
		WebElement weChooseDefaultCategory = driver.findElement(By.xpath("//option[contains(.,'Default Post Category NE BRISATI')]"));
		weChooseDefaultCategory.click();
	}
	
	
	
	public void insertPostTitle(String title) {
		weInsertPostTitle.clear();
		weInsertPostTitle.sendKeys(title);
	}
	public boolean isTitleErrorDisplayed() {
		return wePostTitleError.isDisplayed();
	} 
	public String getTitleErrorText() {
		return wePostTitleError.getText();
	}
	public boolean isTitleMinCharErrorDisplayed() {
		return wePostTitleMinCharError.isDisplayed();
	} 
	public String getTitleMinCharErrorText() {
		return wePostTitleMinCharError.getText();
	}
	public boolean isTitleMaxCharErrorDisplayed() {
		return wePostTitleMaxCharError.isDisplayed();
	} 
	public String getTitleMaxCharErrorText() {
		return wePostTitleMaxCharError.getText();
	}
	
	
	
	public void insertPostDescription(String description) {
		weInsertPostDescription.clear();
		weInsertPostDescription.sendKeys(description);
	}
	public boolean isDescriptionErrorDisplayed() {
		return wePostDescriptionError.isDisplayed();
	} 
	public String getDescriptionErrorText() {
		return wePostDescriptionError.getText();
	}
	public boolean isDescriptionMinCharErrorDisplayed() {
		return wePostDescriptionMinCharError.isDisplayed();
	} 
	public String getDescriptionMinCharErrorText() {
		return wePostDescriptionMinCharError.getText();
	}
	public boolean isDescriptionMaxCharErrorDisplayed() {
		return wePostDescriptionMaxCharError.isDisplayed();
	} 
	public String getDescriptionMaxCharErrorText() {
		return wePostDescriptionMaxCharError.getText();
	}
	
	
	public boolean isContentErrorDisplayed() {
		return wePostContentError.isDisplayed();
	}
	public String getContentErrorText() {
		return wePostContentError.getText();
	}
	
	
	public boolean isChooseFileErrorDisplayed() {
		return weChooseFileError.isDisplayed();
	}
	public String getChooseFileErrorText() {
		return weChooseFileError.getText();
	}
	public boolean isDeletePhotoErrorDisplayed() {
		return weDeletePhotoText.isDisplayed();
	}
	public String getDeletePhotoErrorText() {
		return weDeletePhotoText.getText();
	}
	
	
	public void chooseTag() {
		weChooseTags.click();
	}
	public boolean isTagErrorDisplayed() {
		return weChooseTagsError.isDisplayed();
	} 
	public String getTagErrorText() {
		return weChooseTagsError.getText();
	}
	
	
	
	public void clickOnImportantNo() {
		weChooseImportantNo.click();
	}
	public void clickOnImportantYes() {
		weChooseImportantYes.click();
	}
	
	
	
	public void chooseFirstNewFile() {
		Utils.scrollToElement(driver, weChooseNewFile);
		String chooseFile = System.getProperty("user.dir");
		weChooseNewFile = driver.findElement(By.name("photo"));
		weChooseNewFile.sendKeys(chooseFile + "\\picture\\Everest.jpg");
	}
	public void chooseSecondNewFile() {
		Utils.scrollToElement(driver, weChooseNewFile);
		String chooseFile = System.getProperty("user.dir");
		weChooseNewFile = driver.findElement(By.name("photo"));
		weChooseNewFile.sendKeys(chooseFile + "\\picture\\River.jpg");
	}
	public void chooseThirdNewFile() {
		Utils.scrollToElement(driver, weChooseNewFile);
		String chooseFile = System.getProperty("user.dir");
		weChooseNewFile = driver.findElement(By.name("photo"));
		weChooseNewFile.sendKeys(chooseFile + "\\picture\\Planet.jpg");
	}
	public void chooseFourthNewFile() {
		Utils.scrollToElement(driver, weChooseNewFile);
		String chooseFile = System.getProperty("user.dir");
		weChooseNewFile = driver.findElement(By.name("photo"));
		weChooseNewFile.sendKeys(chooseFile + "\\documents\\KursMax.docx");
	}
	public void chooseFifthNewFile() {
		Utils.scrollToElement(driver, weChooseNewFile);
		String chooseFile = System.getProperty("user.dir");
		weChooseNewFile = driver.findElement(By.name("photo"));
		weChooseNewFile.sendKeys(chooseFile + "\\documents\\KursMin.docx");
	}
	public void chooseSixthNewFile() {
		Utils.scrollToElement(driver, weChooseNewFile);
		String chooseFile = System.getProperty("user.dir");
		weChooseNewFile = driver.findElement(By.name("photo"));
		weChooseNewFile.sendKeys(chooseFile + "\\picture\\Photo.avif");
	}
	public void deletePhotoOnUpdatingPost() {
		weDeletePhoto.click();
	}
	
	

	
	
	public String getContentPostLocator(String content) {
		return "//div[@id='cke_1_contents']//descendant::iframe[1]";
	}
	public void insertPostContent(String content) {
		WebElement contentField = driver.findElement(By.xpath(getContentPostLocator(content)));
		Utils.scrollToElement(driver, contentField);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

		}		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[1]")));

		driver.findElement(By.cssSelector("body")).sendKeys(content);
		driver.switchTo().defaultContent();
	}

	
	
	public void clickOnHomeButton() {
		weHomeButton.click();
	}
	public void clickOnPostButton() {
		wePostButton.click();
	}
	public void clickOnCubesSchoolButton() {
		weCubesSchoolButton.click();
	}
	public void clickOnSidebarMenu() {
		weSidebarMenu.click();
	}
	public void clickOnBlogButton() {
		weBlogButton.click();
	}
	
	
	
	public void clickOnSidebarSlidersList() {
		weSidebarSliders.click();
		WebElement weSlidersList = driver.findElement(By.xpath("//*[text()='Sliders list']"));
		weSlidersList.click();
	}
	public void clickOnSidebarAddSlider() {
		weSidebarSliders.click();
		WebElement weAddSlider = driver.findElement(By.xpath("//*[text()='Add Slider']"));
		weAddSlider.click();
	}
	public void clickOnSidebarPostCategoriesList() {
		weSidebarPostCategories.click();
		WebElement wePostCategoriesList = driver.findElement(By.xpath("//*[text()='Post Categories list']"));
		wePostCategoriesList.click();
	}
	public void clickOnSidebarAddPostCategory() {
		weSidebarPostCategories.click();
		WebElement weAddPostCategory = driver.findElement(By.xpath("//*[text()='Add Post Category']"));
		weAddPostCategory.click();
	}
	public void clickOnSidebarTagsList() {
		weSidebarTags.click();
		WebElement weTagsList = driver.findElement(By.xpath("//*[text()='Tags list']"));
		weTagsList.click();
	}
	public void clickOnSidebarAddTag() {
		weSidebarTags.click();
		WebElement weAddTag = driver.findElement(By.xpath("//*[text()='Add Tag']"));
		weAddTag.click();
	}
	public void clickOnSidebarPostsList() {
		weSidebarPosts.click();
		WebElement wePostsList = driver.findElement(By.xpath("//*[text()='Posts list']"));
		wePostsList.click();
	}
	public void clickOnSidebarAddPost() {
		weSidebarPosts.click();
		WebElement weAddPost = driver.findElement(By.xpath("//*[text()='Add Post']"));
		weAddPost.click();
	}
	public void clickOnSidebarCommentsList() {
		weSidebarComments.click();
		WebElement weCommentsList = driver.findElement(By.xpath("//*[text()='Comments List']"));
		weCommentsList.click();
	}
	public void clickOnSidebarUsersList() {
		weSidebarUsers.click();
		WebElement weUsersList = driver.findElement(By.xpath("//*[text()='Users List']"));
		weUsersList.click();
	}
	public void clickOnSidebarAddUser() {
		weSidebarUsers.click();
		WebElement weAddUser = driver.findElement(By.xpath("//*[text()='Add User']"));
		weAddUser.click();
	}
	public void userLogOut() {
		weUserIcon.click();
		WebElement weLogOut = driver.findElement(By.partialLinkText("Log Out"));
		weLogOut.click();
	}
	
}
