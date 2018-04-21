import edu.princeton.cs.algs4.StdOut;

public class GeneralizeQueue<Item> {

    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }

    public Item delete(int k) {
        Node current = first;
        for (int i = 0; i < k-2; i++) {
            current = current.next;
        }
        Node current1 = current.next;
        Item item = current.item;
        current.next = current1.next;
        current1.next = null;
        N--;
        return item;
    }

    public void to_string() {
        while (first != null) {
            StdOut.print(first.item + " ");
            first = first.next;
        }
    }

    public static void main(String[] args) {
        GeneralizeQueue<String> gen = new GeneralizeQueue<String>();
        gen.insert("kobe");
        gen.insert("curry");
        gen.insert("dunant");
        gen.insert("jordan");
        gen.delete(3);
        gen.to_string();
    }
}
