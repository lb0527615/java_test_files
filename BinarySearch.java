import java.util.Arrays;

public class BinarySearch {


    public static int search(int key, int [] a, int lo, int hi){
    int n = a.length;
	//n counts the total length of the txt array, which is used later to determine the value of the search.
	if (hi > lo){
		int mid = lo + (hi - lo) / 2;
		//mid will reset the value each time it is used.
        if ((mid == n-1 || key < a[mid+1]) && a[mid] == key)
            return mid;
			//In the event the variable is found when dividing, it will return the value of mid.
        else if (key < a[mid])
            return search(key, a, lo, (mid-1));
        else return search(key, a, (mid+1), hi);
		//Depending on if the key is above or below the middle value.
		//Top statement will return if key is below the middle value, bottom will occur if it's above the middle value.
    }
	//Once the variable that is needed to be found is found, it will enter into once the following three return statements based on certain qualities.
	else if(hi == lo && n == hi) {
        return -1*(lo);
	}
	//Returns the next highest value as a negative
	else if(lo > hi) {
		return -1;
   	//In the event the key doesn't exist or it cannot be found, it will return -1.
    }
	return -1*((lo)-1);
	//An alternative way to return the next highest value as a negative.
	}

   public static void main(String[] args) {
   In in = new In(args[0]);
   int[] a = in.readAllInts();
   //The first two lines will take the text file used and process it as an array function. In will read the text file, and call it function in, where it will be converted into an integer array known as a.
   
   int key = Integer.parseInt(args[1]);
   //The second input function, an integer number, will be named key to be used in the BinarySearch.
   
   StdOut.println(search(key, a, 0, a.length-1));
   //The function will then run the search method using the values of int key, int array a, and the high and low values of the array that begin at 0 and end at the array length subtracted by 1.
   }
}
