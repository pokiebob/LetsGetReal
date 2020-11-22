public class RealNumber{
  private double value;

  public RealNumber(double v){
    value = v;
  }

  public double getValue(){
    return value;
  }

  public String toString(){
    return ""+getValue();
  }
  //---------ONLY EDIT BELOW THIS LINE------------

  /*
  *Return true when the values are within 0.001% of eachother.
  *Special case: if one is exactly zero, the other must be exactly zero.
  */
  public boolean equals(RealNumber other){
    if (value == 0 && other.getValue() == 0) {
      return true;
    }
    if ( Math.round(100000 * value) == Math.round(100000 * other.getValue()) ) {
      return true;
    }
    return false;
  }

  /*
  *Return a new RealNumber that has the value of:
  *the sum of this and the other
  */
  public RealNumber add(RealNumber other){
     //other can be ANY RealNumber, including a RationalNumber
     //or other subclasses of RealNumber (that aren't written yet)
     return new RealNumber(value + other.getValue());
  }

  /*
  *Return a new RealNumber that has the value of:
  *the product of this and the other
  */
  public RealNumber multiply(RealNumber other){
        return new RealNumber(value * other.getValue());
  }

  /*
  *Return a new RealNumber that has the value of:
  *this divided by the other
  */
  public RealNumber divide(RealNumber other){
        return new RealNumber(value / other.getValue());
  }

  /*
  *Return a new RealNumber that has the value of:
  *this minus the other
  */
  public RealNumber subtract(RealNumber other){
    return null;
  }
  public static void main(String[] args) {
    RealNumber a = new RealNumber(0.125);
    RealNumber a1 = new RealNumber(0.125001);
    RealNumber a2 = new RealNumber(0.12501);
    RealNumber b = new RealNumber(1.125);
    RealNumber c = new RealNumber(0);
    RealNumber c1 = new RealNumber(0.0);
    RealNumber d = new RealNumber(1);

    System.out.println(a.equals(a1));
    System.out.println(a.equals(a2));
    System.out.println(a.equals(b));
    System.out.println(c.equals(c1));

    System.out.println(b.equals(a.add(d)));
    System.out.println(a1.add(a2));

    System.out.println(a.multiply(c));
    System.out.println(b.multiply(d));

    System.out.println(c.divide(a));
    System.out.println(b.divide(d));
    System.out.println(d.divide(a));
  }
}
