import java.util.ArrayList;

/**
 * Demonstrates basic usage of the ArrayList class in Java.
 */
public class ArrayListExample {
    /**
     * The main method where program execution begins.
     * @param args Command line arguments (not used).
     */
    public static void main(String args[]) {
        // Creates an ArrayList to store Integer values.
        ArrayList<Integer> list = new ArrayList<>();

        // Adds the integer 2 to the list.
        list.add(2);
        // Adds the integer 3 to the list.
        list.add(3);
        // Adds the integer 7 to the list.
        list.add(7);
        // Adds the integer 1 to the list.
        list.add(1);
        // Adds the integer 5 to the list.
        list.add(5);

        // Updates the element at index 2 to be 10.
        list.set(2, 10);

        // Iterates over the list and prints each element.
        for (int i = 0; i < list.size(); i++) {
            // Prints the element at index i.
            System.out.println(list.get(i));
        }

        // Removes the element at index 0 from the list.
        list.remove(0);
        // Removes the last element from the list.
        list.remove(list.size() - 1);

        // Prints the first element of the modified list.
        System.out.println(list.get(0));
    }
}
