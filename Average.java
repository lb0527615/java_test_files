public class Average {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
		//The above value n will serve as the input statement for when the user places 
        if (n >= 1) {
            System.out.println(
                    "Write out the name and the three average scores of the individual. When done, type <ctrl+D> on Mac or Linux OS, or <ctrl+Z> on Windows OS.");
        }// the above statement will print if the user types a number above 1.

        String[] name = new String[n];
        int[] g1 = new int[n];
        int[] g2 = new int[n];
        int[] g3 = new int[n];
        int j = 0;
		//The above assigns input values for the function once executed. Name will represent the name of the person the individual will type, while the remaining integer values will represent the three numbers the user will input.
        
		while (!StdIn.isEmpty()) {
			String x1 = StdIn.readString();
            int x2 = StdIn.readInt();
            int x3 = StdIn.readInt();
            int x4 = StdIn.readInt();
			//The above 4 will act out as input statements.
            if (j < n) {
                name[j] = x1;
                g1[j] = x2;
                g2[j] = x3;
                g3[j] = x4;
                j++;
            }
		//The above while statement will assign print values to the string and three input functions.
        }
        for (int i = 0; i < n; i++) {
			double count = (g1[i] + g2[i] + g3[i]);
            double mean = (count / 3);
            //The two double variables are assigned to create a formula that will calculate the mean for each individual based on the three numbers the user will provide for each person.
			StdOut.printf(name[i] + " " + g1[i] + " " + g2[i] + " " + g3[i] + " " + "%.2f", mean);
			StdOut.println();
        }	//The above print statements will print out each line the user will type, as well as including the mean for the three numbers for each function. 
			//Println allows the program to skip to the next line, and will loop until it reaches the limits of the for statement.
    }	//The above for statement is set to print out the number of lines the user will set under the input value for n.
		
}
