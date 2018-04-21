import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class MyQueue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;
    private class Node {
        Item item;
        Node next;
    }

    public MyQueue(Queue<Item> q) {
        Queue<Item> newQueue = new Queue<Item>();
        Queue<Item> temp = q;
        int tempSize = temp.size();
        for (int i = 0; i < tempSize; i++)
            newQueue.enqueue(temp.dequeue());
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else  oldlast.next = last;
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<Item> {
        private Node current = null;
        public boolean hasNext() {
            return current != null;
        }
        public void remove() { }
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Queue<String> oldQueue = new Queue<String>();
        oldQueue.enqueue("kobe");
        oldQueue.enqueue("curry");
        oldQueue.enqueue("dunant");
        oldQueue.enqueue("rose");
        MyQueue<String> myQueue = new MyQueue<String>(oldQueue);
        StdOut.println(myQueue + "\n" + oldQueue);
//        for (String i : myQueue)
//            StdOut.println(i);
    }
}
