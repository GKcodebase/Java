package Java8;

import java.util.Arrays;
import java.util.List;

/**
 * The type Stream api.
 */
public class StreamAPI {
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Using Stream API to find even numbers and print them
        numbers.stream()
                .filter(num -> num % 2 == 0)
                .forEach(System.out::println);

    }
}
