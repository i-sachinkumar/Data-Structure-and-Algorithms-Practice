package Test;

import java.io.*;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        String X = br.readLine().trim();
        String Y = br.readLine().trim();

        pw.println(numString(X, Y));
        br.close();
        pw.close();
    }

    public static int numString(String X, String Y){
        HashSet<String> substring1 = palindromicSubstring(X);
        HashSet<String> substring2 = palindromicSubstring(Y);

        HashSet<String> concatString = new HashSet<>();
        for(String s1 : substring1){
            for(String s2: substring2){
                concatString.add(s1 + s2);
            }
        }
        return concatString.size();
    }

    public static HashSet<String> palindromicSubstring(String s){
        int n = s.length();

        boolean[][] dp = new boolean[n][n];
        char[] chars = s.toCharArray();

        //one and two chars
        for(int i = 0; i < n ; i++){
            dp[i][i] = true;
            if(i < n-1 && chars[i] == chars[i+1]) dp[i][i+1] = true;
        }

        //remaining
        for(int diag = 2; diag < n ; diag++){
            for(int i = 0, j = diag; j < n; i++,j++){
                if(chars[i] == chars[j] && dp[i+1][j-1]) dp[i][j] = true;
            }
        }


        HashSet<String> palindromes = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = i; j < n ; j++){
                sb.append(chars[j]);
                if(dp[i][j]) palindromes.add(sb.toString());
            }
        }
        return palindromes;
    }
}
