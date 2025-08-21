import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

class CountEmployeesPerManager {
    private static List<int[]> getEmployeesCount(List<int[]> employees) {
        List<int[]> result = new ArrayList<>();

        Map<Integer,Integer> map = new HashMap<>();

        for(int[] emp : employees){
            int mgrId = emp[1];
            map.put(mgrId, map.getOrDefault(mgrId,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int[] pair = {entry.getKey(),entry.getValue()};
            result.add(pair);
        }
        return result;
    }
    public static void main(String[] args) {
      List<int[]> employees = new ArrayList<>();
      employees.add(new int[]{1, 2});
      employees.add(new int[]{2, 3});
      employees.add(new int[]{3, 2});
      employees.add(new int[]{4, 5});
      employees.add(new int[]{5, 5});

      List<int[]> result = getEmployeesCount(employees);
      for(int[] pair : result) {
          System.out.println("Manager ID: " + pair[0] + ", Employee Count: " + pair[1]);
      }
    }
}
