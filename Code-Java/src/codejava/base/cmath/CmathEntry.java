package codejava.base.cmath;

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
}
