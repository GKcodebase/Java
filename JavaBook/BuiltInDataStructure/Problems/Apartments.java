/**
 * There are n applicants and m free apartments. 
 * Your task is to distribute the apartments so that as many applicants as possible will get an apartment.
 * Each applicant has a desired apartment size, and they will accept any apartment whose size is close enough to the desired size.
 */
import java.util.*;
public class Apartments {

    public int getMaxApplicants(long [] applicants, long [] apartments, long k){
        Arrays.sort(applicants);
        Arrays.sort(apartments);

        int i=0, j=0, count=0;
        while(i<applicants.length && j<apartments.length){
            if(Math.abs(applicants[i]- apartments[j]) <= k){
                i++;j++;count++;
            } else {
                if(applicants[i]<apartments[j])
                    i++;
                else
                    j++;
            }
        }
        return count;
    }

   public static void main(String args[]){
    //    Apartments a = new Apartments();
    //    int [] applicants = {60, 45, 80, 60};
    //    int [] apartments = {30, 60, 75};
    //    int k = 5;
    //    System.out.println(a.getMaxApplicants(applicants, apartments, k));
    // The first input line has three integers n, m, and k: the number of applicants, the number of apartments, and the maximum allowed difference.
    // The next line contains n integers a_1, a_2, \ldots, a_n: the desired apartment size of each applicant. If the desired size of an applicant is x, they will accept any apartment whose size is between x-k and x+k.
    // The last line contains m integers b_1, b_2, \ldots, b_m: the size of each apartment.

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    long k = sc.nextLong();
    long [] applicants = new long[n];
    for(int i=0;i<n;i++)
        applicants[i] = sc.nextLong();
    long [] apartments = new long[m];
    for(int i=0;i<m;i++)
        apartments[i] = sc.nextLong();
    Apartments a = new Apartments();
    System.out.println(a.getMaxApplicants(applicants, apartments, k));

   } 
}
