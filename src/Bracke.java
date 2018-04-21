import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Bracke {

    public static void main(String[] args) {
        StdOut.println(bracke("1+2)*3-4)*5-6)))"));
    }
    public static String bracke(String str) {
        String temp = "";
        Stack<Character> brack = new Stack<Character>();
        Stack<Character> vals = new Stack<Character>();
        int len = str.length();
        int N = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == '0' || str.charAt(i) == '1' || str.charAt(i) == '2' || str.charAt(i) == '3' ||
                    str.charAt(i) == '4' || str.charAt(i) == '5' || str.charAt(i) == '6' || str.charAt(i) == '7' ||
                    str.charAt(i) == '8' || str.charAt(i) == '9') {
                vals.push(str.charAt(i));
                N++;
            }
            if (str.charAt(i) == ')' && N == 2) {
                temp = temp + "(" + vals.pop() + brack.pop() + vals.pop() + str.charAt(i);
                N=0;
            }
            if (str.charAt(i) == '-' || str.charAt(i) == '+')
                brack.push(str.charAt(i));
        }
        return temp;
    }
}
