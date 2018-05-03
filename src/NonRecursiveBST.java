import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
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
        Node z = new Node(key, value);
        if (root == null) {
            root = z;
            return;
        }

        Node parent = null, x = root;
        while (x != null) {
            parent = x;
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else {
                x.val = value;
                return;
            }
        }
        int cmp = key.compareTo(parent.key);
        if (cmp < 0) parent.left = z;
        else         parent.right = z;
    }

    public Key min() {
        return min(root);
    }

    private Key min(Node x) {
        while (x != null && x.left != null)
            x = x.left;
        return x.key;
    }

    public Key max() {
        return max(root);
    }
    private Key max(Node x) {
        while (x != null && x.right != null)
            x = x.right;
        return x.key;
    }

    public Key floor(Key key) {     //等于小于key的最大键
        Node x = root;
        if (x == null)  return null;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x.key;
            else if (cmp < 0)  x = x.left;
            else {
                Key minright = min(x.right);
                if (minright == null || key.compareTo(minright) < 0)
                    return x.key;
                else
                    x = x.right;
            }
        }
        return null;
    }

    public Key ceiling(Key key) {   //等于大于key的最小键
        Node x = root;
        if (x == null) return null;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x.key;
            else if (cmp > 0)
                x = x.right;
            else {
                Key maxleft = min(x.left);
                if (maxleft == null || key.compareTo(maxleft) > 0)
                    return x.key;
                else
                    return maxleft;
            }
        }
        return null;
    }

    public int rank(Key key) {      //小于key的键的数量
        int thisSize = 0;
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) {
                thisSize = thisSize + 1 + size(x.left);
                StdOut.println("size.left equal " + size(x.left));
                x = x.right;
            }
            else
                return size(x.left);
        }
        return -1;
    }

    public Key select(int k) {
        Node x = root;
        if (x == null)
            return null;

        if (k < 0 || k >= size())
            return null;

        int lsize = size(x.left);
        while (x != null) {
            if (lsize != k) {
                k = k - lsize - 1;
                if (x.right == null)
                    break;
                x = x.right;
                lsize = size(x.left);
            } else {
                x = x.left;
                lsize = size(x.left);
            }
        }
        return x.key;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        if (x.right == null && x.left == null)
            return 1;
        return size(x.right) + size(x.left) + 1;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    private Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        Stack<Node> sk = new Stack<Node>();
        while (x != null) {
            int cmplo = lo.compareTo(x.key);
            int cmphi = hi.compareTo(x.key);
            if (cmplo < 0 && x.left != null) x = x.left;
            if (cmplo <= 0 && cmphi >= 0) {
                sk.push(x);
                x = x.left;
            }
            if (cmphi > 0 && x.right != null) x = x.right;
        }
        Node p = sk.pop();
        queue.enqueue(p.key);
        if (p.right != null) {
            p = p.right;
            while (p != null) {
                int cmplo = p.key.compareTo(lo);
                int cmphi = p.key.compareTo(hi);
                if (cmplo >= 0 && cmphi <= 0) {
                    sk.push(p);
                    p = p.left;
                }
                else if (cmplo < 0 && p.right != null)
                    p = p.right;
                else if (cmphi > 0 && p.left != null)
                    p = p.left;
                else
                    p = p.left;
            }
        }
     }

    public static void main(String[] args) {
        NonRecursiveBST<String, Integer> bst = new NonRecursiveBST<String, Integer>();
        bst.put("d", 24);
        bst.put("c", 30);
        bst.put("b", 1);
        bst.put("p", 3);
        bst.put("a", 1);
        bst.put("g", 23);
        bst.put("f", 15);
        StdOut.println("size= " + bst.size() + " select(3)=" + bst.select(3));
        StdOut.println("rank()=" + bst.rank("d"));
        StdOut.println("floor(c)=" + bst.floor("e") + " ceiling(c)=" + bst.ceiling("e"));
        StdOut.println("select(3)=" + bst.select(4));
        StdOut.println("min=" + bst.min() + " max= " + bst.max());
        for (String s : bst.keys())
            StdOut.print(s + " ");
    }
}
