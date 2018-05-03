
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int N, repeatIndex;
    private Key repeatKey;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        if (repeatKey.equals(null) || repeatKey != key)
            repeatKey = key;
        else
            return values[repeatIndex];
        int i = rank(key);
        repeatIndex = i;
        if (i < N && keys[i].compareTo(key) == 0)   return values[i];
        else                                        return null;
    }

    public void put(Key key, Value value) {
        if (N > 0 && N == keys.length)
            reverse(2 * N);
//        if (key.compareTo(keys[N - 1]) >= 0) {   //3.1.28
//            keys[N] = key;
//            values[N++] = value;
//            return;
//        }

        if (repeatKey == null || repeatKey != key)
            repeatKey = key;
        else if (repeatKey.equals(key)) {
            values[repeatIndex] = value;
            return;
        }

        int i = rank(key);
        repeatIndex = i;
        if (i < N && keys[i].compareTo(key) == 0) {
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

    public int rank(Key key) {
        int lo = 0; int hi = N -1;
        while (hi >= lo) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if      (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public void delete(Key key) {
        if (N == (1/4 * keys.length))
            reverse((1/2) * keys.length);
        int i = rank(key);
        while (i < N - 1) {
            keys[i] = keys[i+1];
            values[i] = values[i+1];
            i++;
        }
        keys[N - 1] = null;
        values[N - 1] = null;
        N--;
    }

    public Key floor(Key key) {
        for (int i = 0; i < N; i++)
            if (key.equals(keys[i]))
                return key;
            else if (key.compareTo(keys[i]) < 0)
                return keys[i-1];
        return null;
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N - 1];
    }

    public Key select(int k) {
        return keys[k];
    }

    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new Queue<Key>();
        for (int i = rank(lo); i < rank(hi); i++)
            q.enqueue(keys[i]);
        if (contains(hi))
            q.enqueue(keys[rank(hi)]);
        return q;
    }

    public void reverse(int newLength) {
        Key[] newKeys = (Key[]) new Comparable[newLength];
        Value[] newVals = (Value[]) new Object[newLength];
        for (int i = 0; i < N; i++) {
            newKeys[i] = keys[i];
            newVals[i] = values[i];
        }
        keys = newKeys;
        values = newVals;
    }

    public void show() {
        for (int i = 0; i < N; i++)
            StdOut.print(keys[i] +  "-" + values[i] + " ");
        StdOut.println();
    }

    public static void main(String[] args) {
        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>(10);
        st.put("kobe", 24);
        st.put("curry", 30);
        st.put("wade", 3);
        st.put("paul", 3);
        st.put("harden", 13);
        st.put("harden", 40);
        st.delete("paul");
        st.show();
        StdOut.println("floor is " + st.floor("harden"));
    }
}