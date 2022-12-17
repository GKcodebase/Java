package Java8;

/**
 * The type Lambda functions basic.
 */
public class lambdaFunctionsBasic {
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){

        lambdaFunctionsBasic tester = new lambdaFunctionsBasic();

        //with type declaration
        MathOperation addition = (int a, int b) -> a + b;

        //without type declaration
        MathOperation subtraction = (a, b) -> a - b;

        //with return statement along with curly braces
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        //without return statement and without curly braces
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("100 + 50 = " + tester.operate(100, 50, addition));
        System.out.println("1000 - 500 = " + tester.operate(1000, 500, subtraction));
        System.out.println("200 x 3 = " + tester.operate(200, 3, multiplication));
        System.out.println("900 / 45 = " + tester.operate(900, 45, division));

        //without parenthesis
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        //with parenthesis
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Tom");
        greetService2.sayMessage("Kim");
    }

    /**
     * The interface Math operation.
     */
    interface MathOperation {
        /**
         * Operation int.
         *
         * @param a the a
         * @param b the b
         * @return the int
         */
        int operation(int a, int b);
    }

    /**
     * The interface Greeting service.
     */
    interface GreetingService {
        /**
         * Say message.
         *
         * @param message the message
         */
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

}
