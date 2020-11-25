public class RationalNumber extends RealNumber {
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(0.0);
    if (deno == 0) {
      numerator = 0;
      denominator = 1;
    } else {
      numerator = nume;
      denominator = deno;
      if (denominator < 0) {
        numerator = numerator * -1;
        denominator = denominator * -1;
      }
    }
  }

  public double getValue(){
    return (double) numerator / denominator;
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }

  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    return new RationalNumber(denominator, numerator);
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    if (numerator == 0 || other.getNumerator() == 0) {
      return numerator == 0 && other.getNumerator() == 0;
    } else {
      reduce();
      other.reduce();
      return numerator == other.getNumerator() && denominator == other.getDenominator();
    }
  }
  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    if (denominator == 1 || numerator == 0) {
      return "" + numerator;
    }
    return "" + numerator + "/" + denominator;
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    /*use euclids method or a better one*/
    // http:sites.math.rutgers.edu/~greenfie/gs2004/euclid.html
    if (a < b) {
      int c = a;
      a = b;
      b = c;
    }
    int r = a%b;
    while (r != 0) {
      a = b;
      b = r;
      r = a % b;
    }
    return b;

  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    int gcdee = gcd(numerator, denominator);
    numerator = numerator / gcdee;
    denominator = denominator / gcdee;
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    return new RationalNumber(numerator * other.getNumerator(), denominator * other.getDenominator());
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    return multiply(other.reciprocal());
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    return new RationalNumber(numerator * other.getDenominator() + other.getNumerator() * denominator, denominator * other.getDenominator());
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    return new RationalNumber(numerator * other.getDenominator() - other.getNumerator() * denominator, denominator * other.getDenominator());
  }

  public static void main(String[] args) {
    RationalNumber a = new RationalNumber(1, 2);
    RationalNumber b = new RationalNumber(4, 1);
    RationalNumber c = new RationalNumber(20, 0);
    RationalNumber d = new RationalNumber(3, 6);

    System.out.println(a.getValue());
    System.out.println(b.getValue());
    System.out.println(c.getValue());

    System.out.println(a.getNumerator());
    System.out.println(b.getNumerator());
    System.out.println(c.getNumerator());

    System.out.println(a.getDenominator());
    System.out.println(b.getDenominator());
    System.out.println(c.getDenominator());

    System.out.println(b.getValue() - a.reciprocal().getValue());
    System.out.println(a.getValue() - b.reciprocal().getValue());

    System.out.println(a.equals(b));
    System.out.println(c.equals(new RationalNumber(0, 4)));
    System.out.println(a.equals(d));

    System.out.println(a);
    System.out.println(b);
    System.out.println(c);

    System.out.println(gcd(a.getNumerator(), a.getDenominator()));
    System.out.println(gcd(3, 6));

    System.out.println(a.multiply(b));
    System.out.println(b.multiply(c));

    System.out.println(b.divide(a));
    System.out.println(b.divide(c));

    System.out.println(a.add(b));
    System.out.println(d.add(b));
    System.out.println(b.add(c));

    System.out.println(a.subtract(b));
    System.out.println(d.subtract(b));
    System.out.println(b.subtract(c));

  }
} 
