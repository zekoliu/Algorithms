import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class CombinationWord {

    public static void main(String[] args) {
        String s = StdIn.readLine();
        String[] strings = s.split(" ");
        int totalSize = newSize(strings);
        String[] totalCom = new String[totalSize];

        int stringLen = strings.length, totalComInd = 0;

        for (int i = 0; i < stringLen; i++)
            for (int j = i + 1; j < stringLen; j++)
                totalCom[totalComInd++] = strings[i] + strings[j];
        Quick.sort(strings);
        for (int i = 0; i < totalSize; i++)
            for (int j = 0; j < stringLen; j++)
                if (totalCom[i].equals(strings[j]))
                    StdOut.print(totalCom[i] + " ");

    }

    private static int newSize(String[] a) {
        int N = 0;
        for (int i =  1; i < a.length; i++)
            N += i;
        return N;
    }

    private static void show(String[] s) {
        int len = s.length;
        for (int i = 0; i < len; i++)
            StdOut.print(s[i] + " ");
        StdOut.println();
    }
}
