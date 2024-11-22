package week2.assig;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Initializing the driver & get the URL
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		//Using Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		//Logging in by using existing credentials
	    driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		
		//Find leads using xpath with phone number
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).clear();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).sendKeys("65");
		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("88");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("88965422");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//Capture the lead ID of the first resulting lead
		driver.findElement(By.xpath("//span[text()='Name and ID']")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys("17736");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//a[text()='17736']")).click();
		
		//Print the lead ID
		String id=driver.findElement(By.xpath("//span[text()='Testleaf (17736)']")).getText();
		System.out.println("The First Lead Id is:" +id);
		
		//Delete the lead
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
		//Check the deleted lead
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[text()='Name and ID']")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys("17736");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//verifying "No records to display"
		String record=driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		System.out.println("The message  is:" +record);
		if(record.contains("No records to display"))
		{
			System.out.println("Account deleted successfully");
		}else {
			System.out.println("Account is not deleted successfully");
		}
		//Thread.sleep(1000);
		//driver.close();
		}

}
