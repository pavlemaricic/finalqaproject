package projekat.webpages.tag;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import projekat.main.URLConstant;
import projekat.main.Utils;

public class AddTagPage {

	private WebDriver driver;

	@FindBy(name = "name")
	private WebElement weTagName;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement weSaveTag;
	@FindBy(xpath = "//a[text()='Cancel']")
	private WebElement weCancelTag;
	@FindBy(id = "name-error")
	private WebElement weNameError;
	@FindBy(xpath = "//a[text()='Home']")
	private WebElement weHomeButton;
	@FindBy(xpath = "//a[text()='Tags']")
	private WebElement weTagsButton;
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
	
	public AddTagPage(WebDriver driver, boolean openPage) {
		this.driver = driver;
		this.driver.manage().window().maximize();
		if(openPage) {
		this.driver.get(URLConstant.TAG_ADD);
		}
		
		PageFactory.initElements(driver, this);
	}
		
	public void insertTagName(String tagName) {
		weTagName.clear();
		weTagName.sendKeys(tagName);
	}
	
	public void clickOnSave() {
		weSaveTag.click();
	}
	
	public void clickOnCancel() {
		weCancelTag.click();
	}
	
	public boolean isNameErrorDisplayed() {
		return weNameError.isDisplayed();
	}
	
	public String getNameErrorText() {
		return weNameError.getText();
	}
	
	public String getTagNameText() {
		return weTagName.getAttribute("value");
	}
	
	public void ClickOnHomeButton() {
		weHomeButton.click();
	}
	
	public void clickOnTagsButton() {
		weTagsButton.click();
	}
	
	public void clickOnCubesSchoolButton() {
		weCubesSchoolButton.click();
	}
	
	public void clickOnBlogButton() {
		weBlogButton.click();
	}
	
	public void userLogOut() {
		weUserIcon.click();
		WebElement weLogOut = driver.findElement(By.partialLinkText("Log Out"));
		weLogOut.click();
	}
	
	public void addNewTag(String name) {
		insertTagName(name);
		clickOnSave();
	}
	
	public String addNewTag() {
		String tagName = Utils.getRandomTagName();
		addNewTag(tagName);
		return tagName;
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

}
