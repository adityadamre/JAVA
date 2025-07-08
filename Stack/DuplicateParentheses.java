import java.util.*;

public class DuplicateParentheses {
    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != ')') {
                s.push(str.charAt(i));
            } else {
                int count = 0;
                while(s.pop() != '(') {
                    s.pop();
                    count++;
                }
                if(count < 1) {
                    return true;
                }
            }
        }
        
        return false;
    }


    public static void main(String[] args) {
        String str = "((a+b)*(c+d))"; // ALWAYS VALID EXPRESSION
        
        System.out.println(isDuplicate(str));
    }
}
