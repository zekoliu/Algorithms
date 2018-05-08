import edu.princeton.cs.algs4.StdOut;

public class RightRedLinkRB<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;
        private boolean color;

        public Node(Key key, Value value, int N, boolean color) {
            this.key = key;
            this.val = value;
            this.N = N;
            this.color = color;
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value, 1, RED);

        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else              x.val = value;

        if (isRed(x.right) && isRed(x.right.right) && isRed(x.right.right.right))
            x = rotateLeft(x.right);
        if (isRed(x.left) && isRed(x.left.left) && isRed(x.left.left.left))
            x = rotateRight(x.left);
        if (isRed(x.left) && isRed(x.right) && isRed(x.right.right))
            x = rotateLeft(x);
        if (isRed(x.right) && isRed(x.left) && isRed(x.left.left))
            x = rotateRight(x);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        return x.val;
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == true;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.right.color = BLACK;
        h.left.color = BLACK;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else           return x.N;
    }

    public static void main(String[] args) {
        RightRedLinkRB<String, Integer> rightRedLinkRB = new RightRedLinkRB<String, Integer>();
        rightRedLinkRB.put("Kobe", 24);
        rightRedLinkRB.put("Curry", 30);
        rightRedLinkRB.put("Harden", 13);
        rightRedLinkRB.put("Dunant", 35);
        rightRedLinkRB.put("Rose", 1);
        rightRedLinkRB.put("Paul", 3);
        rightRedLinkRB.put("Wade", 3);
        rightRedLinkRB.put("Parket", 9);
        rightRedLinkRB.put("Yao", 11);
        rightRedLinkRB.put("Yi", 9);
        rightRedLinkRB.put("zekoliu", 10);
        rightRedLinkRB.put("jenenliu", 21);
        StdOut.println(rightRedLinkRB.get("Parket"));
    }
}
