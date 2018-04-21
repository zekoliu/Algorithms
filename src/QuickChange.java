import edu.princeton.cs.algs4.StdOut;

public class QuickChange {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo,j-1);    //排序左边
        sort(a, j+1, hi);   //排序右边
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi+1;
        Comparable v = a[lo];
        int index = 0;

        for (int k = 1; k < a.length; k++) {    //find array max value
            if (a[index].compareTo(a[k]) > 0) {
                index = k;
            }
        }
        exch(a, index, a.length - 1);   //将最大值放在最后面
        while (true) {
            while (less(a[++i], v))   ;//if (i == hi)    break;       //向右扫描大于v的数
            while (less(v, a[--j]))   ;//if (j == lo)    break;       //向左扫描小于v的数
            if (i >= j)  break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static boolean less(Comparable a, Comparable b) {
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
        Comparable[] a = {9,8,7,6,7,8,9};
        QuickChange.sort(a);
        show(a);
    }
}
