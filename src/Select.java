import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Select {

    public static Comparable select(Comparable[] a, int k) {
        StdRandom.shuffle(a);
        int lo = 0, hi = a.length - 1;
        return sort(a, lo, hi, k);
//        while (hi > lo) {
//            show(a);
//            int j = partition(a, lo, hi);
//            if      (j == k)    return a[k];
//            else if (j > k)     hi = j - 1;
//            else if (j < k)     lo = j + 1;
//        }
//        return a[k];
    }

    public static Comparable sort(Comparable[] a, int lo, int hi, int k) {
        int j = partition(a, lo, hi);
        if (hi > lo && j == k)
            return a[j];
        else if (hi > lo && j < k) {
            hi = j - 1;
            sort(a, lo, hi, k);
        }
        else if (hi > lo && j > k) {
            lo = j + 1;
            sort(a, lo, hi, k);
        }
        return a[k];
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];

        while (true) {
            while (less(++i, v))    if (i == hi)  break;
            while (less(v, --j))    if (j == lo)  break;
            if (i >= j)  break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void show(Comparable[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        Comparable[] a = {1 ,2, 3, 4, 5, 6, 7, 8, 9, 0};
        int k = 4;
        StdOut.print(select(a, k) + "     ");
    }
}
