package Strings;

public class KMP {
    private static void buildlps(int[] lps, String str) {
        lps[0] = 0;
        int i = 0, j = 1;

        while(j < str.length()) {
            if(str.charAt(i) == str.charAt(j)) {
                i++;
                lps[j] = i;
                j++;
            } else {
                if(i != 0) {
                    i = lps[i-1];
                } else {
                    lps[j] = 0;
                    j++;
                }
            }
        }
    }

    public static boolean isSubstring(String text, String pattern) {   // Return true if pattern is present in text
        if(pattern.length() > text.length()) return false;

        int[] lps = new int[pattern.length()];
        buildlps(lps, pattern);

        int i = 0, j = 0;
        while(j < text.length()) {
            if(text.charAt(j) == pattern.charAt(i)) {
                i++;
                j++;

                if(i == pattern.length()) return true;
            } else {
                if(i != 0) i = lps[i-1];
                else j++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String text = "ababcabdabababd";
        String pattern = "ababcd";

        System.out.println("Is the pattern substring of text? -> " + isSubstring(text, pattern));
    }
}
