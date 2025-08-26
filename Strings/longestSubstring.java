package Strings;

import java.util.HashMap;

// Problem No 3
// Can be optimised , have done with current knowledge

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {  // Without repeating characters
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

    // LEETCODE 340
    public static int maxLength(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, maxLen = 0;

        for(int r = 0; r < s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            while(map.size() > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if(map.get(s.charAt(l)) == 0) map.remove(s.charAt(l));
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String str = "serrraesdpo";
        System.out.println(maxLength(str, 3));
    }
}
