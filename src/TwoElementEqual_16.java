import edu.princeton.cs.algs4.StdOut;

public class TwoElementEqual_16 {

    public static void main(String[] args) {
        double[] array = {0.1, 0.12, 0.012, 1.2, 0.11, 0.34, 0.115, 0.114};
        TwoNumClose(array);
    }

    public static void TwoNumClose(double[] array) {
        int len = array.length;
        double minusResult = Double.MAX_VALUE;
        double firstNum = 0;
        double secondNum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (Math.abs((array[i] - array[j])) < minusResult) {
                    minusResult = Math.abs((array[i] - array[j]));
                    StdOut.println(minusResult + " ");
                    firstNum = array[i];
                    secondNum = array[j];
                }
            }
        }
        StdOut.println(firstNum + " " + secondNum);
    }
}
