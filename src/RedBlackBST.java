import edu.princeton.cs.algs4.StdOut;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private Node temp;
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
        if (temp != null && temp.key.compareTo(key) == 0) {
            x.val = value;
            return x;
        }

        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else              x.val = value;

        if (isRed(x.right) && !isRed(x.left))    x = rotateLeft(x);
        if (isRed(x.left) && isRed(x.left.left)) x = rotateRight(x);
        if (isRed(x.left) && isRed(x.right))     flipColors(x);
        x.N = size(x.left) + size(x.right) + 1;
        temp = x;
        return x;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        if (temp == x)
            return x.val;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        temp = x;
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

    public boolean isRedBlackBST() {
        return isRedBlackBST(root);
    }

    private boolean isRedBlackBST(Node h) {
        if (h == null) return false;
        if (!isBST(root, min(), max()))
            return false;
        if (!is23(root))
            return false;
        if (!isBalanced(root, 0))
            return false;
        return true;
    }

    public boolean is23() {
        return is23(root);
    }

    private boolean is23(Node h) {
        if (h == null) return true;
        if (h.right != null && isRed(h.right))       //存在两个红链接,右边比为红
            return false;
        if (h != root && isRed(h) && isRed(h.left))  //不可能存在4-节点
            return false;
        boolean leftStatus = is23(h.left);
        boolean rightStatus = is23(h.right);
        return leftStatus && rightStatus;
    }

    public boolean isBalanced() {
        int black = 0;
        Node x = root;
        while (x != null) {
            if (!isRed(x)) black++;
            x = x.left;             //不走右边？
        }
        return isBalanced(root, black);
    }

    private boolean isBalanced(Node h, int black) {
        if (h == null) return black == 0;
        if (!isRed(h)) black--;
        return isBalanced(h.left, black) && isBalanced(h.right, black);
    }

    public boolean isBST() {
        return isBST(root, null, null);
    }

    private boolean isBST(Node x, Key min, Key max) {
        if (x == null) return true;
        if (min != null && x.key.compareTo(min) <= 0) return false;
        if (max != null && x.key.compareTo(max) >= 0) return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node h) {
        if (h == null) return h;
        return max(h.right);
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node h) {
        if (h.left == null) return h;
        else return min(h.left);
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else           return x.N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private Node moveRedLeft(Node h) {
        flipColors(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
        }
        return h;
    }

    public void deleteMin() {
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;

    }

    private Node deleteMin(Node h) {
        if (h.left == null)
            return null;
        if (!isRed(h.left) && !isRed(h.left.left))
            h = moveRedLeft(h);
        h.left = deleteMin(h.left);
        return Balanced(h);
    }

    private Node moveRedRight(Node h) {
        flipColors(h);
        if (!isRed(h.left.left))
            h = rotateRight(h);
        return h;
    }

    public void deleteMax() {
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        root = deleteMax(root);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node deleteMax(Node h) {
        if (isRed(h.left))
            h = rotateRight(h);
        if (h.right == null)
            return null;
        if (!isRed(h.right) && !isRed(h.right.left))
            h = moveRedRight(h);
        h.right = deleteMax(h.right);
        return Balanced(h);
    }

    public void delete(Key key) {
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        root = delete(root, key);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node delete(Node h, Key key) {
        if (key.compareTo(h.key) < 0) {
            if (!isRed(h.left) && !isRed(h.left.left))
                h = moveRedLeft(h);
            h.left = delete(h.left, key);
        } else {
            if (isRed(h.left))
                h = rotateRight(h);
            if (key.compareTo(h.key) == 0 && (h.right == null))
                return null;
            if (!isRed(h.right) && !isRed(h.right.left))
                h = moveRedRight(h);
            if (key.compareTo(h.key) == 0) {
                h.val = get(h.right, min(h.right).key);
                h.key = min(h.right).key;
                h.right = deleteMin(h.right);
            }
            else h.right = delete(h.right, key);
        }
        return Balanced(h);
    }

    private Node Balanced(Node h) {
        if (isRed(h.right)) h = rotateLeft(h);
        if (isRed(h.right) && !isRed(h.left))    h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))     flipColors(h);
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    public static void main(String[] args) {
        RedBlackBST<String, Integer> redBlackBST = new RedBlackBST<String, Integer>();
        String s = "E A S Y Q U T I O N";
        String[] strings = s.split(" ");
        int len = strings.length;
        for (int i = 0; i < len; i++)
            redBlackBST.put(strings[i], i);
        StdOut.println(redBlackBST.size());
//        StdOut.println(redBlackBST.is23());
//        StdOut.println(redBlackBST.isRedBlackBST());
        StdOut.println(redBlackBST.min());
    }
}