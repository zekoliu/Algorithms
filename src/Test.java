import edu.princeton.cs.algs4.StdOut;

public class Test2_9 {

    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        for (int k = lo; k <= hi; k++)
            if (i > mid)        a[k] = aux[j++];
            else if (j > hi)    a[k] = aux[i++];
            else if (aux[i].compareTo(aux[j]) > 0)  a[k] = aux[j++];
            else if (aux[i].compareTo(aux[j]) <= 0) a[k] = aux[i++];
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi-lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    public static void main(String[] args) {
        Comparable[] a = {1,3,5,7,2,4,6,8};
        Comparable[] aux = new Comparable[a.length];
        int lo = 0;
        int mid = a.length / 2;
        int hi = a.length - 1;
        Test2_9.sort(a);
        for (int i = 0; i < hi; i++)
            StdOut.print(a[i] + " ");
    }
}
