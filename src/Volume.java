
import java.util.Comparator;
import java.util.Date;

public class Volume {
    private final Date date;
    private final Double amount;

    public Volume(Date d, Double s) {
        date = d;
        amount = s;
    }

    public String toString() {
        return date + " " + amount;
    }

    public static class WhenOrder implements Comparator<Volume> {
        public int compare(Volume v, Volume w) {
            return v.date.compareTo(w.date);
        }
    }

    public static class HowMuchOrder implements Comparator<Volume> {
        public int compare(Volume v, Volume w) {
            if (v.amount < w.amount) return -1;
            if (v.amount > w.amount) return 1;
            return 0;
        }
    }
}
