import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class RangeLookupCSV {

    public static void main(String[] args) {
        In in = new In(args[0]);
        int keyField = Integer.parseInt(args[1]);
        int valField = Integer.parseInt(args[2]);
        ST<String, String> st = new ST<String, String>();
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] tokens = line.split(",");
            String key = tokens[keyField];
            String val = tokens[valField];
            st.put(key, val);
        }

        String firstKey = args[3];
        String secondKey = args[4];

        while (!StdIn.isEmpty()) {
            String query = StdIn.readString();
            if (st.contains(query) && firstKey.compareTo(query) < 0 && secondKey.compareTo(query) > 0)
                StdOut.println(st.get(query));
        }
    }
}
