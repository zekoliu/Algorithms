import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdOut;

import javax.smartcardio.CommandAPDU;
import java.util.Comparator;

public class InverseDomanName {

    public static void main(String[] args) {
        String[] strings = {"zekoliu@foxmail.com", "cs.princeton.edu", "www.baidu.js", "www.google.net", "www.tencent.com"};
        String[] newStrs = new String[strings.length];
        for (int i = 0; i < strings.length; i++)
            newStrs[i] =  newString(strings[i]);
        Quick.sort(newStrs);
        show(newStrs);
    }

    private static String newString(String s) {
        String[] strings = s.split("\\.");
        String newS = "";
        for (int i = strings.length - 1; i > 0; i--)
            newS = strings[i] + "." + newS;
        newS = newS + strings[0];
        return newS;
    }

    private static void show(Comparable[] s) {
        int len = s.length;
        for (int i = 0; i < len; i++)
            StdOut.print(s[i] + " ");
        StdOut.println();
    }
}
