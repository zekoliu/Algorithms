import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearch {

    public static  int binarySearch(int array[], int key) {
        int lo = array[0];
        int hi = array[array.length - 1];
        while (hi >= lo) {
            int mid = (hi + lo) / 2;
            StdOut.printf("%2d\n", mid);
            if (key > mid) {
                lo = mid - 1;
            }
            else if (key < mid){
                hi = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            if (binarySearch(whitelist, key) < 0)
                StdOut.println(key);
        }
    }
}
//    public static void main(String[] args) {
//        int array[] = {2, 4, 1,4,5,6,7,8,1,2,12,32,545,434,23};
//        int key = 8;
//        Arrays.sort(array);
//        StdOut.println(binarySearch(array, key));
//    }
//    public static  int binarySearch(int array[], int key) {
//        int lo = array[0];
//        int hi = array[array.length - 1];
//        while (hi >= lo) {
//            int mid = (hi + lo) / 2;
//            StdOut.printf("%2d\n", mid);
//            if (key > mid) {
//                lo = mid - 1;
//            }
//            else if (key < mid){
//                hi = mid + 1;
//            }
//            else {
//                return mid;
//            }
//        }
//        return -1;
//    }
//}
