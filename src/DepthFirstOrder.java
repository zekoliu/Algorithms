import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph G) {
        pre = new Queue<Integer>();
        post = new Queue<Integer>();
        reversePost = new Stack<Integer>();
        marked = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++)
            if (!marked[v])
                dfs(G, v);
    }

    private void dfs(Digraph G, int v) {
        pre.enqueue(v);

        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w])
                dfs(G, w);

        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }

    public boolean isTopological() {    //4.2.9
        if (pre.size() == 0)
            return false;
        for (int i = 0; i < pre.size(); i++)
            if (pre.dequeue() != reversePost.pop())
                return false;
        return true;
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(new In(args[0]));

        DepthFirstOrder DFO = new DepthFirstOrder(G);
        for (int v : DFO.pre())
            StdOut.print(v + " ");
        StdOut.println();

        for (int lastV : DFO.post())
            StdOut.print(lastV + " ");
        StdOut.println();

        for (int reverseV : DFO.reversePost())
            StdOut.print(reverseV + " ");
        StdOut.println();
    }
}
