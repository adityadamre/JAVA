package Strings;

public class LongestPallindromicSubstring {
    private static boolean isPallindrome(String str) {
        int l = 0, r = str.length() - 1;

        while(l <= r) {
            if(str.charAt(l) != str.charAt(r)) return false;
            l++; r--;
        }

        return true;
    }

    public static String longestPalindromeBrute(String s) {
        if(s == null || s.length() == 0) return "";
        if(s.length() == 1) return s;

        if(isPallindrome(s)) return s;

        String first = longestPalindromeBrute(s.substring(0, s.length() - 1));
        String second = longestPalindromeBrute(s.substring(1));

        return first.length() >= second.length() ? first : second;
    }

    private static int expandFromCenter(String s, int left, int right) {
        while(left >= 0 && right <= s.length() - 1 && s.charAt(right) == s.charAt(left)) {
            left--; right++;
        }

        return right - left - 1;
    }

    public static String longestPalindrome(String s) {  // Expand From Center
        if(s == null || s.length() < 1) return s;

        int st = 0, end = 0;

        for(int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);
            int len2 = expandFromCenter(s, i, i+1);
            int len = Math.max(len1, len2);

            if(len > (end - st)) {
                st = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(st, end+1);
    }

    public static void main(String[] args) {
        String str = new String("mlabcdcban");

        System.out.println(longestPalindrome(str));
    }
}
