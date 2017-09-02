package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {

	public void fillInUsername(WebDriver driver, String user) {
		// TODO Auto-generated method stub
		WebElement username = driver.findElement(By.id("identifierId"));
		username.clear();
		username.sendKeys(user);
	}

	public static void fillInPassword(WebDriver driver, String pw) {
		// TODO Auto-generated method stub
		WebElement password = driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input"));
		password.clear();
		password.sendKeys(pw);
	}

	public void accessGmailPage(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
		gmailLink.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
	}

	public void clickNextUser(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement nextUser = driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span"));
		nextUser.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")));
	}

	public EmailHomepage clickNextPass(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement nextPass = driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span"));
		nextPass.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
		return PageFactory.initElements(driver, EmailHomepage.class);	
	}

	

	
	

}
