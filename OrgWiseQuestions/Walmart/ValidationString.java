import java.util.Stack;

/**
 * Given a string s containing only the characters '(', ')', and '*', write a function to check if the string is valid based on the following rules:
 * Every '(' must be matched with a corresponding ')'.
 * Every ')' must have a corresponding '('.
 * The '*' character can be treated as either an opening parenthesis '(', a closing parenthesis ')', or an empty string.
 */
public class ValidationString {
   public static void main(String args[]){
       System.out.println(isValid("(*)")); // true
       System.out.println(isValid("(*))")); // true
       System.out.println(isValid("((*)")); // true
       System.out.println(isValid("((*)*)")); // true
       System.out.println(isValid("((*)*))))")); // false
       System.out.println(isValid("((())")); // false
   }

   public static boolean isValid(String s) {
      int minOpen=0; // Minimum number of open parentheses
      int maxOpen=0; // Maximum number of open parentheses
      for(char c : s.toCharArray()){
          if(c == '(') { 
              minOpen++;
              maxOpen++;
          } else if(c == ')') {
              minOpen--;
              maxOpen--;
          } else { // c == '*'
              // '*' can be treated as '(', ')', or empty
              minOpen--;
              maxOpen++;
          }
          if(maxOpen < 0) return false;// If maxOpen is negative, there are unmatched closing parentheses
      }
      return minOpen <= 0; // Check if all open parentheses are matched
   }
}
