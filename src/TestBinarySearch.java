import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class TestBinarySearch {

    public static void main(String[] args) {
        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>(20);
        String[] strings = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T"};
        for (int i = 0; i < 20; i++)
            st.put(strings[StdRandom.uniform(0, 20)], StdRandom.uniform(0, 20));
        st.show();
        StdOut.println("min=" + st.min() + " max=" + st.max() + " floor C=" + st.floor("C") +  " select 3=" + st.select(3));
    }
}
