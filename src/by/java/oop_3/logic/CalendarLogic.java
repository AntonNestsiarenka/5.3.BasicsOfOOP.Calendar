package by.java.oop_3.logic;

import by.java.oop_3.bean.Calendar;
import by.java.oop_3.bean.DayOfWeek;
import by.java.oop_3.bean.Month;
import by.java.oop_3.view.Viewer;

import java.util.HashMap;
import java.util.Objects;

public final class CalendarLogic {

    private Viewer viewer;

    public CalendarLogic()
    {
        viewer = new Viewer();
    }

    public void fillDayOff(Calendar calendar)
    {
        // Заполняет календарь выходными днями (суббота и воскресенье).
        for (Month month : Month.values())
        {
            for (int i = 1; i <= month.getNumberOfDaysInMonth(); i++)
            {
                DayOfWeek dayOfWeek = getDayOfWeek(i, month, calendar.getYear());
                if (dayOfWeek.getNumberOfDay() == 0 || dayOfWeek.getNumberOfDay() == 1)
                {
                    calendar.new Holiday("DayOff", i, month);
                }
            }
        }
    }

    public void displayCalendarMonth(Calendar calendar, Month month)
    {
        // Выводит в консоль календарь на заданный месяц.
        viewer.printMonthForm(month);
        HashMap<DayOfWeek, Integer> posInStr = new HashMap<>();
        int position = 1;
        int step = 6;
        for (DayOfWeek dayOfWeek : DayOfWeek.values())
        {
            posInStr.put(dayOfWeek, position);
            position += step;
        }
        int size = 0;
        for (int i = 1; i <= month.getNumberOfDaysInMonth(); i++)
        {
            DayOfWeek dayOfWeek = getDayOfWeek(i, month, calendar.getYear());
            for (int j = size; j < posInStr.get(dayOfWeek); j++)
                viewer.printMessage(" ");
            if (isHoliday(calendar, i, month))
            {
                viewer.printHolidayWithRedColor(i);
            }
            else
            {
                viewer.printDayWithBlackColor(i);
            }
            if (dayOfWeek.getNumberOfDay() != 0)
            {
                size = posInStr.get(dayOfWeek) + 2;
            }
            else
            {
                size = 0;
                viewer.printMessage("\n");
            }
        }
        viewer.printLnMessage("\n");
    }

    public void displayCalendar(Calendar calendar)
    {
        // Выводит в консоль весь календарь.
        viewer.printCalendarForm(calendar);
        for (Month month : Month.values())
        {
            displayCalendarMonth(calendar, month);
        }
        viewer.printMessage("\n");
    }

    public void displayHolidaysInfo(Calendar calendar)
    {
        // Выводит в консоль информацию обо всех выходных и праздниках календаря в отсортированном виде.
        calendar.getHolidays().sort(Calendar.Holiday::compareTo);
        for (Calendar.Holiday holiday : calendar.getHolidays())
        {
            viewer.printLnMessage(holiday.toString());
        }
        viewer.printMessage("\n");
    }

    private DayOfWeek getDayOfWeek(int dayOfMonth, Month month, int year) {
        // Возвращает день недели для заданного числа, месяца, года.
        int codeOfMonth;
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && (month == Month.JANUARY || month == Month.FEBRUARY))
        {
            codeOfMonth = month.getCodeOfMonth() - 1;
        }
        else {
            codeOfMonth = month.getCodeOfMonth();
        }
        int codeOfYear = getCodeOfYear(year);
        int codeOfDay = (dayOfMonth + codeOfMonth + codeOfYear) % 7;
        DayOfWeek dayOfWeek = null;
        for (DayOfWeek day : DayOfWeek.values()) {
            if (codeOfDay == day.getNumberOfDay()) {
                dayOfWeek = day;
                break;
            }
        }
        return dayOfWeek;
    }

    private int getCodeOfYear(int year) {
        // Возвращает код года.
        int last2Digits = year % 100;
        int codeOfFirst2Digits = getCodeOfFirst2Digits((year - last2Digits) / 100);
        int code = (codeOfFirst2Digits + last2Digits + last2Digits / 4) % 7;
        return code;
    }

    private int getCodeOfFirst2Digits(int number) {
        // Возвращает код для первых двух цифр года.
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0, j = 6; i < 4; i++, j -= 2)
            map.put(i, j);
        return map.get(number % 4);
    }

    private boolean isHoliday(Calendar calendar, int numberOfDay, Month month)
    {
        // Проверяет является ли заданный день месяца выходным или праздничным.
        for (Calendar.Holiday holiday : calendar.getHolidays())
        {
            if (holiday.getMonth().getNumberOfMonth() == month.getNumberOfMonth() && holiday.getNumberOfDay() == numberOfDay)
                return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendarLogic that = (CalendarLogic) o;
        return Objects.equals(viewer, that.viewer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(viewer);
    }
}