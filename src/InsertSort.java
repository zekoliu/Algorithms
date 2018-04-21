import edu.princeton.cs.algs4.StdOut;

import java.sql.Date;
import java.util.Comparator;

public class InsertSort {

    private static boolean less(Comparator a, Object v, Object w) {
        return a.compare(v, w) < 0;
    }

    public static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static void sort(Object[] a, Comparator c) {
        int len = a.length;
        for (int i = 0; i < len; i++)
            for (int j = i; j > 0 && less(c, a[j], a[j-1]); j--)
                exch(a, j, j-1);
    }

    private static void show(Job[] vers) {
        for (int i = 0; i < vers.length; i++)
            StdOut.println(vers[i] + " ");
    }

    public static void main(String[] args) {
        Version_10 s1 = new Version_10("115.1.1");
        Version_10 s2 = new Version_10("115.10.1");
        Version_10 s3 = new Version_10("115.10.2");
        Version_10 s4 = new Version_10("115.2.1");
        Version_10[] ss = {s1, s2, s3, s4};
        Job j1 = new Job("solution 2.4.1", new Date(10-10-2010), 20.1);
        Job j2 = new Job("solution 2.4.2", new Date(10-10-2012), 10);
        Job j3 = new Job("solution 2.4.3", new Date(10-10-2010), 20.0);
        Job[] jobs = {j1, j2, j3};
        sort(jobs, new Job.WhatOrder());
        show(jobs);
    }
}
