package codejava.base.chrono;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;


public class ChronoEntry {
  public static void ChronoProgram() {
    //initialize a time point with now
    LocalDateTime time = LocalDateTime.now();
    //initialize a time point with values
    LocalDateTime timeOf = LocalDateTime.of(2022, 10, 27, 13, 30, 45);
    //whether time point before,after or equals another time point
    boolean b1 = time.isBefore(timeOf);
    boolean b2 = time.isAfter(timeOf);
    boolean b3 = time.isEqual(timeOf);
    //get year, month and day
    int year = time.getYear();
    int month = time.getMonthValue();
    int day = time.getDayOfMonth();
    //get weekday
    int weekDay = time.getDayOfWeek().getValue();
    //get hour, minute and second
    int hour = time.getHour();
    int minute = time.getMinute();
    int second = time.getSecond();
    //get time since unix epoch
    long milli = time.atZone(ZoneOffset.UTC).toInstant().toEpochMilli();
    //add years to a time point
    LocalDateTime time1 = time.plusYears(1);
    //add months to a time point
    LocalDateTime time2 = time.plusMonths(2);
    //add days to a time point
    LocalDateTime time3 = time.plusDays(3);
    //add hours to a time point
    LocalDateTime time4 = time.plusHours(4);
    //add minutes to a time point
    LocalDateTime time5 = time.plusMinutes(5);
    //add seconds to a time point
    LocalDateTime time6 = time.plusSeconds(6);
    //minus years to a time point
    LocalDateTime time7 = time.minusYears(1);
    //minus months to a time point
    LocalDateTime time8 = time.minusMonths(2);
    //minus days to a time point
    LocalDateTime time9 = time.minusDays(3);
    //minus hours to a time point
    LocalDateTime time10 = time.minusHours(4);
    //minus minutes to a time point
    LocalDateTime time11 = time.minusMinutes(5);
    //minus seconds to a time point
    LocalDateTime time12 = time.minusSeconds(6);
    //change year of a time point to a given value
    LocalDateTime time13 = time.withYear(2011);
    //change month of a time point to a given value
    LocalDateTime time14 = time.withMonth(11);
    //change day of a time point to a given value
    LocalDateTime time15 = time.withDayOfMonth(11);
    //change hour of a time point to a given value
    LocalDateTime time16 = time.withHour(11);
    //change minute of a time point to a given value
    LocalDateTime time17 = time.withMinute(11);
    //change second of a time point to a given value
    LocalDateTime time18 = time.withSecond(11);
    //get the time duration between two time points
    Duration duration = Duration.between(time, timeOf);
    //get duration days count
    long daysCount = duration.toDays();
    //get duration hours count
    long hoursCount = duration.toHours();
    //get duration minutes count
    long minutesCount = duration.toMinutes();
    //get duration seconds count
    long secondsCount = duration.toSeconds();
    //get a duration of several days
    duration = Duration.ofDays(10);
    //get a duration of several hours
    duration = Duration.ofHours(10);
    //get a duration of several minutes
    duration = Duration.ofMinutes(10);
    //get a duration of several seconds
    duration = Duration.ofSeconds(10);
  }

  public static boolean testAll() {
    boolean ret = true;
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime time = LocalDateTime.of(2022, 10, 27, 13, 30, 45);
    ret = !now.isBefore(time)
        && now.isAfter(time)
        && !now.isEqual(time)
        && time.getYear() == 2022
        && time.getMonthValue() == 10
        && time.getDayOfMonth() == 27
        && time.getDayOfWeek().getValue() == 4
        && time.getHour() == 13
        && time.getMinute() == 30
        && time.getSecond() == 45
        && time.atZone(ZoneOffset.UTC).toInstant().toEpochMilli() == 1666877445000L
        && time.plusYears(1).isEqual(LocalDateTime.of(
        2023, 10, 27, 13, 30, 45))
        && time.plusMonths(2).isEqual(LocalDateTime.of(
        2022, 12, 27, 13, 30, 45))
        && time.plusDays(3).isEqual(LocalDateTime.of(
        2022, 10, 30, 13, 30, 45))
        && time.plusHours(4).isEqual(LocalDateTime.of(
        2022, 10, 27, 17, 30, 45))
        && time.plusMinutes(5).isEqual(LocalDateTime.of(
        2022, 10, 27, 13, 35, 45))
        && time.plusSeconds(6).isEqual(LocalDateTime.of(
        2022, 10, 27, 13, 30, 51))
        && time.minusYears(1).isEqual(LocalDateTime.of(
        2021, 10, 27, 13, 30, 45))
        && time.minusMonths(2).isEqual(LocalDateTime.of(
        2022, 8, 27, 13, 30, 45))
        && time.minusDays(3).isEqual(LocalDateTime.of(
        2022, 10, 24, 13, 30, 45))
        && time.minusHours(4).isEqual(LocalDateTime.of(
        2022, 10, 27, 9, 30, 45))
        && time.minusMinutes(5).isEqual(LocalDateTime.of(
        2022, 10, 27, 13, 25, 45))
        && time.minusSeconds(6).isEqual(LocalDateTime.of(
        2022, 10, 27, 13, 30, 39))
        && time.withYear(2011).isEqual(LocalDateTime.of(
        2011, 10, 27, 13, 30, 45))
        && time.withMonth(11).isEqual(LocalDateTime.of(
        2022, 11, 27, 13, 30, 45))
        && time.withDayOfMonth(11).isEqual(LocalDateTime.of(
        2022, 10, 11, 13, 30, 45))
        && time.withHour(11).isEqual(LocalDateTime.of(
        2022, 10, 27, 11, 30, 45))
        && time.withMinute(11).isEqual(LocalDateTime.of(
        2022, 10, 27, 13, 11, 45))
        && time.withSecond(11).isEqual(LocalDateTime.of(
        2022, 10, 27, 13, 30, 11));
    if (!ret)
      System.out.print("Chrono Test Failed!");
    return ret;
  }
}
