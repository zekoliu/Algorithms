import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Euler {
    private Digraph G;
    private Degress D;

    public Euler(Digraph G) {
        this.G = G;
        G = new Digraph(G);
        D = new Degress(G);
    }

    public boolean isConnect() {
        for (int i = 1; i < G.V(); i++)
            if (!G.hasEdge(0, i))
                return false;
        return true;
    }

    public boolean isEuler() {
        if (!isConnect())
            return false;
        for (int i = 0; i < G.V(); i++)
            if (D.indegree(i) != D.outdegree(i))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(new In(args[0]));
        Euler E = new Euler(G);
        StdOut.println(E.isEuler());
    }
}
