import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class KeyInsertSort {

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            if (less(a[i], a[i-1]))
                return false;
        return true;
    }

    public static void insertSort(Comparable[] a) {
        int len = a.length;
        int minElementIndex = 0;
        for (int n = 1; n < len; n++)
            if (less(a[n], a[minElementIndex]))
                minElementIndex = n;
        exch(a, 0 ,minElementIndex);
        for (int i = 1; i < len; i++) {
            for (int j = i; less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
        }
    }

    public static void main(String[] args) {
        Comparable[] a = {30 ,1, 12, 12, 34, 12, 34, 45, 90, 45, 23,12, 23,34,45, 56, 5,6,67,23, 2,1, 3333, 4444,6,23,46,5756,1232,345,646,7,5672,2};
        Comparable[] b = {30 ,1, 12, 12, 34, 12, 34, 45, 90 , 45, 23,12, 23,34,45, 56, 5,6,67,23, 2,1, 3333, 4444,6,23,46,5756,1232,345,646,7,5672,2};
        Stopwatch time = new Stopwatch();
        insertSort(a);
        StdOut.println(time.elapsedTime());
        show(a);
        Stopwatch time1 = new Stopwatch();
        Insertion.sort(b);
        StdOut.println(time1.elapsedTime());
        show(b);
    }
}
