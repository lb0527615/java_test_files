public class Merge {

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
    
	@SuppressWarnings({"rawtypes", "unchecked"})
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i].compareTo(a[i-1]) < 0) return false;
        return true;
    }
	
    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] a, int lo, int hi) {
        int n = hi - lo + 1;
        Comparable[] aux = new Comparable[n];
        sort(a, aux, lo, hi);
    }

    public static void main(String[] args) {
		if (args.length < 3) {
			System.out.println("Insufficient arguments. Please provide at least 3 arguments.");
			return;
		}
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		int startIndex = 2;
		int endIndex = args.length-1;
		int l = endIndex - startIndex + 1;
		int newIndex = 0;
		if (l <=0) {
			System.out.println("No elements to sort.");
			return;
		}
		String[] a = new String[l];
		System.arraycopy(args, startIndex, a, newIndex, l);
		MergeSort.sort(a, n1, n2);
		assert isSorted(a);
		for (int i = 0, i <= a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}


