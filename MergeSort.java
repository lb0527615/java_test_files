public class MergeSort {

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid;
        for (int k = lo; k < hi; k++) {
            if      (i == mid)                 aux[k] = a[j++];
            else if (j == hi)                  aux[k] = a[i++];
            else if (a[j].compareTo(a[i]) < 0) aux[k] = a[j++];
            else                               aux[k] = a[i++];
        }

        // copy back
        for (int k = lo; k < hi; k++)
            a[k] = aux[k];
    }
	//The merge method will sort the values of the array specificed by lo, mid, and hi into the aux array, then placed back into the a array.
    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {

        // base case
        if (hi - lo <= 1) return;

        // sort each half, recursively
        int mid = lo + ((hi - lo)/2);
        sort(a, aux, lo, mid);
        sort(a, aux, mid, hi);

        // merge back together
        merge(a, aux, lo, mid, hi);
    }
    //After entering into the first sort method, it will then enter into this sort method, where the middle of the array to be sorted will be defined. The array will then be split in half, and processed into the merge method.
	@SuppressWarnings({"rawtypes", "unchecked"})
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i].compareTo(a[i-1]) < 0) return false;
        return true;
    }
	//The isSorted method ensures the code is sorted properly.
	
	
    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] a, int lo, int hi) {
        int n = a.length;
        Comparable[] aux = new Comparable[n];
		//aux will be a temporary array to store and sort the array function. It will have the same length as a.
        sort(a, aux, lo, hi);
    }
	//The above sort method will take the integers and the array and will create an array to store the a array temporarlily in order to sort it back into a.

    public static void main(String[] args) {
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		//The above two variables will take the integers provided in args and will use the numbers provided to sort the array in between the variables given.
		int l = (args.length - 2);
		//int l defines the length of the copied array, where it will remove the integer values of n1 and n2 from the array.
		String[] a = new String[l];
		System.arraycopy(args, 2, a, 0, l);
		//String []a is created and becomes a duplicate of the args array beginning at args[2].
		MergeSort.sort(a, n1, n2+1);
		//The formula is then processed into the sort method, where specific variables will be sorted as per user input.
		assert isSorted(a);
		//isSorted will ensure the array is successfully sorted.
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		//Once the array is sorted, the for statement will print out the new array that is either partially or fully organized.
		System.out.println();
		//The program will end once achieving its given task.
	}
}


