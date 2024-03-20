package Java8;

/**
 * The type Lambda expression.
 */
    public class LambdaExpression {

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        // Before Java 8
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Old way: Running a thread");
            }
        }).start();

        // With Lambda Expression
        new Thread(() -> System.out.println("New way: Running a thread")).start();

    }
}
