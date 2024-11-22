package week2.assig;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Initializing the driver & get the URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		//Using Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		//Logging in by using existing credentials
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Creating a lead by using basic locators & xpath
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("Testleaf");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Inpa");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("Johnu");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Software Testing");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("johncy.cse92@gmail.com");
		
		//Using WebElement and select class to handle the dropdown
		WebElement state=driver.findElement(By.name("generalStateProvinceGeoId"));
		Select obj=new Select(state);
		obj.selectByVisibleText("New York");
		
		//Using locators for edit  lead
		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.linkText("Edit")).click();
		
		//Clearing existing description
		WebElement user=driver.findElement(By.name("description"));
		user.sendKeys("Manual Tester");
		user.clear();
		user.sendKeys("Automation Tester");
		
		//Update lead
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Testing is important for a quality product");
		driver.findElement(By.name("submitButton")).click();
		
		//Print the title of the webpage
		String title=driver.getTitle();
		System.out.println("Title of the resulting page is:"  +title);
		
		Thread.sleep(10000);
		driver.close();
		
		}}
