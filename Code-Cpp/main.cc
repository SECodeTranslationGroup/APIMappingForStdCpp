#include <iostream>
#include <cwctype>

#include <vector>
#include <map>

#include <string>

#include "code_cpp/base/global_entry.h"
#include "code_cpp/base/misc/example_object.h"
#include <chrono>
#include <format>
int main() {
  GlobalEntry::TestAllEntry();
  std::chrono::time_point time = std::chrono::system_clock::now();
  std::chrono::time_point days = std::chrono::floor<std::chrono::days>(time);
  std::chrono::time_point years = std::chrono::floor<std::chrono::years>(time)+std::chrono::seconds(1);
  std::chrono::year_month_day ymd(days);
  std::chrono::duration times_in_day = time - days;
  std::chrono::hh_mm_ss hms(times_in_day);
  std::chrono::time_point time1 = std::chrono::sys_days{ymd + std::chrono::years(1)} + times_in_day;
  std::chrono::time_point time2 = std::chrono::sys_days{ymd + std::chrono::months(2)} + times_in_day;
  std::cout << time << std::endl;
  std::cout << years << std::endl;
  std::cout << time1 << std::endl;
  std::cout << time2 << std::endl;
}
