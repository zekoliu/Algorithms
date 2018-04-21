import edu.princeton.cs.algs4.StdOut;

public class HeapTail {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int k = N/2; k >= 1; k--)
            sink(a, k, N);

        while (N > 1) {
            exch(a, 1 , N--);
            sink(a, 1, N);
        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable tep = a[i-1];
        a[i-1] = a[j-1];
        a[j-1] = tep;
    }

    private static void sink(Comparable[] a, int k, int N) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(a, j, j+1))  j++;
            if (!less(a, k, j))    break;;
            exch(a, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    public static void main(String[] args) {
        Comparable[] a ={"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        HeapTail.sort(a);
        for (int i = 0 ; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
}
