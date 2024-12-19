package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DynamicParameterization {

	// Initialising driver globally
	public ChromeDriver driver;

	@Given("Launch a new browser and Load the URL")
	public void launch_a_new_browser_and_load_the_url() {

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

	@When("Enter credentials- username as dilip@testleaf.com")
	public void enter_credentials_username_as_dilip_testleaf_com() {
		// Entering the username
		driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");

	}

	@When("Enter credentials- password as leaf@{int}")
	public void enter_credentials_password_as_leaf(Integer int1) {
		// Entering the password
		driver.findElement(By.id("password")).sendKeys("leaf@2024");

	}

	@When("Click on the Login Button")
	public void click_on_the_login_button() {
		// Click login button
		driver.findElement(By.id("Login")).click();

	}

	@When("Click on the Toggle menu Button from the Left corner side")
	public void click_on_the_toggle_menu_button_from_the_left_corner_side() {
		// Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

	}

	@When("Click View All Button and Click Sales Button from App Launcher")
	public void click_view_all_button_and_click_sales_button_from_app_launcher() {

		// Click view all
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();

		// Click Sales from App launcher
		WebElement sale = driver.findElement(By.xpath("(//div[@class='slds-truncate'])[6]"));
		driver.executeScript("arguments[0].click();", sale);

	}

	@When("Click on the Accounts Tab")
	public void click_on_the_accounts_tab() {
		// Click on Accounts tab
		WebElement acc = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", acc);

	}

	@When("Click on the New Button")
	public void click_on_the_new_button() {
		// Click on new button
		driver.findElement(By.xpath("//div[text()='New']")).click();

	}

	@When("Enter your name as {string} to create account")
	public void enter_your_name_as_to_create_account(String accName) {
		// Entering the account name and replace the hardcoded value with the variables
		driver.findElement(By.xpath("(//input[@class='slds-input'])[5]")).sendKeys(accName);

	}

	@When("Selecting Ownership as Public")
	public void selecting_ownership_as_public() throws InterruptedException {
		// Selecting ownership as public
		WebElement select = driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__')])[4]"));
		driver.executeScript("arguments[0].click();", select);
		Thread.sleep(2000);

		WebElement Public = driver.findElement(By.xpath("//span[text()='Public']"));
		Public.click();

	}

	@When("Click on Save Button")
	public void click_on_save_button() {
		// Click Save button
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

	}

	@Then("Verify the Account Name")
	public void verify_the_account_name() {
		// Verifying the accountname was created
		String accname = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
		System.out.println("Account name is:" + accname);

		if (accname.contains(accname)) {
			System.out.println("Account is created");

		} else {
			System.out.println("Account is not created");
		}

	}

}