package week5.day2Assignment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SalesForce extends ProjectSpecificMethod {

	// Set the data provider attribute with the value as the Dataprovider method
	// name
	@DataProvider(name = "getData")

	public String[][] fetchData() throws IOException {
		// Add a return statement
		return NameData.readValue();
	}

	// Data provider in test arguments
	@Test(dataProvider = "getData")
	public void dynamic(String name) throws InterruptedException {

		// Entering name in the name field
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("name");

		// Click save
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

		// Verifying the legal entity name
		String legalname = driver
				.findElement(By.xpath("//span[contains(@class,'test-id__field-value slds-form-element')]")).getText();
		System.out.println("Legal Entity name is:" + legalname);
		Thread.sleep(2000);

	}

}
