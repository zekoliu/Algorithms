import edu.princeton.cs.algs4.*;

public class RandomConnect {



    public static int count(int N, int p, int q) {
        int edges = 0;
        UF uf = new UF(N);
        while (uf.count() > 1) {
            uf.union(p, q);
            p = StdRandom.uniform(N);
            q = StdRandom.uniform(N);
            edges++;
        }
        return edges;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int p = StdRandom.uniform(N);
        int q = StdRandom.uniform(N);
        StdOut.println(count(N, p, q));
    }
}
