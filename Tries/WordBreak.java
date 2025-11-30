package Tries;
import java.util.*;

public class WordBreak {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;

        public Node() {
            for(int i = 0; i < 26; i++) children[i] = null;
        }
    }

    public static Node root;
    public static int[] marker;

    public static void insert(String word) {
        Node curr = root;

        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static int wordBreak(String key, int st) {
        if(st == key.length()) return 2;
        if(marker[st] != 0) return marker[st];

        Node curr = root;

        for(int i = st; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if(curr.children[idx] == null) break;

            curr = curr.children[idx];
            
            if(curr.eow && wordBreak(key, i + 1) == 2) {
                marker[st] = 2;
                return 2;
            }
        }

        marker[st] = 1;
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = { "the", "a", "there", "their", "any", "thee" };
        
        root = new Node();
        for(int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println("Enter the string to be searched: ");
        String str = sc.next();

        marker = new int[str.length()]; // Used to memoiz the result calculated once...
                                        // 0 - not visited, 1 - false, 2 - true

        System.out.println(wordBreak(str, 0) == 2);

        sc.close();
    }
}
