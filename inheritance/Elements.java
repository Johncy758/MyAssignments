package week3.ass.inheritance;

//Creating Execution class that inherits all the classes
public class Elements extends Button {

	public static void main(String[] args) {

		// Creating object in execution class
		Elements elmnt = new Elements();

		// Calling the methods of superclass and subclass Button
		elmnt.click();
		elmnt.setText();
		elmnt.submit();

		// Creating object for additinal subclass and calling method
		CheckBoxButton chkbx = new CheckBoxButton();
		chkbx.clickCheckButton();

		// Creating object for additinal subclass and calling method
		RadioButton Rb = new RadioButton();
		Rb.selectRadioButton();

	}

}
