import edu.princeton.cs.algs4.Queue;
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
        if (N > 2/M)
            resize(2 * M);
        st[hash(key)].put(key, value);
    }

    private void delete(Key key) {
        if (N > 0 && N < M/8)
            resize(M/2);
        st[hash(key)].delete(key);
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < M; i++)
            for (Key key : st[i].keys())
                queue.enqueue(key);
        return queue;
    }

    public void resize(int cap) {
        SeparateChainingHashST<Key, Value> t = new SeparateChainingHashST<Key, Value>(cap);
        for (int i = 0; i < M; i++)
            for (Key key : st[i].keys())
                t.put(key, st[i].get(key));
        this.st = t.st;
        this.M = t.M;
        this.N = t.N;
    }

    public static void main(String[] args) {
        String s = "S E A R C H E X A M P L E";
        String[] strings = s.split(" ");
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<>(11);
        for (int i = 0; i < strings.length; i++)
            st.put(strings[i], i);
        StdOut.println("get A equal " + st.get("A"));
        st.delete("A");
        for (String s1 : st.keys())
            StdOut.print(s1 + " ");
    }
}
