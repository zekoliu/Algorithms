import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;

public class DoublingRatio {
    public static double timeTrial(int N) {
        int Max = 1000000;
        int[] a = new int[N];
        for(int i = 0; i< N; i++)
            a[i] = StdRandom.uniform(-Max, Max);
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }
    public static void main(String[] args) {
        double prev = timeTrial(125);
        for (int N = 1; true; N += N) {
            double time = timeTrial(N);
            StdOut.printf("%6d %7.1f ", N, time);
            StdOut.printf("%5.1f\n", time / prev);
            prev = time;
        }
    }
}
