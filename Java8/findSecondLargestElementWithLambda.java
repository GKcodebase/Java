package Java8;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * The type Find second largest element in list  with lambda.
 */
public class findSecondLargestElementWithLambda {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 9, 11, 2, 8, 21, 1);

        //Using Skip method


        // Execution - start time
        LocalTime startTime = LocalTime.now();

        int secondLargest = numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();

        // Execution - end time
        LocalTime endTime = LocalTime.now();


        // find difference
        Duration duration = Duration.between(startTime, endTime);
        long differenceInNano = duration.getNano();


        // print sum to console
        System.out.println("\nSecond largest number in List with skip method is  - "
                + secondLargest);


        // print execution time in Nano seconds
        System.out.println("\nExecution time - "
                + differenceInNano + " ns");


        // Execution - start time
        startTime = LocalTime.now();


        // sort in descending-order and get 2nd largest element
        int secondLargestNumber = numbers
                .stream()
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .skip(1)
                .findFirst()
                .get();


        // Execution - end time
        endTime = LocalTime.now();


        // find difference
        duration = Duration.between(startTime, endTime);
        differenceInNano = duration.getNano();


        // print sum to console
        System.out.println("\nSecond largest number in List using limit method is - "
                + secondLargestNumber);


        // print execution time in Nano seconds
        System.out.println("\nExecution time - "
                + differenceInNano + " ns");


    }

}

