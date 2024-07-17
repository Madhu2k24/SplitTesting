package Step_Def;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;

import PageObjects.ChildPageObject;
import PageObjects.ParentPageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Split_StepDef {

	WebDriver driver;
    ParentPageObject parentPage;
    ChildPageObject childPage;

	@Given("User is on A\\/B Test variation page")
	public void user_is_on_a_b_test_variation_page() {
		
		EdgeOptions option=new EdgeOptions();
		option.addArguments("--guest");
		driver = new EdgeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/abtest");
	}

	@When("User clicks on Elemental Selenium link")
	public void user_clicks_on_elemental_selenium_link() {

		parentPage=new ParentPageObject(driver);
		parentPage.ClickOnElementalSelenium();
	}

	@Then("User should navigate to Elemental Selenium page")
	public void user_should_navigate_to_elemental_selenium_page() {
		
		childPage=new ChildPageObject(driver);
		childPage.moveToChildwindow();
	}

	@Then("User fills {string} and select the language")
	public void user_fills_and_select_the_language(String email)  {

		childPage.EnterEmail(email);
		WebElement option = childPage.ChooseLanguage();
		Select sc = new Select(option);
		sc.selectByVisibleText("Java");

	}

	@And("Clicks on Send me Test Auotomation Pro tip button")
	public void clicks_on_send_me_test_auotomation_pro_tip_button() {

		childPage.ClickOnAutomationProTips();
	}
	
	@And("Close the browser")
	public void close_the_browser() {
		//driver.quit();

	}


}
