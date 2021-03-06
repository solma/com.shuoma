package com.sma.ds.math;

import static com.sma.util.MathUtil.greatestCommonDivisor;

import java.util.HashMap;
import java.util.Map;

public class Fraction {
  long numerator;
  long denominator;

  Fraction(long numerator, long denominator) {
    this.numerator = numerator;
    this.denominator = denominator;
  }

  Fraction add(Fraction other) {
    numerator = numerator * other.denominator + other.numerator * denominator;
    denominator = denominator * other.denominator;
    return proper();
  }

  Fraction multiple(Fraction other) {
    numerator *= other.numerator;
    denominator *= other.denominator;
    return proper();
  }

  private Fraction proper() {
    long gcd = greatestCommonDivisor(numerator, denominator);
    //System.out.println(numerator + " " + denominator + " " + gcd);
    numerator /= gcd;
    denominator /= gcd;
    return this;
  }

  private Decimal toDecimal() {
    proper();
    StringBuilder sb = new StringBuilder();

    sb.append((numerator > 0 ^ denominator > 0) ? "-" : "");
    long n = Math.abs(this.numerator), d = Math.abs(this.denominator);
    sb.append(n / d);
    long r = n % d;
    if (r > 0) {
      sb.append(".");
      Map<Long, Integer> fractionalPart = new HashMap<>();
      while (r > 0) {
        if (fractionalPart.containsKey(r)) {
          sb.insert(fractionalPart.get(r), ".");
          //sb.append(")");
          break;
        }
        fractionalPart.put(r, sb.length());
        r *= 10;
        sb.append(r / d);
        r %= d;
      }
    }
    return new Decimal(sb.toString());
  }

  @Override
  public String toString() {
    return numerator + "/" + denominator;
  }

  public static void main(String[] args) {
    System.out.println(new Fraction(2, 15).toDecimal());
  }
}
