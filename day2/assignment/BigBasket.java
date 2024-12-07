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
import org.openqa.selenium.interactions.Actions;

public class BigBasket {

	public static void main(String[] args) throws InterruptedException, IOException {

		// Initializing ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Get URL
		driver.get("https://www.bigbasket.com/");

		// Using Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Click on "Shop by Category"
		driver.findElement(By.xpath("(//button[contains(@id,'headlessui-menu-')])[4]")).click();
		
        //Mouse over "Foodgrains, Oil & Masala"
		WebElement mouseOver = driver.findElement(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(mouseOver).perform();
		
       //Mouse over "Rice & Rice Products"
		WebElement mousehover = driver.findElement(By.xpath("//a[text()='Rice & Rice Products']"));
		Actions rice = new Actions(driver);
		rice.moveToElement(mousehover).perform();
		
        //Click on "Boiled & Steam Rice"
		driver.findElement(By.xpath("//a[text()='Boiled & Steam Rice']")).click();
		Thread.sleep(2000);

		//Filter the results by selecting the brand "bb Royal"
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("BB Royal");
		driver.findElement(By.xpath("//input[@id='i-BBRoyal']")).click();
		Thread.sleep(7000);

		//Click on "Tamil Ponni Boiled Rice"
		WebElement element = driver.findElement(By.xpath("//h3[text()='Tamil Ponni Boiled Rice']"));
		driver.executeScript("arguments[0].click();", element);
		
        //Handling windows
		Set<String> parentWindow = driver.getWindowHandles();
		List<String> childWindow = new ArrayList<String>(parentWindow);
		driver.switchTo().window(childWindow.get(1));

		Thread.sleep(2000);

		//Selecting the 5 Kg bag
		WebElement element2 = driver.findElement(By.xpath("//span[text()='5 kg']"));
		driver.executeScript("arguments[0].click();", element2);
		
        //Check and note the price of the rice
		String price = driver.findElement(By.xpath("//td[contains(@class,'Description___StyledTd-sc')]")).getText();
		System.out.println("Price of 5kg rice is: " + price);
		
        //Click "Add" to add the bag to your cart
		driver.findElement(By.xpath("//button[text()='Add to basket']")).click();

		//Verifying the success message that confirms the item was added to your cart
		String msg = driver.findElement(By.xpath("//p[contains(text(),'An item has been added')]")).getText();
		System.out.println("Message displayed: " + msg);
		Thread.sleep(2000);
		
        //Take a snapshot of the current page
		File src = driver.getScreenshotAs(OutputType.FILE);
		File trg = new File("./SnapShot/Bigbasket.png");
		FileUtils.copyFile(src, trg);

		//Closing the current window
		driver.close();
		//Closing the main window
		driver.switchTo().window(childWindow.get(0));
		driver.close();

	}
}
