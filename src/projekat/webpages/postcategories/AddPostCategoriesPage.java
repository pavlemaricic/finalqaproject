package projekat.webpages.postcategories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import projekat.main.URLConstant;
import projekat.main.Utils;

public class AddPostCategoriesPage {

	private WebDriver driver;

	@FindBy(name = "name")
	private WebElement weInsertPostCategoryName;
	@FindBy(id = "name-error")
	private WebElement wePostCategoryNameError;
	@FindBy(xpath = "//*[text()='The name has already been taken.']")
	private WebElement wePostCategoryTakenNameError;
	@FindBy(xpath = "//span[text()='Please enter no more than 255 characters.']")
	private WebElement wePostCategoryNameCharError;
	
	@FindBy(name = "description")
	private WebElement weInsertPostCategoryDescription;
	@FindBy(id = "description-error")
	private WebElement wePostCategoryDescriptionError;
	@FindBy(xpath = "//*[text()='The description must be at least 50 characters.']")
	private WebElement wePostCategoryDescriptionMinCharError;
	@FindBy(xpath = "//*[text()='Please enter no more than 500 characters.']")
	private WebElement wePostCategoryDescriptionMaxCharError;
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement weSavePostCategory;
	@FindBy(xpath = "//a[text()='Cancel']")
	private WebElement weCancelPostCategory;
	@FindBy(xpath = "//a[text()='Home']")
	private WebElement weHomeButton;
	@FindBy(xpath = "//a[text()='Post Categories']")
	private WebElement wePostCategoriesButton;
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
	
	public AddPostCategoriesPage(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().window().maximize();
		this.driver.get(URLConstant.CATEGORY_ADD);
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void insertPostCategoryName(String name) {
		weInsertPostCategoryName.clear();
		weInsertPostCategoryName.sendKeys(name);
	}
	public void insertPostCategoryDescription(String description) {
		weInsertPostCategoryDescription.clear();
		weInsertPostCategoryDescription.sendKeys(description);
	}
	
	
	
	public void clickOnSave() {
		weSavePostCategory.click();
	}
	public void clickOnCancel() {
		weCancelPostCategory.click();
	}
	
	
	
	public boolean isNameErrorDisplayed() {
		return wePostCategoryNameError.isDisplayed();
	}
	public boolean isTakenNameErrorDisplayed() {
		return wePostCategoryTakenNameError.isDisplayed();
	}
	public boolean isNameCharErrorDisplayed() {
		return wePostCategoryNameCharError.isDisplayed();
	}
	public boolean isDescriptionErrorDisplayed() {
		return wePostCategoryDescriptionError.isDisplayed();
	}
	public boolean isDescriptionErrorMinCharDisplayed() {
		return wePostCategoryDescriptionMinCharError.isDisplayed();
	}
	public boolean isDescriptionErrorMaxCharDisplayed() {
		return wePostCategoryDescriptionMaxCharError.isDisplayed();
	}
	public String getNameErrorText() {
		return wePostCategoryNameError.getText();
	}
	public String getTakenNameErrorText() {
		return wePostCategoryTakenNameError.getText();
	}
	public String getNameCharErrorText() {
		return wePostCategoryNameCharError.getText();
	}
	public String getDescriptionErrorText() {
		return wePostCategoryDescriptionError.getText();
	}
	public String getDescriptionErrorMinCharText() {
		return wePostCategoryDescriptionMinCharError.getText();
	}
	public String getDescriptionErrorMaxCharText() {
		return wePostCategoryDescriptionMaxCharError.getText();
	}
	
	
	
	public void addNewPostCategoryName(String name) {
		insertPostCategoryName(name);
	}
	public String addNewPostCategoryName() {
		String postCategoryName = Utils.getRandomPostCategoryName();
		addNewPostCategoryName(postCategoryName);
		return postCategoryName;
	}
	public void addNewPostCategoryDescription(String description) {
		insertPostCategoryDescription(description);
	}
	public String addNewPostCategoryDescription() {
		String postCategoryDescription = Utils.getRandomPostCategoryDescription();
		addNewPostCategoryDescription(postCategoryDescription);
		return postCategoryDescription;
	}
	public void addNewPostCategory(String name, String description) {
		addNewPostCategoryName(name);
		addNewPostCategoryDescription(description);
	}
	public String getPostCategoryNameText() {
		return weInsertPostCategoryName.getAttribute("value");
	}
	
	
	
	public void clickOnHomeButton() {
		weHomeButton.click();
	}
	public void clickOnPostCategoriesButton() {
		wePostCategoriesButton.click();
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
