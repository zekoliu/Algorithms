import edu.princeton.cs.algs4.BinarySearch;

import java.util.Arrays;

public class FourSum {

    public static int count(int[] a) {      //暴力算法
        int length = a.length;
        int cnt = 0;
        for (int i = 0; i < length; i++)
            for (int j = i+1; j < length; j++)
                for (int k = j+1; k < length; k++)
                    for (int l = k+1; l < length; l++)
                        if (a[i] + a[j] + a[k] + a[l] == 0)
                            cnt++;
        return cnt;
    }

    public static int countFast(int[] a) { //比暴力算法效率高一点
        Arrays.sort(a);
        int length = a.length;
        int cnt = 0;
        for (int i = 0; i < length; i++)
            for (int j = i+1; j < length; j++)
                for (int k = j+1; k < length; k++)
                    if (BinarySearch.rank(-a[i]-a[j]-a[k], a) > k)
                        cnt++;
        return cnt;
    }
}
