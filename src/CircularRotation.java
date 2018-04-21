import edu.princeton.cs.algs4.StdOut;

public class CircularRotation {

    public static void main(String[] args) {
        String s = "ACTGACG";
        String circular = "";
        int len = s.length();
        StdOut.println(circular);
        String temp = "";
        for (int i = 1; i < len; i++) {
            temp = s.substring(i, len) + s.substring(0, i);
//            StdOut.println(temp);
            if (temp.equals(circular))
                StdOut.println(temp);
        }
        StdOut.print(mystery(s));
    }
    
    public static String mystery(String s)     {
        int N=s.length();
        if(N<=1)
            return s;
        String a=s.substring(0, N/2);
        String b=s.substring(N/2, N);
//        StdOut.println(a+b);
        return mystery(b)+ mystery(a);
    }
}
