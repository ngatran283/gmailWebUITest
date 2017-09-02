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
		// 1. Go to gmail website
		System.setProperty("webdriver.gecko.driver", "D:\\software\\selenium-java-3.0.1\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to("https://www.google.com.vn/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// 2. Click to gmail
		WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
		gmailLink.click();
		// 3. Input user name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
		WebElement username = driver.findElement(By.id("identifierId"));
		username.clear();
		username.sendKeys("ngatran283@gmail.com");
		// 4. Click next
		WebElement nextUser = driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span"));
		nextUser.click();
		// 5. Input password
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")));
		WebElement password = driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input"));
		password.clear();
		password.sendKeys("goosie283");
		// 6. Click passwordNext
		WebElement nextPass = driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span"));
		nextPass.click();

		// 7. verify Inbox
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
		Assert.assertTrue("Sign in successfully", driver.findElement(By.partialLinkText("Inbox")).isDisplayed());

		// 8.Click profile Button
		WebElement profileBttn = driver.findElement(By.cssSelector("span[class='gb_7a gbii']"));
		profileBttn.click();
		// 9. click sign out button
		WebElement signoutBttn = driver.findElement(By.id("gb_71"));
		signoutBttn.click();

	}

	@Test
	public void gmailSendAndReceiveTest() throws InterruptedException {
		// 1. Sign in
		// 1. Go to gmail website
		System.setProperty("webdriver.gecko.driver", "D:\\software\\selenium-java-3.0.1\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to("https://www.google.com.vn/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// 2. Click to gmail
		WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
		gmailLink.click();
		// 3. Input user name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
		WebElement username = driver.findElement(By.id("identifierId"));
		username.clear();
		username.sendKeys("ngatran283@gmail.com");
		// 4. Click next
		WebElement nextUser = driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span"));
		nextUser.click();
		// 5. Input password
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")));
		WebElement password = driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input"));
		password.clear();
		password.sendKeys("goosie283");
		// 6. Click passwordNext
		WebElement nextPass = driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span"));
		nextPass.click();
		// 7. verify Inbox
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
		Assert.assertTrue("Sign in successfully", driver.findElement(By.partialLinkText("Inbox")).isDisplayed());
		// Click Compose
		WebElement compose = driver.findElement(By.xpath(".//*[@id=':if']/div/div"));
		compose.click();
		// Fill in recipent
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[name='to']")));
		WebElement toText = driver.findElement(By.cssSelector("textarea[name='to']"));
		toText.clear();
		toText.sendKeys("ngatran283@gmail.com");
		// Fill in subject
		WebElement subject = driver.findElement(By.cssSelector("input[name='subjectbox']"));
		subject.click();
		subject.clear();
		subject.sendKeys("Demo Email");
		// Fill in email body
		WebElement body = driver.findElement(By.cssSelector("div[class='Am Al editable LW-avf']"));
		body.clear();
		body.sendKeys("Hello tester! good morning");
		// Click Send
		WebElement sendBttn = driver.findElement(By.cssSelector("div[class='T-I J-J5-Ji aoO T-I-atl L3']"));
		sendBttn.click();
		// Click Inbox again
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Inbox (806)")));
		WebElement inbox = driver.findElement(By.partialLinkText("Inbox"));
		inbox.click();
		// Click email
		WebElement newEmail = driver.findElement(By.xpath("//tr[1]//td[@tabindex='-1']"));
		newEmail.click();
		// Verify the email subject and email body is correcct
		WebElement subjectArea = driver.findElement(By.cssSelector("h2[class='hP']"));
		Assert.assertEquals("subject should be the same", "Demo Email", subjectArea.getText());
		WebElement bodyText = driver.findElement(By.cssSelector("div[class='a3s aXjCH m15e4250a23bf69d0']>div[dir='ltr']"));
		Assert.assertEquals("body should be the some", "Hello tester! good morning", bodyText.getText());
		// 8.Click profile Button
		WebElement profileBttn = driver.findElement(By.cssSelector("span[class='gb_7a gbii']"));
		profileBttn.click();
		// Sign out
		WebElement signoutBttn = driver.findElement(By.id("gb_71"));
		signoutBttn.click();
	}

	@After
	public void cleanUpEn() {
		driver.quit();
	}
}
