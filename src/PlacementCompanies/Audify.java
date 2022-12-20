package PlacementCompanies;

import java.util.*;
import java.util.Arrays;


public class Audify {

    public static void main(String[] args) {











        int a = 4;
        int b = 6;
        int c = 6;
        System.out.println(a*b/a);
        System.out.println(2*4/6);
//        System.out.println(getSpecialSubstring("giraffe", "01111001111111111011111111", 2));
//        String s1 = "abaaa", s2 = "abaaababbacbaba";
//        for(int i = 0 ; i < 1000; i++){
//            s1 = s1 + "abaaa";
//        }
//        System.out.println("done");
//        System.out.println(magicString(s1,s2));
    }



    public static int magicString(String X, String Y){
        HashSet<String> set = new HashSet<>();
        HashSet<String> sub1 = palindromic(X);
        HashSet<String> sub2 = palindromic(Y);
        for(String s1: sub1){
            for(String s2: sub2){
                set.add(s1 + s2);
            }
        }
        return set.size();
    }
    public static HashSet<String> palindromic(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        char[] chars = s.toCharArray();

        for(int i = 0; i < n ; i++){
            dp[i][i] = true;
            if(i < n-1 && chars[i] == chars[i+1]) dp[i][i+1] = true;
        }

        for(int diag = 2; diag < n; diag++){
            for(int i = 0, j = diag; j < n ; i++,j++){
                if(chars[i] == chars[j] && dp[i+1][j-1]) dp[i][j] = true;
            }
        }

        HashSet<String> ans = new HashSet<>();

        for(int i = 0 ; i < n ; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = i; j < n; j++){
                sb.append(chars[j]);
                if(dp[i][j]) ans.add(sb.toString());
            }
        }
        return ans;
    }





    /**
     * Seema has got two strings X and Y.
     * Since she likes palindromes,
     * she would like to pick x as some non-empty palindromic substring of X
     * and y as some non-empty palindromic substring of Y.
     * Concatenating them, she would have string xy.
     * Seema feels getting strings this way is interesting,
     * so she wants to evaluate how many unique numbers of strings she can get.
     *
     * Input
     * 1 line has a single string X (1 ≤ |X| ≤ 2*10^5).
     * 2nd line has a single string Y (1 ≤ |Y| ≤ 2*10^5).
     * Strings X and Y contain lowercase English letters only (no capital letters).
     *
     * Output
     * The first and only line should contain a single integer - the number of possible strings.
     *
     * Example 1
     * input
     * X = xx
     * Y = xyx
     * Output
     * 6
     * Explanation Strings-xx, xy, xxyx, xxx, xxy, xxxyx
     *
     * Example 2
     * input
     * xxyx
     * xyxx
     * output 15
     *
     * Note: Do not repeat strings, as xx+x = xxx and also x+xx = xxx, but xxx will be counted only once.*/
    public static int solve(String X, String Y){
        HashSet<String> set = new HashSet<>();
        HashSet<String> xs = palindromicSubstring(X);
        HashSet<String> ys = palindromicSubstring(Y);

        for(String s1 : xs){
            for(String s2 : ys){
                set.add(s1+s2);
            }
        }
        return set.size();
    }
    public static HashSet<String> palindromicSubstring(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        char[] chars = s.toCharArray();
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
            if(i+1 < n && chars[i] == chars[i+1]) dp[i][i+1] = true;
        }

        for(int diag = 2 ; diag < n ; diag++){
            for(int i = 0, j = diag ; j < n ; j++,i++){
                if(chars[i] == chars[j] && dp[i+1][j-1]) dp[i][j] = true;
            }
        }

