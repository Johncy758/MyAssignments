package week3.ass.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort {
	
	public static void main(String[] args) {
		
		//Initializing the array list using add()
		List<String> companyName = new ArrayList<String>(); 
		
		companyName.add("HCL");
		companyName.add("Wipro");
		companyName.add("Aspire Systems");
		companyName.add("CTS");
		
		//Sort the list
		Collections.sort(companyName);
		
		//using for loop to iterate
		for (int i = companyName.size()-1; i >=0; i--) {
			 { 
		           //Prints the reverse list 
		            System.out.print(companyName.get(i)+","); 
		        } 
			   
			
		}
	}

}
