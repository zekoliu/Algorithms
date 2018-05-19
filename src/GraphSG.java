import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class GraphSG {
    private int V;
    private int E;
    private Bag<Integer>[] adj;

    public GraphSG(String string, String sp) {
        In in = new In(string);
        int length = string.length();
        StdOut.println(length);
        adj = (Bag<Integer>[]) new Bag[length];
        for (int i = 0; i < length; i++)
            adj[i] = new Bag<Integer>();
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);

            for (int i = 1; i < a.length; i++) {
                int v = Integer.parseInt(a[0]);
                int w = Integer.parseInt(a[i]);
                V+=2;
                addEdge(v, w);
            }
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        if (contains(adj[v], w) || contains(adj[w], v) || v == w)   //一二判断是否是平行，三判断是否自环
            return;
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public boolean contains(Bag<Integer> bag, int v) {
        for (int i : bag)
            if (i == v)
                return true;
        return false;
    }

    public boolean hasEdge(int v, int w) {
        for (int i : adj[v])
            if (i == w)
                return true;
        return false;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < V; i++) {
            s = s + i + ": ";
            for (int v : adj[i])
                s = s + v + " ";
            s = s + "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        String s = args[0];
        String sp = args[1];
        GraphSG graph = new GraphSG(s, sp);
        StdOut.println(graph);
//        for (int i = 0; i < graph.V(); i++) {
//            StdOut.print(i + ": ");
//            for (int v : graph.adj[i])
//                StdOut.print(v + " ");
//            StdOut.println();
//        }
        StdOut.print(graph.hasEdge(2, 0));
    }
}
