package steps;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import base.BaseProjectSMethod;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteSd extends BaseProjectSMethod {

	@When("Crmsfa Link Should be Clicked")
	public void crmsfa_link_should_be_clicked() {

		// Click on Crmsfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

	@When("Account Tab Should be Clicked")
	public void account_tab_should_be_clicked() {

		// Click the Account tab
		driver.findElement(By.linkText("Accounts")).click();
	}

	@When("Click the Find Accounts Tab")
	public void click_the_find_accounts_tab() {

		// Click the Find accounts button
		driver.findElement(By.linkText("Find Accounts")).click();
	}

	@When("Enter the Account Id as {string}")
	public void enter_the_account_id_as(String id) {

		// Entering the account id by removing the hardcoded values and replace with
		// the variables
		driver.findElement(By.name("id")).sendKeys(id);
	}

	@When("Click on Find accounts Button")
	public void click_on_find_accounts_button() throws InterruptedException {

		// Click the find accounts button
		driver.findElement(By.xpath("//button[text()='Find Accounts']")).click();
		Thread.sleep(2000);
		// Click the first link
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		Thread.sleep(2000);
	}

	@When("Click the deactivate button")
	public void click_the_deactivate_button() {

		// Click the Deactivate button
		driver.findElement(By.linkText("Deactivate Account")).click();

		// Handling the alert
		Alert name = driver.switchTo().alert();
		name.accept();
	}

	@Then("Print the message")
	public void print_the_message() {

		// Print the message
		String msg = driver.findElement(By.className("subSectionWarning")).getText();
		System.out.println(msg);

	}

}
