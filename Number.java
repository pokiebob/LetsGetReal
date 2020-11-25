public abstract class Number{

  public abstract double getValue();

  /*return 0 when this Number equals the other RealNumber
  return a negative value when this Number is smaller than the other Number
  return a positive value when this Number is larger than the other Number
  */
  public int compareTo(Number other){
    double difference = this.getValue() - other.getValue();
    if (difference == 0.0) {
      return 0;
    } else if (difference > 0) {
      return 1;
    } else {
      return -1;
    }
  }

  /*
  *Return true when the % difference of the values
  *are within 0.00001 of eachother.
  *Special case: if one is exactly zero, the other must be exactly zero.
  */
  public boolean equals(RealNumber other){
    if (this.getValue() == 0 && other.getValue() == 0) {
      return true;
    }
    if ( Math.round(1000000 * this.getValue()) == Math.round(1000000 * other.getValue()) ) {
      return true;
    }
    return false;
  }
}