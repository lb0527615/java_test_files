public class RelativelyPrimeArray {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a single integer argument.");
            return;
        }

        int n = Integer.parseInt(args[0]);
		//n is assigned by the user to create a square grid based on that number.
        boolean[][] rpa = new boolean[n + 1][n + 1];
		//This formula will generate the grid's size.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                rpa[i][j] = findGCD(i, j) == 1;
				//Both for statements create a loop that generate a grid at a set limit determined by n input.
                //the findGCD statement tries to determine if they are relatively prime to 1, which allows it to enter the if statement.
				if (i == j) {
                    System.out.print(" ");
					//Creates a space that does not print a number when numbers on the x and y axis match each other.
                } else {
                    System.out.print(rpa[i][j] ? "T " : "F ");
					//This else statement will name the number set on the x and y axis as being true or false if they are relatively prime.
                }
            }
            System.out.println(); // Print a newline after each row is processed
        }
    }

    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    } //This creates a loop back to the original function to allow the grid to be generated.
}
