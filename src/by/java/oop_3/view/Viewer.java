package by.java.oop_3.view;

import by.java.oop_3.bean.Calendar;
import by.java.oop_3.bean.Month;

public final class Viewer {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public void printMonthForm(Month month)
    {
        // Выводит в консоль форму дней недели для заданного месяца.
        System.out.printf(ANSI_CYAN + "%21.9s" + ANSI_RESET + "\n\n", month.getNameOfMonth());
        String [] namesOfDays = new String[] {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        System.out.print(ANSI_RED + namesOfDays[0] + "   " + ANSI_RESET);
        for (int i = 1; i < namesOfDays.length - 1; i++)
        {
            System.out.print(ANSI_BLACK + namesOfDays[i] + "   " + ANSI_RESET);
        }
        System.out.print(ANSI_RED + namesOfDays[namesOfDays.length - 1] + ANSI_RESET);
        System.out.println();
    }

    public void printCalendarForm(Calendar calendar)
    {
        // Выводит в консоль год заданного календаря.
        System.out.printf(ANSI_BLUE + "%25.14s" + ANSI_RESET + "\n\n", calendar.getYear() + " calendar");
    }

    public void printHolidayWithRedColor(int numberOfDay)
    {
        // Выводит в консоль номер красным цветом.
        System.out.printf(ANSI_RED + "%2d" + ANSI_RESET, numberOfDay);
    }

    public void printDayWithBlackColor(int numberOfDay)
    {
        // Выводит в консоль номер черным цветом.
        System.out.printf(ANSI_BLACK + "%2d" + ANSI_RESET, numberOfDay);
    }

    public void printLnMessage(String message)
    {
        System.out.println(message);
    }

    public void printMessage(String message)
    {
        System.out.print(message);
    }
}
