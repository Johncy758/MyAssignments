package week3.ass.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingElement {
	
	public static void main(String[] args) {
		
		List<Integer> elements = new ArrayList<Integer>();
		
		//Initializing the array list using add()
		elements.add(1);
		elements.add(2);
		elements.add(3);
		elements.add(4);
		elements.add(10);
		elements.add(6);
		elements.add(8);
	
		//sort the list
		Collections.sort(elements);
		
		//using for loop to iterate  and using get() to get an element from the list
		for (int i = 0; i < elements.size()-1; i++) {
			if (elements.get(i)!=elements.get(i+1)-1) {
				
				System.out.println("The Missing  element is:"  +(elements.get(i)+1));
			}
			
			
		}
		
		
	}
}
