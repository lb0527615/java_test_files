public class NumbersRangeSum
{
	public static int getSum (int x, int y)
	{
	//n1 and n2 are reassigned to x and y to create the following recursion.
		int z = x;
		int result = 0;
		// The input function of x(n1) is also assigned to z, where it will serve a function as creating 
		while (z <= y)
		{
			//The loop will start if z is less than or equal to y, and will end once z = y.
			result += z;
			z += 1;
			//z will begin with the assigned variable of x, and will assign the count of z to the result variable. Statement will then skip to z+=1, where z adds 1 number, where it will loop back to result +=z, creating a sum of all the numbers between x(n1) and y(n2).
			//The loop will keep going, adding the new amount of z each time until z is equal to y.
		}
		
		return result;
		//Once z == y, it will assign result to getSum, which will then be assigned to the variable sum.
	}
		
		
	public static void main(String[] args)
	{
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		//The two variables will serve as the two input functions the user will input.
		int sum = getSum(n1, n2);
		//sum will serve as the assigned variable given from getSum, using the input functions the user provided earlier.
		System.out.println("The sum of natural numbers in range [" + (n1) + "," + (n2) + "] is " + sum + ".");
		//The above statement will print, which will include the input functions the user will input, as well as returning the result from the variable sum.
	}
}