package by.java.oop_3;

import by.java.oop_3.bean.Calendar;
import by.java.oop_3.bean.Month;
import by.java.oop_3.logic.CalendarLogic;

public class CalendarMain {

    public static void main(String[] args)
    {
        Calendar calendar = new Calendar();
        CalendarLogic calendarLogic = new CalendarLogic();

        calendarLogic.fillDayOff(calendar);

        Calendar.Holiday holiday1 = calendar.new Holiday("Orthodox Christmas", 7, Month.JANUARY);
        Calendar.Holiday holiday2 = calendar.new Holiday("International Women's Day", 8, Month.MARCH);
        Calendar.Holiday holiday3 = calendar.new Holiday("Victory Day", 9, Month.MAY);
        Calendar.Holiday holiday4 = calendar.new Holiday("Independence Day", 3, Month.JULY);
        Calendar.Holiday holiday5 = calendar.new Holiday("Defender of the Fatherland Day", 23, Month.FEBRUARY);
        Calendar.Holiday holiday6 = calendar.new Holiday("New Year", 1, Month.JANUARY);

        calendarLogic.displayCalendar(calendar);

        System.out.println("Выходные и праздничные дни");
        calendarLogic.displayHolidaysInfo(calendar);
    }
}
