/**
 * The ComparatorPerson class represents a person with height and weight attributes.
 * It provides a constructor to initialize these attributes.
 * 
 * In the main method, an array of ComparatorPerson objects is created and sorted
 * using a custom Comparator. The sorting is performed first by height, and then by
 * weight if the heights are equal.
 * 
 * After sorting, the list of people is printed in order of increasing height and weight.
 */
public class ComparatorPerson {
    int height;
    int weight;

    public ComparatorPerson(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public static void main(String args[]) {
        ComparatorPerson p1 = new ComparatorPerson(170, 70);
        ComparatorPerson p2 = new ComparatorPerson(180, 80);
        ComparatorPerson p3 = new ComparatorPerson(170, 75);

        ComparatorPerson[] people = { p1, p2, p3 };

        java.util.Arrays.sort(people, new java.util.Comparator<ComparatorPerson>() {
            @Override
            public int compare(ComparatorPerson a, ComparatorPerson b) {
                int heightComparison = Integer.compare(a.height, b.height);
                if (heightComparison != 0) {
                    return heightComparison;
                }
                return Integer.compare(a.weight, b.weight);
            }
        });

        System.out.println("Sorted people by height and weight:");
        for (ComparatorPerson p : people) {
            System.out.println("Height: " + p.height + ", Weight: " + p.weight);
        }
    }
}
