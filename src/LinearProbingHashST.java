import edu.princeton.cs.algs4.StdOut;

public class LinearProbingHashST<Key, Value> {
    private static final int INIT_CAPCITY = 4;

    private int N;
    private int M;
    private Key[] keys;
    private Value[] values;
    private LinearProbingHashST<Key, Value> st;

    public LinearProbingHashST() {
        this(INIT_CAPCITY);
    }

    public LinearProbingHashST(int capacity) {
        M = capacity;
        keys = (Key[])new Object[M];
        values = (Value[])new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        LinearProbingHashST<Key, Value> t;
        t = new LinearProbingHashST<Key, Value>(cap);
        for (int i = 0; i < M; i++)
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

    public void delete(Key key) {
        if (!contains(key)) return;
        int i = hash(key);
        while (!key.equals(keys[i]))
            i = (i + 1) % M;
        keys[i] = null;
        values[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valToRedo = values[i];
            keys[i] = null;
            values[i] = null;
            N--;
            put(keyToRedo, valToRedo);
            i = (i + 1) / M;
        }
        N--;
        if (N > 0 && N == M / 8) resize(M / 2);
    }

    public static void main(String[] args) {
        String s = "E A S Y Q U T I O N";
        String[] strings = s.split(" ");
        LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>(11);
        for (int i = 0; i < strings.length; i++)
            st.put(strings[i], i);
        st.delete("N");
        StdOut.println("Get Q equal " + st.get("Q"));
        StdOut.println("Get Y equal " + st.get("Y"));
    }
}
