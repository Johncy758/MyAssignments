package week5.day1Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SalesForce extends ProjectSpecificMethod {

	@Test

	public void runSalesForce() throws InterruptedException {

		// Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// Click view all
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();

		// click Legal Entities from App Launcher
		WebElement scroll = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		Actions legal = new Actions(driver);
		legal.scrollToElement(scroll).perform();
		Thread.sleep(2000);
		scroll.click();

		// Click on the Dropdown icon in the legal Entities tab
		driver.findElement(By.xpath("(//a[@class='slds-button slds-button_reset'])[6]")).click();

		// Click on New Legal Entity
		WebElement click = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		driver.executeScript("arguments[0].click();", click);

		// Entering name in the name field
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce automation by Johncy");

		// Click save
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

		// Verifying the legal entity name
		String name = driver.findElement(By.xpath("//span[contains(@class,'test-id__field-value slds-form-element')]")).getText();
		System.out.println("Legal Entity name is:" + name);
		Thread.sleep(2000);

	}

}
