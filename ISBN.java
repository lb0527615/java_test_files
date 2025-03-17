public class ISBN
{
	public static void main(String[] args)
	{
		String s = args[0];
		//The above input function will take the 9 digit number provided, and process it as a String statement.
		
		int d1 = ((s.charAt(0) - 48) * 10);
		int d2 = ((s.charAt(1) - 48) * 9);
		int d3 = ((s.charAt(2) - 48) * 8);
		int d4 = ((s.charAt(3) - 48) * 7);
		int d5 = ((s.charAt(4) - 48) * 6);
		int d6 = ((s.charAt(5) - 48) * 5);
		int d7 = ((s.charAt(6) - 48) * 4);
		int d8 = ((s.charAt(7) - 48) * 3);
		int d9 = ((s.charAt(8) - 48) * 2);
		//The above 9 integer formulas will process each formula, turn it into an integer number, while also providing checksum value for each number. From left to right, each digit is multiplied from 10 to 2.
		
		int total = (d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9);
		int x = 0;
		//To process the final digit, the above formulas are used to process the while statement.
		//x is a value used for the while statement, where it will be later used in the print statement once the while loop closes.
		
		while ((total % 11) != 0) {
		//To find the number for the 10th digit of the ISBN, the while statement will look for total to be divided by 11 with a remainder of 0. It will continously loop until the checksum total of the first 9 digits is determined.
			x += 1;
			total += 1;
			//In each loop, a value of 1 will be added to both x and total each time until total can be divided by 11 with a remainder of 0.
			//Once the value of x, the 10th digit, is determined for the ISBN, to two if statements will process.
		}
		
		
		if (x <= 9) 
		{
			System.out.println("The ISBN number would be " + s + x);
			//In the event x was valued as digits 0-9, the string will print with the value of x.
		}
		
		
		else if (x == 10) 
		{
			System.out.println("The ISBN number would be " + s + "X");
			//In the event x was valued as 10, the string will not print the value of x, and will instead process it as "X" to value x as being 10.
		}
		
	}
}