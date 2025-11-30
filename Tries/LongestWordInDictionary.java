package Tries;

public class LongestWordInDictionary {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;

        public Node() {
            for(int i = 0; i < 26; i++) children[i] = null;
        }
    }
    public static Node root;

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

    public static void longestWord(Node root, String[] res, StringBuilder temp) {
        if(root == null) return;

        Node curr = root;
        for(int i = 0; i < 26; i++) {
            if(curr.children[i] != null && curr.children[i].eow) {
                char ch = (char) (i + 'a');
                temp.append(ch);
                if(temp.length() > res[0].length()) res[0] = temp.toString();
                longestWord(curr.children[i], res, temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String[] words = { "apple", "a", "an", "app", "ant", "ap", "apply", "appl", "an" };
        root = new Node();
        for(String word: words) insert(word);

        String[] res = { "" };  // Just to pass String by reference...
        longestWord(root, res, new StringBuilder(""));
        System.out.println(res[0]);
    }
}
