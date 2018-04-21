import edu.princeton.cs.algs4.StdOut;

public class Sort2Distinct {

    public static void sort(Comparable[] a) {
        int lt = 0, gt = a.length - 1;
        int i = 0;
        while (gt >= lt) {
            int cmp = a[i].compareTo(a[lt]);
            if      (cmp > 0)         exch(a, lt++, i++);
            else if (cmp < 0)         exch(a, i, gt--);
            else                      i++;
        }
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
    }

    public static void main(String[] args) {
        Comparable[] a =  {9,9,1,1,9,9,1,9,1,1};
        Sort2Distinct.sort(a);
        show(a);
    }
}
