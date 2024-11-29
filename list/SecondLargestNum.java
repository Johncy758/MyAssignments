package week3.ass.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecondLargestNum {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();

		// Declaring array using list add method
		list.add(3);
		list.add(2);
		list.add(11);
		list.add(4);
		list.add(6);
		list.add(7);

		// Sort & print the list
		Collections.sort(list);

		// Print the second largest number using get method
		int j = list.get(4);
		System.out.println("The Second Largest Element in the array list is:" + j);

	}

}
