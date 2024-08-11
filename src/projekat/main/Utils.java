package projekat.main;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {

	
	
	//TAG	
	public static int getRandomTagNumber() {
		Random random = new Random();
		return random.nextInt(10000);
	}
	public static String getRandomTagName() {
		return "TagName "+getRandomTagNumber();
	}
	
	
	
	//POSTCATEGORY
	public static int getRandomPostCategoryNumber() {
		Random random = new Random();
		return random.nextInt(10000);
	}
	public static String getRandomPostCategoryName() {
		return "PostCategoryName #"+getRandomPostCategoryNumber();
	}	
	public static String getRandomPostCategoryDescription() {
        Random random = new Random();
        int length = random.nextInt(245) + 255; 
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = (char) (random.nextInt(26) + 'a'); 
        }
        return new String(chars);
    }
	
	
	
	//POST
	public static String getRandomPostTitle() {
        Random random = new Random();
        int length = random.nextInt(22) + 20; 
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = (char) (random.nextInt(26) + 'a'); 
        }
        return new String(chars);
    }
	public static String getRandomPostDescription() {
        Random random = new Random();
        int length = random.nextInt(450) + 50; 
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = (char) (random.nextInt(26) + 'a'); 
        }
        return new String(chars);
    }
	public static String getRandomPostContent() {
        Random random = new Random();
        int length = random.nextInt(1000) + 1; 
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = (char) (random.nextInt(26) + 'a'); 
        }
        return new String(chars);
    }
	
	
	
	//SCROLL
	public static void scrollToElement(WebDriver driver, WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public static void scrollToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
