import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdOut;

public class PerfectBST {

    public static void main(String[] args) {
        String[] strings = {"C", "D", "A", "B", "G", "F", "E"};
        Quick.sort(strings);
        BST<String, Integer> bst = new BST<String, Integer>();
        insert(bst, strings, 0, strings.length - 1);
        StdOut.println(bst.keys());
    }

    public static void insert(BST<String, Integer> bst, String[] strings, int lo, int hi) {
        if (lo > hi) return;;
        int mid = lo + (hi - lo) / 2;
        bst.put(strings[mid], mid);
        insert(bst, strings, lo, mid - 1);
        insert(bst, strings, mid + 1, hi);
    }
}
