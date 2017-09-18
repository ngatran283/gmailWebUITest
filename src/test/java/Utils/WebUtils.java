package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import pageObject.SignInPage;

public class WebUtils {

	public static int WAIT_TIME_OUT = 30;
	public static SignInPage gotoSignInPage(WebDriver driver) {
		// TODO Auto-generated method stub
		driver.navigate().to("https://www.google.com.vn/");
		WebUtils.wait(driver, By.linkText("Gmail"));
		return PageFactory.initElements(driver, SignInPage.class);
	}

	public static void sendKeys(WebDriver driver, By by, String string) {
		// TODO Auto-generated method stub
		WebElement element = driver.findElement(by);
		element.clear();
		element.sendKeys(string);
	}

	public static void click(WebDriver driver, By by) {
		// TODO Auto-generated method stub
		WebElement element = driver.findElement(by);
		element.click();
	}

	public static void wait(WebDriver driver, By by) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME_OUT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static void implicitWait(WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME_OUT);
	}
	
	public static String getTextElement(WebDriver driver, By by) {
		// TODO Auto-generated method stub
		return driver.findElement(by).getText();
	}

	public static WebDriver openBrowser() {
		System.setProperty("webdriver.gecko.driver", "D:\\software\\selenium-java-3.0.1\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	public static void selectFile(String path) throws FindFailed {
		// TODO Auto-generated method stub
		Screen screen = new Screen();
		Pattern img_loc = new Pattern("C:\\Users\\bubbl\\Desktop\\loc.png");
		Pattern img_open = new Pattern("C:\\Users\\bubbl\\Desktop\\open.png");
		screen.wait(img_loc,10);
		screen.type(img_loc, path);
		screen.click(img_open);
		
	}

}
