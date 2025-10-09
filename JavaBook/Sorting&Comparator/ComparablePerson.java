public class ComparablePerson implements Comparable<ComparablePerson> {
    int height;
    int weight;
    public ComparablePerson(int height, int weight){
        this.height = height;
        this.weight = weight;
    }
    @Override
    public int compareTo(ComparablePerson o) {
        int heightComparison = Integer.compare(this.height, o.height);
        if (heightComparison != 0) {
            return heightComparison;
        }
        return Integer.compare(this.weight, o.weight);
    }
    public static void main(String args[]) {
        ComparablePerson p1 = new ComparablePerson(170, 70);
        ComparablePerson p2 = new ComparablePerson(180, 80);
        ComparablePerson p3 = new ComparablePerson(170, 75);
        
        System.out.println("Comparing p1 and p2: " + p1.compareTo(p2)); // Should be negative
        System.out.println("Comparing p1 and p3: " + p1.compareTo(p3)); // Should be negative
        System.out.println("Comparing p2 and p3: " + p2.compareTo(p3)); // Should be positive

        // Example of sorting
        ComparablePerson[] people = {p1, p2, p3};
        java.util.Arrays.sort(people);
        System.out.println("Sorted people by height and weight:");
        for (ComparablePerson p : people) {
            System.out.println("Height: " + p.height + ", Weight: " + p.weight);
        }
    }
}
