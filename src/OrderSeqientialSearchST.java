import edu.princeton.cs.algs4.StdOut;

public class OrderSeqientialSearchST<Key extends Comparable<Key>, Value> {
    private Node first;
    private int N = 0;
    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public void put(Key key, Value value) {

        if (first == null || first.key.compareTo(key) > 0) {
            first = new Node(key, value, first);
        }
        Node x = first;
        while (x.next != null && x.next.key.compareTo(key) <= 0)
            x = x.next;
        if (x.key.equals(key)) {
            x.value = value;
            return;
        }
        Node n = new Node(key, value, null);
        n.next = x.next;
        x.next = n;
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next)
            if (x.key.equals(key))
                return x.value;
        return null;
    }

    public void show() {
        for (Node x = first; x != null; x = x.next)
            StdOut.println(x.key + " " + x.value);
    }

    public static void main(String[] args) {
        OrderSeqientialSearchST<String, Integer> o = new OrderSeqientialSearchST<String, Integer>();
        o.put("kobe", 24);
        o.put("curry", 30);
        o.put("rose", 1);
        o.put("jordan", 23);
        o.put("dunant", 35);
        o.put("paul", 3);
        StdOut.println(o.get("paul"));
        o.show();
    }
}
