public class Distribution100
{
    public static void main(String[] args)
	{
	int n = Integer.parseInt(args[0]); //counts the total number of integers
	int j = 0; //be used to evaluate and count if each integer is between 1 and 50.
	int k = 0; //variable used to sort through each input function.
	int m = 0; //be used to evaluate and count  if each integer is between 51 and 100.
	for (int i = 1; i<args.length; i++)
		{
		k = Integer.parseInt(args[i]);
		//K will be the assigned variable to i that will loop back and check each variable to determine if they are equal to j or m.
		if (1<=k && k<=50)
			{
			j = j + 1;
			}
			//if statement determines if the variable is between 1 and 50, and adds it to a tally.
		else if (51<=k && k<=100)
			{
			m = m + 1;	
			}
			//if statement determines if the variable is between 51 and 100, and adds it to a tally.
		}
		
	System.out.println( j + " numbers entered are less than or equal to 50.");
	System.out.println( m + " numbers entered are greater than 50.");
	//The two tally systems will combine with a statement to inform the user how many numbers did they type were under or equal to 50, or over 50.
	}
}