public class AddNumbersInAString {
    //Gl123a45ssd908oo6r, so the program should give 123 + 45 + 908 + 6 = 1082 as the result.
    public static void main(String[] args){
        String str = "Gl123a45ssd908oo6r";
        int sum=0;
        StringBuilder temp = new StringBuilder();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(Character.isDigit(ch)){
                temp.append(ch);
            } else {
                if(temp.length()>0){
                    sum += Integer.parseInt(temp.toString());
                    temp.setLength(0);
                }
            }
        }
        System.out.println("The sum is: " + sum);
    }
}