#include "chrono_entry.h"
#include <iostream>

void ChronoEntry::ChronoProgram() {
  using namespace std::literals;
  //initialize a time point with now
  std::chrono::time_point time = std::chrono::system_clock::now();
  //initialize a time point with values
  std::chrono::time_point time_of = std::chrono::sys_days{2022y / 10 / 27} + 13h + 30min + 45s;
  //whether time point before,after or equals another time point
  bool b1 = time < time_of;
  bool b2 = time > time_of;
  bool b3 = time == time_of;
  //get year, month and day
  std::chrono::time_point days = std::chrono::floor<std::chrono::days>(time);
  std::chrono::year_month_day ymd(days);
  int year = (int)ymd.year();
  int month = (unsigned)ymd.month();
  int day = (unsigned)ymd.day();
  //get weekday
  std::chrono::weekday wd(days);
  int weekDay = wd.iso_encoding();
  //get hour, minute and second
  std::chrono::duration times_in_day = time - days;
  std::chrono::hh_mm_ss hms(times_in_day);
  int hour = hms.hours().count();
  int minute = hms.minutes().count();
  int second = hms.seconds().count();
  //get time since unix epoch
  long milli = time.time_since_epoch().count();
  //add years to a time point
  std::chrono::time_point time1 = std::chrono::sys_days{ymd + std::chrono::years(1)} + times_in_day;
  //add months to a time point
  std::chrono::time_point time2 = std::chrono::sys_days{ymd + std::chrono::months(2)} + times_in_day;
  //add days to a time point
  std::chrono::time_point time3 = time + std::chrono::days(3);
  //add hours to a time point
  std::chrono::time_point time4 = time + std::chrono::hours(4);
  //add minutes to a time point
  std::chrono::time_point time5 = time + std::chrono::minutes(5);
  //add seconds to a time point
  std::chrono::time_point time6 = time + std::chrono::seconds(6);
  //minus years to a time point
  std::chrono::time_point time7 = std::chrono::sys_days{ymd - std::chrono::years(1)} + times_in_day;
  //minus months to a time point
  std::chrono::time_point time8 = std::chrono::sys_days{ymd - std::chrono::months(2)} + times_in_day;
  //minus days to a time point
  std::chrono::time_point time9 = time - std::chrono::days(3);
  //minus hours to a time point
  std::chrono::time_point time10 = time - std::chrono::hours(4);
  //minus minutes to a time point
  std::chrono::time_point time11 = time - std::chrono::minutes(5);
  //minus seconds to a time point
  std::chrono::time_point time12 = time - std::chrono::seconds(6);
  //change year of a time point to a given value
  std::chrono::time_point time13 = std::chrono::sys_days{
      ymd + std::chrono::years(2011 - (int)ymd.year())} + times_in_day;
  //change month of a time point to a given value
  std::chrono::time_point time14 = std::chrono::sys_days{
      ymd + std::chrono::months(11 - (unsigned)ymd.month())} + times_in_day;
  //change day of a time point to a given value
  std::chrono::time_point time15 = time + std::chrono::days(11 - (unsigned)ymd.day());
  //change hour of a time point to a given value
  std::chrono::time_point time16 = time + std::chrono::hours(11 - hms.hours().count());
  //change minute of a time point to a given value
  std::chrono::time_point time17 = time + std::chrono::minutes(11 - hms.minutes().count());
  //change second of a time point to a given value
  std::chrono::time_point time18 = time + std::chrono::seconds(11 - hms.seconds().count());
  //get the time duration between two time points
  std::chrono::duration duration = time - time_of;
  //get duration days count
  long days_count = std::chrono::duration_cast<std::chrono::days>(duration).count();
  //get duration hours count
  long hours_count = std::chrono::duration_cast<std::chrono::hours>(duration).count();
  //get duration minutes count
  long minutes_count = std::chrono::duration_cast<std::chrono::minutes>(duration).count();
  //get duration seconds count
  long seconds_count = std::chrono::duration_cast<std::chrono::seconds>(duration).count();
  //get a duration of several days
  duration = std::chrono::days(10);
  //get a duration of several hours
  duration = std::chrono::hours(10);
  //get a duration of several minutes
  duration = std::chrono::minutes(10);
  //get a duration of several seconds
  duration = std::chrono::seconds(10);
}
bool ChronoEntry::TestAll() {
  bool ret = true;
  using namespace std;
  using namespace std::chrono;
  using namespace std::literals;
  using sys_tp = std::chrono::time_point<system_clock>;
  sys_tp now = system_clock::now();
  sys_tp time = sys_days{2022y / 10 / 27} + 13h + 30min + 45s;
  vector<pair<bool, bool>> bool_result_list = {
      {now < time, false},
      {now > time, true},
      {now == time, false}
  };
  year_month_day ymd = floor<days>(time);
  duration time_dur = time - floor<days>(time);
  duration d = days(3) + hours(6) + minutes(9) + seconds(12);
  hh_mm_ss hms(time_dur);
  vector<pair<long, long>> int_result_list = {
      {(int)ymd.year(), 2022},
      {(unsigned)ymd.month(), 10},
      {(unsigned)ymd.day(), 27},
      {weekday(floor<days>(time)).iso_encoding(), 4},
      {hms.hours().count(), 13},
      {hms.minutes().count(), 30},
      {hms.seconds().count(), 45},
      {time.time_since_epoch().count(), 16668774450000000},

  };
  vector<pair<sys_tp, sys_tp>> time_point_result_list = {
      {floor<days>(time),
       sys_days{2022y / 10 / 27}},
      {sys_days{ymd + years(1)} + time_dur,
       sys_days{2023y / 10 / 27} + 13h + 30min + 45s},
      {sys_days{ymd + months(2)} + time_dur,
       sys_days{2022y / 12 / 27} + 13h + 30min + 45s},
      {time + days(3),
       sys_days{2022y / 10 / 30} + 13h + 30min + 45s},
      {time + hours(4),
       sys_days{2022y / 10 / 27} + 17h + 30min + 45s},
      {time + minutes(5),
       sys_days{2022y / 10 / 27} + 13h + 35min + 45s},
      {time + seconds(6),
       sys_days{2022y / 10 / 27} + 13h + 30min + 51s},
      {sys_days{ymd - years(1)} + time_dur,
       sys_days{2021y / 10 / 27} + 13h + 30min + 45s},
      {sys_days{ymd - months(2)} + time_dur,
       sys_days{2022y / 8 / 27} + 13h + 30min + 45s},
      {time - days(3),
       sys_days{2022y / 10 / 24} + 13h + 30min + 45s},
      {time - hours(4),
       sys_days{2022y / 10 / 27} + 9h + 30min + 45s},
      {time - minutes(5),
       sys_days{2022y / 10 / 27} + 13h + 25min + 45s},
      {time - seconds(6),
       sys_days{2022y / 10 / 27} + 13h + 30min + 39s},
      {sys_days{ymd + years(2011 - (int)ymd.year())} + time_dur,
       sys_days{2011y / 10 / 27} + 13h + 30min + 45s},
      {sys_days{ymd + months(11 - (unsigned)ymd.month())} + time_dur,
       sys_days{2022y / 11 / 27} + 13h + 30min + 45s},
      {time + days(11 - (unsigned)ymd.day()),
       sys_days{2022y / 10 / 11} + 13h + 30min + 45s},
      {time + hours(11 - hms.hours().count()),
       sys_days{2022y / 10 / 27} + 11h + 30min + 45s},
      {time + minutes(11 - hms.minutes().count()),
       sys_days{2022y / 10 / 27} + 13h + 11min + 45s},
      {time + seconds(11 - hms.seconds().count()),
       sys_days{2022y / 10 / 27} + 13h + 30min + 11s}
  };
  for (auto it : int_result_list) {
    ret = ret && it.first == it.second;
  }
  for (auto it : bool_result_list) {
    ret = ret && it.first == it.second;
  }
  for (auto it : time_point_result_list) {
    ret = ret && it.first == it.second;
  }
  if (!ret)
    cout << "Chrono Test Failed!";

  return ret;
}
