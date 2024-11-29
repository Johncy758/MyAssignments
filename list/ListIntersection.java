package week3.ass.list;

import java.util.ArrayList;
import java.util.List;

public class ListIntersection {

	public static void main(String[] args) {

		// Declaring two arrays
		int[] array1 = { 3, 2, 11, 4, 6, 7 };
		int[] array2 = { 1, 2, 8, 4, 9, 7 };

		// Adding array elements to list
		List<Integer> elements = new ArrayList<>();

		// Comparing both arrays and printing intersection numbers
		for (int i = 0; i < array1.length; i++) {

			for (int j = 0; j < array2.length; j++) {

				if (array1[i] == array2[j]) {
					System.out.println("Intersection numbers are:" + array1[i]);
				}

			}
		}
	}
}