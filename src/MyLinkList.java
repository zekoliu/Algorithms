import edu.princeton.cs.algs4.StdOut;
import sun.awt.AWTAccessor;

import java.util.Iterator;
import java.util.ListIterator;

public class MyLinkList<Item> implements Iterable<Item> {

    private Node first;
    private class Node {
        Item item;
        Node next;
    }
    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public Item delete() {
        Node current = first;
        while (current.next.next != null) {
            current = current.next;
        }

        Item temp = current.next.item;
        current.next = null;
        return temp;
    }

    public Item deleteKElement(int k) {
        Node second = first;
        Node current = new Node();
        second.next = current;
        while (k-- > 0 && current.next != null) {
            current = current.next;
            second = second.next;
        }
        if (k == 1) {
            Item result = current.item;
            second.next = current.next;
            current.next = null;
            return result;
        } else {
            return null;
        }
    }

    public Item find(Item key) {
        Node current = first;
        while (current.next != null)
            if (current.item == key)
                return current.item;
        return null;
    }

    public void removeAfter(Node node) {
        Node current = first;
        while (current.next != null) {
            if (current == node)
                current.next = null;
        }
    }

//    public Item max() {
//        Node current = first;
//        Item item = first.item;
//        while (current.next != null) {
//            if (((Comparable)).compareTo(current.item) < 0)
//                item = current.item;
//            current = current.next;
//        }
//        return item;
//    }

    public Node reverseNode(Node x) {
        Node first = x;
        Node reverse = null;
        while (first != null) {
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }

    public void to_string() {
        Node current = first;
        for (; current != null; current = current.next) {
            StdOut.printf("%s ", current.item);
        }
        StdOut.print("\n");
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public void remove() {

        }
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        MyLinkList<String> lst = new MyLinkList<>();
        lst.add("a");
        lst.add("b");
        lst.add("c");
        lst.add("d");
        lst.add("e");
        lst.to_string();
    }
}

