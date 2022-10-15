package com.example.demo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateOfPlan {

    Calendar calendar = Calendar.getInstance();

    // To get which week of this year is the current week
    public int weekOfCurrentDate() {
        calendar.setFirstDayOfWeek(Calendar.MONDAY);

        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    public String currentDate() {
        Date date = new Date();
        String dateOfCurrent = String.format("%1$tB-%1$td", date);
        String tableHeadDate = dateOfCurrent + " " + weekDayOfCurrentDay();
        return tableHeadDate;
    }

    public String weekDayOfCurrentDay() {
        String[] weekday = new String[] { "Sun.", "Mon.", "Tue.", "Wed.", "Thu.", "Fri.", "Sat." };
        int i = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (i < 0) {
            i = 0;
        }
        return weekday[i];
    }

    // Help method for second parameter of getLocalDate():DayOfWeek dow
    private DayOfWeek weekday() {
        int n = calendar.get(Calendar.DAY_OF_WEEK);
        DayOfWeek result = null;

        switch (n) {
            case 1:
                result = DayOfWeek.SUNDAY;
            case 2:
                result = DayOfWeek.MONDAY;
            case 3:
                result = DayOfWeek.TUESDAY;
            case 4:
                result = DayOfWeek.WEDNESDAY;
            case 5:
                result = DayOfWeek.THURSDAY;
            case 6:
                result = DayOfWeek.FRIDAY;
            case 7:
                result = DayOfWeek.SATURDAY;
        }

        return result;
    }

    // Known the week number ,the year and the weekday, to get the date
    public LocalDate getLocalDate(int weekNumber, DayOfWeek dow, int year, Locale locale) {
        return LocalDate.of(year, 1, 7).with(dow).with(WeekFields.of(locale).weekOfWeekBasedYear(), weekNumber);
    }

    // Known the week number ,the year and the weekday, to get the date as a String
    public String getDateAsString(int weekNumber) {
        int year = 2022;
        DateOfPlan plan = new DateOfPlan();
        LocalDate result = plan.getLocalDate(weekNumber, plan.weekday(), year, Locale.UK);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL");
        String formattedString = result.format(formatter);
        return formattedString;
    }
}

