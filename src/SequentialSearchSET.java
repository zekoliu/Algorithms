import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class SequentialSearchSET<Key> {
    private int n;
    private Node first;

    private class Node {
        private Key key;
        private Node next;

        public Node(Key key, Node next) {
            this.key = key;
            this.next = next;
        }
    }

    public SequentialSearchSET() {
    }


    public int size() {
        return n;
    }


    public boolean isEmpty() {
        return size() == 0;
    }


    public boolean contains(Key key) {
        return get(key) != null;
    }


    public Key get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key))
                return x.key;
        }
        return null;
    }


    public void add(Key key) {
        if (key == null) {
            delete(key);
            return;
        }

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return;
            }
        }
        first = new Node(key, first);
        n++;
    }

    public void delete(Key key) {
        first = delete(first, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }

    public String toString() {
        String s = "";
        Node x;
        for (x = first; x != null; x = x.next)
            s = s + x.key + " ";
        return s;
    }

    public static void main(String[] args) {
        SequentialSearchSET<String> st = new SequentialSearchSET<String>();
        st.add("kobe");
        st.add("curry");
        st.add("dunant");
        st.add("harden");
        StdOut.println(st.keys());
        StdOut.println(st.size());
    }
}