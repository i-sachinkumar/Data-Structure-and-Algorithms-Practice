package Hackerrank;

/**
 * hackerrank link {@https://www.hackerrank.com/challenges/encryption/problem}
 */

public class Encryption {
    public static void main(String[] args) {
        System.out.println(encryption("have a nice day"));
    }

    public static String encryption(String s) {
        s = s.replaceAll(" ", "");
        int n = s.length();
        int row = (int)Math.sqrt(n);
        int col = (int)Math.ceil(Math.sqrt(n));
        if(row*col < n) row++;

        char[][] c = new char[row][col];

        String ans = "";

        for(int i = 0 ; i < n ; i++){
            c[i/col][i%col] = s.charAt(i);
        }
        for(int i = 0 ; i < col ; i++){
            boolean isAdded = false;
            for (int j = 0 ; j < row ; j++){
                if(c[j][i] != '\u0000'){
                    ans = ans + c[j][i];
                    isAdded = true;
                }
            }
            if(isAdded) ans = ans + " ";
        }

        return ans.trim();
    }
}
