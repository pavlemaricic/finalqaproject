package projekat.webpages.tag;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import projekat.main.URLConstant;
import projekat.main.Utils;

public class ListTagPage {

	private WebDriver driver;
	
	@FindBy(partialLinkText = "Add new Tag")
	private WebElement weAddNewTag;
	@FindBy(xpath = "//a[text()='Home']")
	private WebElement weHomeButton;
	@FindBy(xpath = "//i[@class='far fa-user']")
	private WebElement weUserIcon;
	@FindBy(xpath = "//a[text()='Cubes School']")
	private WebElement weCubesSchoolButton;
	
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

	public ListTagPage(WebDriver driver) {
		this.driver = driver;		
		PageFactory.initElements(driver, this);
	}
	
	public void openPage() {
		this.driver.get(URLConstant.TAGS_LIST);	
	}
	
	public void clickOnAddNewTag() {
		weAddNewTag.click();
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
	
	public void clickOnDeleteTag(String name) {
		WebElement deleteButton = driver.findElement(By.xpath(getDeleteButtonLocator(name)));
		deleteButton.click();
	}
	
	public void clickOnDeleteDialogDelete() {
		WebElement deleteButton = driver.findElement(By.xpath("//button[text()='Delete']"));
		deleteButton.click();
	}
	
	public void clickOnDeleteDialogCancel() {
		WebElement cancelButton = driver.findElement(By.xpath("//button[text()='Cancel']"));
		cancelButton.click();
	}
	
	public void clickOnDeleteDialogX() {
		WebElement xButton = driver.findElement(By.xpath("//span[text()='×']"));
		xButton.click();
	}
	
	
	public void clickOnUpdateTag(String name) {
		WebElement updateButton = driver.findElement(By.xpath(getUpdateButtonLocator(name)));
		Utils.scrollToElement(driver, updateButton);
		updateButton.click();
	}
	
	public void deleteTag(String name) {
		clickOnDeleteTag(name);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Delete']")));
		clickOnDeleteDialogDelete();		
	}
	
	
	public int countTagWithName(String name) {
		List<WebElement> weTagsList = driver.findElements(By.xpath("//strong[text()='"+name+"']"));
		return weTagsList.size();
	}
	public boolean isTagWithNameInList(String name) {
		List<WebElement> weTagsList = driver.findElements(By.xpath("//strong[text()='"+name+"']"));
		return weTagsList.size()>0;
	}	
	public List<WebElement> getTagWithNameList(String name){
		return driver.findElements(By.xpath("//strong[text()='"+name+"']"));
	}	
	
	public void userLogOut() {
		weUserIcon.click();
		WebElement weLogOut = driver.findElement(By.partialLinkText("Log Out"));
		weLogOut.click();
	}
	
	
	private String getDeleteButtonLocator(String name) {
		return "//strong[text()='"+name+"']//ancestor::tr//td[5]//button";
	}	
	private String getUpdateButtonLocator(String name) {
		return "//strong[text()='"+name+"']//ancestor::tr//td[5]//a[2]";
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
