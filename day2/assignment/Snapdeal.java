package week4.day2.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {

		// Disable notifications
		ChromeOptions noti = new ChromeOptions();
		noti.addArguments("--Disable-notifications");

		// Initializing ChromeDriver
		ChromeDriver driver = new ChromeDriver(noti);
		driver.manage().window().maximize();

		// Load the URL
		driver.get("https://www.snapdeal.com/");

		// Using Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Go to "Men's Fashion"
		WebElement men = driver.findElement(By.xpath("//span[@class='catText']"));
		Actions build = new Actions(driver);
		build.moveToElement(men).perform();

		// Go to "Sports Shoes"
		WebElement sports = driver.findElement(By.xpath("//span[text()='Sports Shoes']"));
		sports.click();

		// Get the count of sports shoes
		String count = driver.findElement(By.xpath("(//div[@class='child-cat-count '])[2]")).getText();
		System.out.println("Count of Sports shoes:" + count);

		// Click on "Training Shoes"
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();

		// Sort the products by "Low to High"
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		driver.findElement(By.xpath("//li[@class='search-li']")).click();

		Thread.sleep(2000);

		// Check if the displayed items are sorted correctly
		List<WebElement> sort = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		for (int i = 0; i < sort.size() - 1; i++) {

			System.out.println("Sort order:" + sort.get(i).getText());

		}

		// Selecting price range from 500-700.
		WebElement minprice = driver.findElement(By.xpath("//input[@name='fromVal']"));
		minprice.clear();
		minprice.sendKeys("500");

		WebElement maxprice = driver.findElement(By.xpath("//input[@name='toVal']"));
		maxprice.clear();
		maxprice.sendKeys("700");

		// Clicking the price ranga
		driver.findElement(By.xpath("//div[contains(@class,'price-go-')]")).click();
		Thread.sleep(5000);

		// Filter by any colour
		driver.findElement(By.xpath("//span[@class='filter-color-tile White&Blue ']")).click();

		// driver.findElement(By.xpath("//div[@class='filter-content
		// ']//label")).click()

		Thread.sleep(1000);

		// Clicking the filter content
		WebElement element = driver.findElement(By.xpath("//div[@class='filter-content ']//label"));
		element.click();

		Thread.sleep(1000);

		// Verify all the applied filters
		System.out.println("Applied filters are:");
		WebElement priceRange = driver.findElement(By.xpath("//a[contains(@class,'clear-filter')]"));
		System.out.println("PriceRange:" + priceRange.getText());

		WebElement color = driver.findElement(By.xpath("//a[text()='White & Blue']"));
		System.out.println("Color:" + color.getText());

		// Mouse hover on the first resulting "Training Shoes".
		WebElement first = driver.findElement(By.xpath("//p[@class='product-title']"));
		Actions act = new Actions(driver);
		act.moveToElement(first).perform();

		// Click the "Quick View" button.
		WebElement quickview = driver.findElement(By.xpath("//div[text()=' 					Quick View']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(quickview).perform();
		Thread.sleep(2000);

		// Print the cost and the discount percentage
		String finalprice = driver.findElement(By.xpath("//span[@class='pdp-final-price']")).getText();
		System.out.println("Final price is:" + finalprice);

		String discount = driver.findElement(By.xpath("//span[@class='pdpDiscount ']")).getText();
		System.out.println("Discount is:" + discount);

		// Take a snapshot of the shoes
		File src = driver.getScreenshotAs(OutputType.FILE);
		File trg = new File("./SnapShot/snapdeal.png");
		FileUtils.copyFile(src, trg);

		// Close the current window
		driver.close();

		// Close the main window
		driver.quit();
	}

}
