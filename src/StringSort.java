import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdOut;

public class StringSort {

    private static String[] dedup(String[] a) {
        Quick.sort(a);
        String[] temp = new String[a.length];
        int len = a.length, tempIndex = 0;
        for (int i = 0; i < len; i++)
            if (i == 0)
                temp[tempIndex] = a[i];
            else {
                if (temp[tempIndex] != a[i])
                    temp[++tempIndex] = a[i];
            }
        return temp;
    }

    public static void main(String[] args) {
        String[] a = {"kobe", "kobe", "zeko", "curry", "kobe"};
        a = dedup(a);
        for (int i = 0; i < a.length && a[i] != null; i++)
            StdOut.print(a[i] + " ");
    }
}
