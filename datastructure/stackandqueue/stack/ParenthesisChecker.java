package datastructure.stackandqueue.stack;

import java.util.Stack;

/**
 * The type Parenthesis checker.
 */
public class ParenthesisChecker {

    /**
     * Check parenthesis boolean.
     *
     * @param expression the expression
     * @return the boolean
     */
    public static boolean checkParenthesis(String expression){
        boolean ans = true;
        Stack stack = new Stack();
        for(char c:expression.toCharArray()){
            Character ch = !stack.isEmpty()? (Character) stack.peek():null;
            if(c == '[' || c== '{' || c== '(')
                stack.push(c);
            else if(c == ']'){
                if(ch!=null && ch!='['){
                    ans=false;
                    break;
                }
                else{
                    stack.pop();
                }
            }
            else if(c == '}'){
                if(ch!=null && ch!='{'){
                    ans=false;
                    break;
                }
                else{
                    stack.pop();
                }
            }else if(c == ')'){
                if(ch!=null && ch!='('){
                    ans=false;
                    break;
                }
                else{
                    stack.pop();
                }
            }
        }
        ans = stack.isEmpty();
        return ans;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        String s1 = "{}[{()}]()";
        String s2 = "{({)]";

        System.out.println("The string "+s1+ " check is "+checkParenthesis(s1));
        System.out.println("The string "+s2+ " check is "+checkParenthesis(s2));

    }
}
