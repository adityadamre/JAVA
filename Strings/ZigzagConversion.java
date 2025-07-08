package Strings;

public class ZigzagConversion {

    public static String convert(String s, int numRows) {
        if(numRows == 1 || s.length() < numRows) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) rows[i] = new StringBuilder();

        int currRow = 0;
        boolean goingDown = false;  // CATCH :- It gets true in first iteration itself,
                                    //          goingDown toggles on appending first char (currRow == 0)-> becomes true!

        for(char c : s.toCharArray()) {
            rows[currRow].append(c);

            if(currRow == 0 || currRow == numRows - 1) goingDown = !goingDown;

            currRow += goingDown ? 1 : -1;
        }
        
        StringBuilder result = new StringBuilder();
        for(StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String str = new String("PAYPALISHIRING");
        int rows = 4;

        System.out.println(convert(str, rows));
    }
}
