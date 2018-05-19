import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Cycle;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class GraphProperties {
    private BreadthFirstPaths bfp;
    private Graph G;
    public GraphProperties(Graph G) {
        this.G = G;
    }

    public int eccentricity(int v) {
        int max = 0;
        bfp = new BreadthFirstPaths(G, v);
        for (int i = 0; i < G.V(); i++) {
//            StdOut.println(bfp.distTo(i));
            if (bfp.distTo(i) > max)        //找出最远的最短距离
                max = bfp.distTo(i);
        }
        return max;
    }
    
    public int diameter() {
        int temp = 0;
        for (int i = 0; i < G.V(); i++)
            if (eccentricity(i) > temp)     //找出所有节点中离心率最大的一个
                temp = eccentricity(i);
        return temp;
    }

    public int radius() {
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < G.V(); i++)
            if (temp > eccentricity(i) && eccentricity(i) > 0)  //找出所有节点中离心率最大的一个
                temp = eccentricity(i);
        return temp;
    }

    public int center() {
        for (int i = 1; i < G.V(); i++)
            if (eccentricity(i) == radius())        //离心率和半径相等的顶点，返回这个顶点
                return i;
        return -1;
    }

//    public int girth() {
//        Cycle c = new Cycle(G);
//        for (int i = 0; i < G.V(); i++) {
//            if (c.hasCycle())
//        }
//    }

    public static void main(String[] args) {
        Graph graph = new Graph(new In(args[0]));
        GraphProperties gp = new GraphProperties(graph);
        StdOut.println(gp.eccentricity(0));
        StdOut.println("diameter equal " + gp.diameter() + " radius equal " + gp.radius() + " center equal " + gp.center());
    }
}
