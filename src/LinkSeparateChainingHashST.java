import edu.princeton.cs.algs4.StdOut;

import java.util.LinkedList;

public class LinkSeparateChainingHashST<Key, Value> {
    private int N;
    private int n;
    private int M;
    private Node first;
    private LinkedList<Node>[] st;

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key   = key;
            this.value = value;
            this.next  = next;
        }
    }

    public LinkSeparateChainingHashST(int capacity) {
        M = capacity;
        st = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++)
            st[i] = new LinkedList<Node>();
    }



    public void put(Key key, Value val) {
        int hashcode = hash(key);
        LinkedList<Node> item = st[hashcode];

//        if (item.size() >= n * 3/4)
        Node p = new Node(key,val, null);
        item.add(p);
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        int hashcode = hash(key);
        LinkedList<Node> item = st[hashcode];
        for (int i = 0; i < item.size(); i++)
            if (item.get(i).key.equals(key))
                return item.get(i).value;
        return null;
    }

    public static void main(String[] args) {
        String s = "S E A R C H E X A M P L E";
        String[] strings = s.split(" ");
        LinkSeparateChainingHashST<String, Integer> st = new LinkSeparateChainingHashST<>(15);
        for (int i = 0; i < strings.length; i++)
            st.put(strings[i], i);
        StdOut.println("get A equal " + st.get("E"));
    }
}
