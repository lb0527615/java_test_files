public class Square {
	
	private final double xx;
	private final double yy;
	private final double zz;
	//The three variables above are assigned double value for the constructor. Anything processed in this set of variables will process as double.
	
	//Any objects that are created using the constructor will process as the variables of xx, yy, and zz in any statement.
	public Square(double x, double y, double length) {
		xx = x;
		yy = y;
		zz = length;

	}
	
	//returns the area of the square, using length
	public double area() {
		return zz * zz;
	}
	
	//returns the perimeter of the square, using length
	public double perimeter() {
		return 4 * zz;
	}	

	//Intersection occurs if a single corner piece of a square is located in either square. The formulas below determines if each square could be found.
	public boolean intersects(Square b) {
		//top left corner piece
		if ((xx <= b.xx && b.xx <= (xx+zz))&&((yy >= b.yy) && b.yy >= (yy-zz))) return true;
		else if ((b.xx <= xx && xx <= (b.xx+b.zz))&&((b.yy >= yy) && yy >= (b.yy-b.zz))) return true;
		//bottom left corner piece
		else if ((xx <= b.xx && b.xx <= (xx+zz))&&((yy >= (b.yy-b.zz)) && (b.yy-b.zz) >= (yy-zz))) return true;
		else if ((b.xx <= xx && xx <= (b.xx+b.zz))&&((b.yy >= (yy-zz)) && (yy-zz) >= (b.yy-b.zz))) return true;
		
		//top right corner piece
		else if ((xx <= (b.xx+b.zz) && (b.xx+b.zz) <= (xx+zz))&&((yy >= b.yy) && b.yy >= (yy-zz))) return true;
		else if ((b.xx <= (xx+zz) && (xx+zz) <= (b.xx+b.zz))&&((b.yy >= yy) && yy >= (b.yy-b.zz))) return true;
		
		//bottom right corner piece
		else if ((xx <= (b.xx+b.zz) && (b.xx+b.zz) <= (xx+zz))&&((yy >= b.yy) && (b.yy-b.zz) >= (yy-zz))) return true;
		else if ((b.xx <= (xx+zz) && (xx+zz) <= (b.xx+b.zz))&&((b.yy >= yy) && (yy-zz) >= (b.yy-b.zz))) return true;
		
		else return false;
	}
	
	//Determines if all fours corners of Square a are located in Square b in the form of determining if b contains a.
	public boolean contains(Square b) {
		if (((b.xx <= xx && xx <= (b.xx+b.zz))&&((b.yy >= yy) && yy >= (b.yy-b.zz))) && ((b.xx <= xx && xx <= (b.xx+b.zz))&&((b.yy >= (yy-zz)) && (yy-zz) >= (b.yy-b.zz))) && ((b.xx <= (xx+zz) && (xx+zz) <= (b.xx+b.zz))&&((b.yy >= yy) && yy >= (b.yy-b.zz))) && ((b.xx <= (xx+zz) && (xx+zz) <= (b.xx+b.zz))&&((b.yy >= yy) && (yy-zz) >= (b.yy-b.zz)))) return true;
		else return false;
	}
	
	//Draws both squares in a new window.
	public void draw(Square b) {
		StdDraw.square((b.xx + (b.zz/2)), (b.yy - (b.zz/2)), b.zz/2);
		StdDraw.square(xx + (zz/2), yy - (zz/2), zz/2);
	}
	

	public static void main(String[] args) {
		//Parses the three values and converts them into doubles.
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);
		double length = Double.parseDouble(args[2]);
		//assigns a constructor value to args input.
		Square a = new Square(x, y, length);
		
		//Right away, the area and perimeter for the first square is calculated, using the length.
		StdOut.printf("The area is " + "%.2f", + a.area());
		StdOut.println();
		StdOut.printf("The perimeter is " + "%.2f", a.perimeter());
		StdOut.println();
		StdOut.print("Enter the upper-left coordinates and the length of a square:");
		
		//The function will enter into standard input after the last line is printed out.
		while (!StdIn.isEmpty()) {
			//The first three double values provided will be converted into variables for a special constructor known as Square b.
			double x2 = StdIn.readDouble();
			double y2 = StdIn.readDouble();
			double length2 = StdIn.readDouble();
			Square b = new Square(x2, y2, length2);
			
			//Checks if either of the two squares do intersect with each other.
			boolean intersection = a.intersects(b);
			if (intersection == true) StdOut.println("It intersects the first square.");
			else StdOut.println("It does not intersect the first square.");
			
			//Checks to see if the first square is in square b.
			boolean contain = a.contains(b);
			if (contain == true) StdOut.println("It contains the first square.");
			else StdOut.println("It does not contain the first square.");
			
			//After the values are printed, the command will then draw both squares.
			b.draw(a);
			
			//javac -classpath .;stdlib.jar Square.java
		}
	}
}