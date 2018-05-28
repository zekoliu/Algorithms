import edu.princeton.cs.algs4.*;

public class Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<Integer>();
    }

    public Digraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public Digraph(Digraph G) {
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

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++)
            for (int w : adj[v])
                R.addEdge(w, v);
        return R;
    }

    public boolean hasEdge(int v, int w) {
        Queue<Integer> queue = new Queue<Integer>();
        boolean[] marked = new boolean[V];
        marked[v] = true;
        for (int i : adj[v]) {
            marked[i] = true;
            if (i == w)
                return true;
            queue.enqueue(i);       //把i的各个连通点压入队列
        }

        while (!queue.isEmpty()) {
            StdOut.println(queue.toString());
            int current = queue.dequeue();
            if (current == w)
                return true;
            marked[current] = true;
            for (int i : adj[current])
                if (!marked[i])
                    queue.enqueue(i);
        }
        return false;
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
        Digraph d = new Digraph(new In(args[0]));
        StdOut.println(d.toString());
        StdOut.println(d.hasEdge(7, 4));
    }
}
