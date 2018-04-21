import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdOut;

public class QuickMerge_10 {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
//        if (aux[mid].compareTo(aux[mid+1]) > 0)      //2_8 a[mid] > a[mid+1] run merge()
//             merge(a, lo, mid, hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
//        StdOut.println("lo = "  + lo + ", mid = " + mid + ", hi = " + hi);
        Comparable[] aux = new Comparable[hi-mid];
//        int auxIndex = 0;
        for (int i =0, j = hi; i < aux.length ;j--, i++) {
            aux[i] = a[j];
        }
        for (int i = 0 ; i < aux.length; i++) {
            StdOut.print(" " + aux[i]);
        }
        StdOut.println();

        int firstpart = mid;
        int secondpart = 0;
//        int i = lo, j = a.length-1, aMid = mid;
        for (int k = hi; k >= lo; k--) {
//            StdOut.println("mid= " + aMid + " k= " + k + " j= " + j);
            if (secondpart >= aux.length-1)
                break;
            if (firstpart < 0) {
                for(int i = secondpart; secondpart >= aux.length-1; secondpart++) {
                    a[k] = aux[secondpart];
                    k--;
                }
                break;
            }

            if (less(a[firstpart], aux[secondpart])) {
                a[k] = a[firstpart];
                firstpart--;
            } else {
                a[k] = aux[secondpart];
                secondpart++;
            }
//            if (less(a[aMid], aux[k]) && auxIndex > k && aMid >= 0) a[j--] = a[aMid--];
//            else if (auxIndex <= k) break;
//            else if (aMid < 0) {
//                a[j--] = aux[auxIndex - 1];
//                auxIndex--;
//            } else a[j--] = aux[i++];
        }
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }

    public static void main(String[] args) {
        Comparable[] a = {9,8,7,6,5,4,3,2,1,99,87,9};
        QuickMerge_10.sort(a);
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
    }
}
