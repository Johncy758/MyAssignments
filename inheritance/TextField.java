package week3.ass.inheritance;

//Creating subclass that inherits baseclass
public class TextField extends WebElement {

	// Implementing method in subclass
	public void getText() {
		System.out.println("Getting the value");
	}

	public static void main(String[] args) {

		// Creating object in subclass
		TextField txt = new TextField();

		// Calling the methods of both superclass and subclass
		txt.click();
		txt.setText();
		txt.getText();
	}
}
