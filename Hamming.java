import java.util.*;

public class Hamming {
	

   
	//create will determine each value to change
   private static List<String> create(int k, String s) {
    List<String> result = new ArrayList<>();
    process(k, s.toCharArray(), 0, result);
    return result;
	}


   private static void process(int k, char[] s, int count, List<String> result) {
	    
		//This line of command prevents the argument from printing a blank line.
		if (k == 0) {
			result.add(new String(s));
			return;
		}

		// for loop will alter the characters of the bit strings. Either the if or the else statements will occur if the chracter being read is either 0 or 1.
		for (int i = count; i < s.length; i++) {
			if (s[i] == '0') {
				s[i] = '1';
				process(k-1, s, i+1, result);
				s[i] = '0';
			} 
			
			else {
				s[i] = '0';
				process(k-1, s, i+1, result);
				s[i] = '1';
			}
			
		}
	}

	public static void main(String[] args) {

		//The integer and string argument are converted to values k and s.
		int k = Integer.parseInt(args[0]);
		String s = args[1];
		
		// The values will be placed into a generator, and will be processed into a list called result.
		List<String> result = create(k, s);
		
		//The for each loop will go through each value for result, and print them out.
		for (String str : result) {
			System.out.print(str + " ");
			}
		
		//Once all values are acquired, the program will end.
		System.out.println();
	}
}