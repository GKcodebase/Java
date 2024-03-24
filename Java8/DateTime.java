package Java8;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * The type Date time.
 */
public class DateTime {
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current date and time: " + now);
        Date date = new Date();
        System.out.println("Date in IST: " + date);
        System.out.println("TimeStamp in UTC: " + Instant.now());

    }
}
