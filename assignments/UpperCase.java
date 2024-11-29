package week3.assignments;

public class UpperCase {

	public static void main(String[] args) {

		// Initialaizing the value
		String test = "changeme";

		// Converting string to chararray
		char[] capital = test.toCharArray();

		// Using for loop to find the odd index
		for (int i = capital.length - 1; i >= 0; i--) {

			// Changing the character to uppercase
			if (i % 2 != 0) {

				capital[i] = Character.toUpperCase(capital[i]);

			}

		}

		// Converting array to string and printing the value
		String result = new String(capital);
		System.out.println("The uppercase of odd index is:" + result);
	}

}
