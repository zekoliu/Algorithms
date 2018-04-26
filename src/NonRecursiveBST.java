import edu.princeton.cs.algs4.StdOut;

public class NonRecursiveBST<Key extends Comparable<Key>, Value> {
    private Node root;
    private int N;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.val = value;
        }
    }

    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else     return x.val;
        }
        return null;
    }

    public void put(Key key, Value value) {
        Node x = root;
        if (x == null) {
            root = new Node(key, value);
            return;
        }

        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else {
                x.val = value;
                return;
            }
        }
        x = new Node(key, value);
        N++;
    }

    public Key min() {
        Node x = root;
        while (x != null)
            x = x.left;
        return x.key;
    }

    public Key max() {
        Node x = root;
        while (x != null)
            x = x.right;
        return x.key;
    }

    public Key floor(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x.key;
            if (cmp < 0)
                x = x.left;
        }
        Node t = x.right;
        if (t != null) return t.key;
        else           return x.key;
    }

    public Key ceiling(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x.key;
            if (cmp > 0)
                x = x.right;
        }
        Node t = x.left;
        if (t != null)  return t.key;
        else            return x.key;
    }

    public int rank(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) ;
        }
        return -1;
    }

    public Key insert(int k) {
        Node x = root;
        while (x != null) {

        }
        return null;
    }


    public static void main(String[] args) {
        NonRecursiveBST<String, Integer> bst = new NonRecursiveBST<String, Integer>();
        bst.put("k", 24);
        bst.put("c", 30);
        bst.put("r", 1);
        bst.put("p", 3);
        StdOut.println(bst.get("paul"));
    }
}
