import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quick {

    public static int count = 0;
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
//        if (j - lo <= 2 || hi - (j+1) <= 2)     //3_7
//            count++;
        sort(a, lo,j-1);    //排序左边
        sort(a, j+1, hi);   //排序右边
    }

    private static int partition(Comparable[] a, int lo, int hi) {
//        StdOut.println("lo = " + lo + ", hi = " + hi);

        int i = lo, j = hi+1;
        Comparable v = a[lo];

        while (true) {
            while (less(a[++i], v))   if (i == hi)    break;       //向右扫描大于v的数
            while (less(v, a[--j]))   if (j == lo)    break;       //向左扫描小于v的数
            if (i >= j)  break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static boolean less(Comparable a, Comparable b) {
//        count++;    //2_8
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
        Comparable[] a = {9,9,9,9,9,9,9};
        Quick.sort(a);
        show(a);
//        StdOut.println("count = " + count);
    }
}
