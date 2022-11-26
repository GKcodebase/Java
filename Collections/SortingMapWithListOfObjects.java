package Collections;

import java.util.*;

/**
 * The type Sorting map with list of objects.
 */
public class SortingMapWithListOfObjects {

    /**
     * The type Student.
     */
    public static class Student {
        /**
         * The Id.
         */
        int id;
        /**
         * The Name.
         */
        String name;

        /**
         * Gets name.
         *
         * @return the name
         */
        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", level='" + level + '\'' +
                    '}';
        }

        /**
         * The Level.
         */
        String level;

        /**
         * Instantiates a new Student.
         *
         * @param id    the id
         * @param name  the name
         * @param level the level
         */
        public Student(int id, String name, String level) {
            this.id = id;
            this.name = name;
            this.level = level;
        }

        /**
         * Gets id.
         *
         * @return the id
         */
        public int getId() {
            return id;
        }

        /**
         * Sets id.
         *
         * @param id the id
         */
        public void setId(int id) {
            this.id = id;
        }

        /**
         * Sets name.
         *
         * @param name the name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Gets level.
         *
         * @return the level
         */
        public String getLevel() {
            return level;
        }

        /**
         * Sets level.
         *
         * @param level the level
         */
        public void setLevel(String level) {
            this.level = level;
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Map<String, List<Student>> mapList = new HashMap<>();
        mapList.put("1001", Arrays.asList(new Student(22, "bob", "3"), new Student(45, "Rob", "6"), new Student(90, "Tom", "9")));
        mapList.put("1002", Arrays.asList(new Student(22, "Rob", "3"), new Student(45, "Cody", "9"), new Student(90, "Judy", "2"), new Student(90, "Sam", "3"), new Student(85, "Appu", "9"), new Student(49, "Joppan", "2")));
        mapList.put("1003", Arrays.asList(new Student(89, "fukru", "7"), new Student(39, "chukru", "9")));
        mapList.put("1004", Arrays.asList(new Student(82, "Pappu", "9")));
        mapList.put("1005", new ArrayList<>());
        mapList.put("1006", Arrays.asList(new Student(12, "Chahcha", "3"), new Student(7, "Chahchi", "6"), new Student(80, "chuppan", "9")));
        System.out.println(mapList);

        System.out.println("Map after sorting :: ");


        Map<String, List<Student>> mapList2 = sorter(mapList);

        System.out.println(mapList2);
    }

    private static Map<String, List<Student>> sorter(Map<String, List<Student>> mapList) {
        Comparator<Student> comparator = Comparator.comparing(Student::getName);
        mapList.values().forEach(list -> list.sort(comparator));
        return mapList;
    }

}
