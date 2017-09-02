package checkgmail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.WebUtils;
import pageObject.EmailHomepage;
import pageObject.SignInPage;

public class GmailSignInTest {
	WebDriver driver;

	@Test
	public void gmailLoginShouldBeSuccessful() {
		System.setProperty("webdriver.gecko.driver", "D:\\software\\selenium-java-3.0.1\\geckodriver.exe");
		driver = new FirefoxDriver();
		// 1. Go to gmail website
		SignInPage signInPage = WebUtils.gotoSignInPage(driver);
		// 2. Click to gmail
		signInPage.accessGmailPage(driver);
		// 3. Input user name
		signInPage.fillInUsername(driver, "ngatran283@gmail.com");
		// 4. Click next
		signInPage.clickNextUser(driver);
		// 5. Input password
		SignInPage.fillInPassword(driver, "goosie283");
		// 6. Click passwordNext
		EmailHomepage emailHomepage = signInPage.clickNextPass(driver);
		// 7. verify Inbox
		Assert.assertTrue("Sign in successfully", emailHomepage.isElementExist(driver));
		// 8.Click profile Button
		signInPage = emailHomepage.signOut(driver);
	}

	@Test
	public void gmailSendAndReceiveTest() throws InterruptedException {
		// 1. Sign in
		System.setProperty("webdriver.gecko.driver", "D:\\software\\selenium-java-3.0.1\\geckodriver.exe");
		driver = new FirefoxDriver();
		// 1. Go to gmail website
		SignInPage signInPage = WebUtils.gotoSignInPage(driver);
		// 2. Click to gmail
		signInPage.accessGmailPage(driver);
		// 3. Input user name
		signInPage.fillInUsername(driver, "ngatran283@gmail.com");
		// 4. Click next
		signInPage.clickNextUser(driver);
		// 5. Input password
		SignInPage.fillInPassword(driver, "goosie283");
		// 6. Click passwordNext
		EmailHomepage emailHomepage = signInPage.clickNextPass(driver);
		// 7. verify Inbox
		Assert.assertTrue("Sign in successfully", driver.findElement(By.partialLinkText("Inbox")).isDisplayed());
		// Click Compose
		emailHomepage.createEmail(driver);
		// Fill in recipent
		emailHomepage.inputReceiver(driver, "ngatran283@gmail.com");
		// Fill in subject
		emailHomepage.inputSubject(driver, "Demo Email");
		// Fill in email body
		emailHomepage.inputEmailBody(driver, "Hello tester! good morning");
		// Click Send
		emailHomepage.sendEmail(driver);
		// Click Inbox
		emailHomepage.clickInbox(driver);
		// Click email
		emailHomepage.clickNewEmail(driver);
		// Verify the email subject and email body is correcct
		emailHomepage.assertTextEquals(driver, "subject should be the same","Demo Email");
		// 8. Sign Out
		signInPage = emailHomepage.signOut(driver);
	}

	@After
	public void cleanUpEn() {
		driver.quit();
	}
}
