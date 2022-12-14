#include "cmath_entry.h"
#include <iostream>
#include <numbers>
#include <vector>
#include <any>
void CmathEntry::CmathProgram() {
  //initialize math values
  int i1 = 3;
  double d1 = 3.5, d2 = 1.5, d3 = 0.5;
  //absolute
  double abs = std::abs(d1);
  //floating point remainder
  double d_mod = std::fmod(d1, d2);
  //IEEE remainder
  double d_remainder = std::remainder(d1, d2);
  //fuse multiply add
  double fma = std::fma(d1, d2, d3);
  //positive difference
  double dim = std::fdim(d1, d2);
  //linear interpolation
  double lerp = std::lerp(d1, d2, d3);
  //power of e
  double exp = std::exp(d1);
  //power of 2
  double exp2 = std::exp2(d1);
  //power of e minus 1
  double expm1 = std::expm1(d1);
  //logarithm base e
  double log = std::log(d1);
  //logarithm base 2
  double log2 = std::log2(d1);
  //logarithm base 10
  double log10 = std::log10(d1);
  //logarithm base e of value plus 1
  double log1p = std::log1p(d1);
  //logarithm base any value
  double log_base = std::log(d1) / std::log(d2);
  //power of any value
  double pow = std::pow(d1, d2);
  //square root
  double sqrt = std::sqrt(d1);
  //cubic root
  double cbrt = std::cbrt(d1);
  //square root of the sum of the squares of two
  double hypot = std::hypot(d1, d2);
  //square root of the sum of the squares of three
  double hypot3 = std::hypot(d1, d2, d3);
  //sine cosine and tangent
  double sin = std::sin(d1);
  double cos = std::cos(d1);
  double tan = std::tan(d1);
  //arc-sine arc-cosine and arc-tangent
  double asin = std::asin(d3);
  double acos = std::acos(d3);
  double atan = std::atan(d3);
  //arc-tangent of coordinate
  double atan2 = std::atan2(d2, d1);
  //hyperbolic sine cosine and tangent
  double sinh = std::sinh(d1);
  double cosh = std::cosh(d1);
  double tanh = std::tanh(d1);
  //inverse hyperbolic sine cosine and tangent
  double asinh = std::asinh(d3);
  double acosh = std::acosh(d3);
  double atanh = std::atanh(d3);
  //nearest int less or equal value
  double ceil = std::ceil(d1);
  //nearest int greater or equal value
  double floor = std::floor(d1);
  //nearest int toward 0
  double trunc = std::trunc(d1);
  //nearest int rounding
  double round = std::round(d1);
  //power of 2 multiples value
  double ld_exp = std::ldexp(d1, i1);
  //next greater float value
  double next_up = std::nextafter(d1, std::numeric_limits<double>::infinity());
  //next less float value
  double next_down = std::nextafter(d1, -std::numeric_limits<double>::infinity());
  //copy sign of a float value
  double copysign = std::copysign(d1, d2);
  //whether float is finite
  bool is_finite = std::isfinite(d1);
  //whether float is infinite
  bool is_inf = std::isinf(d1);
  //whether float is nan
  bool is_nan = std::isnan(d1);
}
bool CmathEntry::TestAll() {
  bool ret = true;
  double epsilon = 1e-10;
  using namespace std;
  ret = abs(abs(-3.5) - 3.5) < epsilon
      && abs(fmod(6.8, 2.4) - 2) < epsilon
      && abs(remainder(6.8, 2.4) + 0.4) < epsilon
      && abs(fma(0.9, 0.9, 0.19) - 1.0) < epsilon
      && abs(fdim(-1, -4) - 3) < epsilon
      && abs(fdim(-4, -1) - 0) < epsilon
      && abs(lerp(1, 5, 0.2) - 1.8) < epsilon
      && abs(lerp(5, 1, 0.2) - 4.2) < epsilon
      && abs(exp(2) - numbers::e * numbers::e) < epsilon
      && abs(exp2(2) - 4) < epsilon
      && abs(expm1(2) - numbers::e * numbers::e + 1) < epsilon
      && abs(log(numbers::e * numbers::e) - 2) < epsilon
      && abs(log2(4) - 2) < epsilon
      && abs(log10(100) - 2) < epsilon
      && abs(log1p(numbers::e * numbers::e - 1) - 2) < epsilon
      && abs(log(9) / log(3) - 2) < epsilon
      && abs(pow(2, 3) - 8) < epsilon
      && abs(hypot(3, 4) - 5) < epsilon
      && abs(hypot(3, 4, 12) - 13) < epsilon
      && abs(sin(numbers::pi / 6) - 0.5) < epsilon
      && abs(cos(numbers::pi / 3) - 0.5) < epsilon
      && abs(tan(numbers::pi / 4) - 1) < epsilon
      && abs(asin(0.5) - numbers::pi / 6) < epsilon
      && abs(acos(0.5) - numbers::pi / 3) < epsilon
      && abs(atan(1) - numbers::pi / 4) < epsilon
      && abs(atan2(1, 1) - numbers::pi / 4) < epsilon
      && abs(sinh(1) - (numbers::e - 1 / numbers::e) / 2) < epsilon
      && abs(cosh(1) - (numbers::e + 1 / numbers::e) / 2) < epsilon
      && abs(tanh(1) - sinh(1) / cosh(1)) < epsilon
      && abs(ceil(0.2) - 1) < epsilon
      && abs(floor(1.7) - 1) < epsilon
      && abs(trunc(1.7) - 1) < epsilon
      && abs(trunc(-1.7) + 1) < epsilon
      && abs(round(1.7) - 2) < epsilon
      && abs(ldexp(1.5, 3) - 12) < epsilon
      && abs(nextafter(0, numeric_limits<double>::infinity()) -
          numeric_limits<double>::min()) < epsilon
      && abs(nextafter(0, -numeric_limits<double>::infinity()) -
          -numeric_limits<double>::min()) < epsilon
      && abs(copysign(1.3, -1) + 1.3) < epsilon
      && isfinite(3.1)
      && !isfinite(numeric_limits<double>::infinity())
      && !isfinite(sqrt(-1))
      && !isinf(3.1)
      && isinf(numeric_limits<double>::infinity())
      && !isinf(sqrt(-1))
      && !isnan(3.1)
      && !isnan(numeric_limits<double>::infinity())
      && isnan(sqrt(-1));
  if (!ret)
    cout << "Cmath Test Failed!"<< endl;
  return ret;
}
