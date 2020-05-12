package calendar;
import java.lang.StringBuilder;
import java.lang.StringBuffer;
/**
 *
 * @author Joanis Naum
 */
public class Calendar {

    //data
    private int day;
    private int month;
    private int year;
    private int daysInMonth;

    //constructor
    public Calendar(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;

        if (month == 1 || month == 3 || month == 5 || month == 7
                || month == 8 || month == 10 || month == 12) {
            daysInMonth = 31;
        } else if (month == 2) {
            if (((year % 4) == 0) || ((year % 100) == 0) && ((year % 400) == 0)) {
                daysInMonth = 29;
            } else {
                daysInMonth = 28;
            }
        } else {
            daysInMonth = 30;
        }
    }

    //methods
    /*public String nameOfDay() {
        int h, q, m, K, J;
        String name = "";
        q = day;
        K = year % 100;
        J = year / 100;
        if (month == 1) {
            m = 13;
            K--;
        } else if (month == 2) {
            m = 14;
            K--;
        } else {
            m = month;
        }

        h = (q + (13 * (m + 1)) / 5 + K + (K / 4) + (J / 4) - 2 * J) % 7;
        if (h == 0) {
            name = "sobota";
        } else if (h == 1) {
            name = "neděle";
        } else if (h == 2) {
            name = "pondělí";
        } else if (h == 3) {
            name = "úterý";
        } else if (h == 4) {
            name = "středa";
        } else if (h == 5) {
            name = "čtvrtek";
        } else if (h == 6) {
            name = "pátek";
        }
        return name;
    }*/
    public static int actualDay(int day, int month, int year) {
        int q = day;
        int m = month;
        int K = year % 100;
        int J = year / 100;
        if (m == 1) {
            m = 13;
            K--;
        } else if (m == 2) {
            m = 14;
            K--;
        }
        return (q + (13 * (m + 1)) / 5 + K + (K / 4) + (J / 4) - 2 * J) % 7 ;
    }
    
    public int date(){
        int date = actualDay(day, month, year);
        if (date == 0) {
            date = 6;
        } else if (date == 1) {
            date = 7;
        } else if (date == 2) {
            date = 1;
        } else if (date == 3) {
            date = 2;
        } else if (date == 4) {
            date = 3;
        } else if (date == 5) {
            date = 4;
        } else if (date == 6) {
            date = 5;
        }
        return date;
    }

    public String fCalendar() {
        int acDay = actualDay(day, month, year);
        int dayNum = 1;

        String calFormat = "Mo Tu We Th Fr Sa Su \n";
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (((j < acDay - 1 ) && (acDay != 7)) && (i == 0)) {
                    calFormat += "   ";
                } else {
                    if (dayNum < 10) {
                        calFormat += Integer.toString(dayNum) + "  ";
                    } else {
                        calFormat += Integer.toString(dayNum) + " ";
                    }
                    dayNum++;
                }
                if (dayNum > daysInMonth) {
                    return calFormat;
                }
            }
            calFormat += "\n";
        }
        return calFormat;
    }
    
    /*public String fCalendar(){
        String calFormat = "Mo Tu We Th Fr Sa Su \n";
        
        
        
        
        return calFormat;
    }*/
    

    public static boolean leapYear(int year) {
        if (((year % 4) == 0) || ((year % 100) == 0) && ((year % 400) == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public static int daysInYear(int year) {
        if (leapYear(year)) {
            return 366;
        } else {
            return 365;
        }
    }

    public static void main(String[] args) {
        //Calendar date = new Calendar(28, 2, 2021);
        //System.out.println(date.nameOfDay());
        System.out.println(Calendar.actualDay(21, 4, 2020));
        Calendar c = new Calendar(21, 4, 2020);
        System.out.println(c.fCalendar());
        System.out.println(c.daysInYear(2020));
    }

}
