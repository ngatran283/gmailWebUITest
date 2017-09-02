package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.SignInPage;

public class WebUtils {

	public static SignInPage gotoSignInPage(WebDriver driver) {
		// TODO Auto-generated method stub
		driver.navigate().to("https://www.google.com.vn/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Gmail")));
		return PageFactory.initElements(driver, SignInPage.class);
	}

	
}
