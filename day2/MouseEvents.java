package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseEvents {
	
	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(" https://www.snapdeal.com/");
		
		Actions actions = new Actions(driver);
		WebElement mensFashion = driver.findElement(By.xpath("//span[@class='catText'][1]"));
		actions.moveToElement(mensFashion).perform();
		WebElement shirt = driver.findElement(By.xpath("//span[text()='Shirts']"));
		
		
		
	}

}
