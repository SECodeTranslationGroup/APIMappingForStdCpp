package codejava.base.chrono;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;


public class ChronoEntry {
  public static void ChronoProgram() {
    LocalDateTime time = LocalDateTime.now();
    LocalDateTime timeOf = LocalDateTime.of(2022, 10, 27, 13, 30, 45);

    boolean b1 = time.isBefore(timeOf);
    boolean b2 = time.isAfter(timeOf);
    boolean b3 = time.isEqual(timeOf);

    int year = time.getYear();
    int month = time.getMonthValue();
    int day = time.getDayOfMonth();
    int weekDay = time.getDayOfWeek().getValue();
    int hour = time.getHour();
    int minute = time.getMinute();
    int second = time.getSecond();

    long milli = time.atZone(ZoneOffset.UTC).toInstant().toEpochMilli();

    LocalDateTime time1 = time.plusYears(1);
    LocalDateTime time2 = time.plusMonths(2);
    LocalDateTime time3 = time.plusDays(3);
    LocalDateTime time4 = time.plusHours(4);
    LocalDateTime time5 = time.plusMinutes(5);
    LocalDateTime time6 = time.plusSeconds(6);

    LocalDateTime time7 = time.minusYears(1);
    LocalDateTime time8 = time.minusMonths(2);
    LocalDateTime time9 = time.minusDays(3);
    LocalDateTime time10 = time.minusHours(4);
    LocalDateTime time11 = time.minusMinutes(5);
    LocalDateTime time12 = time.minusSeconds(6);

    LocalDateTime time13 = time.withYear(2011);
    LocalDateTime time14 = time.withMonth(11);
    LocalDateTime time15 = time.withDayOfMonth(11);
    LocalDateTime time16 = time.withHour(11);
    LocalDateTime time17 = time.withMinute(11);
    LocalDateTime time18 = time.withSecond(11);

    Duration duration = Duration.between(time, timeOf);
    long daysCount = duration.toDays();
    long hoursCount = duration.toHours();
    long minutesCount = duration.toMinutes();
    long secondsCount = duration.toSeconds();

    duration = Duration.ofDays(10);
    duration = Duration.ofHours(10);
    duration = Duration.ofMinutes(10);
    duration = Duration.ofSeconds(10);
  }

}
