package week3.ass.list;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ajio {

	public static void main(String[] args) throws InterruptedException {
		
		//Initializing the driver & get the URL
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//Using Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.ajio.com/");
		
		//Using WebElement to search the value and enter 
		WebElement searchbox = driver.findElement(By.xpath("//input[@name='searchVal']"));
		searchbox.sendKeys("Bags");
		searchbox.submit();
		
		Thread.sleep(2000);
		//Searching by using xpath with existing credentials
		driver.findElement(By.xpath("//label[contains(text(),'Men')]")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//label[contains(text(),'Fashion Bags')]")).click();
		Thread.sleep(5000);
		
		//Using gettext to find the total no of items
		 String result= driver.findElement(By.xpath("//div[@class='length']")).getText();
		 System.out.println("The No of items found:" +result);
		 
		 //Using List interface to find more no of elements and print it
		 List<WebElement> brands = driver.findElements(By.className("brand"));
		 int size= brands.size();
		 System.out.println("List of the brands:" +size);
		 
		 for (int i = 0; i < brands.size(); i++) {
				System.out.println(brands.get(i).getText());
	
		 }
		 
		 List<WebElement> bags = driver.findElements(By.className("nameCls"));
		 int count = bags.size();
		 System.out.println("List of the bags:" +count);
		 
		 for (int i = 0; i < bags.size(); i++) {
			 System.out.println(bags.get(i).getText());
			
		 }
		 
}
}
