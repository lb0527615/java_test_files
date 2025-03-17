public class Point
{
	private final double xx;
	private final double yy;
	private final double zz;
	//The three variables above are assigned double value for the constructor. Anything processed in this set of variables will process as double.
	
	public Point(double x, double y, double z)
	{
		xx = x;
		yy = y;
		zz = z;
		//Any objects that are created using the constructor will process as the variables of xx, yy, and zz in any statement.
	}
	
	public double distanceto(Point q) 
	{
		double x = q.xx - xx;
		double y = q.yy - yy;
		double z = q.zz - zz;
		//In executing p.distanceto, p will be assigned to xx, yy, and zz.
		//(Point q) will use will take object q (defined by the second set of coordinates), and assign each variable to q.xx, q.yy, and q.zz)
		//Variables x, y, and z will then be used in the next formula to find the Euclidean.
		
		return Math.sqrt((x * x) + (y * y) + (z * z));
		//x, y, and z will be processed in a Euclidean formula, where the result will fully process once they summed up after being multiplied by their own variables, and later square rooted.
	}
	
	public String toString()
	{
		return ("(" + xx + "," + yy + "," + zz + ")");
		//method toString will print a statement using the Constructor, with each variable being assigned a number based on the object variable used in executing the statement.
	
	}
	
	public static void main(String[] args)
	{
		double x1 = Double.parseDouble(args[0]);
		double y1 = Double.parseDouble(args[1]);
		double z1 = Double.parseDouble(args[2]);		
		double x2 = Double.parseDouble(args[3]);
		double y2 = Double.parseDouble(args[4]);
		double z2 = Double.parseDouble(args[5]);
		//The 6 variables are assigned based on the 6 input functions the user will provide.
		//x1, y1, and z1 represent coordinates for the first set of coordinates, p.
		//x2, y2, and z2 represent coordinates for the second set of coordinates, q.
		
		
		Point p = new Point(x1, y1, z1);
		Point q = new Point(x2, y2, z2);
		//The two formulas create objects, p and q, based on the user's inputs for their 2 sets of coordinates.
		//p represents the first set of coordinates, while q represents the second set of coordinates.
		
		
		System.out.println("The first point is " + p.toString());
		System.out.println("The second point is " + q.toString());
		//The first two print statements will use method toString and will use the object
		//p.String will use the first set of coordinates, q.String will use the second set of coordinates.
		
		System.out.printf("The Euclidean distance is " + "%.2f", p.distanceto(q));
		//p.distanceto(q) will assign the value of the first set of coordinates to the constructor values.
		//(q) will assign the second set of coordinates to a specialized set of constructor values.
		//print f will print out the return variable of distanceto with no more than 2 decimals.
		System.out.println();
		//The function will print and end.
	}
}