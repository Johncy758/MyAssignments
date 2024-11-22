package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonApp {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Initializing the driver & get the URL
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		
		//Using Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Searching the productusing xpath
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Bags for boys");
		driver.findElement(By.xpath("//div[text()='bags for boys']")).click();
		
		//Printing the  total number of results
		String result=driver.findElement(By.xpath("//span[contains(text(),'results for')]")).getText();
		System.out.println("The total no of results is:" +result +"bags for boys");
		
		
		//Selecting the first 2brands in the left menu
		driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base'])[4]")).click();
		driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base'])[5]")).click();
		
		//Sorting by newest arrivals
		driver.findElement(By.xpath("//span[@class='a-dropdown-label']")).click();
		driver.findElement(By.xpath("(//a[@class='a-dropdown-link'])[4]")).click();
		
		//Printing the first resulting bag name
		String name=driver.findElement(By.xpath("//h2[@class='a-size-mini s-line-clamp-1']/span")).getText();
		System.out.println("The name of the bag is:" +name);
		
		//Printing the discount of the bag
		String dis=driver.findElement(By.xpath("//span[text()='(57% off)']")).getText();
		System.out.println("The Discount of the bag is:" +dis);
		
		//Printing the title of the page
		String title=driver.getTitle();
		System.out.println("Title of the page is: " +title);
		
		Thread.sleep(1000);
		driver.close();
		
		}

}
