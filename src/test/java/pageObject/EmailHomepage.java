package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import Utils.WebUtils;

public class EmailHomepage {

	public SignInPage signOut(WebDriver driver) {
		// TODO Auto-generated method stub
		WebUtils.click(driver, By.cssSelector("span[class='gb_7a gbii']"));
		// 9. click sign out button
		WebUtils.click(driver, By.id("gb_71"));
		return PageFactory.initElements(driver, SignInPage.class);
	}

	public void createEmail(WebDriver driver) {
		// TODO Auto-generated method stub
		WebUtils.click(driver, By.xpath(".//*[@id=':if']/div/div"));
		WebUtils.wait(driver, By.cssSelector("textarea[name='to']"));
	}

	public void inputReceiver(WebDriver driver, String recipent) {
		// TODO Auto-generated method stub
		WebUtils.sendKeys(driver, By.cssSelector("textarea[name='to']"), recipent);
	}

	public void inputSubject(WebDriver driver, String subj) {
		// TODO Auto-generated method stub
		WebUtils.sendKeys(driver, By.cssSelector("input[name='subjectbox']"), subj);
	}

	public void inputEmailBody(WebDriver driver, String content) {
		// TODO Auto-generated method stub
		WebUtils.sendKeys(driver, By.cssSelector("div[class='Am Al editable LW-avf']"), content);
	}

	public void sendEmail(WebDriver driver) {
		// TODO Auto-generated method stub
		WebUtils.click(driver, By.cssSelector("div[class='T-I J-J5-Ji aoO T-I-atl L3']"));
		WebUtils.wait(driver, By.linkText("Inbox (807)"));
	}

	public void clickInbox(WebDriver driver) {
		// TODO Auto-generated method stub
		WebUtils.click(driver, By.partialLinkText("Inbox"));
	}

	public EmailViewPage clickNewEmail(WebDriver driver) {
		// TODO Auto-generated method stub
		WebUtils.click(driver, By.xpath("//tr[1]//td[@tabindex='-1']"));
		WebUtils.wait(driver, By.cssSelector("h2[class='hP']"));
		return PageFactory.initElements(driver, EmailViewPage.class);
	}

	public boolean isElementExist(WebDriver driver) {
		// TODO Auto-generated method stub
		return driver.findElement(By.partialLinkText("Inbox")).isDisplayed();
	}

}
