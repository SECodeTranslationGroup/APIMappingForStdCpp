namespace CodeCsharp.Base.Cmath;

public class CmathEntry {
  public static void NumbersProgram() {
    //initialize math values
    int i1 = 3;
    double d1 = 3.5, d2 = 1.5, d3 = 0.5;
    //absolute
    double abs = Math.Abs(d1);
    //floating point remainder
    double dMod = d1 % d2;
    //IEEE remainder
    double dRemainder = Math.IEEERemainder(d1, d2);
    //fuse multiply add
    double fma = Math.FusedMultiplyAdd(d1, d2, d3);
    //positive difference
    double dim = d1 > d2 ? d1 - d2 : 0;
    //linear interpolation
    double lerp = d1 + d3 * (d2 - d1);
    //power of e
    double exp = Math.Exp(d1);
    //power of 2
    double exp2 = Math.Pow(2, d1);
    //power of e minus 1
    double expm1 = Math.Exp(d1) - 1;
    //logarithm base e
    double log = Math.Log(d1);
    //logarithm base 2
    double log2 = Math.Log2(d1);
    //logarithm base 10
    double log10 = Math.Log10(d1);
    //logarithm base e of value plus 1
    double log1p = Math.Log(d1 + 1);
    //logarithm base any value
    double logBase = Math.Log(d1) / Math.Log(d2);
    //power of any value
    double pow = Math.Pow(d1, d2);
    //square root
    double sqrt = Math.Sqrt(d1);
    //cubic root
    double cbrt = Math.Cbrt(d1);
    //square root of the sum of the squares of two
    double hypot = Math.Sqrt(d1 * d1 + d2 * d2);
    //square root of the sum of the squares of three
    double hypot3 = Math.Sqrt(d1 * d1 + d2 * d2 + d3 * d3);
    //sine cosine and tangent
    double sin = Math.Sin(d1);
    double cos = Math.Cos(d1);
    double tan = Math.Tan(d1);
    //arc-sine arc-cosine and arc-tangent
    double asin = Math.Asin(d3);
    double acos = Math.Acos(d3);
    double atan = Math.Atan(d3);
    //arc-tangent of coordinate
    double atan2 = Math.Atan2(d2, d1);
    //hyperbolic sine cosine and tangent
    double sinh = Math.Sinh(d1);
    double cosh = Math.Cosh(d1);
    double tanh = Math.Tanh(d1);
    //inverse hyperbolic sine cosine and tangent
    double asinh = Math.Asinh(d3);
    double acosh = Math.Acosh(d3);
    double atanh = Math.Atanh(d3);
    //nearest int less or equal value
    double ceil = Math.Ceiling(d1);
    //nearest int greater or equal value
    double floor = Math.Floor(d1);
    //nearest int toward 0
    double trunc = Math.Truncate(d1);
    //nearest int rounding
    double round = Math.Round(d1);
    //power of 2 multiples value
    double ldExp = Math.ScaleB(d1, i1);
    //next greater float value
    double nextUp = Math.BitIncrement(d1);
    //next less float value
    double nextDown = Math.BitDecrement(d1);
    //copy sign of a float value
    double copySign = Math.CopySign(d1, d2);
    //whether float is finite
    bool isFinite = double.IsFinite(d1);
    //whether float is infinite
    bool isInf = double.IsInfinity(d1);
    //whether float is nan
    bool isNan = double.IsNaN(d1);
  }
}