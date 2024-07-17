package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ParentPageObject {

	WebDriver driver;

	By Elemental_Selenium = By.xpath("//a[text()='Elemental Selenium']");

	public ParentPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void ClickOnElementalSelenium() {
		driver.findElement(Elemental_Selenium).click();
	}

}
