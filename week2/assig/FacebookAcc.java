package week2.assig;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookAcc {
	
	public static void main(String[] args) {
		
		//Initializing the driver & get the URL
		ChromeDriver driver=new  ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		
		//Using Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		//Creating a new account by using basic locators
		driver.findElement(By.linkText("Create new account")).click();
		driver.findElement(By.name("firstname")).sendKeys("Johncy");
		driver.findElement(By.name("lastname")).sendKeys("Siva");
		driver.findElement(By.name("reg_email__")).sendKeys("johncy.cse92@gmail.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("myworld");
		
		//Using WebElement and select class to handle the dropdown
		WebElement dropDown = driver.findElement(By.id("day"));
		Select obj=new Select(dropDown);
		obj.selectByVisibleText("28");
		
		WebElement element = driver.findElement(By.id("month"));
		Select obj1=new Select(element);
		obj1.selectByValue("3");
		
		WebElement choose = driver.findElement(By.id("year"));
		Select obj2=new Select(choose);
		obj2.selectByVisibleText("1992");
		
		//Selecting radio button using xpath
		driver.findElement(By.xpath("(//input[@id='sex'])[1]")).click();
		
		}

}
