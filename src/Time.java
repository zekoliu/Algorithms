public class Time implements Comparable<Time> {
    private int hour;
    private int min;
    private int second;

    public Time(String time) {
        String delim = ":";
        String[] times = time.split(delim);
        hour = Integer.parseInt(times[0]);
        min = Integer.parseInt(times[1]);
        second = Integer.parseInt(times[2]);
    }

    public String toString() {
        return this.hour + ":" + this.min + ":" + second;
    }

    public int compareTo(Time t) {
        if (this.hour > t.hour)     return 1;
        if (this.hour < t.hour)     return -1;
        if (this.min > t.min)       return 1;
        if (this.min < t.min)       return -1;
        if (this.second > t.second) return 1;
        if (this.second < t.second) return -1;
        return 0;
    }
}
