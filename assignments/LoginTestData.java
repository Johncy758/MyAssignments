package week3.assignments;

//Creating subclass that inherits superclass
public class LoginTestData extends TestData {

	// Implementing two methods
	public void enterUsername() {
		System.out.println("Enter the username");
	}

	public void enterPassword() {
		System.out.println("Enter the password");

	}

	public static void main(String[] args) {

		// Creating object for subclass
		LoginTestData data = new LoginTestData();

		// Calling the methods of both superclass and subclass
		data.enterCredentials();
		data.navigateToHomePage();
		data.enterUsername();
		data.enterPassword();

	}

}
