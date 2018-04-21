import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

public class California {

    public static void main(String[] args) {
        Character[] s = {'R', 'W', 'Q', 'O', 'J', 'M', 'V', 'A', 'H', 'B', 'S', 'G', 'Z', 'X',
                            'N', 'T', 'C', 'I', 'E', 'K', 'U', 'P', 'D', 'Y', 'F',  'L'};
        String[] name = {"Kobe", "Curry", "Dunant", "Zeko", "Jordan", "Rose", "John", "Wade", "Howard", "Harden"};
        String[] sortName = new String[name.length];
        int sortIndex = 0;
        for (int i = 0; i < s.length; i++)
            for (int j = 0; j < name.length; j++)
                if (name[j].charAt(0) == s[i])
                    sortName[sortIndex++] = name[j];
        show(sortName);
    }

    private static void show(String[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
}
