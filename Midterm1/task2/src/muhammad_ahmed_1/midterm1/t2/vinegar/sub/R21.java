package muhammad_ahmed_1.midterm1.t2.vinegar.sub;

import muhammad_ahmed_1.midterm1.t2.vinegar.A21;
import muhammad_ahmed_1.midterm1.t2.knife.opera.A22;

public class R21 {
    public static void main(String[] args) {
        A21 rectangle = new A21();
        int area = rectangle.getWidth() * rectangle.getHeight();
        System.out.println("Area: " + area);


        A22 mHolder = new A22();
        int m = mHolder.getMonth();


        String monthName;
        switch (m) {
            case  1:  monthName = "January";   break;
            case  2:  monthName = "February";  break;
            case  3:  monthName = "March";     break;
            case  4:  monthName = "April";     break;
            case  5:  monthName = "May";       break;
            case  6:  monthName = "June";      break;
            case  7:  monthName = "July";      break;
            case  8:  monthName = "August";    break;
            case  9:  monthName = "September"; break;
            case 10:  monthName = "October";   break;
            case 11:  monthName = "November";  break;
            case 12:  monthName = "December";  break;
            default:  monthName = "Invalid month (" + m + ")";
        }
        System.out.println("Month: " + monthName);
    }
}
