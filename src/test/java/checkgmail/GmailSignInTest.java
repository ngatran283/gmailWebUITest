package checkgmail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailSignInTest {
	WebDriver driver;

	@Test
	public void gmailLoginShouldBeSuccessful() {
		// Go to gmail website
		System.setProperty("webdriver.gecko.driver", "D:\\software\\selenium-java-3.0.1\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to("https://www.google.com.vn/");
		;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait
		// Click to gmail
		WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
		gmailLink.click();
		// Input user name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
		WebElement username = driver.findElement(By.id("identifierId"));
		username.clear();
		username.sendKeys("ngatran283@gmail.com");
		// Click next
		WebElement nextUser = driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span"));
		nextUser.click();
		// wait
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")));
		// Input password
		WebElement password = driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input"));
		password.clear();
		password.sendKeys("goosie283");
		// Click passwordNext
		WebElement nextPass = driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span"));
		nextPass.click();

		// verify Inbox
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
		Assert.assertTrue("Sign in successfully", driver.findElement(By.partialLinkText("Inbox")).isDisplayed());
		
		// profile Button
		WebElement profileBttn = driver.findElement(By.cssSelector("span[class='gb_7a gbii']"));
		profileBttn.click();
		// click sign out button
		WebElement signoutBttn = driver.findElement(By.id("gb_71"));
		signoutBttn.click();
		
		
	}

	@After
	public void cleanUpEn() {
		driver.quit();
	}
}
