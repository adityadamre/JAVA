package Strings;

public class StringToInt {
    public static int myAtoi(String s) {
        if(s.isEmpty()) return 0;

        int idx = 0, n = s.length(), ans = 0;
        boolean isNegative = false;

        while(idx < n && s.charAt(idx) == ' ') {
            idx++;
        }

        if(idx < n) {
            if(s.charAt(idx) == '-') {
                isNegative = true;
                idx++;
            } else if(s.charAt(idx) == '+') {
                idx++;
            }
        }

        while(idx < n && Character.isDigit(s.charAt(idx))) {
            int digit = s.charAt(idx) - '0';
            
            if(ans > (Integer.MAX_VALUE - digit)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            
            ans = ans * 10 + digit;
            idx++;
        }

        return isNegative ? -ans : ans;
    }

    public static void main(String[] args) {
        String str = "  -231p21";

        System.out.println(myAtoi(str));
    }
}
