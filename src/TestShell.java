import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class TestShell {

    public static void main(String[] args) {
        int N = 10;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i; j++) {
                N = N * 10;
            }
            Double[] arr = new Double[N];
            for (int k = 0; k < N; k++)
                arr[k] = StdRandom.uniform();
            shellSort(arr);
        }
    }

    public static void shellSort(Comparable[] a) {
        int N = a.length;
        int count = 0;
        int h = 1;
        while (h < N/3) h = 3*h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++)
                for (int j = i; j >= h && less(a[j], a[j-h]); j-= h) {
                    exch(a, j, j - h);
                    count++;
                }
            h = h / 3;
        }
//        StdOut.print(N + " " + count + "\n");
        StdOut.println((double)N / (double)count);
    }


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
}
