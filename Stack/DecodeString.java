import java.util.*;

// LEETCODE 394

public class DecodeString {
    public static String decodeString(String str) {
        StringBuilder currStr = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int num = 0;
        
        for(char c : str.toCharArray()) {
            if(Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if(c == '[') {
                numStack.push(num);
                num = 0;
                strStack.push(currStr);
                currStr = new StringBuilder();
            } else if(c == ']') {
                int repeatTimes = numStack.pop();
                StringBuilder prevStr = strStack.pop();
                for(int i = 0; i < repeatTimes; i++) {
                    prevStr.append(currStr);
                }
                currStr = prevStr;
            } else {
                currStr.append(c);
            }
        }

        return currStr.toString();
    }

    public static void main(String[] args) {
        String str = "2[b3[ac]]";

        System.out.println(decodeString(str));
    }
}
