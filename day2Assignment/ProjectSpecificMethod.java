package week5.day2Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



public class ProjectSpecificMethod {

	// Declaring driver globally
	public ChromeDriver driver;
	
	@Parameters({"url","userName","passWord"})

	@BeforeMethod

	// Precondition method
	public void preCondition(String url, String userName, String passWord) {

		// Handling the notificaions
		ChromeOptions noti = new ChromeOptions();
		noti.addArguments("--Disable-notifications");
		driver = new ChromeDriver(noti);

		// Maximizing the window
		driver.manage().window().maximize();

		// Load the URL
		driver.get(url);

		// Using implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Log in by using existing credentials and remove the hardcore values and replace with varaiables
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(passWord);
		driver.findElement(By.id("Login")).click();

	}

	@AfterMethod

	// Postcondition method
	public void postCondition() {

		// Close the browser
		driver.close();

	}

}
