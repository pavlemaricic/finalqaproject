package projekat.webpages.post;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import projekat.main.URLConstant;
import projekat.main.Utils;

public class ListPostPage {

	private WebDriver driver;
	
	
	@FindBy(name = "title")
	private WebElement weSearchByPostTitle;
	@FindBy(xpath = "//span[text()='--Choose Author --']")
	private WebElement weSearchByPostAuthor;
	@FindBy(xpath = "//span[text()='--Choose Category --']")
	private WebElement weSearchByPostCategory;
	@FindBy(name = "important")
	private WebElement weSearchByPostImportantOptions;				
	@FindBy(name = "status")
	private WebElement weSearchByPostStatusOptions;					
	@FindBy(xpath = "//ul[@class='select2-selection__rendered']")
	private WebElement weSearchByPostWithTag;
	
	
	//ALL POSTS
	@FindBy(name = "entities-list-table_length")
	private WebElement weShowPostsEntries;					
	@FindBy(xpath = "//input[@type='search']")
	private WebElement weSearchAllPosts;				
	@FindBy(xpath = "//th[text()='#']")
	private WebElement weSortAllPostsByID;
	@FindBy(xpath = "//th[text()='Title']")
	private WebElement weSortPostsByTitle;
	@FindBy(xpath = "//th[text()='Author']")
	private WebElement weSortPostsByAuthor;
	@FindBy(xpath = "//th[text()='Category']")
	private WebElement weSortPostsByCategory;
	@FindBy(xpath = "//th[text()='Created At']")
	private WebElement sortPostsByCreatedAt;
	
	
	//ACTIONS
	@FindBy(xpath = "//button[@data-action='important']")
	private WebElement weAllPostsImportantPostOption;
	@FindBy(xpath = "//button[@data-action='unimportant']")
	private WebElement weAllPostsUnimportantPostOption;
	@FindBy(xpath = "//button[@data-action='disable']")
	private WebElement weAllPostsDisablePostOption;
	@FindBy(xpath = "//button[@data-action='enable']")
	private WebElement weAllPostsEnablePostOption;
	@FindBy(xpath = "//button[@data-action='delete']")
	private WebElement weAllPostsDeletePostOption;
	@FindBy(xpath = "//i[@class='fas fa-edit']/..")
	private WebElement weAllPostsEditPostOption;
	@FindBy(xpath = "//i[@class='fas fa-eye']")
	private WebElement weAllPostsSeePostOption;

	
	
	@FindBy(partialLinkText = "Add new Post")
	private WebElement weAddNewPost;
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


	public ListPostPage(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().window().maximize();
		this.driver.get(URLConstant.POSTS_LIST);
		
		PageFactory.initElements(driver, this);
	}

	public void openPage() {
		this.driver.get(URLConstant.POSTS_LIST);
	}
	
	
	
	//COUNT
	public int countPostWithTitle(String title) {
		List<WebElement> wePostsList = driver.findElements(By.xpath("//table/tbody/tr/td[contains(text(),'"+title+"')]"));
		return wePostsList.size();
	}
	public boolean isPostWithNameInList(String title) {
		List<WebElement> wePostsList = driver.findElements(By.xpath("//td[.='"+title+"']"));
		return wePostsList.size()>0;
	}
	public List<WebElement> getPostWithNameList(String title){
		return driver.findElements(By.xpath("//td[.='"+title+"']"));
	}
	
	
	
	//TITLESEARCH
	public void insertTitleToSearchPosts(String title) {
		weSearchByPostTitle.clear();
		weSearchByPostTitle.sendKeys(title);
	}
	
	
	
	//AUTHORSEARCH
	public void chooseAuthorToSearchPosts() {
		weSearchByPostAuthor.click();
		WebElement searchAuthor = driver.findElement(By.xpath("//option[.='Polaznik Kursa']"));
		Utils.scrollToElement(driver, searchAuthor);
		WebDriverWait waitAction = new WebDriverWait(driver, Duration.ofSeconds(3));
		waitAction.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[.='Polaznik Kursa']")));
		searchAuthor.click();
	}
	
	
	//CATEGORYSEARCH
	public void chooseCategoryToSearchPosts() {
		weSearchByPostCategory.click();
		WebElement searchCategory = driver.findElement(By.xpath("//option[text()='Default Post Category NE BRISATI']"));
		searchCategory.click();
		WebElement desiredElement = driver.findElement(By.name("important"));
		desiredElement.click(); 

	}
	
