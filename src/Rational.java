import edu.princeton.cs.algs4.StdOut;

import java.util.Random;

public class Rational {
    private int numerator;
    private int denominator;

    public Rational(int NA, int DA) {
        numerator = NA;
        denominator = DA;
    }

    public Rational plus(Rational b) {
        numerator = numerator + b.numerator;
        denominator = denominator + b.denominator;
        return  this;
    }

    public Rational minus(Rational b) {
        numerator = this.numerator - b.numerator;
        denominator = this.numerator - b.denominator;
        return this;
    }

    public Rational times(Rational b) {
        numerator = b.numerator * this.numerator;
        denominator = b.denominator * this.denominator;
        return this;
    }

    public Rational divides(Rational b) {
        numerator = b.numerator * this.denominator;
        denominator = b.denominator * this.numerator;
        return this;
    }

    public String toString() {
        return (this.numerator + "/" + this.denominator);
    }

    public static void main(String[] args) {
        Rational a = new Rational(1, 4);
        Rational b = new Rational(1,4);
        a.times(b);
        StdOut.println(a + " " + b);
    }
}
