package hooks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseProjectSMethod;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksImplementation extends BaseProjectSMethod {
	
	@Before
	
	public void precondition() {
		
		//Initializing the driver & get the URL
			    driver=new ChromeDriver();
				driver.get("http://leaftaps.com/opentaps/control/main");
				driver.manage().window().maximize();
				
				//Using Implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				//Logging in by using existing credentials
				driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
				driver.findElement(By.id("password")).sendKeys("crmsfa");
				driver.findElement(By.className("decorativeSubmit")).click();

	}
	
	@After
	
	public void postcondition()
	{
		//Close the browser
		driver.close();
	}

}
