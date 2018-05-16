import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

public class SparseVector {
    private int d;
    private ST<Integer, Double> st;
    public SparseVector() {
        st = new ST<Integer, Double>();
    }

    public SparseVector(int d) {
        this.d = d;
        this.st = new ST<Integer, Double>();
    }

    public int size() {
        return st.size();
    }

    public void put(int i, double x) {
        st.put(i, x);
    }

    public double get(int i) {
        if (!st.contains(i)) return 0.0;
        else return st.get(i);
    }

    public double dot(double[] that) {
        double sum = 0.0;
        for (int i : st.keys())
            sum += that[i] * this.get(i);
        return sum;
    }

    public SparseVector sum(SparseVector that) {
        SparseVector c = new SparseVector(d);
        for (int i : this.st.keys()) c.put(i, that.get(i));
        for (int i : that.st.keys()) c.put(i, that.get(i));
        return c;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i : st.keys()) {
            s.append("(" + i + ", " + st.get(i) + ") ");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        int N = 10;
        SparseVector a = new SparseVector(N);
        SparseVector b = new SparseVector(N);
        a.put(3, 0.50);
        a.put(9, 0.75);
        a.put(6, 0.11);
        a.put(6, 0.00);
        b.put(3, 0.60);
        b.put(4, 0.90);
        StdOut.println("a = " + a);
        StdOut.println("b = " + b);
//        StdOut.println("a dot b = " + a.dot(b));
        StdOut.println("a + b = " + a.sum(b));
    }
}
