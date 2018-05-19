import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<Integer>();
    }

    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public Graph(Graph G) {
        this(G.V());
        this.E = G.E();

        for (int i = 0; i < G.V(); i++) {
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : G.adj[i])
                reverse.push(w);
            for (int w : reverse)
                adj[i].add(w);
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
        Graph graph = new Graph(new In(args[0]));
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
