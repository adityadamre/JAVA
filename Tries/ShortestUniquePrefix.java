package Tries;
import java.util.*;

public class ShortestUniquePrefix {
    static class Node {
        Node[] children;
        boolean eow;
        int cnt;

        public Node() {
            children = new Node[26];
            for(int i = 0; i < 26; i++) children[i] = null;
            eow = false;
            cnt = 1;
        }
    }

    public static Node root;

    public static void insert(String word) {
        Node curr = root;

        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
                curr = curr.children[idx];
            } else {
                curr = curr.children[idx];
                curr.cnt++;
            }
        }

        curr.eow = true;
    }

    public static ArrayList<String> shortestUniquePrefix(String[] words) {
        ArrayList<String> res = new ArrayList<>();

        for(String str: words) {
            Node curr = root;
            StringBuilder sb = new StringBuilder();

            for(char ch: str.toCharArray()) {
                int idx = ch - 'a';
                curr = curr.children[idx];

                if(curr.cnt == 1) {
                    sb.append(ch);
                    break;
                } else {
                    sb.append(ch);
                }
            }

            res.add(sb.toString());
        }

        return res;
    }

    public static void main(String[] args) {
        String[] words = { "dog", "dove", "thrombin", "duck", "throttle" };
        root = new Node();
        for(int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        ArrayList<String> arr = shortestUniquePrefix(words);
        System.out.println(arr);
    }
}
