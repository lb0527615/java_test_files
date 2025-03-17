import java.util.*;

public class Histogram {
	
	public static void draw(double x, double y, double w, double h) {
		StdDraw.rectangle(x, y, w, h);
	}
	
	public static void main(String[] args) {
	
		while (!StdIn.isEmpty()) {
           
		   //The first three integers in the file will process as the values of n, left, and right.
			final double n = StdIn.readDouble();
            final double left = StdIn.readDouble();
            final double right = StdIn.readDouble();
			//blocklength determines the x value each block will get.
			double blocklength = ((right - left)/n);
			//Remaining integers will process in the value array.
			double[] value = StdIn.readAllDoubles();
			
			//a counter is set to 0 for each value.
			double count = 0;
			//leftside and rightside are the exact length of the rectangle
			double leftside = left;
			double rightside = left + blocklength;
			
			//the graph is created in scale based on the x values for left and right, and the y values based on the total number of values in the array value.
			StdDraw.setYscale(-1, value.length);
			StdDraw.setXscale((left-blocklength), (right+blocklength));
			while (count < n) {
				//height will count the number of values in the array between the set leftside and rightside amounts.
				double height = 0;
				
				//The for loop will process each value remaining in the txt file.
				for (int i = 0; i < value.length; i++) {
					double item = value[i];
					if (leftside <= item && item < rightside) {
						height++;
						
					}
				}
				double x = (leftside + (blocklength/2));
				double y = (height/2);
				double w = (blocklength/2);
				double h = (height/2);
				StdOut.println(height + " " + x + " " + y + " " + w + " " + h);
				//A rectangle will be drawn based on the determined values each time.
				draw(x, y, w, h);
				//new values will be set for leftside and rightside, as well as count.
				leftside = leftside + blocklength;
				rightside = rightside + blocklength;
				count++;
			}
			//a line will be drawn at the end for the bottom of the histogram.
			StdDraw.line((left-blocklength), 0, (right+blocklength), 0);
			
		}
	}
}