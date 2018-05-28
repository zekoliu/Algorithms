import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Degress {
    private Digraph G;
    private boolean[] marked;
    private Queue<Integer> queue;

    public Degress(Digraph G) {
        this.G = G;
        marked = new boolean[G.V()];
    }

    public int indegree(int v) {
        int count = 0;
        for (int i = 0; i < G.V(); i++)
            for (int v1 : G.adj(i))
                if (v1 == v)
                    count++;
        return count;
    }

    public int outdegree(int v) {
        int count = 0;
        for (int i : G.adj(v))
            count++;
        return count;
    }

    public Iterable<Integer> sources() {
        Queue<Integer> q = new Queue<Integer>();
        for (int i = 0; i < G.V(); i++)
            if (outdegree(i) == 1 && indegree(i) == 0)
                q.enqueue(i);
        return q;
    }

    public Iterable<Integer> sinks() {
        Queue<Integer> q = new Queue<Integer>();
        for (int i = 0; i < G.V(); i++)
            if (indegree(i) == 1 && outdegree(i) == 0)
                q.enqueue(i);
        return q;
    }

    public boolean isMap() {
        for (int i = 0; i < G.V(); i++)
            if (indegree(i) != 1 && outdegree(i) != 1)
                return false;
        return true;
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(new In(args[0]));
        Degress D = new Degress(G);
        StdOut.println(D.indegree(11) + "  " + D.indegree(10) + "  " + D.indegree(0) + "  " + D.indegree(1));
        StdOut.println(D.outdegree(10) + "  " + D.outdegree(11) + "  " + D.outdegree(0) + "  " + D.outdegree(1));
        StdOut.println(D.sources().toString());
        StdOut.println(D.sinks().toString());
        StdOut.println(D.isMap());
    }
}
