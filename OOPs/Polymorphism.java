package OOPs;

/**
 * The Simple Polymorphism.
 */
public class Polymorphism {

    /**
     * Add int.
     *
     * @param a the a
     * @param b the b
     * @return the int
     */
    public int add(int a ,int b){
        return a+b;
    }

    /**
     * Add float.
     *
     * @param a the a
     * @param b the b
     * @return the float
     */
    public float add(float a ,float b){
        return a+b;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
           Polymorphism polymorphism = new Polymorphism();
           System.out.println(polymorphism.add(4,5));
           System.out.println(polymorphism.add(4.0f,5.0f));
    }
}
