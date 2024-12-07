package week4.day1;

import java.util.LinkedHashSet;
import java.util.Set;

public class LearnSet {
	
	public static void main(String[] args) {
		
		String name = "JohncyNallaiyan";
		char[] ch = name.toCharArray();
		
	   Set<Character> duplicate  = new LinkedHashSet<Character>();
	   
	   for (Character unq : ch) {
		   duplicate.add(unq);
		   }
	   
	   System.out.println(duplicate);
	   System.out.println("");
	   
	   for (Character character : duplicate) {
		   
		   System.out.print(character);
		
	}
	   
		
	}

}
