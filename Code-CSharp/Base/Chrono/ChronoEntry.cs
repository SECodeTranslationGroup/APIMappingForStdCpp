namespace CodeCsharp.Base.Chrono;
using System;

public class ChronoEntry {
  public static void ChronoProgram() {
    
    DateTime time = DateTime.Now;
    DateTime timeOf = new DateTime(2022, 10, 27, 13, 30, 45);

    bool b1 = time < timeOf;
    bool b2 = time > timeOf;
    bool b3 = time == timeOf;
    
    int year = time.Year;
    int month = time.Month;
    int day = time.Day;
    int weekDay = (int)time.DayOfWeek;
    int hour = time.Hour;
    int minute = time.Minute;
    int second = time.Second;

    long milli = Convert.ToInt64((time - DateTime.UnixEpoch).TotalMilliseconds);
    
    DateTime time1 = time.AddYears(1);
    DateTime time2 = time.AddMonths(2);
    DateTime time3 = time.AddDays(3);
    DateTime time4 = time.AddHours(4);
    DateTime time5 = time.AddMinutes(5);
    DateTime time6 = time.AddSeconds(6);
    
    DateTime time7 = time.AddYears(-1);
    DateTime time8 = time.AddMonths(-2);
    DateTime time9 = time.AddDays(-3);
    DateTime time10 = time.AddHours(-4);
    DateTime time11 = time.AddMinutes(-5);
    DateTime time12 = time.AddSeconds(-6);

    DateTime time13 = time.AddYears(2011 - time.Year);
    DateTime time14 = time.AddMonths(11 - time.Month);
    DateTime time15 = time.AddDays(11 - time.Day);
    DateTime time16 = time.AddHours(11 - time.Hour);
    DateTime time17 = time.AddMinutes(11 - time.Minute);
    DateTime time18 = time.AddSeconds(11 - time.Second);

    TimeSpan duration = time - timeOf;
    long daysCount = duration.Days;
    long hoursCount = duration.Hours;
    long minutesCount = duration.Minutes;
    long secondsCount = duration.Seconds;

    duration = TimeSpan.FromDays(10);
    duration = TimeSpan.FromHours(10);
    duration = TimeSpan.FromMinutes(10);
    duration = TimeSpan.FromSeconds(10);
  }
}