public class Date {
    private final int month;
    private final int day;
    private final int year;

    public Date(int m, int d, int y) {
        this.month = m;
        this.day =d;
        this.year = y;
    }

    public int month() {
        return month;
    }

    public int day() {
        return day;
    }

    public int year() {
        return year;
    }

    public String toString() {
        return month() + "/" + day() + "/" + year();
    }

    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + ((Integer)month).hashCode();
        hash = 31 * hash + ((Integer)day).hashCode();
        hash = 31 * hash + ((Integer)year).hashCode();
        return hash;
    }
}
