import java.sql.Date;
import java.util.Comparator;

public class Job {
    private final String name;
    private final Date date;
    private final double time;

    public Job(String n, Date d, double t) {
        name = n;
        date = d;
        time = t;
    }

    public String toString() {
        return name + " " + date + " " + time;
    }

    public static class WhatOrder implements Comparator<Job> {
        public int compare(Job j, Job anotherJ) {
            if (j.time > anotherJ.time)
                return 1;
            if (j.time < anotherJ.time)
                return -1;
            return 0;
        }
    }
}