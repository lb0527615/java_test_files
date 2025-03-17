public class TriangularTest
{
	public static boolean isTriangular(int a, int b, int c) 
	{
	//The above statement will assign the input functions of n1, n2, and n3 onto a, b, and c. Each of these variables will execute the following statements below, which will provide a return variable or either true or false for a later statement.
		if (a >= b + c) return false; 
		else if (b >= a + c) return false; 
		else if (c >= a + b) return false; 
		else return true;
		//Each of the following statements will check if one variable is greater than or equal to the sum of the other two. If greater, result will be assigned the variable of false, as the three sides cannot form a right triangle.
		//If neither of these statements can prove it's false, result will be assigned the variable of true.
	}
	


		
	public static void main(String[] args)
	{
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		int n3 = Integer.parseInt(args[2]);
		//The above variables will be assigned by the user for input, and will be processed into the static method.
		
		boolean result = isTriangular(n1, n2, n3);
		//The above variable result will be assigned the "result" variable given from isTriangular, when the static borrows the 3 integer variables given by the user.
		
		if (result == true){
			System.out.println("True");
		}
		//After completing isTriangular, the statement will print "True" if isTriangular returns true to result.
		else System.out.println("False");
		////After completing isTriangular, if the statement did not return true to result, the statement will print instead print "False".
	}
}
	