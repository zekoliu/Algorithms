import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayQueueOfStrings {
    private String[] a;
    private int N;
    private int first;
    private int last;

    private void resize(int max) {
        String[] temp = new String[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }
    public ResizingArrayQueueOfStrings_14(int cap) {
        a = new String[cap];
        first = 0;
        last = 0;
    }

    public boolean isEmpty() {
        return N==0;
    }

    public int size() {
        return N;
    }

    public void enqueue(String item) {
        if (N == a.length)
            resize(2*N);
        a[last++] = item;
        if (last == a.length) last = 0;
        N++;
    }

    public String dequeue() {
        if (N > 0 && N == a.length / 4)
            resize(a.length / 2);
        String result = a[first];
        a[first] = null;
        first++;
        if (first == a.length) first = 0;
        return result;
    }
    public static void main(String[] args) {
        ResizingArrayQueueOfStrings_14 s = new ResizingArrayQueueOfStrings_14(10);
        s.enqueue("kobe");
        s.enqueue("my name is kobe");
        StdOut.println(s);
    }
}
