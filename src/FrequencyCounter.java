import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.RedBlackBST;

public class FrequencyCounter {

    public static void main(String[] args) {
        testST();
        testBST();
        testRedBlackBST();
    }

    public static void testST() {
        int minlen = 8;
        Stopwatch stopwatch = new Stopwatch();
        ST<String, Integer> bst = new ST<String, Integer>();
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.length() < minlen) continue;;
            if (!bst.contains(word)) bst.put(word, 1);
            else                     bst.put(word, bst.get(word) + 1);
        }

        String max = "";
        bst.put(max, 0);
        for (String word : bst.keys())
            if (bst.get(word) > bst.get(max))
                max = word;
        StdOut.println(max + " " + bst.get(max) + " time: " + stopwatch.elapsedTime());
    }

    public static void testBST() {
        int minlen = 8;
        Stopwatch stopwatch = new Stopwatch();
        BST<String, Integer> bst = new BST<String, Integer>();
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.length() < minlen) continue;;
            if (!bst.contains(word)) bst.put(word, 1);
            else                     bst.put(word, bst.get(word) + 1);
        }

        String max = "";
        bst.put(max, 0);
        for (String word : bst.keys())
            if (bst.get(word) > bst.get(max))
                max = word;
        StdOut.println(max + " " + bst.get(max) + " time: " + stopwatch.elapsedTime());
    }

    private static void testRedBlackBST() {
        int minlen = 8;
        Stopwatch stopwatch = new Stopwatch();
        RedBlackBST<String, Integer> bst = new RedBlackBST<String, Integer>();
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.length() < minlen) continue;;
            if (!bst.contains(word)) bst.put(word, 1);
            else                     bst.put(word, bst.get(word) + 1);
        }

        String max = "";
        bst.put(max, 0);
        for (String word : bst.keys())
            if (bst.get(word) > bst.get(max))
                max = word;
        StdOut.println(max + " " + bst.get(max) + " time: " + stopwatch.elapsedTime());
    }
}
