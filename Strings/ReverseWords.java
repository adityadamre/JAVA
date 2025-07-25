package Strings;

// LEETCODE 151
public class ReverseWords {
    public static String reverseOrder(String str) {
        int i = 0;
        StringBuilder sb = new StringBuilder();

        while(str.charAt(i) == ' ') i++;
        
        while(i < str.length()) {
            StringBuilder temp = new StringBuilder();

            while(i < str.length() && Character.isLetterOrDigit(str.charAt(i))) {
                temp.append(str.charAt(i));
                i++;
            }

            while(i < str.length() && str.charAt(i) == ' ') {
                i++;
            }

            sb.insert(0, temp + " ");
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    public static String reverseOrderOpti(String str) {
        str.trim();

        String[] word = str.split("\\s+");
        StringBuilder res = new StringBuilder();

        for(int i = word.length - 1; i >= 0; i--) {
            res.append(word[i]);
            if(i != 0) res.append(" ");
        }

        return res.toString();
    }

    // YOU MAY ALSO USE STACK<INTEGER> TO STORE WORDS....

    public static void main(String[] args) {
        String str = "The sky is blue";

        System.out.println(reverseOrderOpti(str));
    }
}
