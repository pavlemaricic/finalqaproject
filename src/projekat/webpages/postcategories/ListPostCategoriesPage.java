package projekat.webpages.postcategories;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import projekat.main.URLConstant;
import projekat.main.Utils;

public class ListPostCategoriesPage {

	private WebDriver driver;
	
	@FindBy(partialLinkText = "Add new Category")
	private WebElement weAddNewCategory;
	@FindBy(partialLinkText = "Change Order")
	private WebElement weChangeOrder;
	@FindBy(xpath = "//a[text()='Home']")
	private WebElement weHomeButton;
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


	public ListPostCategoriesPage(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().window().maximize();
		this.driver.get(URLConstant.CATEGORIES_LIST);
	}
	
	public void openPage() {
		this.driver.get(URLConstant.CATEGORIES_LIST);	
	}
	
	
	
	public void clickOnAddNewPostCategory() {
		WebElement weAddNewCategory = driver.findElement(By.partialLinkText("Add new Category"));
		weAddNewCategory.click();
	}
	
	
	
	//COUNT
	public int countPostCategoryWithName(String name) {
		List<WebElement> wePostCategoriesName = driver.findElements(By.xpath("//strong[text()='"+name+"']"));
		return wePostCategoriesName.size();
	}
	public int countPostCategoryWithDescription(String description) {
		List<WebElement> wePostCategoriesDescription = driver.findElements(By.xpath("//strong[text()='"+description+"']"));
		return wePostCategoriesDescription.size();
	}
	public boolean isPostCategoryNameInList(String name) {
		List<WebElement> wePostCategoriesName = driver.findElements(By.xpath("//strong[text()='\"+name+\"']"));
		return wePostCategoriesName.size()>0;
	}
	public List<WebElement> getPostCategoryWithNameList(String name){
		return driver.findElements(By.xpath("//strong[text()='\\\"+name+\\\"']"));
	}
	
	public String getCategoryIdLocator(String name) {
		return "//strong[text()='"+name+"']//ancestor::tr";
	}
	
	public String getCategoryId(String name) {
		WebElement categoryIdElement = driver.findElement(By.xpath(getCategoryId(name)));
		return categoryIdElement.getAttribute("data-id");
	}
	
	
	
	public void clickOnHomeButton() {
		weHomeButton.click();
	}
	public void clickOnUserIcon() {
		weUserIcon.click();
	}
	public void clickOnBlogButton() {
		weBlogButton.click();
	}
	public void clickOnCubesSchoolButton() {
		weCubesSchoolButton.click();
	}
	
	
	
	private String getDeletePostCategoryButtonLocator(String delete) {
		return "//strong[text()='"+delete+"']/../../td[6]/div/button";
	}
	public void clickOnDeletePostCategory(String delete) {
		WebElement deleteButton = driver.findElement(By.xpath(getDeletePostCategoryButtonLocator(delete)));
		Utils.scrollToElement(driver, deleteButton);
		try {
			Thread.sleep(1500);	//ne pomaze nista sem thread sleep-a
		} catch (InterruptedException e) {
			
		}
		deleteButton.click();
	}
	public void clickOnDeleteDialogDelete() {
		WebElement deleteButton = driver.findElement(By.xpath("//button[text()='Delete']"));
		deleteButton.click();
	}
	public void clickOnDeleteDialogCancel() {
		WebElement cancelButton = driver.findElement(By.xpath("//button[text()=''Cancel]"));
		cancelButton.click();
	}
	public void clickOnDeleteDialogX() {
		WebElement xButton = driver.findElement(By.xpath("//span[text()='×']"));
		xButton.click();
	}
	public void deletePostCategory(String delete) {
		clickOnDeletePostCategory(delete);
		WebDriverWait waitAction = new WebDriverWait(driver, Duration.ofSeconds(2));
		waitAction.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Delete']")));
		clickOnDeleteDialogDelete();
	}
	
	
	
	private String getUpdatePostCategoryButtonLocator(String update) {
		return "//strong[text()='"+update+"']//../../td[6]/div/a[2]";
	}
	public void updatePostCategoryName(String update) {
	WebElement updateButton = driver.findElement(By.xpath(getUpdatePostCategoryButtonLocator(update)));
	Utils.scrollToElement(driver, updateButton);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {

		}
		updateButton.click();
	}
	
	
	
	private String getToSeePostCategoryLocator(String see) {
		return "//strong[text()='"+see+"']/../../td[6]/div/a[1]";
	}
	public void seePostCategory(String see) {
		WebElement seeButon = driver.findElement(By.xpath(getToSeePostCategoryLocator(see)));
		Utils.scrollToElement(driver, seeButon);
		try {
			Thread.sleep(1500);	//ne pomaze nista sem thread sleep-a
		} catch (InterruptedException e) {

		}
		seeButon.click();
		String mainWindow = driver.getWindowHandle();
		driver.switchTo().window(mainWindow);
	}
	
	public void clickOnChangeOrder() {
		weChangeOrder.click();
	}
	public void clickOnChangeOrderSave() {
		clickOnChangeOrder();
		WebElement weSaveOrder = driver.findElement(By.partialLinkText("Save Order"));
		weSaveOrder.click();
	}
	public void clickOnChangeOrderCancel() {
		clickOnChangeOrder();
		WebElement weCancelOrder = driver.findElement(By.partialLinkText("Cancel"));
		weCancelOrder.click();
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
