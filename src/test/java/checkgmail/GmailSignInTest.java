package checkgmail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Utils.WebUtils;
import categories.Critical;
import categories.Major;
import categories.Minor;
import pageObject.EmailHomepage;
import pageObject.EmailViewPage;
import pageObject.SignInPage;

public class GmailSignInTest {

	WebDriver driver;

	@Before
	public void init() {
		driver = WebUtils.openBrowser();
	}

	@Category({ Critical.class })
	@Test
	public void gmailLoginShouldBeSuccessful() {
		// 1. Go to gmail website
		SignInPage signInPage = WebUtils.gotoSignInPage(driver);
		// 2. Click to gmail
		signInPage.accessGmailPage(driver);
		// 3. Input user name
		signInPage.fillInUsername(driver, "selenium655@gmail.com");
		// 4. Click next
		signInPage.clickNextUser(driver);
		// 5. Input password
		SignInPage.fillInPassword(driver, "nga123456789");
		// 6. Click passwordNext
		EmailHomepage emailHomepage = signInPage.clickNextPass(driver);
		// 7. verify Inbox
		Assert.assertTrue("Sign in successfully", emailHomepage.isElementExist(driver));
		// 8.Click profile Button
		signInPage = emailHomepage.signOut(driver);
	}

	@Category({ Major.class })
	@Test
	public void gmailSendAndReceiveTest() throws InterruptedException {
		// 1. Go to gmail website
		SignInPage signInPage = WebUtils.gotoSignInPage(driver);
		// 2. Click to gmail
		signInPage.accessGmailPage(driver);
		// 3. Input user name
		signInPage.fillInUsername(driver, "selenium655@gmail.com");
		// 4. Click next
		signInPage.clickNextUser(driver);
		// 5. Input password
		SignInPage.fillInPassword(driver, "nga123456789");
		// 6. Click passwordNext
		EmailHomepage emailHomepage = signInPage.clickNextPass(driver);
		// 7. verify Inbox
		Assert.assertTrue("Sign in successfully", driver.findElement(By.partialLinkText("Inbox")).isDisplayed());
		// Click Compose
		emailHomepage.createEmail(driver);
		// Fill in recipent
		emailHomepage.inputReceiver(driver, "selenium655@gmail.com");
		// Fill in subject
		emailHomepage.inputSubject(driver, "Demo Email");
		// Fill in email body
		emailHomepage.inputEmailBody(driver, "Hello tester! good morning");
		// Click Send
		emailHomepage.sendEmail(driver);
		// Click Inbox
		emailHomepage.clickInbox(driver);
		// Click email
		EmailViewPage emailViewPage = emailHomepage.clickNewEmail(driver);
		// Verify the email subject and email body is correct
		String actualSubject = emailViewPage.getEmailText(driver);
		Assert.assertEquals("Succeed!", "Demo Email", actualSubject);
		// 8. Sign Out
		signInPage = emailHomepage.signOut(driver);
	}

	@Category({ Major.class })
	@Test
	public void gmailSendAttachedFileAndReceiveTest() throws InterruptedException {
		// 1. Go to gmail website
		SignInPage signInPage = WebUtils.gotoSignInPage(driver);
		// 2. Click to gmail
		signInPage.accessGmailPage(driver);
		// 3. Input user name
		signInPage.fillInUsername(driver, "selenium655@gmail.com");
		// 4. Click next
		signInPage.clickNextUser(driver);
		// 5. Input password
		SignInPage.fillInPassword(driver, "nga123456789");
		// 6. Click passwordNext
		EmailHomepage emailHomepage = signInPage.clickNextPass(driver);
		// 7. verify Inbox
		Assert.assertTrue("Sign in successfully", driver.findElement(By.partialLinkText("Inbox")).isDisplayed());
		// Click Compose
		emailHomepage.createEmail(driver);
		// Fill in recipent
		emailHomepage.inputReceiver(driver, "selenium655@gmail.com");
		// Fill in subject
		emailHomepage.inputSubject(driver, "Demo Email");
		// Fill in email body
		emailHomepage.inputEmailBody(driver, "Hello tester! good morning");
		// Attach file
		emailHomepage.attachFile(driver);
		// Click Send
		emailHomepage.sendEmail(driver);
		// Click Inbox
		emailHomepage.clickInbox(driver);
		// Click email
		EmailViewPage emailViewPage = emailHomepage.clickNewEmail(driver);
		// Verify the email subject and email body is correct
		String actualSubject = emailViewPage.getEmailText(driver);
		Assert.assertEquals("Succeed!", "Demo Email", actualSubject);
		// 8. Sign Out
		signInPage = emailHomepage.signOut(driver);
	}

	@Category({ Major.class })
	@Test
	public void saveDraftEmailAutomatically() throws InterruptedException {
		// 1. Go to gmail website
		SignInPage signInPage = WebUtils.gotoSignInPage(driver);
		// 2. Click to gmail
		signInPage.accessGmailPage(driver);
		// 3. Input user name
		signInPage.fillInUsername(driver, "selenium655@gmail.com");
		// 4. Click next
		signInPage.clickNextUser(driver);
		// 5. Input password
		SignInPage.fillInPassword(driver, "nga123456789");
		// 6. Click passwordNext
		EmailHomepage emailHomepage = signInPage.clickNextPass(driver);
		// 7. verify Inbox
		Assert.assertTrue("Sign in successfully", driver.findElement(By.partialLinkText("Inbox")).isDisplayed());
		// Click Compose
		emailHomepage.createEmail(driver);
		// Fill in recipent
		emailHomepage.inputReceiver(driver, "selenium655@gmail.com");
		// Fill in subject
		emailHomepage.inputSubject(driver, "Demo Email");
		// Fill in email body
		emailHomepage.inputEmailBody(driver, "Hello tester! good morning");
		// Close email
		emailHomepage.clickCloseEmail(driver);
		// Click Draft
		emailHomepage.clickDraft(driver);
		// Click email
		EmailViewPage emailViewPage = emailHomepage.clickNewEmail(driver);
		// Verify
		String actualSubject = emailViewPage.getEmailText(driver);
		Assert.assertEquals("Succeed!", "Demo Email", actualSubject);
		// 8. Sign Out
		signInPage = emailHomepage.signOut(driver);

	}

	@Category({ Minor.class })
	@Test
	public void deleteEmail() throws InterruptedException {
		// 1. Go to gmail website
		SignInPage signInPage = WebUtils.gotoSignInPage(driver);
		// 2. Click to gmail
		signInPage.accessGmailPage(driver);
		// 3. Input user name
		signInPage.fillInUsername(driver, "selenium655@gmail.com");
		// 4. Click next
		signInPage.clickNextUser(driver);
		// 5. Input password
		SignInPage.fillInPassword(driver, "nga123456789");
		// 6. Click passwordNext
		EmailHomepage emailHomepage = signInPage.clickNextPass(driver);
		// 7. verify Inbox
		Assert.assertTrue("Sign in successfully", driver.findElement(By.partialLinkText("Inbox")).isDisplayed());
		// Click Email checkbox
		emailHomepage.clickEmailCheckBox(driver);
		// delete email
		emailHomepage.deleteEmail(driver);
		Assert.assertTrue("Delete successfully!", driver.findElement(By.linkText("Learn more")).isDisplayed());
		String actual = emailHomepage.getMessage(driver);
		Assert.assertEquals("success", "The conversation has been moved to the Trash.", actual);
		signInPage = emailHomepage.signOut(driver);


	}
	@After
	public void cleanUpEn() {
		driver.quit();
	}
}
