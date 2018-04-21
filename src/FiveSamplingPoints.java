import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.net.CookieManager;

public class FiveSamplingPoints {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        if (hi - lo > 10)
            key(a);
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];

        while (true) {
            while (less(a[++i], v))     if (i == hi) break;
            while (less(v, a[--j]))     if (j == lo) break;
            if (i >= j)     break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void key(Comparable[] a) {
        Comparable[] tep = new Comparable[5];
        for (int i = 0; i < 5; i++)
            tep[i] = a[StdRandom.uniform(0, a.length)];
        Insertion.sort(tep);
        Comparable midEle = a[tep.length / 2 + 1];
        int i = findIndex(a, midEle);
        exch(a, 0, i);
    }

    private static int findIndex(Comparable[] a, Comparable key) {
        for (int i = 0; i < a.length; i++)
            if (a[i].compareTo(key) == 0)
                return i;
        return -1;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static void main(String[] args) {
        Comparable[] a = new Comparable[20];
        for (int i = 0; i < 20; i++)
            a[i] = StdRandom.uniform(1, 50);
        FiveSamplingPoints.sort(a);
        show(a);
    }
}
