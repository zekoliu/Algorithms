import edu.princeton.cs.algs4.StdOut;

public class Qucik3WayFast {

    public static void sort(Comparable[] a, int lo) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;

        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi +1;
        Comparable v = a[lo];

        while (true) {
            while (less(a[++i], v))     if (i == hi) break;
            while (less(v, a[--j]))     if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static Comparable[] segmentationArr(Comparable[] a, int lo, int hi) {
        int p = lo, q = hi;
        Comparable v = a[lo];
        for (int index = 1; index < q; index++) {   //切相同数
            if (equal(v, a[q])) {
                index--;
                q--;
                continue;
            }
            else if (equal(a[p], v)) {
                p++;
                continue;
            }
            else if (equal(a[index], v) && (p == (hi - q)))
                exch(a, index, q--);
            else if (equal(a[index], v) && (p != (hi - q))) {
                exch(a, index, p++);
            }
        }

        int i = p, j = q;
        for (int index = p; index < q; index++)     //切大小数
            if (less(a[i], v) && i <= j) {
                i++;
                continue;
            }
            else if (less(a[index], v) && i <= j)
                exch(a, index, i++);
            else if (less(v, a[index]) && i <= j)
                exch(a, index, j--);

        show(a);
        Comparable[] temp = new Comparable[a.length];
        int len = a.length, iCurrent = p, pCurrent = lo, qCurrent = q + 1;
        StdOut.println("qcr= " + qCurrent + " hi= " + hi);
        for (int aIndex = 0; aIndex < len; aIndex++) {
            if (iCurrent < i) {
                temp[aIndex] = a[iCurrent++];
                continue;
            }
            else if (pCurrent < p) {
                temp[aIndex] = a[pCurrent++];
                continue;
            }
            else if (qCurrent <= hi) {
                temp[aIndex] = a[qCurrent++];
                continue;
            } else if (iCurrent <= q){
                temp[aIndex] = a[iCurrent++];
            }
        }
        return temp;
    }

    private static boolean equal(Comparable a, Comparable b) {
        return a.compareTo(b) == 0;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static void main(String[] args) {
        Comparable[] a = {4, 3, 4, 4, 4, 51, 4, 4, 5, 6, 78, 4, 4, 4, 4,23,2,1,3,1,1,4};
        a = segmentationArr(a, 0, a.length - 1);
        show(a);
    }
}
