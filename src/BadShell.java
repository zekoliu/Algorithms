import edu.princeton.cs.algs4.Shell;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class BadShell {

    public static void show(Comparable[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
    public static void main(String[] args) {
        Comparable[] array = new Comparable[100];
        for (int i = 0; i < 100; i++)
            array[i] = StdRandom.uniform(1, 100);
        Shell.sort(array);
        show(array);
    }
}
