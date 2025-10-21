import java.util.*;

public class CelebrityProblem {
    // STACK
    public static int celebrity(int mat[][]) {  // TC -> O(2n), SC -> O(n)
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < mat.length; i++) st.push(i);

        while(st.size() > 1) {
            int p1 = st.pop();
            int p2 = st.pop();

            if(mat[p1][p2] == 1) st.push(p2);
            else st.push(p1);
        }

        int celeb = st.pop();

        for(int i = 0; i < mat.length; i++) {
            if(i == celeb) continue;

            if(mat[celeb][i] == 1 || mat[i][celeb] == 0) return -1;
        }

        return celeb;
    }

    // TWO-POINTER (Intuitive)
    public static int celebrityOpti(int mat[][]) {  // TC -> O(2n), SC -> O(1)
        int top = 0, down = mat.length - 1;
        
        while(top < down) {
            if(mat[top][down] == 1) {
                top++;
            } else if(mat[down][top] == 1) {
                down--;
            } else {
                top++;
                down--;
            }
        }
        
        if(top > down) return -1;
        
        for(int i = 0; i < mat.length; i++) {
            if(i == top) continue;
            
            if(mat[i][top] == 0 || mat[top][i] == 1) return -1;
        }
        
        return top;
    }

    public int celebrityAlternative(int mat[][]) {  // TC -> O(2n), SC -> O(1)
        int n = mat.length;
        int candidate = 0;
        
        for (int i = 1; i < n; i++) {
            if (mat[candidate][i] == 1) {
                candidate = i;           // Key TakeAway
            }
        }
        
        // Verify candidate
        for (int i = 0; i < n; i++) {
            if (i == candidate) continue;
            
            if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                return -1;
            }
        }
        
        return candidate;
    }

    public static void main(String[] args) {
        int[][] arr = {{0,1,1,1},
                       {0,0,1,0},
                       {0,0,0,0},
                       {0,0,1,0}};

        System.out.println(celebrityOpti(arr));
    }
}
