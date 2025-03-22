package Strings;

// Problem No 3
// Can be optimised , have done with current knowledge

public class longestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int length = 1, index = 0, maxLength = 1;

        for(int i = 1; i < s.length(); i++) {
            boolean shouldContinue = false;
            for(int j = index; j < i; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    length = 1;
                    index = i;
                    shouldContinue = true;
                    continue;
                }
            }
            if(shouldContinue) {
                continue;
            } else {
                length++;
            }
            
            maxLength = Math.max(length, maxLength);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String str = "serrrasdpo";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
