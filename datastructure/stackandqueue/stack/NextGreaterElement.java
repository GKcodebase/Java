package datastructure.stackandqueue.stack;

import java.util.Arrays;

/**
 * The type Next greater element.
 */
public class NextGreaterElement {
    /**
     * Get next great element int [ ].
     *
     * @param array the array
     * @return the int [ ]
     */
    public static int[] getNextGreatElement(int[] array){
        int l = array.length;
        int[] result = new int[l];
        Stack<Integer> stack = new Stack<>(l);
        for(int i =l-1;i>=0;i--){
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && stack.top()<=array[i])
                    stack.pop();
            }
            if(stack.isEmpty())
                result[i]=-1;
            else
                result[i] = stack.top();
            stack.push(array[i]);
        }
        return result;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args)
    {
        int arr[] = {4,6,3,2,8,1,11,9};
        System.out.println(Arrays.toString(arr));
        int result[] = getNextGreatElement(arr);
        System.out.println(Arrays.toString(result));
    }
}
