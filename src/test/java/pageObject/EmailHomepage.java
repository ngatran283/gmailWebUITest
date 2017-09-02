package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailHomepage {

	public SignInPage signOut(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement profileBttn = driver.findElement(By.cssSelector("span[class='gb_7a gbii']"));
		profileBttn.click();
		// 9. click sign out button
		WebElement signoutBttn = driver.findElement(By.id("gb_71"));
		signoutBttn.click();
		return PageFactory.initElements(driver, SignInPage.class);
	}

	public void createEmail(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement compose = driver.findElement(By.xpath(".//*[@id=':if']/div/div"));
		compose.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[name='to']")));
	}

	public void inputReceiver(WebDriver driver, String recipent) {
		// TODO Auto-generated method stub
		WebElement toText = driver.findElement(By.cssSelector("textarea[name='to']"));
		toText.clear();
		toText.sendKeys(recipent);

	}

	public void inputSubject(WebDriver driver, String subj) {
		// TODO Auto-generated method stub
		WebElement subject = driver.findElement(By.cssSelector("input[name='subjectbox']"));
		subject.click();
		subject.clear();
		subject.sendKeys(subj);

	}

	public void inputEmailBody(WebDriver driver, String content) {
		// TODO Auto-generated method stub
		WebElement body = driver.findElement(By.cssSelector("div[class='Am Al editable LW-avf']"));
		body.clear();
		body.sendKeys(content);
	}

	public void sendEmail(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement sendBttn = driver.findElement(By.cssSelector("div[class='T-I J-J5-Ji aoO T-I-atl L3']"));
		sendBttn.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Inbox (807)")));
	}

	public void clickInbox(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement inbox = driver.findElement(By.partialLinkText("Inbox"));
		inbox.click();
	}

	public void clickNewEmail(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement newEmail = driver.findElement(By.xpath("//tr[1]//td[@tabindex='-1']"));
		newEmail.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2[class='hP']")));
	}

	public boolean isElementExist(WebDriver driver) {
		// TODO Auto-generated method stub
		return driver.findElement(By.partialLinkText("Inbox")).isDisplayed();
	}

	public void assertTextEquals(WebDriver driver, String message, String expect) {
		// TODO Auto-generated method stub
		WebElement subjectArea = driver.findElement(By.cssSelector("h2[class='hP']"));
		Assert.assertEquals(message, expect , subjectArea.getText());
		
	}

}
