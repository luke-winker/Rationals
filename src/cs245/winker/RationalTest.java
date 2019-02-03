package cs245.winker;

public class RationalTest {

    public static void main(String[] args) {
	// write your code here
        Rational r = new Rational(2,8);
        Rational r2 = new Rational(4,10);

        System.out.println("Rational 'r' :  " + r.toString());
        System.out.println("Rational 'r2':  " + r2.toString());
        System.out.println("Rational 'r' reduced:  " + r.reduce().toString());
        System.out.println("Rational 'r2' reduced:  " + r2.reduce().toString());
        System.out.println("Rationals 'r' and 'r2' multiplied:  " + r.multiply(r2).toString());
        System.out.println("Rationals 'r' and 'r2' added:  " + r.add(r2).toString());
    }
}
