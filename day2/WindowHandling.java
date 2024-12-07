package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandling {
	
	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.irctc.co.in/");
		
		ChromeOptions d = new ChromeOptions();
	     d.addArguments("--disable-notifications");
		
		driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		
		Set<String> parentWindow = driver.getWindowHandles();
		System.out.println(parentWindow);
		
		List<String> getWindow = new ArrayList<String>(parentWindow);
		driver.switchTo().window(getWindow.get(1));
		String childWindow = driver.getTitle();
		System.out.println(childWindow);
		
		driver.switchTo().window(getWindow.get(0));
		driver.close();
		
		
		
	}

}
