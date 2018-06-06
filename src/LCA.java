import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class LCA {
    private boolean[] marked;
    private int[] edgeTo;
    private int[] heights;

    public LCA(Digraph G) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        heights = new int[G.V()];

        for (int v = 0; v < G.V(); v++)
            if (!marked[v])
                dfs(G, v);
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                heights[w] = heights[v] + 1;
                dfs(G, w);
            }
        }
    }

    public int lca(int v, int w) {
        while (heights[v] > heights[w])
            v = edgeTo[v];
        while (heights[w] > heights[v])
            w = edgeTo[w];
        if (v == w)
            return v;
        while (heights[v] >= 0) {
            v = edgeTo[v];
            w = edgeTo[w];
            if (v == w)
                return v;
        }
        return 0;
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(new In(args[0]));
        LCA lca = new LCA(G);

        StdOut.println("8 and 11 LCA is " + lca.lca(8, 11));
        StdOut.println("11 and 12 LCA is " + lca.lca(11, 12));
    }
}
