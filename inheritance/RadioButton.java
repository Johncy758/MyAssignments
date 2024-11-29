package week3.ass.inheritance;

//Creating additional subclass that inherits subclass

public class RadioButton extends Button {

	// Implementing method in subclass

	public void selectRadioButton() {
		System.out.println("Select the Radio button");
	}

	public static void main(String[] args) {

		// Creating object in subclass
		RadioButton rad = new RadioButton();

		// Calling the methods of superclass and subclasses
		rad.click();
		rad.submit();
		rad.setText();
		rad.selectRadioButton();
	}
}
