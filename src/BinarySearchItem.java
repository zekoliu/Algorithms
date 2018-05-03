import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearchItem<Item extends Comparable<Item>> {
    private Item[] items;
    private int n;
    private int cap;

    public BinarySearchItem(int capacity) {
        items = (Item[]) new Comparable[2 * capacity];
        cap = capacity;
    }

    public BinarySearchItem(Comparable[] keys) {
        n = keys.length;
        cap = keys.length;
        items = (Item[]) new Comparable[2 * cap];
        Merge.sort(keys);
        for (int i = 0; i < keys.length; i++)
            items[i] = (Item)keys[i];
    }

    public int size() {
        return n;
    }

    private int rank(Item key) {
        int lo = 0, hi = n - 1;
        while (hi >= lo) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(items[mid]);
            if      (cmp > 0)   lo = mid + 1;
            else if (cmp < 0)   hi = mid - 1;
            else                return mid;
        }
        return lo;
    }

    public Item get(Item key) {
        int i = rank(key);
        if (i < n && items[i].compareTo(key) == 0) return items[i + cap];
        else                                       return null;
    }

    public void put(Item key, Item val) {
        int i = rank(key);
        if (i < n && items[i].compareTo(key) == 0) {
            items[i + cap] = val;
            return;
        }

        for (int j = n; j > i; j--) {
            items[j] = items[j - 1];
            items[j + cap] = items[j + cap - 1];
        }

        items[i] = key;
        items[i + cap] = val;
        n++;
    }

    public boolean isEmpty() { return n == 0; }
    public Item min() { return items[0]; }
    public Item max() { return items[n - 1]; }

    public static void main(String[] args) {
//        BinarySearchItem<Event> st = new BinarySearchItem<Event>(10);
//        Event e1 = new Event("kobe");
//        Event e2 = new Event("jordan");
//        Event e3 = new Event("curry");
//        Event e4 = new Event("dunant");
//
//        st.put(e1, e1);
//        st.put(e2, e3);
//        st.put(e3, e4);
//
//        StdOut.println("min = " + st.min());
    }
}
