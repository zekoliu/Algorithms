import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {

    public static void main(String[] args) {
        test_5(50);
        Stack<String> str = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            String temp;
            if (s.equals("(")) str.push(s);
            else if (s.equals("{")) str.push(s);
            else if (s.equals("[")) str.push(s);
            else if (s.equals(")")) {
                temp = str.pop();
                if (temp.equals("("))
                    StdOut.println("true");
                else
                    StdOut.println("False");
            }
            else if (s.equals("[")) {
                temp = str.pop();
                if (temp.equals("]"))
                    StdOut.println("true");
                else
                    StdOut.println("false");
            }
            else if (s.equals("}")) {
                temp = str.pop();
                if (temp.equals("{"))
                    StdOut.println("true");
                else
                    StdOut.println("false");
            }
        }
        StdOut.println("true");
    }
    public static void test_5(int N) {
        Stack<Integer> stack = new Stack<Integer>();
        while (N>0) {
            stack.push(N % 2);
            N = N / 2;
        }
        for (int d : stack) StdOut.print(d);
        StdOut.println();
    }
}
