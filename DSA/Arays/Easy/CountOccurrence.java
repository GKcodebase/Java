package DSA.Arays.Easy;

/**
 * The type Count occurrence.
 */
public class CountOccurrence {
    /**
     * Count occurrence int.
     * Count the number of keys in the given sorted array
     * O(log n) + count(key) time complexity
     *
     * @param arrays the arrays
     * @param key    the key
     * @return the int
     */
    int countOccurrence(int[] arrays, int key) {
        int size = arrays.length;
        int first = 0, last = size, mid = first + (last - first) / 2;
        //Check or find the location of key.
        while (first < last) {
            mid = first + (last - first) / 2;
            if (arrays[mid] == key)
                break;
            else if (arrays[mid] > key)
                last = mid - 1;
            else
                first = mid + 1;
            if (first >= last)
                return -1;
        }
        int count = 1;
        int left = mid - 1;
        //Count occurrence of key towards left of found index
        while (left >= 0 && arrays[left] == key) {
            count++;
            left--;
        }
        //Count occurrence of key towards right of found index
        int right = mid + 1;
        while (right < size && arrays[right] == key) {
            count++;
            right++;

        }
        return count;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        //Driver code to run method
        int[] arr = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
        CountOccurrence occurrence = new CountOccurrence();
        int key = 2;
        System.out.println("Count of key :: " + key + " is :: " + occurrence.countOccurrence(arr, key));
    }
}

