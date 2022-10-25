package codejava.base.cmath;

public class CmathEntry {
  public static void NumbersProgram() {
    int i1 = 3, i2 = 2;
    double d1 = 3.5, d2 = 1.5, d3 = 0.5;

    int iAbs = Math.abs(i1);
    double dAbs = Math.abs(d1);
    double dMod = d1 % d2;
    double dRemainder = Math.IEEEremainder(d1, d2);

    double fma = Math.fma(d1, d2, d3);
    double dim = d1 > d2 ? d1 - d2 : 0;

    double lerp = d1 + d3 * (d2 - d1);
    double exp = Math.exp(d1);
    double exp2 = Math.pow(2, d1);
    double expm1 = Math.expm1(d1);
    double log = Math.log(d1);
    double log2 = Math.log(d1) / Math.log(2);
    double log10 = Math.log10(d1);
    double log1p = Math.log1p(d1);
    double logBase = Math.log(d1) / Math.log(d2);

    double pow = Math.pow(d1, d2);
    double sqrt = Math.sqrt(d1);
    double cbrt = Math.cbrt(d1);
    double hypot = Math.hypot(d1, d2);
    double hypot3 = Math.hypot(Math.hypot(d1, d2), d3);

    double sin = Math.sin(d1);
    double asin = Math.asin(d3);
    double cos = Math.cos(d1);
    double acos = Math.acos(d3);
    double tan = Math.tan(d1);
    double atan = Math.atan(d3);
    double atan2 = Math.atan2(d2, d1);

    double sinh = Math.sinh(d1);
    double asinh = Math.log(d1 + Math.sqrt(d1 * d1 + 1.0));
    double cosh = Math.cosh(d1);
    double acosh = Math.log(d1 + Math.sqrt(d1 * d1 - 1.0));
    double tanh = Math.tanh(d1);
    double atanh = 0.5 * Math.log((d1 + 1.0) / (d1 - 1.0));

    double ceil = Math.ceil(d1);
    double floor = Math.floor(d1);
    double trunc = d1 < 0 ? Math.ceil(d1) : Math.floor(d1);
    double round = Math.round(d1);

    double ldExp = Math.scalb(d1, i1);
    double nextUp = Math.nextUp(d1);
    double nextDown = Math.nextDown(d1);
    double copySign = Math.copySign(d1, d2);

    boolean isFinite = Double.isFinite(d1);
    boolean isInf = Double.isInfinite(d1);
    boolean isNan = Double.isNaN(d1);
  }
}
