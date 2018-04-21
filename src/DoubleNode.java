import edu.princeton.cs.algs4.StdOut;

public class DoubleNode<Item>  {
    private Node first;

    private class Node {
        double item;
        Node beforeNext;
        Node rearNext;
    }

    public void addBefore(double item) {  //向前加
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.beforeNext = oldfirst;
    }

    public void addRear(double item) {   //向后加
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.rearNext = oldfirst;
    }

    public double beforePop() {
        double val = first.item;
        first = first.beforeNext;
        return val;
    }

    public double rearPop() {
        double val = first.item;
        first = first.rearNext;
        return val;
    }

    public void to_String() {   //打印出整个链表
        Node current = first;
        while (current != null) {
            StdOut.print(current.item);
            current = current.beforeNext;
        }
        StdOut.print("\n");
        while (first != null) {
            StdOut.print(first.item);
            first = first.rearNext;
        }
        StdOut.println(" ");
    }
    public static void main(String[] args) {
        DoubleNode<Integer> i = new DoubleNode<Integer>();
        i.addBefore(1.0);
        i.addBefore(2.0);
        i.beforePop();
        i.addRear(9.0);
        i.rearPop();
        i.rearPop();
        i.to_String();
    }
}
