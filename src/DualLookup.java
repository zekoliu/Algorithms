import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class DualLookup {

    public static boolean isElement(int value, int[] array) {
        int[] temp = array;
        Arrays.sort(temp);  //排序找出最大元素

        int max = temp[temp.length - 1];
        int maxIndex = BinarySearch.indexOf(array, max);   //最大元素下标

        int[] beforeArray = new int[maxIndex];          //分割为两个不同数组
        int[] rearArray = new int[array.length - maxIndex];
        divideTwoArray(beforeArray, rearArray, array, maxIndex);
        Arrays.sort(rearArray);

        if (BinarySearch.rank(value, beforeArray) != -1)
            return true;
        else if (BinarySearch.rank(value, rearArray) != -1)
            return true;
        else
            return false;
    }

    public static void divideTwoArray(int[] beforeArray, int[] rearArray, int[] array, int maxIndex) {
        for (int i = 0; i < maxIndex; i++)
            beforeArray[i] = array[i];

        for (int i = maxIndex; i < array.length; i++)
            rearArray[i] = array[i];
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,5,4,3,2,1};
        if (isElement(4, a))
            StdOut.print("good");
    }
}
