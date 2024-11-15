package week1.ass;

import java.util.Arrays;

public class FindMissingElement {
  public static void main(String[] args) {
	  
	  int[] inp= {1,4,3,2,8,6,7};
	Arrays.sort(inp);
	
	   for (int i = inp[0]; i < inp.length; i++) {
		   if (inp[i]!=i+1) {
			   System.out.println("The Missing Element is:" +(i+1));
			   break;
			
		}
			
		}
}
}
