//
// Created by 85339 on 2022/10/27.
//

#include "chrono_entry.h"

void ChronoEntry::ChronoProgram() {

  using namespace std::literals;

  std::chrono::time_point time = std::chrono::system_clock::now();
  std::chrono::time_point time_of = std::chrono::sys_days{2022y / 10 / 27} + 13h + 30min + 45s;

  bool b1 = time < time_of;
  bool b2 = time > time_of;
  bool b3 = time == time_of;

  std::chrono::time_point days = std::chrono::floor<std::chrono::days>(time);
  std::chrono::year_month_day ymd(days);
  std::chrono::duration times_in_day = time - days;
  std::chrono::hh_mm_ss hms(times_in_day);
  int year = (int)ymd.year();
  int month = (unsigned)ymd.month();
  int day = (unsigned)ymd.day();

  std::chrono::weekday wd(days);
  int weekDay = wd.iso_encoding();
  int hour = hms.hours().count();
  int minute = hms.minutes().count();
  int second = hms.seconds().count();

  long milli = time.time_since_epoch().count();

  std::chrono::time_point time1 = std::chrono::sys_days{ymd + std::chrono::years(1)} + times_in_day;
  std::chrono::time_point time2 = std::chrono::sys_days{ymd + std::chrono::months(2)} + times_in_day;
  std::chrono::time_point time3 = time + std::chrono::days(3);
  std::chrono::time_point time4 = time + std::chrono::hours(4);
  std::chrono::time_point time5 = time + std::chrono::minutes(5);
  std::chrono::time_point time6 = time + std::chrono::seconds(6);

  std::chrono::time_point time7 = std::chrono::sys_days{ymd - std::chrono::years(1)} + times_in_day;
  std::chrono::time_point time8 = std::chrono::sys_days{ymd - std::chrono::months(2)} + times_in_day;
  std::chrono::time_point time9 = time - std::chrono::days(3);
  std::chrono::time_point time10 = time - std::chrono::hours(4);
  std::chrono::time_point time11 = time - std::chrono::minutes(5);
  std::chrono::time_point time12 = time - std::chrono::seconds(6);

  std::chrono::time_point time13 = std::chrono::sys_days{
      ymd + std::chrono::years(2011 - (int)ymd.year())} + times_in_day;
  std::chrono::time_point time14 = std::chrono::sys_days{
      ymd + std::chrono::months(11 - (unsigned)ymd.month())} + times_in_day;
  std::chrono::time_point time15 = time + std::chrono::days(11 - (unsigned)ymd.day());
  std::chrono::time_point time16 = time + std::chrono::hours(11 - hms.hours().count());
  std::chrono::time_point time17 = time + std::chrono::minutes(11 - hms.minutes().count());
  std::chrono::time_point time18 = time + std::chrono::seconds(11 - hms.seconds().count());

  std::chrono::duration duration = time - time_of;
  long days_count = std::chrono::duration_cast<std::chrono::days>(duration).count();
  long hours_count = std::chrono::duration_cast<std::chrono::hours>(duration).count();
  long minutes_count = std::chrono::duration_cast<std::chrono::minutes>(duration).count();
  long seconds_count = std::chrono::duration_cast<std::chrono::seconds>(duration).count();

  duration = std::chrono::days(10);
  duration = std::chrono::hours(10);
  duration = std::chrono::minutes(10);
  duration = std::chrono::seconds(10);


}
