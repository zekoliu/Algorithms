import edu.princeton.cs.algs4.StdOut;

public class AnotherSeparateChainingHashST<Key, Value> {
    private final int INIT_CAPACITY = 3;
    private int N;
    private int M;
    private SequentialSearchST<Key, Value>[] st;

    public AnotherSeparateChainingHashST(int M) {
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new SequentialSearchST();
    }

    private int firstHash(int k) {      //3.4.27
        return  (11 * k) % M;
    }

    private int secondHash(int k) {
        return (17 * k) % M;
    }

    public void put(int k, Key key, Value value) {
        int firstKH = firstHash(k);
        int secondKH = secondHash(k);
        if (st[firstKH].size() > st[secondKH].size())
            st[secondKH].put(key, value);
        else
            st[firstKH].put(key, value);
    }

    public Value get(int k, Key key) {
        return (Value)st[firstHash(k)].get(key);
    }

    public void keys() {
        for (int i = 0; i < M; i++)
            for (Key key : st[i].keys())
                StdOut.print(key + " ");
        StdOut.println();
    }

    public void delete(int i, Key key) {        //3.4.29
        st[firstHash(i)].delete(key);
    }

    public static void main(String[] args) {
        AnotherSeparateChainingHashST<String, Integer> st = new AnotherSeparateChainingHashST<String, Integer>(3);
        String s = "E A S Y Q U E S T I O N";
        String[] strings = s.split(" ");
        for (int i = 0; i < strings.length; i++)
            st.put(i, strings[i], i);
        st.keys();
        st.delete(1, strings[1]);
        st.delete(3, strings[3]);
        st.keys();
        StdOut.println(st.get(2, strings[2]));
    }
}
