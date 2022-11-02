namespace CodeCsharp.Base.Chrono;
using System;

public class ChronoEntry {
  public static void ChronoProgram() {
    //initialize a time point with now
    DateTime time = DateTime.Now;
    //initialize a time point with values
    DateTime timeOf = new DateTime(2022, 10, 27, 13, 30, 45);
    //whether time point before,after or equals another time point
    bool b1 = time < timeOf;
    bool b2 = time > timeOf;
    bool b3 = time == timeOf;
    //get year, month and day
    int year = time.Year;
    int month = time.Month;
    int day = time.Day;
    //get weekday
    int weekDay = (int)time.DayOfWeek;
    //get hour, minute and second
    int hour = time.Hour;
    int minute = time.Minute;
    int second = time.Second;
    //get time since unix epoch
    long milli = Convert.ToInt64((time - DateTime.UnixEpoch).TotalMilliseconds);
    //add years to a time point
    DateTime time1 = time.AddYears(1);
    //add months to a time point
    DateTime time2 = time.AddMonths(2);
    //add days to a time point
    DateTime time3 = time.AddDays(3);
    //add hours to a time point
    DateTime time4 = time.AddHours(4);
    //add minutes to a time point
    DateTime time5 = time.AddMinutes(5);
    //add seconds to a time point
    DateTime time6 = time.AddSeconds(6);
    //minus years to a time point
    DateTime time7 = time.AddYears(-1);
    //minus months to a time point
    DateTime time8 = time.AddMonths(-2);
    //minus days to a time point
    DateTime time9 = time.AddDays(-3);
    //minus hours to a time point
    DateTime time10 = time.AddHours(-4);
    //minus minutes to a time point
    DateTime time11 = time.AddMinutes(-5);
    //minus seconds to a time point
    DateTime time12 = time.AddSeconds(-6);
    //change year of a time point to a given value
    DateTime time13 = time.AddYears(2011 - time.Year);
    //change month of a time point to a given value
    DateTime time14 = time.AddMonths(11 - time.Month);
    //change day of a time point to a given value
    DateTime time15 = time.AddDays(11 - time.Day);
    //change hour of a time point to a given value
    DateTime time16 = time.AddHours(11 - time.Hour);
    //change minute of a time point to a given value
    DateTime time17 = time.AddMinutes(11 - time.Minute);
    //change second of a time point to a given value
    DateTime time18 = time.AddSeconds(11 - time.Second);  
    //get the time duration between two time points
    TimeSpan duration = time - timeOf;
    //get duration days count
    long daysCount = duration.Days;
    //get duration hours count
    long hoursCount = duration.Hours;
    //get duration minutes count
    long minutesCount = duration.Minutes;
    //get duration seconds count
    long secondsCount = duration.Seconds;
    //get a duration of several days
    duration = TimeSpan.FromDays(10);
    //get a duration of several hours
    duration = TimeSpan.FromHours(10);
    //get a duration of several minutes
    duration = TimeSpan.FromMinutes(10);
    //get a duration of several seconds
    duration = TimeSpan.FromSeconds(10);
  }
}