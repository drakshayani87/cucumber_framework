package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Given.Givens;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Hrmlog {
	WebDriver driver;
	
	@Given("using hrm url in any browser") 
	public void tc_01() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(" https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
	}

	@When("user type invalid Username and Password")
	public void tc_02() {
		driver.findElement(By.name("username")).sendKeys("selenium");
		driver.findElement(By.name("password")).sendKeys("atomation");

	}

	@And("click on login button")
	public void tc_03() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	}

	@Then("verify the error message")
	public void tc_04() {
		if (driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p"))
				.size() > 0) {
			System.out.println("Error mesage is displayed on screen");
		} else {
			System.out.println("Error mesage is not displayed on screen");
		}
	}

	@When("user type valid Username and Password")
	public void tc_05() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
	}

	@When("^user type \"([^\"]*)\" and \"([^\"]*)\"$")

	public void multipletestdata(String un, String pwd) throws Exception {
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pwd);

	}
}
