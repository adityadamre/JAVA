import java.util.*;

public class ValidParentheses {
    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char brace = str.charAt(i);
            if(brace == '(' || brace == '[' || brace == '{') {
                s.push(brace);
            } else {
                if(s.isEmpty()) return false;

                if((brace == ')' && s.peek() == '(') || (brace == ']' && s.peek() == '[') || (brace == '}' && s.peek() == '{')) {
                    s.pop();
                } else {
                    return false;
                }
            } 
        }

        if(!s.isEmpty()) return false;

        return true;
    }


    public static void main(String[] args) {
        String str = "([{})";
        System.out.println(isValid(str));
    }
}