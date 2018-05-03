import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class AnotherBST<Key extends Comparable<Key>, Value> {
    private Node root, recentNode;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.val = value;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return 1 + size(x.left) + size(x.right);
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        if (recentNode.key.equals(key))     //找到，直接返回
            return recentNode.val;
        int cmp = key.compareTo(x.key);
        if      (cmp > 0)    return get(x.left, key);
        else if (cmp < 0)    return get(x.right, key);
        else  {
            if (recentNode != x);       //找到最后一次访问的那个节点，更新
                recentNode = x;
            return x.val;
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value);
        if (recentNode.equals(x))   //相同，直接返回
            return recentNode;
        int cmp = key.compareTo(x.key);
        if      (cmp > 0) x.right = put(x.right, key, value);
        else if (cmp < 0) x.left  = put(x.left, key, value);
        else              x.val = value;
        if (recentNode != null)     //不同，更新Node
            recentNode = x;
        return x;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0)  return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t == null) return t;
        else           return x;
    }

    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp > 0) return ceiling(x.right, key);
        Node t = ceiling(x.left, key);
        if (t == null) return t;
        else           return x;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }

    public int height() {
        return height(root);
    }

    private int height(Node x) {
        if (x == null) return -1;
        return Math.max(height(x.left), height(x.right)) + 1;
    }


    public static void main(String[] args) {
        AnotherBST<String, Integer> bst = new AnotherBST<String, Integer>();
        bst.put("kobe", 24);
        bst.put("cury", 30);
        bst.put("dunant", 35);
        bst.put("rose", 1);
        bst.put("harden", 13);
//        bst.delete("kobe");
        StdOut.println(bst.keys(bst.min(), bst.max()));
        StdOut.println("size = " + bst.size() + " Tree height= " + bst.height());
    }
}
