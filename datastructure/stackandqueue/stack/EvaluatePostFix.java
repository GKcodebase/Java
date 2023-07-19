package datastructure.stackandqueue.stack;

/**
 * The type Evaluate post fix.
 */
public class EvaluatePostFix {
    /**
     * Evaluate int.
     *
     * @param expression the expression
     * @return the int
     */
    public static int evaluate(String expression) {
        Stack<Integer> stack = new Stack<>(expression.length());
        //1.Scan expression character by character,
        //2.If character is a number push it in stack
        //3.If character is operator then pop two elements from stack
        //perform the operation and put the result back in stack
        //At the end, Stack will contain result of whole expression.
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (!Character.isDigit(c)) {
                Integer x = stack.pop();
                Integer y = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(y + x);
                        break;
                    case '-':
                        stack.push(y - x);
                        break;
                    case '*':
                        stack.push(y * x);
                        break;
                    case '/':
                        stack.push(y / x);
                        break;
                }
            } else {
                stack.push(Character.getNumericValue(c));
            }
        }
        return stack.pop();

    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        System.out.println(evaluate("921*-8-4+"));
    }
}
