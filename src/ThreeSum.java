import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class ThreeSum {

    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i+1; j < N; j++)
                for (int k = j+1; k < N; k++)
                    if (a[i] + a[j] + a[k] == 0)
                        cnt++;
        return cnt;
    }

//    public static boolean isOverflow(int firstNum, int secondNum, int thridNum) {
//        if ((firstNum > secondNum && secondNum > thridNum) ||
//                (secondNum > firstNum && firstNum > thridNum))
//            return (firstNum + secondNum) < Integer.MAX_VALUE;
//        else if ((firstNum > thridNum && thridNum > secondNum) ||
//                (thridNum > firstNum && firstNum > secondNum))
//            return (firstNum + thridNum) > Integer.MAX_VALUE;
//        else if ((secondNum > thridNum && thridNum > firstNum) ||
//                (thridNum > secondNum && secondNum > firstNum))
//            return (secondNum + thridNum) > Integer.MAX_VALUE;
//        return false;
//    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        Stopwatch stopwatch = new Stopwatch();
        StdOut.println(count(a));
        double time = stopwatch.elapsedTime();
        StdOut.println(time);
    }
}
