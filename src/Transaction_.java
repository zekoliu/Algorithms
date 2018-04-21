import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;

import java.util.Date;

public class Transaction {
    private String who;
    private Date when;
    private double amount;

    public Transaction_13(String name, Date data, double amt) {
        who = name;
        when = data;
        amount = amt;
    }

    public String name() {
        return who;
    }

    public Date date() {
        return when;
    }

    public double amount() {
        return amount;
    }

    public String toString() {
        return "name is: " + who + "when " + when + "amount " + amount;
    }

    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Transaction that = (Transaction)x;
        if (this.who != that.who()) return false;
//        if (this.when != that.when) return false;
        if (this.amount != that.amount()) return false;
        return true;
    }

    public static void main(String[] args) {
        String name = "kobe bryant";
        Date date = new Date("2018/3/20");
        double amount = 100000;
        Transaction tr = new Transaction(name, date, amount);
        StdOut.println(tr.who);
    }
}
