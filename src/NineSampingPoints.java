import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class NineSampingPoints {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi)   return;
        if (hi - lo > 5)
            setKey(a, findKey(a, lo, (a.length / 3) / 2, a.length / 3),
                    findKey(a, a.length / 3,  (a.length / 3 + 2 * a.length / 3) / 2, 2 * a.length / 3),
                    findKey(a, 2 * a.length / 3, ((2 * a.length / 3 + a.length) / 2), a.length-1));
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi+1;
        Comparable v = a[lo];

        while (true) {
            while (less(a[++i], v))     if (i == hi) break;
            while (less(v, a[--j]))     if (j == lo) break;
            if (i >= j)  break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static void setKey(Comparable[] a, int start, int mid, int end) {
        if ((less(a[start], a[mid]) && less(a[mid], a[end])) || (less(a[end], a[mid]) && less(a[mid], a[start])))
            exch(a, start, mid);
        else if (less(a[start], a[end]) && less(a[end], a[mid]) || (less(a[mid], a[end]) && less(a[end], a[start])))
            exch(a, start, end);
    }

    public static int findKey(Comparable[] a, int start, int mid, int end) {
        if ((less(a[start], a[mid]) && less(a[mid], a[end])) || (less(a[end], a[mid]) && less(a[mid], a[start])))
            return mid;
        else if (less(a[start], a[end]) && less(a[end], a[mid]) || (less(a[mid], a[end]) && less(a[end], a[start])))
            return end;
        return start;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static Boolean less(Comparable a, Comparable b) {
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
        ThreeSamplingPoints.sort(a);
        show(a);
    }
}
