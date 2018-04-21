import edu.princeton.cs.algs4.StdOut;
import java.util.Comparator;
import java.util.Date;

public class ForcedStability {

    public static void sort(Object[] a, Comparator c) {
        int N = a.length;
        for (int i = 0; i < N; i++)
            for (int j = i; j > 0 && less(c, a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
    }

    public static void selectsort(Object[] a, Comparator c) {
        int N = a.length;
        for (int i = 0; i < N - 1; i++) {
            int k = i;
            for (int j = k; j < N; j++)
                if (less(c, a[j], a[k]))
                    k = j;
            exch(a, i, k);
        }
    }

    private static boolean less(Comparator c, Object v, Object w) {
        return c.compare(v, w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void printTransation(Volume[] t) {
        for (int i = 0; i < t.length; i++) {
            StdOut.println(t[i].toString());
        }
    }

    public static int monthToNum(String mon) {
        if      (mon.equals("Jan"))  return 1;
        else if (mon.equals("Feb"))  return 2;
        else if (mon.equals("Mar"))  return 3;
        else if (mon.equals("Apr"))  return 4;
        else if (mon.equals("May"))  return 5;
        else if (mon.equals("Jun"))  return 6;
        else if (mon.equals("Jul"))  return 7;
        else if (mon.equals("Aug"))  return 8;
        else if (mon.equals("Sep"))  return 9;
        else if (mon.equals("Oct"))  return 10;
        else if (mon.equals("Nov"))  return 11;
        else                         return 12;
    }

    public static void main(String[] args) {
        Volume v = new Volume(new Date(10-monthToNum("Dev")-10), 200000.0);
        Volume v1 = new Volume(new Date(12-monthToNum("Oct")-12), 100000.0);
        Volume v2 = new Volume(new Date(23-monthToNum("Jul")-14), 130000.0);
        Volume v3 = new Volume(new Date(22-monthToNum("Jan")-12), 101000.0);
        Volume v4 = new Volume(new Date(13-monthToNum("Dev")-13), 100100.0);
        Volume[] vs = {v, v1, v2, v3, v4};
        sort(vs, new Volume.WhenOrder());
        printTransation(vs);
        StdOut.println();
        selectsort(vs, new Volume.HowMuchOrder());
        printTransation(vs);
    }
}

