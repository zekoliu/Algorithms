import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class TwoSumFaster {

    public static int count(int[] array) {
        Arrays.sort(array);
        int len = array.length;
        int countSize = 0;
        int low = len / 2;
        int height = low + 1;
        for (int i = 0; i < len; i++) {
            if ((array[low] + array[height]) > 0 && (low > 0 && height < len))
                low--;
            else if ((array[low] + array[height] < 0) && (low > 0 && height < len))
                height++;
            else if ((array[low] + array[height] == 0) && (low > 0 && height < len))
                countSize++;
        }
        return countSize;
    }

    public static int threeCount(int[] array) {
        Arrays.sort(array);
        int len = array.length;
        int count = 0;
        int low = len / 2;
        int height = low + 1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (-array[i] + array[low] + array[height] > 0)
                    low--;
                else if (-array[i] + array[low] + array[height] < 0)
                    height++;
                else
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
    }
}
