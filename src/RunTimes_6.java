import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class RunTimes_6 {

    public static void main(String[] args) {
        int sum = 0;
        int N = 10000;
        Stopwatch stopwatch = new Stopwatch();
        while (true) {
            for (int n = N; n > 0; n /= 2)
                for (int i = 0; i < n; i++)
                    sum++;
            double time = stopwatch.elapsedTime();
            StdOut.printf("%d %4.2f\n", N, time);
            N+=N;
        }
    }
}
