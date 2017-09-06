package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Utils.WebUtils;

public class SignInPage {

	public void fillInUsername(WebDriver driver, String user) {
		// TODO Auto-generated method stub
		WebUtils.sendKeys(driver, By.id("identifierId"), user);
	}

	public static void fillInPassword(WebDriver driver, String pw) {
		// TODO Auto-generated method stub
		WebUtils.sendKeys(driver, By.xpath("//input[@type='password']"), pw);
	}

	public void accessGmailPage(WebDriver driver) {
		// TODO Auto-generated method stub
		WebUtils.click(driver, By.linkText("Gmail"));
		WebUtils.wait(driver, By.id("identifierId"));
	}

	public void clickNextUser(WebDriver driver) {
		// TODO Auto-generated method stub
		WebUtils.click(driver, By.xpath(".//*[@id='identifierNext']"));
		WebUtils.wait(driver, By.xpath("//input[@type='password']"));
	}

	public EmailHomepage clickNextPass(WebDriver driver) {
		// TODO Auto-generated method stub
		WebUtils.click(driver, By.id("passwordNext"));
		WebUtils.wait(driver, By.partialLinkText("Inbox"));
		return PageFactory.initElements(driver, EmailHomepage.class);
	}

}
