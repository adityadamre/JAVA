package Queue;
import java.util.*;

public class FirstUniqueChar {
    public static void firstUniqChar(String str) {
        Queue<Character> q = new LinkedList<>();
        char[] freq = new char[26];

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;

            while(!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            if(q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
    }

    public static void main(String[] args) {
        String str = "gargantua";
        firstUniqChar(str);
    }
}
