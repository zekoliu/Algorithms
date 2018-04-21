import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class CopyStack {

    public static void main(String[] args) {
        Stack<Integer> num = new Stack<Integer>();
        for (int i = 0; i < 10; i++)
            num.push(i);
        StdOut.println(copy(num));
    }
    public static Stack copy(Stack<Integer> stack) {
        Stack<Integer> cpStack = new Stack<Integer>();
        Stack<Integer> temp = new Stack<Integer>();
        int i;
        while (!stack.isEmpty()) {
            i = stack.pop();
            temp.push(i);
        }
        while (!temp.isEmpty()) {
            i = temp.pop();
            cpStack.push(i);
        }
        return cpStack;
    }
}
