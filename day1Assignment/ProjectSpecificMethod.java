package week5.day1Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ProjectSpecificMethod {

	// Declaring driver globally
	public ChromeDriver driver;

	@BeforeMethod

	// Precondition method
	public void preCondition() {

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

		// Log in by using existing credentials
		driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("leaf@2024");
		driver.findElement(By.id("Login")).click();

	}

	@AfterMethod

	// Postcondition method
	public void postCondition() {

		// Close the browser
		driver.close();

	}

}
