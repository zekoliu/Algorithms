import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.val = value;
            this.N = N;
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
        else           return x.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp > 0)    return get(x.left, key);
        else if (cmp < 0)    return get(x.right, key);
        else                 return x.val;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp > 0) x.right = put(x.right, key, value);
        else if (cmp < 0) x.left  = put(x.left, key, value);
        else              x.val = value;
        x.N = size(x.left) + size(x.right) + 1;
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

    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if      (t > k)  return select(x.left, k);
        else if (t < k)  return select(x.right, k-t-1);
        else             return x;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else              return size(x.left);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.right) + size(x.left) + 1;
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
            if (x.left == null)  return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
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

    public Key randomKey() {
        return randomKey(root);
    }

    private Key randomKey(Node x) {
        int n = StdRandom.uniform(0, size(x) - 1);
        return select(n);
    }

    int nSize = 0;
    public int nonRecurSize() {
        return nonRecurSize(root);
    }

    private int nonRecurSize(Node x) {
        if (x == null) return 0;
        if (x != null) {
            nSize++;
            nonRecurSize(x.left);
            nonRecurSize(x.right);
        }
        return nSize;
    }

    public boolean isBinaryTree() {
        return isBinaryTree(root.left);
    }

    private boolean isBinaryTree(Node x) {      //3.2.29
        StdOut.println("Size is " + size() + " and " + nonRecurSize());
        if (nonRecurSize() == nSize)
            return true;
        return false;
    }

    public boolean isOrdered() {
        return isOrdered(root, min(), max());
    }

    private boolean isOrdered(Node x, Key min, Key max) {   //3.2.30
        if (min.compareTo(min()) < 0 || max.compareTo(max()) > 0)   //检查是否在二叉树里面
            return false;
        boolean isOrder = (x.key.compareTo(max(x.left).key) > 0 && x.key.compareTo(min(x.right).key) < 0);;
        boolean isLeftOrdered = isOrdered(x.left, min, max);    //递归搜索
        boolean isRightOrdered = isOrdered(x.right, min, max);
        return isOrder && isLeftOrdered && isRightOrdered;
    }

    public boolean hasNoDuplicates() {      //3.2.31
        return hasNoDuplicates(root);
    }

    private boolean hasNoDuplicates(Node x) {
        if (x.left != null && x.right != null)
            if (x.val == x.left.val || x.val == x.right.val || x.left.val == x.right.val)
                return false;
        boolean lelf = hasNoDuplicates(x.left);
        boolean right = hasNoDuplicates(x.right);
        return lelf && right;
    }

    public boolean isBST() {    //3.2.32
        return isBST(root);
    }

    private boolean isBST(Node x) {     //遍历找到该元素，判断是否由子节点，有的话是根节点
        if (x == null)
            return false;
        Node temp = root;
        while (temp != x) {
            if (temp.key.compareTo(x.key) > 0)
                temp = temp.left;
            else if (temp.key.compareTo(x.key) < 0)
                temp = temp.right;
            else
                break;
        }
        if (temp.right == null && temp.left == null)
            return false;
        return true;
    }

//    private boolean isBST() {     //3.2.32网站标准答案
//        return isBST(root, null, null);
//    }
//
//    // is the tree rooted at x a BST with all keys strictly between min and max
//    // (if min or max is null, treat as empty constraint)
//    // Credit: Bob Dondero's elegant solution
//    private boolean isBST(Node x, Key min, Key max) {
//        if (x == null) return true;
//        if (min != null && x.key.compareTo(min) <= 0) return false;
//        if (max != null && x.key.compareTo(max) >= 0) return false;
//        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
//    }

    public boolean checkSelectRank() {      //3.2.33
        return checkSelectRank(size() - 1);
    }

    private boolean checkSelectRank(int size) {
        for (int i = 0; i < size; i++)
            if (i != rank(select(i)))
                return false;
        if (!randomKey().equals(select(rank(randomKey()))))
            return false;
        return true;
    }

    public void layerTraversal() {
        layerTraversal(root);
    }

    private void layerTraversal(Node x) {
        Queue<Node> queue = new Queue<Node>();
        if (queue.isEmpty())
            queue.enqueue(x);
        while (!queue.isEmpty())
            if (queue.peek().left != null && queue.peek().right != null) {
                Node temp = queue.dequeue();
                StdOut.print(temp.key + " ");
                queue.enqueue(temp.left);
                queue.enqueue(temp.right);
            }
            else if (queue.peek().left != null && queue.peek().right == null) {
                Node temp = queue.dequeue();
                StdOut.print(temp.key + " ");
                queue.enqueue(temp.left);
            }
            else if (queue.peek().left == null && queue.peek().right != null) {
                Node temp = queue.dequeue();
                StdOut.print(temp.key + " ");
                queue.enqueue(temp.right);
            }
            else
                StdOut.print(queue.dequeue().key + " ");
    }

    public static void main(String[] args) {
        BST<String, Integer> bst = new BST<String, Integer>();
        bst.put("k", 35);
        bst.put("c", 35);
        bst.put("d", 35);
        bst.put("r", 35);
        bst.put("h", 35);
//        bst.delete("kobe");
//        StdOut.println(bst.isBST());
        StdOut.println(bst.isOrdered());
//        StdOut.println(bst.checkSelectRank());
        bst.layerTraversal();
//        StdOut.println(bst.keys(bst.min(), bst.max()) + "\nRandom key=" + bst.randomKey());
    }
}
