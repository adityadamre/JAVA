import java.util.*;

// LEETCODE 402
public class RemoveKDigits {
    public static String removeKDigits(String str, int k) {
        if(k == str.length()) return "0";

        Stack<Character> s = new Stack<>();
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < str.length(); i++) {
            while(!s.isEmpty() && k > 0 && (str.charAt(i) - '0') < (s.peek() - '0')) {
                s.pop();
                k--;
            }
            s.push(str.charAt(i));
        }

        while(k != 0) {
            s.pop();
            k--;
        }

        if(s.isEmpty()) return "0";

        while(!s.isEmpty()) {
            res.append(s.pop());
        }

        while(res.length() != 0 && res.charAt(res.length() - 1) == '0') {
            res.delete(res.length() - 1, res.length());
        }

        res.reverse();

        if(res.isEmpty()) return "0";

        return res.toString();
    }


    public static void main(String[] args) {
        String str = "1432219";

        System.out.println(removeKDigits(str, 3));
    }
}
