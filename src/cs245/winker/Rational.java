package cs245.winker;

public class Rational {
    private int numerator;
    private int denominator;

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    private Rational helpMultiply(Rational r) {
        // Multiply but not reduced
        Rational result = new Rational();
        result.numerator = this.numerator * r.numerator;
        result.denominator = this.denominator * r.denominator;
        return result;
    }

    public Rational() {
        this.numerator = 1;
        this.denominator = 1;
    }

    public Rational(int num, int den) {
        if (num >= 0 && den > 0) {
            this.numerator = num;
            this.denominator = den;
        } else {
            throw
                    new ArithmeticException();
        }
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public Rational reduce() {
        int gcd = gcd(numerator, denominator);
        int x = numerator / gcd;
        int y = denominator / gcd;
        Rational r = new Rational(x, y);
        return r;
    }

    public Rational multiply(Rational r) {
        Rational result = new Rational();
        result.numerator = this.numerator * r.numerator;
        result.denominator = this.denominator * r.denominator;
        return result.reduce();
    }

    public Rational add(Rational r) {
        // Creates returnable rational
        Rational result = new Rational();

        // Finds least common multiple
        int lcm = (this.denominator * r.denominator) / gcd(this.denominator, r.denominator);
        result.denominator = lcm;

        // Finds numbers to multiply with the rationals
        int multiple1 = lcm / this.denominator;
        int multiple2 = lcm / r.denominator;

        // Multiply our rationals by their corresponding multiple
        // - Create x and y to help create adjusted rationals
        Rational x = new Rational(multiple1, multiple1);
        Rational y = new Rational(multiple2, multiple2);
        // - Do actual multiplying
        Rational newA = this.helpMultiply(x);
        Rational newB = r.helpMultiply(y);

        // Add numerator
        result.numerator = newA.numerator + newB.numerator;

        // Return reduced result
        return result.reduce();

    }



}
