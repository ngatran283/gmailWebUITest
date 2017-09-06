package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import Utils.WebUtils;

public class EmailHomepage {

	public SignInPage signOut(WebDriver driver) {
		// TODO Auto-generated method stub
		WebUtils.click(driver, By.xpath("//div[@aria-label='Account Information']/../div[1]"));
		// 9. click sign out button
		WebUtils.click(driver, By.id("gb_71"));
		return PageFactory.initElements(driver, SignInPage.class);
	}

	public void createEmail(WebDriver driver) {
		// TODO Auto-generated method stub
		WebUtils.click(driver, By.xpath("//*[@id=':if']/div/div"));
		WebUtils.wait(driver, By.xpath("//div/textarea[@name='to']"));
	}

	public void inputReceiver(WebDriver driver, String recipent) {
		// TODO Auto-generated method stub
		WebUtils.sendKeys(driver, By.xpath("//div/textarea[@name='to']"), recipent);
	}

	public void inputSubject(WebDriver driver, String subj) {
		// TODO Auto-generated method stub
		WebUtils.sendKeys(driver, By.cssSelector("input[name='subjectbox']"), subj);
	}

	public void inputEmailBody(WebDriver driver, String content) {
		// TODO Auto-generated method stub
		WebUtils.sendKeys(driver, By.xpath("//div[contains(@aria-label,'Body')]"), content);
	}

	public void sendEmail(WebDriver driver) {
		// TODO Auto-generated method stub
		WebUtils.click(driver, By.xpath("//div[contains(@aria-label,'Ctrl-Enter')]"));
		WebUtils.wait(driver, By.linkText("Inbox (812)"));
	}

	public void clickInbox(WebDriver driver) {
		// TODO Auto-generated method stub
		WebUtils.click(driver, By.partialLinkText("Inbox"));
	}

	public EmailViewPage clickNewEmail(WebDriver driver) {
		// TODO Auto-generated method stub
		WebUtils.click(driver, By.xpath("//tr[1]//td[6]"));
		WebUtils.wait(driver, By.cssSelector("h2[class='hP']"));
		return PageFactory.initElements(driver, EmailViewPage.class);
	}

	public boolean isElementExist(WebDriver driver) {
		// TODO Auto-generated method stub
		return driver.findElement(By.partialLinkText("Inbox")).isDisplayed();
	}

}
