package codejava.base.cmath;

import java.rmi.MarshalException;

public class CmathEntry {
  public static void NumbersProgram() {
    //initialize math values
    int i1 = 3;
    double d1 = 3.5, d2 = 1.5, d3 = 0.5;
    //absolute
    double abs = Math.abs(d1);
    //floating point remainder
    double dMod = d1 % d2;
    //IEEE remainder
    double dRemainder = Math.IEEEremainder(d1, d2);
    //fuse multiply add
    double fma = Math.fma(d1, d2, d3);
    //positive difference
    double dim = d1 > d2 ? d1 - d2 : 0;
    //linear interpolation
    double lerp = d1 + d3 * (d2 - d1);
    //power of e
    double exp = Math.exp(d1);
    //power of 2
    double exp2 = Math.pow(2, d1);
    //power of e minus 1
    double expm1 = Math.expm1(d1);
    //logarithm base e
    double log = Math.log(d1);
    //logarithm base 2
    double log2 = Math.log(d1) / Math.log(2);
    //logarithm base 10
    double log10 = Math.log10(d1);
    //logarithm base e of value plus 1
    double log1p = Math.log1p(d1);
    //logarithm base any value
    double logBase = Math.log(d1) / Math.log(d2);
    //power of any value
    double pow = Math.pow(d1, d2);
    //square roo
    double sqrt = Math.sqrt(d1);
    //cubic root
    double cbrt = Math.cbrt(d1);
    //square root of the sum of the squares of two
    double hypot = Math.hypot(d1, d2);
    //square root of the sum of the squares of three
    double hypot3 = Math.hypot(Math.hypot(d1, d2), d3);
    //sine cosine and tangent
    double sin = Math.sin(d1);
    double cos = Math.cos(d1);
    double tan = Math.tan(d1);
    //arc-sine arc-cosine and arc-tangent
    double asin = Math.asin(d3);
    double acos = Math.acos(d3);
    double atan = Math.atan(d3);
    //arc-tangent of coordinate
    double atan2 = Math.atan2(d2, d1);
    //hyperbolic sine cosine and tangent
    double sinh = Math.sinh(d1);
    double cosh = Math.cosh(d1);
    double tanh = Math.tanh(d1);
    //inverse hyperbolic sine cosine and tangent
    double asinh = Math.log(d1 + Math.sqrt(d1 * d1 + 1.0));
    double acosh = Math.log(d1 + Math.sqrt(d1 * d1 - 1.0));
    double atanh = 0.5 * Math.log((d1 + 1.0) / (d1 - 1.0));
    //nearest int less or equal value
    double ceil = Math.ceil(d1);
    //nearest int greater or equal value
    double floor = Math.floor(d1);
    //nearest int toward 0
    double trunc = d1 < 0 ? Math.ceil(d1) : Math.floor(d1);
    //nearest int rounding
    double round = Math.round(d1);
    //power of 2 multiples value
    double ldExp = Math.scalb(d1, i1);
    //next greater float value
    double nextUp = Math.nextUp(d1);
    //next less float value
    double nextDown = Math.nextDown(d1);
    //copy sign of a float value
    double copySign = Math.copySign(d1, d2);
    //whether float is finite
    boolean isFinite = Double.isFinite(d1);
    //whether float is infinite
    boolean isInf = Double.isInfinite(d1);
    //whether float is nan
    boolean isNan = Double.isNaN(d1);
  }

  public static boolean testAll() {
    boolean ret = true;
    double epsilon = 1e-10;
    ret = Math.abs(Math.abs(-3.5) - 3.5) < epsilon
        && Math.abs(6.8 % 2.4 - 2) < epsilon
        && Math.abs(Math.IEEEremainder(6.8, 2.4) + 0.4) < epsilon
        && Math.abs(Math.fma(0.9, 0.9, 0.19) - 1.0) < epsilon
        && Math.abs((-1 > -4 ? -1+4:0)-3) <epsilon
        && Math.abs((-4> -1 ? -4+1:0) - 0) < epsilon
        && Math.abs(1 + 0.2 * (5 - 1) - 1.8) < epsilon
        && Math.abs(5 + 0.2 * (1 - 5) - 4.2) < epsilon
        && Math.abs(Math.exp(2) - Math.E * Math.E) < epsilon
        && Math.abs(Math.pow(2, 2) - 4) < epsilon
        && Math.abs(Math.expm1(2) - Math.E * Math.E + 1) < epsilon
        && Math.abs(Math.log(Math.E * Math.E) - 2) < epsilon
        && Math.abs(Math.log(4) / Math.log(2) - 2) < epsilon
        && Math.abs(Math.log10(100) - 2) < epsilon
        && Math.abs(Math.log1p(Math.E * Math.E - 1) - 2) < epsilon
        && Math.abs(Math.log(9) / Math.log(3) - 2) < epsilon
        && Math.abs(Math.pow(2, 3) - 8) < epsilon
        && Math.abs(Math.hypot(3, 4) - 5) < epsilon
        && Math.abs(Math.hypot(Math.hypot(3, 4), 12) - 13) < epsilon
        && Math.abs(Math.sin(Math.PI / 6) - 0.5) < epsilon
        && Math.abs(Math.cos(Math.PI / 3) - 0.5) < epsilon
        && Math.abs(Math.tan(Math.PI / 4) - 1) < epsilon
        && Math.abs(Math.asin(0.5) - Math.PI / 6) < epsilon
        && Math.abs(Math.acos(0.5) - Math.PI / 3) < epsilon
        && Math.abs(Math.atan(1) - Math.PI / 4) < epsilon
        && Math.abs(Math.atan2(1, 1) - Math.PI / 4) < epsilon
        && Math.abs(Math.sinh(1) - (Math.E - 1 / Math.E) / 2) < epsilon
        && Math.abs(Math.cosh(1) - (Math.E + 1 / Math.E) / 2) < epsilon
        && Math.abs(Math.tanh(1) - Math.sinh(1) / Math.cosh(1)) < epsilon
        && Math.abs(Math.ceil(0.2) - 1) < epsilon
        && Math.abs(Math.floor(1.7) - 1) < epsilon
        && Math.abs((1.7 < 0 ? Math.ceil(1.7) : Math.floor(1.7)) - 1) < epsilon
        && Math.abs((-1.7 < 0 ? Math.ceil(-1.7) : Math.floor(-1.7)) + 1) < epsilon
        && Math.abs(Math.round(1.7) - 2) < epsilon
        && Math.abs(Math.scalb(1.5, 3) - 12) < epsilon
        && Math.abs(Math.nextUp(0) - Double.MIN_VALUE) < epsilon
        && Math.abs(Math.nextDown(0) + Double.MIN_VALUE) < epsilon
        && Math.abs(Math.copySign(1.3, -1) + 1.3) < epsilon
        && Double.isFinite(3.1)
        && !Double.isFinite(Double.POSITIVE_INFINITY)
        && !Double.isFinite(Math.sqrt(-1))
        && !Double.isInfinite(3.1)
        && Double.isInfinite(Double.POSITIVE_INFINITY)
        && !Double.isInfinite(Math.sqrt(-1))
        && !Double.isNaN(3.1)
        && !Double.isNaN(Double.POSITIVE_INFINITY)
        && Double.isNaN(Math.sqrt(-1));
    if (!ret)
      System.out.println("Cmath Test Failed!");
    return ret;
  }
}
