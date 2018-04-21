import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class QuickUnionUF {
    private int[] id;
    private int count;
    public int num = 0;

    public QuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i< N; i++)
            id[i] = i;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int p) {      //quick-union
        while (p != id[p]) {
            p = id[p];
            num++;
        }
        return p;
    }

    public void union(int p, int q) {   //quick-union
        int pRoot = find(p);
        int qRoot = find(q);
        StdOut.println(num);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        num++;
        count--;
    }

    public static void main(String[] args) {
        QuickUnionUF uf = new QuickUnionUF(10);
        Stopwatch stopwatch = new Stopwatch();
        uf.union(9, 0);
        uf.union(3, 4);
        uf.union(5, 8);
        uf.union(7, 2);
        uf.union(2, 1);
        uf.union(5, 7);
        uf.union(0, 3);
        uf.union(4, 2);
        StdOut.printf("%f",stopwatch.elapsedTime());
    }
}