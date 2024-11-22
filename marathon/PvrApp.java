package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class PvrApp {
	
	public static void main(String[] args) throws InterruptedException {
		
		////Initializing the driver & get the URL
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.pvrcinemas.com/");
		driver.manage().window().maximize();
		
		//Using Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Thread.sleep(1000);
		
		//Choosing cinema and booking ticktes
		driver.findElement(By.xpath("//span[@class='cinemas-inactive']")).click();
		driver.findElement(By.xpath("//span[text()='Select Cinema']")).click();
		driver.findElement(By.xpath("//span[text()='INOX BMC Bhawani Mall Bhubaneswar']")).click();
		driver.findElement(By.xpath("//span[text()='Select Date']")).click();
		driver.findElement(By.xpath("//div[@id='date']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Tomorrow')]")).click();
		driver.findElement(By.xpath("(//span[text()='WICKED'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='12:20 PM']")).click();
		driver.findElement(By.xpath("(//span[text()='Book'])[4]")).click();
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
		driver.findElement(By.xpath("//span[@id='CL.CLUB|J:21']")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		
		//Printing the seat information
		String seat=driver.findElement(By.xpath("//div[@class='seat-info']")).getText();
		System.out.println("The seat info is:" +seat);
		
		//Printing the total cost
		String cost=driver.findElement(By.xpath("//div[@class='grand-tota col-md-3']")).getText();
		System.out.println("The total cost is:" +cost);
		
		//Proceeding further and closing the popup
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		driver.findElement(By.xpath("(//i[@class='pi pi-times'])[2]")).click();
		
		//printing the title of the page
		String title=driver.getTitle();
		System.out.println("The title of the current page is:" +title);
		
		Thread.sleep(1000);
		driver.close();
		
}

}
