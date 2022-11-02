package codejava.base.chrono;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;


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

}
