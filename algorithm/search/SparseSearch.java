package algorithm.search;

public class SparseSearch {
    public static boolean modifiedBinarySearch(String[] array, int low, int high, String target) {
        if (low > high)
            return false;
        int mid = (low + high) / 2;
        //Modified Binary Search
        if (array[mid] == "") {
            int i = mid - 1;
            int j = mid + 1;
            while (true) {
                if (i < low && j > high)
                    return false;
                if (i >= low && array[i] != "") {
                    mid = i;
                    break;
                } else if (j <= high && array[j] != "") {
                    mid = j;
                    break;
                }
                i--;
                j++;
            }

        }
        // Now perform simple Binary Search
        if (array[mid].equals(target))
            return true;
        else if (array[mid].compareTo(target) > 0)
            return modifiedBinarySearch(array, low, mid - 1, target);
        else
            return modifiedBinarySearch(array, mid + 1, high, target);
    }

    public static boolean searchForString(String[] array, String target) {
        return modifiedBinarySearch(array, 0, array.length - 1, target);
    }

    public static void main(String args[]) {
        String[] array = {
                "",
                "educative",
                "",
                "",
                "",
                "hello",
                "",
                "learning",
                "world",
                "",
                "",
                ""
        };
        String[] targetArray = {
                "educative",
                "learning",
                "good",
                "bad",
                " "
        };

        for (int i = 0; i < targetArray.length; i++) {
            System.out.println(targetArray[i] + ": " + searchForString(array, targetArray[i]));
        }
    }
}
