import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.StdOut;

public class TestRB {

    public static void main(String[] args) {
        String s = "E A S Y Q U T I O N";
        String[] strings = s.split(" ");
        RedBlackBST<String, Integer> redBlackBST = new RedBlackBST<String, Integer>();
        int length = strings.length;
        for (int i = 0; i < length; i++)
            redBlackBST.put(strings[i], i);
        StdOut.println("RedBlackBST size= " +  redBlackBST.size());
        StdOut.println("RedBlackBST min= " + redBlackBST.min());
        StdOut.println("RedBlackBST max= " + redBlackBST.max());
        StdOut.println("RedBlackBST keys= " + redBlackBST.keys());
        redBlackBST.delete("Q");
        redBlackBST.deleteMax();
        redBlackBST.deleteMin();
        StdOut.println("delete later RedBlackBST keys= " + redBlackBST.keys());
    }
}
