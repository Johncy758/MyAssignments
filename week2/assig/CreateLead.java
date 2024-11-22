package week2.assig;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateLead {
	
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
		
		//Creating a lead by using basic locators
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Johncy");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Siva");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Testing");
		driver.findElement(By.name("submitButton")).click();
		
		//Print the title of the webpage
		String title=driver.getTitle();
		System.out.println("Title of the current webpage is:"  +title);
		
		//Thread.sleep(10000);
		//driver.close();
		}

}
