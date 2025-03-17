import java.util.*;
import java.io.*;

public class LookupMultipleNumber {
    public static void main(String[] args) {
        
		//in will read the csv file provided.
		In in = new In(args[0]);
		//limit represents how many values maximum should be printed in Standard Output.
		int limit = Integer.parseInt(args[1]);
		//Both Field values represent the columns to read from. keyField are the columns that will act as input values to pull output values from valField.
        int keyField = Integer.parseInt(args[2]);
        int valField = Integer.parseInt(args[3]);
		
		//Everything in in is converted into a database.
        String[] database = in.readAllLines();
		//ST.java is used for later parts of the code. ST is the Symbol Table that values in "in" are read from.
		ST<String, String> st = new ST<>();
		
		//Values in the args array will then process into a while loop.
		while (!StdIn.isEmpty()) {
			//String s will be the value provided in Standard Input. count will act as a counter each time the objective is located
			String s = StdIn.readString();
			int count = 0;
			
			//
			for (int i = 0; i <= database.length; i++) {
				//In the event the loop reaches the end, the bottom if statement end the print line, the for loop, and reset the while loop.
				if (i == database.length) StdOut.println();
				
				//If the if statement above isn't met, the loop will still continue.
				else if (i <= database.length) {
					//i represents each row for columns placed in keyField and valField. Their inputs are placed into key and val as a matching pair.
					//Loop statement will go down each row until it meets the end.
					String[] tokens = database[i].split(",");
					String key = tokens[keyField];
					String val = tokens[valField];
					
					//if the count variable matches with limit, the for loop will end early and reset.
					if (count >= limit) {
						StdOut.println();
						break;
					}
				
					//In the event key is found and is equal to input s, the following will occur.
					else if (key.equals(s)) {
						//the values for key and val will be put into the symbol table.
						st.put(key, val);
						//get() will print out the current value assigned to the key value in the chart.
						StdOut.print(st.get(key) + " ");
						//the symbol table is cleared of the current key and its current value.
						st.remove(key);
						//count will gain an extra value.
						count++;
					}
				}
			}
		}
    }
}
