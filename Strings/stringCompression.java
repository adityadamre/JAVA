package Strings;

public class stringCompression {
    public static String compression(String str) {
        StringBuilder sb = new StringBuilder("");

        for(int i = 0; i < str.length(); i++) {
            Integer freq = 1;
            while(i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                freq++;
                i++;
            }
            sb.append(str.charAt(i));
            if(freq > 1) {
                sb.append(freq.toString());
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = new String("aaaannnsssssbvv");
        System.out.println(compression(str));
    }
}





// My Logic

// Integer freq = 0;
// for(int i = 0; i < str.length(); i++) {
//     if(i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
//         freq++;
//     } else {
//         freq++;
//         sb.append(str.charAt(i));
//         if(freq > 1) {
//             sb.append(freq.toString());
//         }
//         freq = 0;
//     }
// }