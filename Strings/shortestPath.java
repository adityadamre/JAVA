package Strings;

public class shortestPath {
    public static float destination(String str) {
        int x = 0, y = 0;
        for(int i = 0; i < str.length(); i++) {
            char dir = str.charAt(i);
            if(dir == 'N') {
                y++;
            } else if(dir == 'E') {
                x++;
            } else if(dir == 'S') {
                y--;
            } else {
                x--;
            }
        }
        return (float) Math.sqrt(x * x + y * y);
    }

    public static void main(String[] args) {
        String str = "WNEENESENNN";
        System.out.println(destination(str));
    }
}
