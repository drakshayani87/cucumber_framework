package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	        features=".\\src\\test\\resources\\feature\\abc.feature",
			glue="stepdefinitions",
			
			plugin= {"pretty","html:target/cucumber-roports"},
			monochrome=true
			
)

public class RunTestNGtest extends AbstractTestNGCucumberTests {

}