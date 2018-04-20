import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdOut;

public class EqualElement_12 {

    public static int count(int[] firstArr, int[] secondArr) {
        int cnt = 0;
        int length = firstArr.length;
        for (int i = 0; i < length; i++)
            if (BinarySearch.rank(firstArr[i], secondArr) > 0)
                cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = {1,3,4,5,5,6,7,8,8,9,8};
        int[] b = {1,3,4,12,12,12,12,12};
        StdOut.printf("%d\n", count(a, b));
    }
}
