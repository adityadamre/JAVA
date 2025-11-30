package Tries;

public class UniqueSubstrings {
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

    private static int countNodes(Node curr) {
        if(curr == null) return 0;

        int cnt = 0;
        for(int i = 0; i < 26; i++) {
            if(curr.children[i] != null) cnt += countNodes(curr.children[i]);
        }

        return ++cnt;
    }

    public static int uniqueSubstring(String word) {
        for(int i = 0; i < word.length(); i++) {
            insert(word.substring(i));
        }
        
        return countNodes(root);
    }

    public static void main(String[] args) {
        root = new Node();
        String word = "apple";
        System.out.println("\nNo. of unique substrings: " + uniqueSubstring(word));
    }    
}
