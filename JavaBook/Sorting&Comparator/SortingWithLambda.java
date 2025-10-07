/**
 * The {@code SortingWithLambda} class demonstrates sorting an array of objects
 * using a lambda expression with {@link java.util.Arrays#sort(Object[], java.util.Comparator)}.
 * <p>
 * Each instance represents a person with {@code height} and {@code weight} attributes.
 * The main method creates several instances and sorts them first by height,
 * and then by weight if heights are equal.
 * <p>
 * Example usage:
 * <pre>
 *     SortingWithLambda p1 = new SortingWithLambda(170, 70);
 *     SortingWithLambda p2 = new SortingWithLambda(180, 80);
 *     SortingWithLambda p3 = new SortingWithLambda(170, 75);
 *     SortingWithLambda[] people = { p1, p2, p3 };
 *     Arrays.sort(people, ...);
 * </pre>
 * The sorted output will list people by ascending height, and by ascending weight for equal heights.
 */
public class SortingWithLambda {
    int height;
    int weight;

    public SortingWithLambda(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public static void main(String args[]) {
        SortingWithLambda p1 = new SortingWithLambda(170, 70);
        SortingWithLambda p2 = new SortingWithLambda(180, 80);
        SortingWithLambda p3 = new SortingWithLambda(170, 75);

        SortingWithLambda[] people = { p1, p2, p3 };

        java.util.Arrays.sort(people, (a, b) -> {
            return a.height - b.height != 0 ? a.height - b.height : a.weight - b.weight;
        });

        System.out.println("Sorted people by height and weight:");
        for (SortingWithLambda p : people) {
            System.out.println("Height: " + p.height + ", Weight: " + p.weight);
        }
    }
}
