package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features={"src/test/resources/Features"},
glue={"Step_Def"},
tags=" @Regression",
plugin= {"pretty","html:target/htmlreport.html"})

public class TestRunner extends AbstractTestNGCucumberTests {

	
	
}
