import edu.princeton.cs.algs4.*;

public class TopM {

    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        MinPQ<Transaction> pq = new MinPQ<Transaction>(M+1);
        while (!StdIn.isEmpty()) {
            pq.insert(new Transaction(StdIn.readLine()));
            if (pq.size() > M)
                pq.delMin();
        }

        Stack<Transaction> stack = new Stack<Transaction>();
        while (!pq.isEmpty())   stack.push(pq.delMin());
        for (Transaction t : stack) StdOut.println(t);
    }
}
