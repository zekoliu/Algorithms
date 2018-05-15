import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

import java.util.TreeSet;

public class SET<Key extends Comparable<Key>> { //
    private TreeSet<Key> st;
    public SET() {
        st = new TreeSet<Key>();
    }

    public void add(Key key) {
        st.add(key);
    }

    public void delete(Key key) {
        st.remove(key);
    }

    public boolean contains(Key key) {
        return st.contains(key);
    }

    public boolean isEmpty() {
        return st.size() == 0;
    }

    public int size() {
        return st.size();
    }

    public String toString() {
        return st.toString();
    }

    public static void main(String[] args) {
        SET<String> set = new SET<String>();
        set.add("www.baidu.com");
        set.add("www.google.com");
        set.add("www.amazon.com");
        set.add("www.tencent.com");
        set.add("www.deeplearing.org");
        StdOut.println(set.toString());
        set.delete("www.amazon.com");
        StdOut.println(set.toString());
    }
}
