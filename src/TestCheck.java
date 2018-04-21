import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdOut;

public class TestCheck {

    public static boolean check(Comparable[] a) {
        Comparable[] temp = new Comparable[a.length];
        temp = copyArr(a, temp);
        Quick.sort(temp);
        if (isElement(a, temp) && isSorted(temp))
            return true;
        return false;
    }

    public static Comparable[] copyArr(Comparable[] a, Comparable[] temp) {
        int len = a.length;
        for (int i = 0; i < len; i++)
            temp[i] = a[i];
        return temp;
    }

    public static boolean isSorted(Comparable[] a) {
        int len = a.length;
        for (int i = 1; i < len; i++)
            if (a[i].compareTo(a[i-1]) < 0)
                return false;
        return true;
    }

    public static boolean isElement(Comparable[] a, Comparable[] b) {
        int len = a.length;
        for (int i = 0; i < len; i++)
            if (BinarySearch(a[i], b).equals(-1))
                return false;
        return true;
    }

    public static Comparable BinarySearch(Comparable key, Comparable[] a) {
        int len = a.length;
        int low = 0;
        int high = len;
        while (high > low)  {
            int half = (low + high) / 2;
            if (key.compareTo(a[half]) > 0) low = half;
            else if (key.compareTo(a[half]) < 0) high = half;
            else {
                return a[half];
            }
        }
        return -1;
    }

    public static void show(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static void main(String[] args) {
        Comparable[] a = {1,1,4,3,21,5,63,2,6,32,5};
//        int key = 2;
//        StdOut.println(BinarySearch(key, a));
        StdOut.print(check(a));
    }
}
