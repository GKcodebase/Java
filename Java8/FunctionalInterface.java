package Java8;

/**
 * The type Functional interface.
 */
public class FunctionalInterface {

    /**
     * The interface My interface.
     */
// Before Java 8
    interface MyInterface {
        /**
         * My method.
         */
        void myMethod();
    }

    /**
     * Main.
     *
     * @param arg the arg
     */
    public static void main(String arg[]){

        // With Functional Interface and Lambda Expression
        MyInterface myInterface = () -> System.out.println("Hello from functional interface");
        myInterface.myMethod();

    }
}
