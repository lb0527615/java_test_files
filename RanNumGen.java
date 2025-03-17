public class RanNumGen
{
    public static void main(String[] args)
    {
        //sets precedents on the soon-to-be-running program. 
		//limit is an integer number inputted by the user to define how many times a random number will be generated. 
		int limit = Integer.parseInt(args[0]);
        int max = 100;
        int min = 1;
        int range = max - min + 1;
		
        //generate random numbers within 1 - 100
        for (int n = 1; n <= limit ; n++) {
            int random = (int) (Math.random() * range) + min;
			//random is a formula I found that will generate a randomized number that has a set range.
            System.out.println(random);
        }
    }
}