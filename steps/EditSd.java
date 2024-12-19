package steps;

import org.openqa.selenium.By;

import base.BaseProjectSMethod;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditSd extends BaseProjectSMethod {

	@When("Crmsfa Link should be clicked")
	public void crmsfa_link_should_be_clicked() {

		// Click on Crmsfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

	@When("Account Tab should be clicked")
	public void account_tab_should_be_clicked() {

		// Click the Account tab
		driver.findElement(By.linkText("Accounts")).click();
	}

	@When("Click the Find Accounts tab")
	public void click_the_find_accounts_tab() {

		// Click the Find accounts button
		driver.findElement(By.linkText("Find Accounts")).click();

	}

	@When("Enter the account Id as {string}")
	public void enter_the_account_id_as(String id) {

		// Entering the account id by removing the hardcoded values and replace with
		// the variables
		driver.findElement(By.name("id")).sendKeys(id);

	}

	@When("Click the Find accounts button")
	public void click_the_find_accounts_button() throws InterruptedException {

		// Click the find accounts button
		driver.findElement(By.xpath("//button[text()='Find Accounts']")).click();
		Thread.sleep(2000);

		// Click the first link
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		Thread.sleep(2000);
	}

	@When("Click the edit button")
	public void click_the_edit_button() {

		// Click the Edit button
		driver.findElement(By.linkText("Edit")).click();

		// Enter the text in description field
		driver.findElement(By.name("description")).sendKeys("Automation Tester");
	}

	@When("Click the save button")
	public void click_the_save_button() {

		// Click the save button
		driver.findElement(By.className("smallSubmit")).click();
	}

	@Then("Check the edited name of the account")
	public void check_the_edited_name_of_the_account() {

		// Check and print the edited account
		String edited = driver.findElement(By.xpath("(//span[@class='tabletext'])[3]")).getText();
		System.out.println("Edited Account name is:" + edited);

	}

}
