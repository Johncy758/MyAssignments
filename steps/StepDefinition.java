package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

	// Initialising driver globally
	public ChromeDriver driver;

	@Given("Launch the browser and load the URL")
	public void launch_the_browser_and_load_the_url() {

		// Handling the notificaions
		ChromeOptions noti = new ChromeOptions();
		noti.addArguments("--Disable-notifications");
		driver = new ChromeDriver(noti);

		// Maximizing the window
		driver.manage().window().maximize();

		// Load the URL
		driver.get("https://login.salesforce.com");

		// Using implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@When("Enter the username as dilip@testleaf.com")
	public void enter_the_username_as_dilip_testleaf_com() {

		// Entering the username
		driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
	}

	@When("Enter the password as leaf@{int}")
	public void enter_the_password_as_leaf(Integer int1) {

		// Entering the password
		driver.findElement(By.id("password")).sendKeys("leaf@2024");

	}

	@When("Click on Login button")
	public void click_on_login_button() {

		// Click login button
		driver.findElement(By.id("Login")).click();

	}

	@When("Click on toggle menu button from the  left corner")
	public void click_on_toggle_menu_button_from_the_left_corner() {

		// Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

	}

	@When("Click View All button and Click Sales from App Launcher")
	public void click_view_all_button_and_click_sales_from_app_launcher() {

		// Click view all
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();

		// Click Sales from App launcher
		WebElement sale = driver.findElement(By.xpath("(//div[@class='slds-truncate'])[6]"));
		driver.executeScript("arguments[0].click();", sale);

	}

	@When("Click on Accounts tab")
	public void click_on_accounts_tab() {

		// Click on Accounts tab
		WebElement acc = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", acc);

	}

	@When("Click on New button")
	public void click_on_new_button() {

		// Click on new button
		driver.findElement(By.xpath("//div[text()='New']")).click();

	}

	@When("Enter your name as account name")
	public void enter_your_name_as_account_name() {

		// Entering the account name
		driver.findElement(By.xpath("(//input[@class='slds-input'])[5]")).sendKeys("Johncy");
	}

	@When("Select Ownership as Public")
	public void select_ownership_as_public() throws InterruptedException {

		// Selecting ownership as public
		WebElement select = driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__')])[4]"));
		driver.executeScript("arguments[0].click();", select);
		Thread.sleep(2000);

		WebElement Public = driver.findElement(By.xpath("//span[text()='Public']"));
		Public.click();

	}

	@When("Click Save button")
	public void click_save_button() {

		// Click Save button
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

	}

	@Then("Verify the account name")
	public void verify_the_account_name() {

		// Verifying the accountname was created
		String accname = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
		System.out.println("Account name is:" + accname);

		if (accname.contains("Johncy")) {
			System.out.println("Account is created");

		} else {
			System.out.println("Account is not created");
		}

	}

}
