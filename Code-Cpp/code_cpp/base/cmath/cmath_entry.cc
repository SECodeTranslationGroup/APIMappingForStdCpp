#include "cmath_entry.h"

void CmathEntry::CmathProgram() {
  int i1 = 3, i2 = 2;
  double d1 = 3.5, d2 = 1.5, d3 = 0.5;

  int i_abs = std::abs(i1);
  double d_abs = std::abs(d1);
  double d_mod = std::fmod(d1, d2);
  double d_remainder = std::remainder(d1, d2);

  double fma = std::fma(d1, d2, d3);
  double dim = std::fdim(d1, d2);

  double lerp = std::lerp(d1, d2, d3);
  double exp = std::exp(d1);
  double exp2 = std::exp2(d1);
  double expm1 = std::expm1(d1);
  double log = std::log(d1);
  double log2 = std::log2(d1);
  double log10 = std::log10(d1);
  double log1p = std::log1p(d1);
  double log_base = std::log(d1) / std::log(d2);

  double pow = std::pow(d1,d2);
  double sqrt = std::sqrt(d1);
  double cbrt = std::cbrt(d1);
  double hypot = std::hypot(d1,d2);
  double hypot3 = std::hypot(d1,d2,d3);

  double sin = std::sin(d1);
  double asin = std::asin(d3);
  double cos = std::cos(d1);
  double acos = std::acos(d3);
  double tan = std::tan(d1);
  double atan= std::atan(d3);
  double atan2 = std::atan2(d2,d1);

  double sinh = std::sinh(d1);
  double asinh = std::asinh(d3);
  double cosh = std::cosh(d1);
  double acosh = std::acosh(d3);
  double tanh = std::tanh(d1);
  double atanh = std::atanh(d3);

  double ceil = std::ceil(d1);
  double floor = std::floor(d1);
  double trunc = std::trunc(d1);
  double round = std::round(d1);

  double ld_exp = std::ldexp(d1,i1);
  double next_up = std::nextafter(d1,INFINITY);
  double next_down = std::nextafter(d1,-INFINITY);
  double copysign = std::copysign(d1,d2);

  bool is_finite = std::isfinite(d1);
  bool is_inf = std::isinf(d1);
  bool is_nan = std::isnan(d1);
}
