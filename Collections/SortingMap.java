package Collections;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The  Sorting map.
 * Sorting map of object, based on the element in the object.
 */
public class SortingMap {

    /**
     * The type Employees.
     */
    static class Employees {
        /**
         * The Name.
         */
        String name;
        /**
         * The Number.
         */
        int number;

        /**
         * Instantiates a new Employees.
         *
         * @param name   the name
         * @param number the number
         */
        public Employees(String name, int number) {
            this.name = name;
            this.number = number;
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {


        Map<String, Employees> employeesMap = new HashMap<>();
        employeesMap.put("123", new Employees("raju", 2565));
        employeesMap.put("345", new Employees("bob", 2595));
        employeesMap.put("563", new Employees("tommy", 0065));
        employeesMap.put("103", new Employees("vasu", 2865));
        employeesMap.put("193", new Employees("rayan", 6765));
        employeesMap.put("903", new Employees("moni", 9089));
        employeesMap.put("883", new Employees("koppan", 4567));

        List<Map.Entry<String, Employees>> entryList = new ArrayList<>(employeesMap.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Employees>>() {
            @Override
            public int compare(Map.Entry<String, Employees> o1, Map.Entry<String, Employees> o2) {
                return o1.getValue().name.compareTo(o2.getValue().name);
            }
        });

        employeesMap = entryList.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        employeesMap.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " : " + e.getValue().name));


    }
}
