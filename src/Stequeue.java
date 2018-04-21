import edu.princeton.cs.algs4.StdOut;

public class Stequeue_32<Item> {
    private Node queueFirst;
    private Node stackFirst = queueFirst;
    private Node last;
    private int N;
    private class Node {
        Item item;
        Node stackNext;
        Node queueNext;
    }

    public boolean isEmpty() {
        return queueFirst == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.queueNext = null;
        if (isEmpty()) queueFirst = last;
        else  oldlast.queueNext = last;
        N++;
    }

    public Item dequeue() {
        Item item = queueFirst.item;
        queueFirst = queueFirst.queueNext;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    public void push(Item item) {
        Node oldfirst = stackFirst;
        stackFirst = new Node();
        stackFirst.item = item;
        stackFirst.stackNext = oldfirst;
    }

    public Item pop() {
        Item item = stackFirst.item;
        stackFirst = stackFirst.stackNext;
        return item;
    }

    public void t_string() {
        while (stackFirst != null) {
            StdOut.print(stackFirst.item);
            stackFirst = stackFirst.stackNext;
        }
        StdOut.print("\n");
        while (queueFirst != null) {
            StdOut.print(queueFirst.item);
            queueFirst = queueFirst.queueNext;
        }
    }

    public static void main(String[] args) {
        Stequeue_32<String> str = new Stequeue_32<String>();
        str.push("a");
        str.enqueue("a");
        str.enqueue("kobe");
        str.push("n");
        str.pop();
        str.dequeue();
        str.t_string();
    }
}
