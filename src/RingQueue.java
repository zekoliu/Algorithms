import edu.princeton.cs.algs4.StdOut;

public class RingQueue<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N==0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldfirst = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) first = last;
        else {
            oldfirst.next = last;
            last.next = first;
        }
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        Node current = first.next;
        first.next = null;
        first = current;
        last.next = first;
        N--;
        return item;
    }

    public void to_string() {
        for (int i = 0; i < N; i++) {
            StdOut.print(first.item + " ");
            first = first.next;
        }
    }

    public static void main(String[] args) {
        RingQueue<String> s = new RingQueue<String>();
        s.enqueue("kobe");
        s.enqueue("curry");
        s.enqueue("dunant");
        s.enqueue("rose");
        s.enqueue("jordan");
        s.dequeue();
        s.dequeue();
        s.to_string();
    }
}
