import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.UF;

public class SearchUnionFind {
    private UF uf;
    private int s;

    public SearchUnionFind(Graph G, int s) {
        uf = new UF(G.V());
        for (int i = 0; i < G.V(); i++)
            for (int v : G.adj(i))
                uf.union(v, i);
        this.s = s;
    }

    public boolean marked(int w) {
        return uf.connected(s, w);
    }

    public int count() {
        return uf.count();
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        SearchUnionFind suf = new SearchUnionFind(G, s);

        for (int v = 0; v < G.V(); v++)
            if (suf.marked(v))
                StdOut.print(v + " ");
        StdOut.println();

        if (suf.count() != G.V())
            StdOut.print("NOT ");
        StdOut.println("connected");
    }
}