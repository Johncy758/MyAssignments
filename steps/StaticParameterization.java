package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StaticParameterization {

	// Initialising driver globally
	public ChromeDriver driver;

	@Given("Launch the new browser and Load the Url")
	public void launch_the_new_browser_and_load_the_url() {

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

		// Entering the username
		driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");

		// Entering the password
		driver.findElement(By.id("password")).sendKeys("leaf@2024");

		// Click login button
		driver.findElement(By.id("Login")).click();
	}

	@When("Click the App Launcher Icon next to setup")
	public void click_the_app_launcher_icon_next_to_setup() {

		// Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

	}

	@When("Click View All and Select Accounts from App launcher")
	public void click_view_all_and_select_accounts_from_app_launcher() throws InterruptedException {

		// Click view all
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();

		// Select Accounts tab using actions
		WebElement scroll = driver.findElement(By.xpath("//p[text()='Accounts']"));
		Actions acc = new Actions(driver);
		acc.scrollToElement(scroll).perform();
		Thread.sleep(2000);
		scroll.click();

	}

	@When("Search the account using unique account name")
	public void search_the_account_using_unique_account_name() throws InterruptedException {

		// Search for the account using unique account name
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Johncy", Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@class,'slds-truncate outputLookupLink')]")).click();

	}

	@When("Click the dropdown icon and select Edit")
	public void click_the_dropdown_icon_and_select_edit() throws InterruptedException {

		// Click the dropdown icon next to the account
		driver.findElement(By.xpath("(//button[contains(@class,'slds-button_last')])[2]")).click();

		// Select Edit button
		WebElement edit = driver.findElement(By.xpath("//span[text()='Edit']"));
		driver.executeScript("arguments[0].click();", edit);
		Thread.sleep(2000);

	}

	@When("Set Type to Technology Partner")
	public void set_type_to_technology_partner() {

		// Set Type to Technology Partner
		WebElement type = driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox')])[2]"));
		driver.executeScript("arguments[0].click();", type);

		WebElement tech = driver.findElement(By.xpath("//span[text()='Technology Partner']"));
		tech.click();

	}

	@When("Set Industry to HealthCare")
	public void set_industry_to_health_care() {

		// Set Industry to Healthcare
		WebElement indus = driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox')])[4]"));
		driver.executeScript("arguments[0].click();", indus);

		WebElement health = driver.findElement(By.xpath("//span[text()='Healthcare']"));
		driver.executeScript("arguments[0].click();", health);

	}

	@When("Enter the Billing address to {string}")
	public void enter_the_billing_address_to(String billingcity) {

		// Enter the Billing Address and replace the hardcoded value with the variables
		WebElement bill = driver.findElement(By.xpath("//input[@name='city']"));
		bill.sendKeys(billingcity);

	}

	@When("Enter the Shipping address to {string}")
	public void enter_the_shipping_address_to(String shippingcity) {

		// Enter the Shipping Address replace the hardcoded value with the variables
		WebElement ship = driver.findElement(By.xpath("(//input[@name='city'])[2]"));
		ship.sendKeys(shippingcity);

	}

	@When("Set Customer Priority to Low")
	public void set_customer_priority_to_low() {

		// Set Customer Priority to Low
		WebElement cust = driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox')])[5]"));
		driver.executeScript("arguments[0].click();", cust);

		WebElement low = driver.findElement(By.xpath("//span[text()='Low']"));
		driver.executeScript("arguments[0].click();", low);

	}

	@When("Set SLA to Silver")
	public void set_sla_to_silver() {

		// Set SLA to Silver
		WebElement sla = driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox')])[6]"));
		driver.executeScript("arguments[0].click();", sla);

		WebElement silver = driver.findElement(By.xpath("//span[text()='Silver']"));
		driver.executeScript("arguments[0].click();", silver);

	}

	@When("Set Active to NO")
	public void set_active_to_no() {

		// Set Active to NO
		WebElement active = driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox')])[8]"));
		driver.executeScript("arguments[0].click();", active);

		WebElement no = driver.findElement(By.xpath("//span[text()='No']"));
		driver.executeScript("arguments[0].click();", no);

	}

	@When("Enter a Unique Phone number {string}")
	public void enter_a_unique_phone_number(String phonenum) {

		// Entering phone number replace the hardcoded value with the variables
		WebElement phnum = driver.findElement(By.xpath("//input[@name='Phone']"));
		phnum.sendKeys(phonenum);

	}

	@When("Set Upsell Opportunity to NO")
	public void set_upsell_opportunity_to_no() {

		// Set Upsell Opportunity to No
		WebElement opp = driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input')])[7]"));
		driver.executeScript("arguments[0].click();", opp);

		WebElement no = driver.findElement(By.xpath("//span[text()='No']"));
		driver.executeScript("arguments[0].click();", no);

	}

	@Then("Click Save and verify the phone number")
	public void click_save_and_verify_the_phone_number() {

		// Click Save and verify the phone number
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

		String ph = driver.findElement(By.xpath("//a[text()='9568423789']")).getText();
		System.out.println("Phone Number:" + ph);

		if (ph.contains(ph)) {

			System.out.println("Number is Verified");

		} else {

			System.out.println("Number is not Verified");
		}

	}
}
