import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class TwoStackAchieveQueue<Item> {

    private Stack<Item> firstStack = new Stack<Item>();
    private Stack<Item> secondStack = new Stack<Item>();
    private int N;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        firstStack.push(item);
        N++;
    }

    public Item dequeue() {
        for (int i = 0; i < N; i++)
            secondStack.push(firstStack.pop());
        Item item = secondStack.pop();
        for (int j = 0; j < N-1; j++)
            firstStack.push(secondStack.pop());
        N--;
        return item;
    }

    public static void main(String[] args) {
        TwoStackAchieveQueue<String> twoStackAchieveQueue = new TwoStackAchieveQueue<String>();
        twoStackAchieveQueue.enqueue("kobe");
        twoStackAchieveQueue.enqueue("curry");
        twoStackAchieveQueue.enqueue("dunant");
        twoStackAchieveQueue.enqueue("Rose");
        StdOut.println(twoStackAchieveQueue.dequeue() + "\n" + twoStackAchieveQueue.dequeue());
        StdOut.println(twoStackAchieveQueue.dequeue() + "\n" + twoStackAchieveQueue.dequeue());
    }
}
