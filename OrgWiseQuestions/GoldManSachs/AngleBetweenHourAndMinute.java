public class AngleBetweenHourAndMinute {

   private static int getDegree(int minute, int hour){
        return Math.abs(minute * 6 - (hour % 12) * 30 - minute / 2);
   }
   public static void main(String[] args){
       int hour = 3;
       int minute = 30;
       int angle = getDegree(minute, hour);
       System.out.println("The angle between the hour and minute hand is: " + angle + " degrees");
   }
}
