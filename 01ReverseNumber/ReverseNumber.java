import java.util.Scanner;
class ReverseNumber{
	public static void main(String[] args){

		System.out.println("");
		System.out.println("----Reverse a number without using inbuilt function----");	
		System.out.println("");
			
		int number=0;
		String reverseNumber="";
		
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a number : ");
		number=input.nextInt();
		System.out.println("Input Number is: "+number);
		
		while(number>0){
			reverseNumber=reverseNumber+number%10;
			number=number/10;
			//System.out.println("input "+number);
			//System.out.println("output "+reverseNumber);
		}
		
		System.out.println("Result is: "+reverseNumber);
	}
}