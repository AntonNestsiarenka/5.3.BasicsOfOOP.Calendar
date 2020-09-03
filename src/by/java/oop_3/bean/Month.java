package by.java.oop_3.bean;

public enum Month {

    // Месяцы.

    JANUARY("January", 1, 31, 1),
    FEBRUARY("February", 2, 28, 4),
    MARCH("March", 3, 31, 4),
    APRIL("April", 4, 30, 0),
    MAY("May", 5, 31, 2),
    JUNE("June", 6, 30, 5),
    JULY("July", 7, 31, 0),
    AUGUST("August", 8, 31, 3),
    SEPTEMBER("September", 9, 30, 6),
    OCTOBER("October", 10, 31, 1),
    NOVEMBER("November", 11, 30, 4),
    DECEMBER("December", 12, 31, 6);

    private String nameOfMonth;
    private int numberOfMonth;
    private int numberOfDaysInMonth;
    private int codeOfMonth;

    Month(String nameOfMonth, int numberOfMonth, int numberOfDaysInMonth, int codeOfMonth)
    {
        this.nameOfMonth = nameOfMonth;
        this.numberOfMonth = numberOfMonth;
        this.numberOfDaysInMonth = numberOfDaysInMonth;
        this.codeOfMonth = codeOfMonth;
    }

    public String getNameOfMonth() {
        return nameOfMonth;
    }

    public void setNameOfMonth(String nameOfMonth) {
        this.nameOfMonth = nameOfMonth;
    }

    public int getNumberOfMonth() {
        return numberOfMonth;
    }

    public void setNumberOfMonth(int numberOfMonth) {
        this.numberOfMonth = numberOfMonth;
    }

    public int getNumberOfDaysInMonth() {
        return numberOfDaysInMonth;
    }

    public void setNumberOfDaysInMonth(int numberOfDaysInMonth) {
        this.numberOfDaysInMonth = numberOfDaysInMonth;
    }

    public int getCodeOfMonth() {
        return codeOfMonth;
    }

    public void setCodeOfMonth(int codeOfMonth) {
        this.codeOfMonth = codeOfMonth;
    }

    @Override
    public String toString() {
        return nameOfMonth;
    }

}