	//IMPORTANTSEARCH
	public void chooseNotToChooseImportantToSearchPosts() {
		weSearchByPostImportantOptions.click();
		WebElement desiredElement = driver.findElement(By.name("important"));
		desiredElement.click(); 	
		WebElement withoutImportant = driver.findElement(By.xpath("//option[text()='-- All --']"));
		withoutImportant.click();
	}
	public void chooseImportantYesToSearchPosts() {
		weSearchByPostImportantOptions.click();	
		WebElement desiredElement = driver.findElement(By.name("important"));
		desiredElement.click(); 
		WebElement importantYes = driver.findElement(By.xpath("//option[text()='yes']"));
		importantYes.click();
	}
	public void chooseImportantNoToSearchPosts() {
		weSearchByPostImportantOptions.click();	
		WebElement desiredElement = driver.findElement(By.name("important"));
		desiredElement.click();	
		WebElement importantNo = driver.findElement(By.xpath("//option[text()='no']"));
		importantNo.click();
	}

	
	
	public void chooseStatusEnabledToSearchPosts() {
		weSearchByPostImportantOptions.click();
		WebElement statusEnabled = driver.findElement(By.xpath("//option[text()='enabled']"));
		statusEnabled.click();
	}
	public void chooseStatusDisabledToSearchPosts() {
		weSearchByPostImportantOptions.click();
		WebElement statusDisabled = driver.findElement(By.xpath("//option[text()='disabled']"));
		statusDisabled.click();
	}
	
	
	
	//WITHTAGSEARCH
	public void chooseTagToSearchPosts() throws InterruptedException {
		weSearchByPostWithTag.click();
		WebElement searchWithTag = driver.findElement(By.xpath("//option[text()='Default TAG NE BRISATI']"));
		searchWithTag.click();
		searchWithTag.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}
	
	
	
	//UPDATE
	private String getUpdatePostButtonLocator(String update) {
		return "//td[text()='"+update+"']/../td[12]/div[1]/a[2]";
	}	
	public void updatePost(String update) {
		WebElement updateButton = driver.findElement(By.xpath(getUpdatePostButtonLocator(update)));
		Utils.scrollToElement(driver, updateButton);
		WebDriverWait waitAction = new WebDriverWait(driver, Duration.ofSeconds(3));
		waitAction.until(ExpectedConditions.elementToBeClickable(By.xpath(getUpdatePostButtonLocator(update))));
		updateButton.click();
	}	
	
	
	
	//DELETE
	private String getDeletePostButtonLocator(String delete) {
		return "//td[text()='"+delete+"']/../td[12]/div[1]/button";
	}	
	public void deletePost(String delete) {
		WebElement deleteButton = driver.findElement(By.xpath(getDeletePostButtonLocator(delete)));
		Utils.scrollToElement(driver, deleteButton);
		WebDriverWait waitAction = new WebDriverWait(driver, Duration.ofSeconds(3));
		waitAction.until(ExpectedConditions.elementToBeClickable(By.xpath(getDeletePostButtonLocator(delete))));
		deleteButton.click();
	}
	public void clickOnDeleteDialogDelete() {
		WebElement deleteDialogButton = driver.findElement(By.xpath("//button[.='Delete']"));
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {

		}
		deleteDialogButton.click();
	}
	public void clickOnDeleteDialogCancel() {
		WebElement cancelDialogButton = driver.findElement(By.xpath("//buton[text()='Cancel']"));
		cancelDialogButton.click();
	}
	
	
	
	//VIEW
	private String getViewPostButtonLocator(String view) {
		return "//td[text()='"+view+"']/../td[12]/div[1]/a[1]";
	}	
	public void viewPost(String view) {
		WebElement viewButton = driver.findElement(By.xpath(getViewPostButtonLocator(view)));
		Utils.scrollToElement(driver, viewButton);
		WebDriverWait waitAction = new WebDriverWait(driver, Duration.ofSeconds(3));
		waitAction.until(ExpectedConditions.elementToBeClickable(By.xpath(getViewPostButtonLocator(view))));
		viewButton.click();
	}
//		try {
//			Thread.sleep(1500);
//		} catch (InterruptedException e) {
//
//		}
	
	
	
