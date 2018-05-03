import edu.princeton.cs.algs4.StdOut;

public class InterpolationSearchST<Integer, Value> {
    private int[] keys;
    private Value[] values;
    private int N;

    public InterpolationSearchST(int capacity) {
        keys = new int[capacity];
        values = (Value[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void put(int key, Value value) {
        int i = rank(key);
        if (i < N && keys[i] == key) {
            values[i] = value;
            return;
        }

        for (int j = N; j > i; j--) {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }

        keys[i] = key;
        values[i] = value;
        N++;
    }

    public Value get(int key) {
        int i = rank(key);
        if (i < N && key == keys[i])   return values[i];
        else                           return null;
    }

    public int rank(int key) {
        if (N == 0)
            return 0;
        int lo = 0, hi = N - 1;
        if (key <= keys[lo])
            return lo;
        if (key >= keys[hi])
            return hi + 1;

        double rs = (((key - keys[lo]) / (double)keys[hi] - keys[lo]) * (N - 1));
        int i = (int)rs;
        int count = 0;
        while (hi >= lo) {
            ++count;
            if (key == keys[i])
                return i;
            if ((i-1 < 0 || key > keys[i]) && (i+1>hi || key < keys[i+1]))
                return i+1;
            ++i;
        }
        return 0;
    }

    public static void main(String[] args) {
        InterpolationSearchST<Double, String> st = new InterpolationSearchST<Double, String>(10);
        st.put(3, "Wade");
        st.put(1, "Rose");
        st.put(10, "Kobe");
        st.put(23, "Jordan");
        st.put(2, "Lying");
        StdOut.println(st.get(10));
    }
}
