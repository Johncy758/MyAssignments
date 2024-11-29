package week3.assignments;

public class DuplicateWord {

	public static void main(String[] args) {

		String text = "We learn Java basics as part of java sessions in java week1";

		int count = 0;

		// Split the text into an array of words
		String[] words = text.split(" ");

		// Iterate through the array to find duplicates
		for (int i = 0; i < words.length; i++) {

			// Initialize count for each word
			count = 1;

			// Skip empty strings
			if (words[i].equals(" ")) {
				continue;
			}

			// Compare the current word with the rest of the array
			for (int j = i + 1; j < words.length; j++) {
				
				// Check for duplicate words (case-insensitive)
				if (words[i].equalsIgnoreCase(words[j])) {
				
					// Increment count
					count++;
					
					// Replace the duplicate with an empty string
					words[j] = " ";
				}
			}
		}
		// Print the modified array, skipping empty strings
		for (int i = 0; i < words.length; i++) {
			if (!words[i].equals("")) {
				System.out.print(words[i] + " ");
			}
		}
	}
}
