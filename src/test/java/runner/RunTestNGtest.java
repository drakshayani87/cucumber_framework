package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	        features=".\\src\\test\\resources\\feature\\apple_Createaccount.feature",
			glue="stepdefinitions",
			tags=" @tag5", 
			plugin= {"pretty","html:target/cucumber-roports"},
			monochrome=true
			
)

public class RunTestNGtest extends AbstractTestNGCucumberTests {

}