	//DISABLEPOST
	private String getDisablePostButtonLocator(String disable) {
		return "//td[text()='"+disable+"']/../td[12]/div[2]/button[1]";
	}
	public void disablePost(String disable) {
		WebElement disableButton = driver.findElement(By.xpath(getDisablePostButtonLocator(disable)));
		Utils.scrollToElement(driver, disableButton);
		WebDriverWait waitAction = new WebDriverWait(driver, Duration.ofSeconds(3));
		waitAction.until(ExpectedConditions.elementToBeClickable(By.xpath(getDisablePostButtonLocator(disable))));
		disableButton.click();
	}
//		try {
//			Thread.sleep(1500);
//		} catch (InterruptedException e) {
//
//		}

	
	
	
	//ENABLEPOST
	private String getEnablePostButtonLocator(String enable) {
		return "//td[text()='"+enable+"']/../td[12]/div[2]/button[1]";
	}
	public void enablePost(String enable) {
		WebElement enableButton = driver.findElement(By.xpath(getEnablePostButtonLocator(enable)));
		Utils.scrollToElement(driver, enableButton);
		WebDriverWait waitAction = new WebDriverWait(driver, Duration.ofSeconds(3));
		waitAction.until(ExpectedConditions.elementToBeClickable(By.xpath(getEnablePostButtonLocator(enable))));
		enableButton.click();
	}
//		try {
//			Thread.sleep(1500);
//		} catch (InterruptedException e) {
//
//		}
	
	
	
	//IMPORTANTPOST
		private String setPostImportantButtonLocator(String important) {
			return "//td[text()='"+important+"']/../td[12]/div[2]/button[2]";
		}
		public void setPostImportant(String important) {
			WebElement importantButton = driver.findElement(By.xpath(setPostImportantButtonLocator(important)));
			Utils.scrollToElement(driver, importantButton);
			WebDriverWait waitAction = new WebDriverWait(driver, Duration.ofSeconds(3));
			waitAction.until(ExpectedConditions.elementToBeClickable(By.xpath(setPostImportantButtonLocator(important))));
			importantButton.click();
		}
//			try {
//				Thread.sleep(1500);
//			} catch (InterruptedException e) {
//	
//			}

		
		
	//UNIMPORTANTPOST
	private String setPostUnimportantButtonLocator(String unimportant) {
		return "//td[text()='"+unimportant+"']/../td[12]/div[2]/button[2]";
	}
	public void setPostUnimportant(String unimportant) {
		WebElement unimportantButton = driver.findElement(By.xpath(setPostUnimportantButtonLocator(unimportant)));
		Utils.scrollToElement(driver, unimportantButton);
		WebDriverWait waitAction = new WebDriverWait(driver, Duration.ofSeconds(3));
		waitAction.until(ExpectedConditions.elementToBeClickable(By.xpath(setPostUnimportantButtonLocator(unimportant))));
		unimportantButton.click();
	}
//			try {
//				Thread.sleep(1500);
//			} catch (InterruptedException e) {
//	
//			}

	
	
	public void choose10PostEntriesToSearchPosts() {
		weShowPostsEntries.click();
		WebElement we10postEntries = driver.findElement(By.xpath("//option[text()='10']"));
		we10postEntries.click();
	}
	public void choose25PostEntriesToSearchPosts() {
		weShowPostsEntries.click();
		WebElement we25postEntries = driver.findElement(By.xpath("//option[text()='25']"));
		we25postEntries.click();
	}
	public void choose50PostEntriesToSearchPosts() {
		weShowPostsEntries.click();
		WebElement we50postEntries = driver.findElement(By.xpath("//option[text()='50']"));
		we50postEntries.click();
	}
	public void choose100PostEntriesToSearchPosts() {
		weShowPostsEntries.click();
		WebElement we100postEntries = driver.findElement(By.xpath("//option[text()='100']"));
		we100postEntries.click();
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
	
	
	
	public void clickOnHomeButton() {
		weHomeButton.click();
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
}
