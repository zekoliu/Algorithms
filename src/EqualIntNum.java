import edu.princeton.cs.algs4.BinarySearch;

public class EqualIntNum {

    public static int count(int[] a) {
        int length = a.length;
        int cnt = 0;
        for (int i = 0; i < length; i++)
            for (int j = i + 1; j < i+1; j++)
                if (a[i] == a[j])
                    cnt++;
        return cnt;
    }

    public static int BinarySortCount(int[] a) {
        int lenght = a.length;
        int cnt = 0;
        for (int i = 0; i < lenght; i++)
            if (BinarySearch.rank(a[i], a) > i)
                cnt++;
        return cnt;
    }
}
