import edu.princeton.cs.algs4.StdOut;

public class AnotherLinearProbingHashST<Key, Value> {

    private static final int INIT_CAPCITY = 4;

    private int N;
    private int M;
    private Key[] keys;
    private Value[] values;
    private AnotherLinearProbingHashST<Key, Value> st;

    public AnotherLinearProbingHashST() {
        this(INIT_CAPCITY);
    }

    public AnotherLinearProbingHashST(int capacity) {
        M = capacity;
        keys = (Key[])new Object[M];
        values = (Value[])new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private int hash(int i, int k) {    //3.4.28
        return (i + k) % M;
    }

    private void resize(int cap) {
        AnotherLinearProbingHashST<Key, Value> t;
        t = new AnotherLinearProbingHashST<Key, Value>(cap);
        for (int i = 0; i < M; i++)         //change array size, all element renew insert
            if (keys[i] != null)
                t.put(keys[i], values[i]);
        keys   = t.keys;
        values = t.values;
        M      = t.M;
    }

    public void put(Key key, Value value) {
        if (N >= M / 2) resize(2 * M);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key))
                return values[i];
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void delayedDelete(Key key) {
        if (!contains(key)) return;
        int i = hash(key);
        while (!key.equals(keys[i]))
            i = (i + 1) % M;
        keys[i] = null;
        values[i] = null;
        N--;
        if (N > 0 && N == M / 8) resize(M / 2);
    }

    public void keys() {
        for (int i = 0; i < M; i++)
            if (keys[i] != null)
                StdOut.print(keys[i] + " ");
    }

    public static void main(String[] args) {
        AnotherLinearProbingHashST<String, Integer> st = new AnotherLinearProbingHashST<String, Integer>(5);
        String s = "E A S Y Q U E S T I O N K O B E";
        String[] strings = s.split(" ");
        for (int i = 0; i < strings.length; i++) {
//            StdOut.print(strings[i]);
            st.put(strings[i], i);
        }
//        st.keys();
        st.keys();
    }
}
