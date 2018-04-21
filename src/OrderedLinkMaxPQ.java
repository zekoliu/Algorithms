import edu.princeton.cs.algs4.StdOut;

public class OrderedLinkMaxPQ {

    private Node first;
    private int N = 0;
    private class Node {
        int item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(int v) {
        Node oldfirst = first;
        first = new Node();
        first.item = v;
        first.next = oldfirst;
        N++;
    }

    public int delMax() {
        Node temp = first;
        while (temp != null) {
            if (temp.item > first.item) {
                exch(first, temp);

                StdOut.println("first.item= " + first.item + " temp.item= " + temp.item);
            }
            temp = temp.next;
        }
        int maxItem = first.item;
        first = first.next;
        return maxItem;
    }

    public void exch(Node i, Node j) {
        assert (i != null && j != null);
        int swap = i.item;
        i.item = j.item;
        j.item = swap;
    }
    public static void main(String[] args) {
        OrderedLinkMaxPQ or = new OrderedLinkMaxPQ();
        or.insert(2);
        or.insert(4);
        or.insert(3);
        or.insert(9);
        or.insert(8);
        or.insert(3);
        StdOut.println(or.delMax() + " " + or.delMax());
    }
}
