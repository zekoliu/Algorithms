import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RubbishEmail {

    public static void main(String[] args) {
        String s = "zekoliu@qq.com";
        String[] strings = s.split("@");
        s = "";
        for (int i = 0; i < 8; i++)
            s = s + StdRandom.uniform(0, 9);
        StdOut.println(s + "@" +  strings[1]);
    }
}
