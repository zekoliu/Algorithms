import edu.princeton.cs.algs4.StdOut;

public class HeapTop {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            if (N > i)
                swim(a, N);
            N = a.length;
        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable tep = a[i-1];
        a[i-1] = a[j-1];
        a[j-1] = tep;
    }

    private static void swim(Comparable[] a, int k) {
        while (k > 1 && less(a, k / 2, k)) {
            exch(a, k/2, k);
            k = k / 2;
        }
    }

    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    public static void main(String[] args) {
        Comparable[] a ={"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E", "P", "Z"};
        HeapTop.sort(a);
        for (int i = 0 ; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
}
