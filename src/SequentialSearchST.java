import edu.princeton.cs.algs4.StdOut;

public class SequentialSearchST<Key extends Comparable<Key>, Value>{
    private Node first, recentNode;
    private int N;
    private int times;
    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public int size() {
        return N;
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        first = delete(first, key);
    }

    // delete key in linked list beginning at Node x
    // warning: function call stack too large if table is large
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            N--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public Value get(Key key) {
        if (recentNode.key == key)
            return recentNode.val;

        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key)) {
                recentNode.key = x.key;
                recentNode.val = x.val;
                return x.val;
            }
        return null;
    }

    public void put(Key key, Value val) {
        if (recentNode.key == key)
            recentNode.val = val;
        for (Node x = first; x != null; x = x.next) {
            times++;
            if (key.equals(x.key)) {
                recentNode.key = x.key;
                recentNode.val = x.val;
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        N++;
    }

    public void show() {
        for (Node x = first; x != null; x = x.next)
            StdOut.print(x.key + "-" + x.val + " ");
        StdOut.println();
    }

    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        String[] strings = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        for (int i = 0; i < strings.length; i++) {
            st.put(strings[i], i);
            st.show();
        }
        StdOut.println(st.times);
//        st.put("E", 1);
//        st.put("A", 2);
//        st.put("S", 3);
//        st.put("Y", 3);
//        st.put("Q", 35);
//        st.show();
    }
}
