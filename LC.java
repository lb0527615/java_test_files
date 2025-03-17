public class LC
{
    public static void main(String[] args)
	{
		//code will begin at 1, will run until it reaches 100.
		for(int n = 1; n <= 100; n++) {
			//if the final number of the sequence can be divided by 10 with no remainder, it will skip to the next line.
			if(n % 10 == 0 && n > 0)
				System.out.println(n);
			//else statement will repeat the sequence on the same line until it conducts the if statement.
			else
				System.out.print(n + " ");
		}
	}
}