import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.SET;

public class Concordance {

    public static void main(String[] args) {
        int CONTEXT = 5;

        In in = new In(args[0]);
        String[] words = in.readAllStrings();
        ST<String, SET<Integer>> st = new ST<String, SET<Integer>>();

        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (!st.contains(s))
                st.put(s, new SET<Integer>());
            SET<Integer> set = st.get(s);
            set.add(i);
        }
        StdOut.println("Finished building concordance");

        while (!StdIn.isEmpty()) {
            String query = StdIn.readString();
            SET<Integer> set = new SET<Integer>();
            if (set == null) set = new SET<Integer>();
            for (int k : set) {
                for (int i = Math.max(0, k - CONTEXT + 1); i < k; i++)
                    StdOut.print(words[i] + " ");
                StdOut.print("*" + words[k] + "* ");
                for (int i = k + 1; i < Math.min(k + CONTEXT, words.length); i++)
                    StdOut.println();
            }
            StdOut.println();
        }
    }
}
