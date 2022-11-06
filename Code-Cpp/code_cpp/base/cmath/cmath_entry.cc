#include "cmath_entry.h"
#include <iostream>

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
  double pow = std::pow(d1,d2);
  //square root
  double sqrt = std::sqrt(d1);
  //cubic root
  double cbrt = std::cbrt(d1);
  //square root of the sum of the squares of two
  double hypot = std::hypot(d1,d2);
  //square root of the sum of the squares of three
  double hypot3 = std::hypot(d1,d2,d3);
  //sine cosine and tangent
  double sin = std::sin(d1);
  double cos = std::cos(d1);
  double tan = std::tan(d1);
  //arc-sine arc-cosine and arc-tangent
  double asin = std::asin(d3);
  double acos = std::acos(d3);
  double atan= std::atan(d3);
  //arc-tangent of coordinate
  double atan2 = std::atan2(d2,d1);
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
  double ld_exp = std::ldexp(d1,i1);
  //next greater float value
  double next_up = std::nextafter(d1,INFINITY);
  //next less float value
  double next_down = std::nextafter(d1,-INFINITY);
  //copy sign of a float value
  double copysign = std::copysign(d1,d2);
  //whether float is finite
  bool is_finite = std::isfinite(d1);
  //whether float is infinite
  bool is_inf = std::isinf(d1);
  //whether float is nan
  bool is_nan = std::isnan(d1);
}
bool CmathEntry::TestAll() {
  bool ret = true;
  if (!ret)
    std::cout << "Cmath Test Failed!";
  return ret;
}
