import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

public class Version {
    private final int start;
    private final int mid;
    private final int end;

    public Version_10(String s) {
        String[] strings = s.split("\\.");
        start = Integer.parseInt(strings[0]);
        mid = Integer.parseInt(strings[1]);
        end = Integer.parseInt(strings[2]);
    }

    public String toString() {
        return start + "." + mid + "." + end;
    }

    public static class WhatOrder implements Comparator<Version_10> {
        public int compare(Version_10 v, Version_10 v1) {
            if (v.start > v1.start) return 1;
            if (v.start < v1.start) return -1;
            if (v.start == v1.start)  {
                if (v.mid > v1.mid)
                    return 1;
                else if (v.mid < v1.mid)
                    return -1;
                else if (v.mid == v1.mid) {
                    if (v.end > v1.end)
                        return 1;
                    else if (v.end < v1.end)
                        return -1;
                    else
                        return 0;
                }
            }
            return 0;
        }
    }
}
