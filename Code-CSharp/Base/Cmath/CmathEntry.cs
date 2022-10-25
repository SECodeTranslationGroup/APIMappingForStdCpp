namespace CodeCsharp.Base.Cmath;

public class CmathEntry {
  public static void NumbersProgram() {
    int i1 = 3, i2 = 2;
    double d1 = 3.5, d2 = 1.5, d3 = 0.5;

    int iAbs = Math.Abs(i1);
    double dAbs = Math.Abs(d1);
    double dMod = d1 % d2;
    double dRemainder = Math.IEEERemainder(d1, d2);

    double fma = Math.FusedMultiplyAdd(d1, d2, d3);
    double dim = d1 > d2 ? d1 - d2 : 0;

    double lerp = d1 + d3 * (d2 - d1);
    double exp = Math.Exp(d1);
    double exp2 = Math.Pow(2, d1);
    double expm1 = Math.Exp(d1) - 1;
    double log = Math.Log(d1);
    double log2 = Math.Log2(d1);
    double log10 = Math.Log10(d1);
    double log1p = Math.Log(d1 + 1);
    double logBase = Math.Log(d1) / Math.Log(d2);

    double pow = Math.Pow(d1, d2);
    double sqrt = Math.Sqrt(d1);
    double cbrt = Math.Cbrt(d1);
    //double hypot = Double.Hypot(d1, d2);
    //double hypot3 =  Double.Hypot(Double.Hypot(d1, d2), d3);

    double sin = Math.Sin(d1);
    double asin = Math.Asin(d3);
    double cos = Math.Cos(d1);
    double acos = Math.Acos(d3);
    double tan = Math.Tan(d1);
    double atan = Math.Atan(d3);
    double atan2 = Math.Atan2(d2, d1);

    double sinh = Math.Sinh(d1);
    double asinh = Math.Asinh(d3);
    double cosh = Math.Cosh(d1);
    double acosh = Math.Acosh(d3);
    double tanh = Math.Tanh(d1);
    double atanh = Math.Atanh(d3);

    double ceil = Math.Ceiling(d1);
    double floor = Math.Floor(d1);
    double trunc = Math.Truncate(d1);
    double round = Math.Round(d1);

    double ldExp = Math.ScaleB(d1, i1);
    double nextUp =  Math.BitIncrement(d1);
    double nextDown =  Math.BitDecrement(d1);
    double copySign = Math.CopySign(d1, d2);

    bool isFinite = double.IsFinite(d1);
    bool isInf = double.IsInfinity(d1);
    bool isNan = double.IsNaN(d1);
  }
}