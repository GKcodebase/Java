import java.util.*;
public class ConcurrentTicket {

    public static long[] getMaxTickets(long [] ticketPrice, long [] arrivals){
        Arrays.sort(ticketPrice);

        long[] result = new long[arrivals.length];
        for(int i=0; i<arrivals.length; i++){
            for(int j=ticketPrice.length-1; j>=0; j--){
                if(ticketPrice[j] <= arrivals[i]){
                    result[i] = ticketPrice[j];
                    ticketPrice[j] = Long.MAX_VALUE;
                    break;
                }
            }
            result[i] = result[i]==0 ? -1 : result[i];
        }
        return result;
    }
   public static void main(String args[]){
       long [] ticketPrice = {5, 3, 7, 8, 5};
       long [] arrivals = {4, 8, 3};

       long [] result = getMaxTickets(ticketPrice, arrivals);
       for(long i: result)
            System.out.print(i + " ");
   }
}
