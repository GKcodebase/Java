package CheatSheet.Basics;

/**
 * The Strings.
 */
public class Strings {
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        String s = "Hello World!!";
        // String Manipulation
        int index =0;
        int start =0;int end =0;
        s.length();             // String length
        s.charAt(index);        // Character at index
        s.substring(start, end);// Extract substring
        s.toLowerCase();        // To lowercase
        s.toUpperCase();        // To uppercase


        // String Builder (Mutable)
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");     // Add to end
        sb.insert(index, s);    // Insert at index
        sb.reverse();           // Reverse string

    }
}
