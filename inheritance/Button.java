package week3.ass.inheritance;

//Creating subclass that inherits baseclass
public class Button extends WebElement {

	// Implementing method in subclass
	public void submit() {
		System.out.println("Submit the value");
	}

	public static void main(String[] args) {

		// Creating object in subclass
		Button butn = new Button();

		// Calling the methods of both superclass and subclass
		butn.click();
		butn.setText();
		butn.submit();
	}

}
