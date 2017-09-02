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
		WebUtils.sendKeys(driver, By.xpath(".//*[@id='password']/div[1]/div/div[1]/input"), pw);
	}

	public void accessGmailPage(WebDriver driver) {
		// TODO Auto-generated method stub
		WebUtils.click(driver, By.linkText("Gmail"));
		WebUtils.wait(driver, By.id("identifierId"));
	}

	public void clickNextUser(WebDriver driver) {
		// TODO Auto-generated method stub
		WebUtils.click(driver, By.xpath(".//*[@id='identifierNext']/content/span"));
		WebUtils.wait(driver, By.xpath(".//*[@id='password']/div[1]/div/div[1]/input"));
	}

	public EmailHomepage clickNextPass(WebDriver driver) {
		// TODO Auto-generated method stub
		WebUtils.click(driver, By.xpath(".//*[@id='passwordNext']/content/span"));
		WebUtils.wait(driver, By.partialLinkText("Inbox"));
		return PageFactory.initElements(driver, EmailHomepage.class);
	}

}
