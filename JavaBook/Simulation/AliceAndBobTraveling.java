public class AliceAndBobTraveling {
    private static int meetingTime(int ax, int ay, int bx, int by, int p, int q, int m, int n){
        int time = 0;
        while(ax < bx && ay < by){
            ax +=m;
            ay +=n;
            bx -=p;
            by -=q;
            time++;
        }
        if(ax >= bx && ay >= by)
            return time;
        return -1;
    }
    public static void main(String args[]){
        int ax = 0, ay = 0; // Alice's starting point
        int bx = 10, by = 10; // Bob's starting point
        int p = 1, q = 1; // Bob's speed in x and y directions
        int m = 2, n = 2; // Alice's speed in x and y directions

        int result = meetingTime(ax, ay, bx, by, p, q, m, n);
        System.out.println(result); // Output the meeting time or -1 if they never meet
    }
}
