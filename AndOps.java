public class AndOps
{
    public static void main(String[] args)
    {
		//both a and b will be inputs defined by the user as variables set between 0.0 and 1.0. Variables cannot equal these numbers.
        double a = Double.parseDouble(args[0]);
		double b = Double.parseDouble(args[1]);
		//this will print out a boonlean function that is defined if a and b are both set between 0 and 1.
		System.out.println(0<a&&b<1);
	}
}