import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FrequencyCounter {

    public static void main(String[] args) {
        int minlen = Integer.parseInt(args[0]);
        int times = 0;
        String word = "";
        ST<String, Integer> st = new ST<String, Integer>();
        while (!StdIn.isEmpty()) {
            word = args[0];
            if (word.length() < minlen) continue;
            if (!st.contains(word)) st.put(word, 1);
            else                    st.put(word, st.get(word) + 1);
            times++;
        }

        StdOut.println("last word is " + word + " times = " + times);

        String max = "";
        st.put(max, 0);
        for (String anotherWord : st.keys())
            if (st.get(anotherWord) > st.get(max))
                max = anotherWord;

        StdOut.print(max + " " + st.get(max));

        int index = 0;
        String[] keys = new String[st.size()];
        int[] values = new int[st.size()];
        for (String s : st.keys()) {
            keys[index] = s;
            values[index++] = st.get(s);
        }

        Quick.sort(keys);
        for (int i = 0; i < keys.length; i++)
            StdOut.print(keys[i] + "-" + st.get(keys[i]) + "  ");
        StdOut.println();
    }
}
