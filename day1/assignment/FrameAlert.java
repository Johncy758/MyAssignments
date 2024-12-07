package week4.day1.assignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameAlert {

	public static void main(String[] args) throws InterruptedException {

		// Initialize ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");

		// Using Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Switch to the frame
		driver.switchTo().frame("iframeResult");

		// click the "Try It" button
		driver.findElement(By.xpath("//button[text()='Try it']")).click();

		// Interact with the alert & click OK
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);

		alert.sendKeys("Harry Potter");
		alert.accept();

		// Verify the displayed text
		WebElement outputText = driver.findElement(By.id("demo"));
		String expectedText = "Hello Harry Potter! How are you today?";
		String actualText = outputText.getText();

		// Check if the text matches the expectation
		if (actualText.equals(expectedText)) {
			System.out.println("Displayed text is correct.");
			System.out.println("Expected: " + expectedText);
			System.out.println("Actual: " + actualText);
		} else {
			System.out.println("Displayed text is incorrect.");

		}

		Thread.sleep(2000);

		// Close the browser
		driver.quit();
	}

}
