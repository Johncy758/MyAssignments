package week4.day2.assignment;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebTable {

	public static void main(String[] args) throws InterruptedException {
		
		// Initializing ChromeDriver  
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Load the URL
		driver.get("https://finance.yahoo.com/");
		
		// Using Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
        //Using mouseover actions
		WebElement mouseOver = driver.findElement(By.xpath("//span[text()='More']"));
		//Object for action class
		Actions builder = new Actions(driver);
		builder.moveToElement(mouseOver).perform();
		
        //Scroll to Crypto tab & click
		WebElement scroll = driver.findElement(By.linkText("Crypto "));
		Actions build = new Actions(driver);
		build.scrollToElement(scroll).perform();
		Thread.sleep(2000);
		scroll.click();
		
        //Locate the cryptocurrency names in the table using specific row
		List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,'markets-table')]/tbody/tr"));
		int rowCount = rows.size();
		System.out.println("No of Rows:" + rowCount);
		
        //Locate the cryptocurrency names in the table using specific column
		List<WebElement> column = driver.findElements(By.xpath("//table[contains(@class,'markets-table')]/thead/tr/th"));
		int colCount = column.size();
		System.out.println("No of Columns:" + colCount);

		//Print the names of  cryptocurrencies
		System.out.println("Names of Cryptocurrencies are:");
		
		//Using for loop to iterate the names
		for (int i = 1; i <= rowCount; i++) {

			String name = driver.findElement(By.xpath("//table[contains(@class,'markets-table')]/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println(name);

		}
	}
}
