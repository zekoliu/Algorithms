import edu.princeton.cs.algs4.StdOut;

public class TestMegre {

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        Comparable[] aux = new Comparable[a.length];
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        for (int k = lo; k <= hi; k++)
            if (i > mid)        a[k] = aux[j++];
            else if (j > hi)    a[k] = aux[i++];
            else if (aux[i].compareTo(aux[j]) > 0)  a[k] = aux[j++];
            else if (aux[i].compareTo(aux[j]) <= 0) a[k] = aux[i++];
    }

    public static void main(String[] args) {
        Comparable[] a = {1,3,5,7,2,4,6,8};
        int lo = 0;
        int mid = a.length / 2;
        int hi = a.length - 1;
        merge(a, lo, mid, hi);
        for (int i = 0; i < hi; i++)
            StdOut.print(a[i] + " ");
    }
}
