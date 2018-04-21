import edu.princeton.cs.algs4.StdOut;

public class MaxPQ<Key extends Comparable<Key>>
{
    private Key[] pq;
    private int N = 0;
    private Key miniaml;

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    public MaxPQ_22(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N==0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        if (miniaml == null && v.compareTo(miniaml) < 0)
            miniaml = v;
        if (N == pq.length)
            reverse(pq.length * 2);
        pq[++N] = v;
        swim(N);
    }

    public Key pqMin() {
        return miniaml;
    }

    public Key delMax() {
        if (N == (pq.length / 4))
            reverse(pq.length / 2);
        Key max = pq[1];
        exch(1, N--);
        sink(1);
        return max;
    }

    private void exch(int i, int j) {
        Key tep = pq[i];
        pq[i] = pq[j];
        pq[j] = tep;
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(j, j+1))  j++;
            if (!less(k, j))    break;;
            exch(j, k);
            k = j;
        }
    }

    public void reverse(int max) {  //22
        Key[] temp = (Key[]) new Comparable[max];
        for (int i = 0; i < N; i++)
            temp[i] = pq[i];
        pq = temp;
    }

    public Key min() {
        int i = N;
        while (i > N / 2 / 2) {
            if (less(i - 1, i))
                i = i - 1;
            i--;
        }
        return pq[i];
    }

    public void show() {
        for (int i = 0; i < pq.length; i++)
            StdOut.print(pq[i] + " ");
    }

    public static void main(String[] args) {
        MaxPQ maxPQ = new MaxPQ(10);
        for (int i = 1; i < 5; i++)
            maxPQ.insert(10 / i);
        for (int k = 0; k < 10; k++)
            maxPQ.insert(++k);
        StdOut.println(maxPQ.min() + " ");
        maxPQ.show();
    }
}
