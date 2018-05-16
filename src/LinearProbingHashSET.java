import edu.princeton.cs.algs4.StdOut;

public class LinearProbingHashSET<Key, Value> {
    private static final int INIT_CAPCITY = 4;

    private int N;
    private int M;
    private Key[] keys;
    private Value[] values;
    private LinearProbingHashSET<Key, Value> st;

    public LinearProbingHashSET() {
        this(INIT_CAPCITY);
    }

    public LinearProbingHashSET(int capacity) {
        M = capacity;
        keys = (Key[])new Object[M];
        values = (Value[])new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        LinearProbingHashSET<Key, Value> t;
        t = new LinearProbingHashSET<Key, Value>(cap);
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
        int i = hash(key), times = 0;
        for (int index = 0; index < M; index++)
            if (keys[index] != null && keys[index].equals(key))
                times++;
        StdOut.println("times = " + times + " N = " + M);
        for (int t = 0; t < times; t++) {
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
    }

    public Value deleteItem(Key key) {
        if (!contains(key)) return null;
        int i = hash(key);
        while (!key.equals(keys[i]))
            i = (i + 1) % M;
        Value value = values[i];
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
        return value;
    }

    public void keys() {
        for (int i = 0; i < M; i++)
            if (keys[i] != null)
                StdOut.print(keys[i] + " ");
    }

    public static void main(String[] args) {
        String s = "E A S Y Y Y Q U T I O N E A S";
        String[] strings = s.split(" ");
        LinearProbingHashSET<String, Integer> st = new LinearProbingHashSET<String, Integer>(11);
        for (int i = 0; i < strings.length; i++)
            st.put(strings[i], i);
        StdOut.println(st.deleteItem("N"));
        StdOut.println("Get Q equal " + st.get("Q"));
        StdOut.println("Get Y equal " + st.get("Y"));
        st.delete("A");
        st.delete("E");
        st.delete("Y");
        st.keys();
    }
}
