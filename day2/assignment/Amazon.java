package week4.day2.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {

		// Initializing ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Load the URL
		driver.get("https://www.amazon.in/");

		// Using Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Searching for "oneplus 9 pro"and click
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("oneplus 9 pro");
		search.submit();

		//Get the price of the first product
		String price = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println("The price of the first product is:" + price);

		//Printing the number of customer ratings for the first displayed product
		String rating = driver.findElement(By.xpath("//span[contains(@class,'s-underline-text')]")).getText();
		System.out.println("Number of customer ratings:" + rating);

		//Click the first text link of the first image
		driver.findElement(By.xpath("//span[contains(@class,'a-size-medium a-color')]")).click();
		Thread.sleep(5000);

		//Take a screenshot of the product displayed
		File scr = driver.getScreenshotAs(OutputType.FILE);
		File trg = new File("./SnapShot/amazon.png");
		FileUtils.copyFile(scr, trg);

		//Window Handling
		Set<String> parentWindow = driver.getWindowHandles();
		List<String> childWindow = new ArrayList<String>(parentWindow);
		
		//Switch to child window 
		driver.switchTo().window(childWindow.get(1));

		//Click the 'Add to Cart' button
		driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();

		//Get the cart subtotal and print
		driver.findElement(By.xpath("//span[contains(@id,'-view-cart-button')]//input")).click();
		String cart = driver.findElement(By.xpath("//span[contains(@class,'a-size-medium a-color-base')]")).getText();
		System.out.println("Cart subtotal is:" + cart);
		
		//Closing the browser
		driver.close();

	}

}
