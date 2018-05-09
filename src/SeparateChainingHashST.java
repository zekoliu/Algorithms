import edu.princeton.cs.algs4.StdOut;

public class SeparateChainingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int N;
    private int M;
    public SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }

    public SeparateChainingHashST(int M) {
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new SequentialSearchST<Key, Value>();
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private Value get(Key key) {
        return (Value)st[hash(key)].get(key);
    }

    private void put(Key key, Value value) {
        st[hash(key)].put(key, value);
    }

    private void delete(Key key) {
        st[hash(key)].delete(key);
    }

    public static void main(String[] args) {
        String s = "S E A R C H E X A M P L E";
        String[] strings = s.split(" ");
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<>(15);
        for (int i = 0; i < strings.length; i++)
            st.put(strings[i], i);
        StdOut.println("get A equal " + st.get("A"));
    }
}
