import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomDrawRedBlackBST {

    public static void main(String[] args) {
        RedBlackBST<String, Integer> redBlackBST = new RedBlackBST<String, Integer>();
        BST<String, Integer> bst = new BST<String, Integer>();
        String[] strings = {"A", "B", "C", "D", "E", "F", "F", "H", "I", "J", "K", "L", "M", "N",
                            "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        for (int i = 0; i < 16; i++) {
            String s = strings[StdRandom.uniform(0, 25)];
            StdOut.print(s + " ");
            int val = StdRandom.uniform(1, 10);
            redBlackBST.put(s, val);
            bst.put(s, val);
        }
        StdOut.println();
        StdOut.println(redBlackBST.keys());
        StdOut.println(bst.keys());
    }
}
