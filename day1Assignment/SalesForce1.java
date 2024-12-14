package week5.day1Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SalesForce1 extends ProjectSpecificMethod {

	@Test

	public void runSalesForce1() throws InterruptedException {

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

		// Enter the Company name as 'TestLeaf
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("TestLeaf");

		// Enter Description as 'Salesforces
		driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys("Salesforces");
		Thread.sleep(2000);

		// Select Status
		WebElement select = driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input')]"));
		driver.executeScript("arguments[0].click();", select);
		Thread.sleep(2000);

		// Click Active in status
		WebElement activeOption = driver.findElement(By.xpath("//span[@title='Active']"));
		activeOption.click();

		// Click on Save
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(5000);

		// Verifying the Alert message
		String alertmsg = driver.findElement(By.xpath("//div[text()='Salesforce automation by Johncy']")).getText();
		System.out.println("Alert msg is:" + alertmsg);

	}

}
