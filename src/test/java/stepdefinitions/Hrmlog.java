package stepdefinitions;

import java.sql.Driver;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Given.Givens;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Hrmlog {
	WebDriver driver;

	// tag1
	@Given("using hrm url in any browser")
	public void tc_01() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(" https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
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

	@Given("using apv url in any browser")
	public void tc_06() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.applevacations.com/#!/");
		driver.findElement(By.linkText("My Account")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.findElement(By.linkText("Sign Up")).click();
		// Thread.sleep(5000);
	}

	@When("user type invalid data1")
	public void tc_07() throws Exception {
		driver.findElement(By.name("ctl01$ContentPlaceHolder$account$txtEmail")).sendKeys("test1234@gmail.com");
		driver.findElement(By.name("ctl01$ContentPlaceHolder$account$txtPhone")).sendKeys("9866931896");
		driver.findElement(By.name("ctl01$ContentPlaceHolder$account$txtPassword")).sendKeys("Test@1234");
		driver.findElement(By.name("ctl01$ContentPlaceHolder$account$ConfirmPassword")).sendKeys("Test@1234");
		driver.findElement(By.name("ctl01$ContentPlaceHolder$account$txtFirstName")).sendKeys("priya");
		driver.findElement(By.name("ctl01$ContentPlaceHolder$account$txtLastName")).sendKeys("boya");
		driver.findElement(By.name("ctl01$ContentPlaceHolder$account$txtAddress1")).sendKeys("guntakal");
		driver.findElement(By.name("ctl01$ContentPlaceHolder$account$txtApartmentNumber")).sendKeys("212");
		driver.findElement(By.name("ctl01$ContentPlaceHolder$account$txtCity")).sendKeys("guntakal");
		new Select(driver.findElement(By.name("ctl01$ContentPlaceHolder$account$txtState"))).selectByVisibleText("PA");
		driver.findElement(By.name("ctl01$ContentPlaceHolder$account$txtPostal")).sendKeys("515801");
		Thread.sleep(5000);
		Scanner s = new Scanner(System.in);
		String Captch = s.next();
		driver.findElement(By.xpath("//*[@id=\"ctl01_ContentPlaceHolder_account_CaptchaControl1_CaptchaText\"]"))
				.sendKeys(Captch);
		// driver.findElement(By.name("ctl01$ContentPlaceHolder$account$txtCity")).sendKeys("515801");//ctl01$ContentPlaceHolder$account$BtnCreate

	}

	// tag2
	@And("click on createaccount button")
	public void tc_08() throws Exception {
		driver.findElement(By.name("ctl01$ContentPlaceHolder$account$BtnCreate")).click();//// *[@id="account-create-wrap"]/p[1]
	}

	@Then("verify the error message1")
	public void tc_09() {
		if (driver.findElements(By.xpath("//*[@id=\"account-create-wrap\"]/p[1]")).size() > 0) {
			System.out.println("Error mesage is displayed on screen");
		} else {
			System.out.println("Error mesage is not displayed on screen");
		}
	}

	@Given("using apv url in any browser1")
	public void tc_0e() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.applevacations.com/#!/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.findElement(By.linkText("My Account")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.findElement(By.linkText("Sign In")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
	}

	// Thread.sleep(5000);
	@When("user gave invalid data")
	public void tc_a() throws Exception {

		driver.findElement(By.name("ctl01$ContentPlaceHolder$ctl02$MyAccountLogin$UserName"))
				.sendKeys("test1234@gmail.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.findElement(By.name("ctl01$ContentPlaceHolder$ctl02$MyAccountLogin$Password")).sendKeys("Test@12341");
		driver.findElement(By.name("ctl01$ContentPlaceHolder$ctl02$MyAccountLogin$LoginButton")).click();
	}

	@And("verify the error message2")
	public void ab() throws Exception {
		if (driver.findElements(By.xpath("//*[@id=\"siteContainer\"]/div[2]/div/div/h2")).size() > 0) {
			System.out.println("Error mesage is displayed on screen");
		} else {
			System.out.println("Error mesage is not displayed on screen");
		}
		// driver.findElement(By.name("ctl01$ContentPlaceHolder$ctl02$MyAccountLogin$Password")).sendKeys("Tst@1234");
		driver.close();
	} // tag3

	@When("user gave valid data")
	public void d() throws Exception {
		driver.findElement(By.name("ctl01$ContentPlaceHolder$ctl02$MyAccountLogin$UserName"))
				.sendKeys("test1234@gmail.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.findElement(By.name("ctl01$ContentPlaceHolder$ctl02$MyAccountLogin$Password")).sendKeys("Test@1234");
		driver.findElement(By.name("ctl01$ContentPlaceHolder$ctl02$MyAccountLogin$LoginButton")).click();

	}

	// tag4
	@Given("using apv url in any browser2")
	public void g() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.applevacations.com/#!/");
		/*
		 * driver.findElement(By.linkText("My Account")).click();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		 * driver.findElement(By.linkText("Sign In")).click();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		 * 
		 * driver.findElement(By.name(
		 * "ctl01$ContentPlaceHolder$ctl02$MyAccountLogin$UserName")).sendKeys(
		 * "test1234@gmail.com");
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		 * driver.findElement(By.name(
		 * "ctl01$ContentPlaceHolder$ctl02$MyAccountLogin$Password")).sendKeys(
		 * "Test@1234"); driver.findElement(By.name(
		 * "ctl01$ContentPlaceHolder$ctl02$MyAccountLogin$LoginButton")).click();
		 */
	}

	//// *[@id="mat-button-toggle-2-button"]/span
	@When("user gave valid data1")
	public void e() throws Exception {
		driver.findElement(By.id("scc_rt_vendorpackage_1_H01")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"desAC_value\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"desAC_value\"]")).sendKeys("Ne");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"desAC_dropdown\"]/div[4]/div")).click();
		driver.findElement(By.xpath("//*[@id='depDT_value']")).clear();
		driver.findElement(By.xpath("//*[@id='depDT_value']")).sendKeys("08/11/2024");
		driver.findElement(By.xpath("//*[@id='depDT_value']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//*[@id='depDT_value']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//span[text()='1 Room, 2 Adults']")).click();
		//Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@ng-bind='PassengersString()']")).click();
		new Select(driver.findElement(By.xpath("//*[@id='scc_rt_passengers_numrooms']"))).selectByVisibleText("2 Room");
		new Select(driver.findElement(By.xpath("//*[@id='passengers_1_adults']"))).selectByVisibleText("4 Adults");
		new Select(driver.findElement(By.xpath("//*[@id='passengers_1_kids']"))).selectByVisibleText("2 Children");
		new Select(driver.findElement(By.name("passengers$1$kids$0$age"))).selectByVisibleText("14");
		new Select(driver.findElement(By.name("passengers$1$kids$1$age"))).selectByVisibleText("5");
		new Select(driver.findElement(By.xpath("//*[@id='passengers_1_adults']"))).selectByVisibleText("2 Adults");
		new Select(driver.findElement(By.xpath("//*[@id='passengers_1_kids']"))).selectByVisibleText("3 Children");
		new Select(driver.findElement(By.name("passengers$1$kids$0$age"))).selectByVisibleText("8");
		new Select(driver.findElement(By.name("passengers$1$kids$1$age"))).selectByVisibleText("11");
		new Select(driver.findElement(By.name("passengers$1$kids$1$age"))).selectByVisibleText("2");
	}

	
	@Then("click on search button")
	public void click_on_search_button() {
		driver.findElement(By.name("scc$rt$submit")).click();
		// throw new io.cucumber.java.PendingException();
	}

	// @Then (" click on search button")
	public void j() {
		driver.findElement(By.name("scc$rt$submit")).click();
	}

	// tag5
	@Given("using applev url in  browser")
	public void using_applev_url_in_browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.applevacations.com/#!/");
	}

	@And("user gave valid informatoin")
	public void i() throws Exception {
		driver.findElement(By.id("scc_rt_vendorpackage_1_A01")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"orgAC_value\"]")).sendKeys("c");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"orgAC_dropdown\"]/div[3]/div")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='desAC_value']")).sendKeys("m");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"desAC_dropdown\"]/div[3]/div")).click();
		driver.findElement(By.xpath("//*[@id='depDT_value']")).clear();
		driver.findElement(By.xpath("//*[@id='depDT_value']")).sendKeys("05/08/2024");
		driver.findElement(By.xpath("//*[@id='depDT_value']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//*[@id='depDT_value']")).sendKeys(Keys.TAB);
		//driver.findElement(By.xpath("//span[text()='1 Room, 2 Adults']")).click();
		//Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@ng-bind='PassengersString()']")).click();
		new Select(driver.findElement(By.xpath("//*[@id='passengers_1_adults']"))).selectByVisibleText("4 Adults");
		new Select(driver.findElement(By.xpath("//*[@id='passengers_1_kids']"))).selectByVisibleText("3 Children");
		new Select(driver.findElement(By.name("passengers$1$kids$0$age"))).selectByVisibleText("5");
		new Select(driver.findElement(By.name("passengers$1$kids$1$age"))).selectByVisibleText("8");
		new Select(driver.findElement(By.name("passengers$1$kids$2$age"))).selectByVisibleText("11");
		  }

	// tag6
	@And("user gave valid informatoin1")
	public void k() throws Exception {
		driver.findElement(By.id("scc_rt_vendorpackage_1_AH01")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"orgAC_value\"]")).sendKeys("k");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"orgAC_dropdown\"]/div[3]/div")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		// Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='desAC_value']")).sendKeys("v");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"desAC_dropdown\"]/div[3]/div")).click();
		driver.findElement(By.xpath("//*[@id='depDT_value']")).clear();
		driver.findElement(By.xpath("//*[@id='depDT_value']")).sendKeys("12/09/2024");
		driver.findElement(By.xpath("//*[@id='depDT_value']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//*[@id='depDT_value']")).sendKeys(Keys.TAB);
		//Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text()='1 Room, 2 Adults']")).click();
		Thread.sleep(4000);
		new Select(driver.findElement(By.xpath("//*[@id='scc_rt_passengers_numrooms']"))).selectByVisibleText("1 Room");
		new Select(driver.findElement(By.xpath("//*[@id='passengers_1_adults']"))).selectByVisibleText("1 Adult");

		new Select(driver.findElement(By.xpath("//*[@id='passengers_1_kids']"))).selectByVisibleText("1 Child");

		new Select(driver.findElement(By.name("passengers$1$kids$0$age"))).selectByVisibleText("14");
		// driver.findElement(By.i("passengers$1$kids"]")).sendKeys("2 Adults");//
		// scc$rt$submit//passengers$1$kids
	}

}
