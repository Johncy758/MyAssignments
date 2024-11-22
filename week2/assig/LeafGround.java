package week2.assig;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGround {
	
	public static void main(String[] args) throws InterruptedException {
		
		////Initializing the driver & get the URL
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://leafground.com/button.xhtml");
		driver.manage().window().maximize();
		
		//Using Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Confirm if the button is disabled
		WebElement button=driver.findElement(By.xpath("(//div[@class='card']/h5)[2]"));
		System.out.println("Confirming the button is disabled:" +button.isDisplayed());
		
		//Printing the text & position of the button
		WebElement text=driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[3]"));
		System.out.println("Text of the button is:" +text.getText());
		System.out.println("Position of the button is:" +text.getLocation());
		
		
		//Printing the text & background color of the  button
		WebElement color=driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[4]"));
		System.out.println("Text of the button is:" +color.getText());
		System.out.println("Background  color of the button is:" +color.getCssValue("background-color"));
		
		//Printing the height and width of the button
		WebElement height=driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[5]"));
		System.out.println("Text of the button is:" +height.getText());
		System.out.println("Height of the button is:" +height.getCssValue("height"));
		System.out.println("Width of the button is:" +height.getCssValue("width"));
		
		//Click  on the button 'click and confirm'
		driver.findElement(By.xpath("//span[text()='Click']")).click();
		
		//Verifying the title of the page
		String title=driver.getTitle();
		System.out.println("Title of the webpage is:" +title);
		
		Thread.sleep(1000);
		driver.close();
		}

}
