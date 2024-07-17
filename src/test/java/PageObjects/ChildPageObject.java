package PageObjects;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChildPageObject {

	WebDriver driver;

	public ChildPageObject(WebDriver driver) {
		this.driver = driver;
	}

	By EnterEmail = By.xpath("//input[@placeholder='Type in your email address']");
	By options = By.id("options");
	By ClickOnProtips = By.cssSelector("input[value='Send me test automation Pro tips']");

	public void EnterEmail(String email) {
		driver.findElement(EnterEmail).sendKeys(email);
	}

	public WebElement ChooseLanguage() {
		return driver.findElement(options);
	}

	public void ClickOnAutomationProTips() {
		driver.findElement(ClickOnProtips).click();
	}

	public void moveToChildwindow() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String ChildWindow = it.next();
		driver.switchTo().window(ChildWindow);
		if (ChildWindow.contentEquals("Elemental Selenium")) {
			Assert.assertTrue(true);
			System.out.println("correct page");
		}

	}

}
