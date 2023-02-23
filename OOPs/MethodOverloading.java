package OOPs;

/**
 * The Method overloading.
 */
public class MethodOverloading {

    /**
     * Add int.
     *
     * @param x the x
     * @param y the y
     * @return the int
     */
    public int add(int x , int y){
        return x+y;
    }

    /**
     * Add float.
     *
     * @param x the x
     * @param y the y
     * @return the float
     */
    public float add(float x , float y){
        return x+y;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        MethodOverloading overloading = new MethodOverloading();
        System.out.println(overloading.add(24,56));
        System.out.println(overloading.add(100.0f,56.0f));
    }
}
