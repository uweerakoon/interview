package interview;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Aditha {

  public static void main(String[] args) {
    GregorianCalendar birthDate = new GregorianCalendar(2011, 06, 28, 00, 20);
    Calendar today = new GregorianCalendar(); 
    today.setTime(new Date()); 
    int yearsInBetween = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR); 
    int monthsDiff = today.get(Calendar.MONTH) - birthDate.get(Calendar.MONTH);
    int daysDiff = today.get(Calendar.DAY_OF_YEAR) - birthDate.get(Calendar.DAY_OF_YEAR);
    int hoursDiff = today.get(Calendar.HOUR) - birthDate.get(Calendar.HOUR);
    int minutesDiff = today.get(Calendar.MINUTE) - birthDate.get(Calendar.MINUTE);
    long ageInMonths = yearsInBetween*12 + monthsDiff; 
    long age = yearsInBetween; 
//    System.out.println("Number of months since James gosling born : " + ageInMonths); 
    System.out.println("Aditha's age : " + age+" Years : "+monthsDiff+" month: "+daysDiff+" days: "+hoursDiff+" hours: "+minutesDiff+" minutes");

  }
}
