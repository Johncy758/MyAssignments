package week4.day2.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandling {

	public static void main(String[] args) {

		// Initializing ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Load the URL
		driver.get("http://leaftaps.com/opentaps/control/login");

		// Using Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Logging in by using existing credentials
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();

		// Clicking on the widget of the "From Contact"
		driver.findElement(By.xpath("(//input[@name='partyIdFrom']/following::img)[1]")).click();

		// Handling windows and switch to new window
		Set<String> parentWindow = driver.getWindowHandles();
		List<String> childWindow = new ArrayList<String>(parentWindow);
		driver.switchTo().window(childWindow.get(1));

		// Clicking on the first resulting contact
		driver.findElement(By.xpath("//a[text()='DemoCustomer']")).click();

		// Switch to main window
		driver.switchTo().window(childWindow.get(0));

		// Clicking on the widget of the "To Contact"
		driver.findElement(By.xpath("(//input[@name='partyIdFrom']/following::img)[2]")).click();

		// Handling windows and switch to new window
		Set<String> parentWindow1 = driver.getWindowHandles();
		List<String> childWindow1 = new ArrayList<String>(parentWindow1);
		driver.switchTo().window(childWindow1.get(1));

		// Clicking on the second resulting contact
		driver.findElement(By.xpath("//a[text()='DemoLBCust']")).click();

		// Switch to main window
		driver.switchTo().window(childWindow1.get(0));

		// Clicking on the Merge button
		driver.findElement(By.xpath("//a[text()='Merge']")).click();

		// Handling alert & Accept the alert
		Alert msg = driver.switchTo().alert();
		System.out.println("Alert message is:" + msg.getText());
		msg.accept();

		// Verifying the title of the page.
		String title = driver.getTitle();
		System.out.println("Title of the page is:" + title);
		if (title.contains("Merge Contacts | opentaps CRM")) {
			System.out.println("Title is matched");

		} else {
			System.out.println("Title is mismatched");
		}
	}
}