//        for(boolean[] d : dp){
//            System.out.println(Arrays.toString(d));
//        }
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                sb.append(chars[j]);
                if(dp[i][j]){
                    set.add(sb.toString());
//                    System.out.println(sb);
                }
            }
            sb = new StringBuilder();
        }
        return set;
    }

    public static int solve(String s)
    {
        int n = s.length();

        // dp array to store whether a substring is
        // palindrome or not using dynamic programming we
        // can solve this in O(N^2) dp[i][j] will be true
        // (1) if substring (i, j) is palindrome else false
        // (0)
//        boolean[][] dp = new boolean[n][n];
//        for (int i = 0; i < n; i++){
//
//            // base case every char is palindrome
//            dp[i][i] = true;
//
//            // check for every substring of length 2
//            if (i < n - 1
//                    && s.charAt(i) == s.charAt(i + 1)) {
//                dp[i][i + 1] = true;
//            }
//        }
//        // check every substring of length greater than 2
//        // for palindrome
//        for (int len = 3; len <= n; len++) {
//            for (int i = 0; i + len <= n; i++) {
//                if (s.charAt(i) == s.charAt(i + (len - 1))
//                        && dp[i + 1][i + (len - 1) - 1]) {
//                    dp[i][i + (len - 1)] = true;
//                }
//            }
//        }

        boolean[][] dp = new boolean[n][n];
        char[] chars = s.toCharArray();
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
            if(i+1 < n && chars[i] == chars[i+1]) dp[i][i+1] = true;
        }

        for(int diag = 2 ; diag < n ; diag++){
            for(int i = 0, j = diag ; j < n ; j++,i++){
                if(chars[i] == chars[j] && dp[i+1][j-1]) dp[i][j] = true;
            }
        }

        for(boolean[] d : dp){
            System.out.println(Arrays.toString(d));
        }

        //*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
        // here we will apply kmp algorithm for substrings
        // starting from i = 0 to n-1 when we will find
        // prefix and suffix of a substring to be equal and
        // it is palindrome we will make dp[i][j] for that
        // suffix to be false which means it is already
        // added in the prefix and we should not count it
        // anymore.
        int[] kmp = new int[n];
        for (int i = 0; i < n; i++) {
            // starting kmp for every i form 0 to n-1
            int j = 0, k = 1;
            while (k + i < n) {
                if (s.charAt(j + i) == s.charAt(k + i))
                {
                    // make suffix to be false
                    // if this suffix is palindrome then it
                    // is already included in prefix
                    dp[k + i - j][k + i] = false;
                    kmp[k++] = ++j;
                }
                else if (j > 0) {
                    j = kmp[j - 1];
                }
                else {
                    kmp[k++] = 0;
                }
            }
        }
        //*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
        int count = 0;
        for (int i = 0; i < n; i++) {
            String str = "";
            for (int j = i; j < n; j++) {
                str += s.charAt(j);
                if (dp[i][j]){
                    // count number of resultant distinct
                    // substrings and print  that substring
                    count++;
                    System.out.println(str);
                }
            }
        }
        System.out.println(
                "Total number of distinct palindromes is "
                        + count);
        return 0;
    }


//
//    public static int[] solve(int n, int m, int[] arr1, int[] arr2){
//        int[] ans = new int[m];
//        Arrays.sort(arr1);
//
//        // for each element of 2nd array
//        for (int i = 0; i < m; i++) {
//            int index = binary_search(
//                    arr2, 0, n - 1, arr1[i]);
//            ans[i] = index+1;
//        }
//        return ans;
//    }
//    static int binary_search(int[] arr, int l, int h, int x){
//        while (l <= h) {
//            int mid = (l + h) / 2;
//            // if 'x' is greater than or equal
//            // to arr[mid], then search in
//            // arr[mid+1...h]
//            if (arr[mid] <= x) l = mid + 1;
//
//            // else search in arr[l...mid-1]
//            else h = mid - 1;
//        }
//
//        // Required index
//        return h;
//    }


    public static int[] solve(int[] arr1, int[] arr2){
        int m = arr1.length;
        int n = arr2.length;
        int[] ans = new int[n];
        Arrays.sort(arr1);

        for (int i = 0; i < n; i++) {
            int index = binary_search(arr1, 0, n - 1, arr2[i]);
            ans[i] = index+1;
        }
        return ans;
    }
    static int binary_search(int[] arr, int l, int h, int x){
        while (l <= h) {
            int mid = (l + h) / 2;
            if (arr[mid] <= x) l = mid + 1;
            else h = mid - 1;
        }
        return h;
    }



    public static int getSpecialSubstring(String str, String bitString, int k) {
        int len = str.length();
        if (len == 0) return 0;

        char[] charStr = str.toCharArray();
        char[] charBitString = bitString.toCharArray();

        int maxSubstringLen = 0;
        int windowStart = 0;
        int cnt = 0;
        for (int windowEnd = 0; windowEnd < len; windowEnd++)
        {
            int pos = charStr[windowEnd] - 'a';
            if (charBitString[pos] == '0') cnt++;
            while (cnt > k && windowStart <= windowEnd)
            {
                pos = charStr[windowStart] - 'a';
                if (charBitString[pos] == '0')
                    cnt--;
                windowStart++;
            }
            maxSubstringLen = Math.max(maxSubstringLen, windowEnd - windowStart + 1);
        }
        return maxSubstringLen;
    }
}
