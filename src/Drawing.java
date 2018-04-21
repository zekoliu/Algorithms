import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class Drawing {

    public static void insertSort(Comparable[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
            drawing(a);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void drawing(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            double x = 1.0 * i / N;
            double y = ((double)a[i]) / 2.0;
            double rw = 0.5 / N;
            double rh = (double)a[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            if (less(a[i], a[i-1]))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Comparable[] a = {8.0,1.0,3.0,2.0,3.0,3.0,5.0};
        insertSort(a);
    }
}
