import edu.princeton.cs.algs4.StdOut;

public class UnOrderedArrayMaxPQ_3 {

    private Comparable[] a;
    private int N = 0;

    public UnOrderedArrayMaxPQ_3(int arraySize) {
        a = new Comparable[arraySize];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Comparable v) {
        a[N++] = v;
        int index = N-1;
        while (index > 0 && less(a[index], a[index-1])) {
            exch(index, index-1);
            index--;
        }
    }

    public Comparable pop() {
        Comparable delEle = a[--N];
        a[N] = null;
        return delEle;
    }

    public boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public void exch(int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        UnOrderedArrayMaxPQ_3 a = new UnOrderedArrayMaxPQ_3(10);
        a.insert(10);
        a.insert(9);
        a.insert(8);
        a.insert(13);
        Comparable temp = a.pop();
        Comparable temp2 = a.pop();
        StdOut.println(temp + " " + temp2);
    }
}
