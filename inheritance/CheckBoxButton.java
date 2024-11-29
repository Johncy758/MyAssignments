package week3.ass.inheritance;

//Creating additional subclass that inherits subclass
public class CheckBoxButton extends Button {

	// Implementing method in subclass

	public void clickCheckButton() {
		System.out.println("Enter check button");
	}

	public static void main(String[] args) {

		// Creating object in subclass
		CheckBoxButton box = new CheckBoxButton();

		// Calling the methods of superclass and subclasses
		box.click();
		box.setText();
		box.submit();
		box.clickCheckButton();
	}
}
