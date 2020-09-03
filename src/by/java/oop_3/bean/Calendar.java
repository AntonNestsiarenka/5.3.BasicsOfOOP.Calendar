package by.java.oop_3.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public final class Calendar {

    /* Класс описывает календарь. */

    private final int year;
    private ArrayList<Holiday> holidays;

    public Calendar()
    {
        // Конструктор без параметров инициализирует переменную year текущим годом.
        Date date = new Date();
        year = date.getYear() + 1900;
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            Month.FEBRUARY.setNumberOfDaysInMonth(29);
        }
        else {
            Month.FEBRUARY.setNumberOfDaysInMonth(28);
        }
        holidays = new ArrayList<Holiday>();
    }

    public Calendar(int year, ArrayList<Holiday> holidays) {
        /* Конструктор инициализирует переменную year заданным годом, а в случае некорректно заданного года
           (отрицательное число) инициализирует текущим годом. */
        if (year < 0) {
            year = new Date().getYear() + 1900;
        }
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            Month.FEBRUARY.setNumberOfDaysInMonth(29);
        }
        else {
            Month.FEBRUARY.setNumberOfDaysInMonth(28);
        }
        this.year = year;
        this.holidays = holidays;
    }

    public Calendar(int year) {
        /* Конструктор инициализирует переменную year заданным годом, а в случае некорректно заданного года
           (отрицательное число) инициализирует текущим годом. */
        if (year < 0) {
            year = new Date().getYear() + 1900;
        }
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            Month.FEBRUARY.setNumberOfDaysInMonth(29);
        }
        else {
            Month.FEBRUARY.setNumberOfDaysInMonth(28);
        }
        this.year = year;
        holidays = new ArrayList<>();
    }

    public int getYear() {
        return year;
    }

    public ArrayList<Holiday> getHolidays() {
        return holidays;
    }

    public void setHolidays(ArrayList<Holiday> holidays) {
        this.holidays = holidays;
    }

    public void addHoliday(Holiday holiday)
    {
        if (!holidays.contains(holiday))
            holidays.add(holiday);
    }

    public void removeHoliday(Holiday holiday)
    {
        holidays.remove(holiday);
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "year=" + year +
                ", holidays=" + holidays +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calendar calendar = (Calendar) o;
        return year == calendar.year &&
                Objects.equals(holidays, calendar.holidays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, holidays);
    }

    public class Holiday implements Comparable<Holiday> {

        /* Класс описывает выходной/праздничный день. */

        private String name;
        private int numberOfDay;
        private Month month;

        public Holiday()
        {
            name = "";
            numberOfDay = 1;
            month = Month.JULY;
            addHoliday(this);
        }

        public Holiday(String name, int numberOfDay, Month month) {
            this.name = name;
            this.numberOfDay = numberOfDay;
            this.month = month;
            addHoliday(this);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNumberOfDay() {
            return numberOfDay;
        }

        public void setNumberOfDay(int numberOfDay) {
            this.numberOfDay = numberOfDay;
        }

        public Month getMonth() {
            return month;
        }

        public void setMonth(Month month) {
            this.month = month;
        }

        @Override
        public String toString() {
            return numberOfDay + " " + month.getNameOfMonth() + " - " + name;
        }

        @Override
        public int compareTo(Holiday o) {
            if (month.getNumberOfMonth() > o.month.getNumberOfMonth())
            {
                return 1;
            }
            else if (month.getNumberOfMonth() < o.month.getNumberOfMonth())
            {
                return -1;
            }
            else if (numberOfDay > o.numberOfDay) {
                return 1;
            }
            else if (numberOfDay < o.numberOfDay) {
                return -1;
            }
            return 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Holiday holiday = (Holiday) o;
            return numberOfDay == holiday.numberOfDay &&
                    Objects.equals(name, holiday.name) &&
                    month == holiday.month;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, numberOfDay, month);
        }
    }
}