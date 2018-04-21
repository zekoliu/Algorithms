import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> {

    private Node first;
    private Node leftLast;
    private Node rightLast;
    private int LEFT_SIZE;
    private int RIGHT_SIZE;

    private class Node {
        Item item;
        Node leftNext;
        Node rightNext;
    }

    public boolean isEmpty() {
        return LEFT_SIZE + RIGHT_SIZE == 0;
    }

    public int size() {
        return LEFT_SIZE + RIGHT_SIZE;
    }

    public void pushLeft(Item item) {
        Node oldLeft = leftLast;
        leftLast = new Node();
        leftLast.item = item;
        leftLast.leftNext = null;
        if (isEmpty()) first = leftLast;
        else oldLeft.leftNext = leftLast;
        LEFT_SIZE++;
    }

    public void pushRight(Item item) {
        Node oldRight = rightLast;
        rightLast = new Node();
        rightLast.item = item;
        rightLast.rightNext = null;
        if (isEmpty()) first = rightLast;
        else oldRight.rightNext = rightLast;
        RIGHT_SIZE++;
    }

    public Item popLeft() {
        Item item = first.item;
        first = first.leftNext;
        if (isEmpty()) leftLast = null;
        LEFT_SIZE--;
        return item;
    }

    public Item popRight() {
        Item item = first.item;
        first = first.rightNext;
        if (isEmpty()) rightLast = null;
        RIGHT_SIZE--;
        return item;
    }

    public void to_string() {
        while (first != null) {
            StdOut.print(first.item);
            first = first.leftNext;
        }
    }
    public static void main(String[] args) {
        Deque<String> deque = new Deque<String>();
        deque.pushLeft("curry");
        deque.pushLeft("kobe");
        deque.pushLeft("jordan");
        deque.pushLeft("Howard");
        deque.pushLeft("word brother");
        deque.popLeft();
        deque.popRight();
        deque.to_string();
        deque.pushRight("Davis");
        deque.pushRight("Rando");
        deque.pushRight("Allen");
        deque.pushRight("Wade");
        StdOut.print(deque.size());
    }
}
