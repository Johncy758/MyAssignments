package week3.assignments;

import java.util.Arrays;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Anagram {

	public static void main(String[] args) {

		// Defining two input strings
		String text1 = "stops";
		String text2 = new String("potss");

		// Checking the length of the strings
		if (text1.length() != text2.length()) {

			System.out.println("Lengths mismatch, therefore the strings are not an Anagram");
			return;
		}

		// Converting strings into character arrays
		char[] ch = text1.toCharArray();
		char[] cs = text2.toCharArray();

		// Sorting the arrays
		Arrays.sort(ch);
		Arrays.sort(cs);

		// for loop to print the sorted arrays
		for (int i = 0; i < ch.length; i++) {

			System.out.print(ch[i]);

		}
		System.out.println();

		for (int i = 0; i < cs.length; i++) {

			System.out.print(cs[i]);

		}
		System.out.println();

		// Defining the boolean variable and for loop to check the strings are Anagram
		boolean ret = true;

		for (int i = 0; i < ch.length; i++) {

			if (ch[i] == cs[i]) {

			} else {
				ret = false;
				break;
			}
		}

		if (ret == true)
			System.out.println("The strings are an Anagram");
		else
			System.out.println("The strings are not an Anagram");

	}

}
