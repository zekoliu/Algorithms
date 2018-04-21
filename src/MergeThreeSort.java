import edu.princeton.cs.algs4.StdOut;

public class MergeThreeSort_22 {

    public static void merge(Comparable[] a, int lo, int fistMid, int secondMid, int hi) {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        int i = lo, j = fistMid, l = secondMid, temp;

        for (int k = lo; k <= hi; k++) {
            if (i > fistMid)                                        //是否超界
                if      (j > secondMid)             a[k] = aux[l++];
                else if (l > hi)                    a[k] = aux[j++];
                else if (lessTwoCompa(a[l], a[j]))  a[k] = aux[l++];
                else                                a[k] = aux[j++];
            else if (j > secondMid)
                if      (i > fistMid)               a[k] = aux[l++];
                else if (l > hi)                    a[k] = aux[i++];
                else if (lessTwoCompa(a[l], a[i]))  a[k] = aux[l++];
                else                                a[k] = aux[i++];
            else if (l > hi)
                if      (i > fistMid)               a[k] = aux[j++];
                else if (j > secondMid)             a[k] = aux[i++];
                else if (lessTwoCompa(a[j], a[i]))  a[k] = aux[j++];
                else                                a[k] = aux[i++];
            else if (lessThreeCompa(a[i], a[j], a[l]) == a[i])      a[k] = aux[i++];      //谁小要谁
            else if (lessThreeCompa(a[i], a[j], a[l]) == a[j])      a[k] = aux[j++];
            else if (lessThreeCompa(a[i], a[j], a[l]) == a[l])      a[k] = aux[l++];
        }
    }

    public static Comparable lessThreeCompa(Comparable a, Comparable b, Comparable c) {
        if ((a.compareTo(b) <= 0 && a.compareTo(c) <= 0))
            return a;
        if (b.compareTo(a) <= 0 && b.compareTo(c) <= 0)
            return b;
        return c;
    }

    public static boolean lessTwoCompa(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void main(String[] args) {
        Comparable[] a = {1,4,7,2,5,8,6,9};
        merge(a, 0, 3, 6, 7);
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
    }
}
