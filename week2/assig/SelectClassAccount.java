package week2.assig;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClassAccount {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Initializing the driver & get the URL
		ChromeDriver driver=new  ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		//Using Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		//Logging in by using existing credentials
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Creating a new account by using basic locators
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Accounts")).click();
		driver.findElement(By.linkText("Create Account")).click();
		driver.findElement(By.id("accountName")).sendKeys("SIJOA");
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
		
		//Using WebElement and select class to handle the dropdown 
		WebElement dropDown=driver.findElement(By.name("industryEnumId"));
		Select obj=new Select(dropDown);
		obj.selectByVisibleText("Computer Software");	
		
		WebElement element=driver.findElement(By.name("ownershipEnumId"));
		Select obj1=new Select(element);
		obj1.selectByVisibleText("S-Corporation");
		
		WebElement choose=driver.findElement(By.id("dataSourceId"));
		Select obj2=new Select(choose);
		obj2.selectByValue("LEAD_EMPLOYEE");
		
		WebElement scroll=driver.findElement(By.id("marketingCampaignId"));
		Select obj3=new Select(scroll);
		obj3.selectByIndex(6);
		
		WebElement enter=driver.findElement(By.id("generalStateProvinceGeoId"));
		Select obj4=new Select(enter);
		obj4.selectByValue("TX");
		
		driver.findElement(By.className("smallSubmit")).click();
		
		//Verifying the account name is matched
		String accname = driver.findElement(By.xpath("(//span[@class='tabletext'])[3]")).getText();
		System.out.println("The given account  name is:" +accname);
		if(accname.contains("SIJOA")) {
			System.out.println("Account name is matched");
		}else {
			System.out.println("Account name is not matched");
		}
		 
		Thread.sleep(10000);
		driver.close();
	}
	}


