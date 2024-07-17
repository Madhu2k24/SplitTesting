package Step_Def;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoPage_StepDef {

	WebDriver driver;

	@Given("User is on DemoPage")
	public void user_is_on_demo_page() {
		EdgeOptions option = new EdgeOptions();
		option.addArguments("--guest");
		driver = new EdgeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://seleniumbase.io/demo_page/");
	}

	@When("USer enter Text in Text input field and Text Area")
	public void u_ser_enter_text_in_text_input_field_and_text_area() {

		driver.findElement(By.cssSelector("input[id='myTextInput']")).sendKeys("Madhu");
	}

	@SuppressWarnings("unlikely-arg-type")
	@And("User verify if Pre-Filled Text Field has the text or not")
	public void user_verify_if_pre_filled_text_field_has_the_text_or_not() {

		WebElement Text = driver.findElement(By.cssSelector("input[id='myTextInput2']"));
		if (Text.equals("Text...")) {
			String GetText = Text.getText();
			System.out.println(GetText);
		}
	}

	@Then("User clicks on button")
	public void user_clicks_on_button() {

		driver.findElement(By.cssSelector("button[id='myButton']")).click();
	}

	@And("User clicks on Placeholder text field")
	public void user_clicks_on_placeholder_text_field() {

		driver.findElement(By.cssSelector("input[id='placeholderText']")).sendKeys("Hie");
	}

	@And("User read the test from Read only Text filled")
	public void user_read_the_test_from_read_only_text_filled() {

		String Read = driver.findElement(By.cssSelector("input[id='readOnlyText']")).getText();
		System.out.println(Read);
	}

	@Then("user clicks on HTML SVG with rect")
	public void user_clicks_on_html_svg_with_rect() {

		driver.findElement(By.cssSelector("rect[id='svgRect']")).getRect();
	}

	@And("user slides the Input Slider Control")
	public void user_slides_the_input_slider_control() {
		Actions a = new Actions(driver);
		WebElement slide = driver.findElement(By.cssSelector("input[type='range']"));
		a.moveToElement(slide, 50, 90);
	}

	@Then("User select option from Select dropdown")
	public void user_select_option_from_select_dropdown() {

		WebElement selct = driver.findElement(By.cssSelector("select[id='mySelect']"));
		Select sc = new Select(selct);
		sc.selectByIndex(3);
		System.out.println(sc.getFirstSelectedOption());

	}

	@And("user verfiy the i-frame text")
	public void user_verfiy_the_i_frame_text() throws InterruptedException {

		try {
			WebElement frame = driver.findElement(By.xpath("//iframe[@id='myFrame2']"));
			driver.switchTo().frame(frame);
			System.out.println(frame.getText());
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}

	}

	@And("user clicks and checks radio button and checkBox")
	public void user_clicks_and_checks_radio_button_and_check_box() {

		driver.findElement(By.xpath("//input[@id='radioButton2']")).click();
		driver.findElement(By.xpath("//input[@id='radioButton2']")).isSelected();

	}

	@Then("user clicks on CheckBox in iFrame")
	public void user_clicks_on_check_box_in_i_frame() {
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='myFrame3']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//input[@id='checkBox6']")).click();

	}

	@Then("User select from Mouse over dropdown")
	public void user_select_from_mouse_over_dropdown() throws InterruptedException {
		Thread.sleep(1000);
		try {
			Actions action = new Actions(driver);
			WebElement mouseOver = driver.findElement(By.xpath("//div/div[text()='Hover Dropdown']"));
			action.moveToElement(mouseOver);
			Select sc = new Select(mouseOver);
			sc.selectByIndex(3);
		} catch (Exception e) {
			System.out.println("Exception caught: " + e.getMessage());
		}

	}

	@Then("user clicks on URL Link and verify the page")
	public void user_clicks_on_url_link_and_verify_the_page() throws InterruptedException {

		Thread.sleep(1000);
		try {
			driver.findElement(By.xpath("//a[@id='myLink1']")).click();
			Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='SeleniumBase']")), "SeleniumBase");

		} catch (Exception e) {
			System.out.println("Exception caught: " + e.getMessage());

		}

	}
}
