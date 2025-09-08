public class MaxDistance {

    public static int maxEuclidianDistance(int x[], int y[]){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<x.length;i++){
            for(int j=0;j<y.length;j++){
                int dist = (int)Math.sqrt(Math.pow(x[i]-x[j], 2) + Math.pow(y[i]-y[j], 2));
                if(dist > max){
                    max = dist;
                }
            }
        }
        return max;
    }
   public static void main(String args[]) {
       int x[] = {1, 2, 3};
       int y[] = {4, 5, 6};
       System.out.println("Max Euclidian Distance: " + maxEuclidianDistance(x, y));
   }
}
