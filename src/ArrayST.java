import edu.princeton.cs.algs4.StdOut;

public class ArrayST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;

    public ArrayST_2(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void put(Key key, Value value) {
        for (int i = 0; i < N; i++)
            if (keys[i].compareTo(key) == 0)
                values[i] = value;
        keys[N] = key;
        values[N] = value;
        N++;
    }

    public Value get(Key key) {
        for (int i = 0; i < N; i++) {
            if (keys[i].compareTo(key) == 0) {
                Key tempKey = key;
                Value tempVal = values[i];
                for (int j = i; j > 0; j--) {
                    keys[j] = keys[j - 1];
                    values[j] = values[j - 1];
                }
                keys[0] = tempKey;
                values[0] = tempVal;
                return tempVal;
            }
        }
        return null;
    }

    public void delete(Key key) {
        if (isEmpty())
            return;
        for (int i = 0; i < N; i++) {
            if (keys[i].equals(key)) {
                keys[i] = keys[N - 1];
                values[i] = values[N - 1];
                keys[N - 1] = null;
                values[N - 1] = null;
                N--;
            }
        }
    }

    public boolean contains(Key key) {
        for (int i = 0; i < N; i++)
            if (keys[i].compareTo(key) == 0)
                return true;
        return false;
    }

    public void show() {
        for (int i = 0; i < N; i++)
            StdOut.println(keys[i] + " " + values[i]);
    }

    public static void main(String[] args) {
        ArrayST<String, Integer> a = new ArrayST<String, Integer>(10);
        a.put("kobe", 24);
        a.put("curry", 30);
        a.put("Jordan", 23);
        a.get("Jordan");
        a.show();
    }
}
