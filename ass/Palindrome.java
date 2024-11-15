package week1.ass;

public class Palindrome {
	
	public static void main(String[] args) {
		
		int input = 12321;
		int remainder = 0;
		
		for (int i=input ; i>0; i=i/10) {
			
			remainder=(remainder*10+i%10);
			
		}
		
		System.out.println(remainder);
		
		int output = remainder;
		
		if (input==output) {
			
			System.out.println("It is a Palindrome number: " +input);
			
			}
		else {
			
			System.out.println("It is not a Palindrome number: " +input);
		}
		
	}

}
