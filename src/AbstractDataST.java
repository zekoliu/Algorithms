import edu.princeton.cs.algs4.StdOut;

public class AbstractDataST {

    public static void main(String[] args) {
        BinarySearchST<Time, Event> st = new BinarySearchST<Time, Event>(10);
        Time t1 = new Time("09:20:11");
        Time t2 = new Time("09:11:13");
        Time t3 = new Time("09:36:21");
        Event e1 = new Event("Chicago");
        Event e2 = new Event("Phoenix");
        Event e3 = new Event("Seattle");
        st.put(t1, e1);
        st.put(t2, e2);
        st.put(t3, e3);
        st.show();
    }
}
