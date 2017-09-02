package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.WebUtils;

public class EmailViewPage {

	public String getEmailText(WebDriver driver) {
		return WebUtils.getTextElement(driver, By.cssSelector("h2[class='hP']"));
	}

}
