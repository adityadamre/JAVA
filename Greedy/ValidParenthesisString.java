package Greedy;

// LEETCODE 678
public class ValidParenthesisString {
    public static boolean isValid(String s) {
        int min = 0, max = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '(') {
                min = min + 1;
                max = max + 1;
            } else if(ch == '(') {
                min = min - 1;
                max = max - 1;
            } else {
                min = min - 1;
                max = max + 1;
            }
            
            if(min < 0) min = 0;

            if(max < 0) return false;
        }

        if(min == 0 || max == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "(*)(*))";

        System.out.println(isValid(s));
    }
}
