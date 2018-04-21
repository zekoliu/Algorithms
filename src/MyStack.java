import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;


public class MyStack<Item> {
    private Node first;
    private int N;

    private class Node {
        Item item;
        Node beforenext;
        Node rearNext;
    }

    public MyStack(Stack<Item> stack) {
        Stack<Item> temp = stack;
        Stack<Item> current = new Stack<Item>();
        Stack<Item> newStack = new Stack<Item>();
        int stackSize = temp.size();
        for (int i = 0; i < stackSize; i++)
            current.push(temp.pop());
        for (int j = 0; j < stackSize; j++)
            newStack.push(current.pop());
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.beforenext = oldfirst;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.beforenext;
        N--;
        return item;
    }

    public void to_String() {
        while (first != null) {
            StdOut.print(first.item);
            first = first.beforenext;
        }
        StdOut.print("\n");
    }

    public static void main(String[] args) {
        Stack<String> oldStack = new Stack<String>();
        oldStack.push("kobe");
        oldStack.push("curry");
        MyStack<String> l = new MyStack<String>(oldStack);
        StdOut.println(l);
    }
}
