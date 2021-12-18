package daily_test.Dec17;

// Qs Link = {https://leetcode.com/problems/letter-combinations-of-a-phone-number/}

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    public static void main(String[] args) {
        List<String> ans = letterCombinations("79");

        for(String s : ans){
            System.out.println(s);
        }
    }


    // 100 % faster
    public static List<String> letterCombinations(String digits) {
        char[] for2 = {'a', 'b', 'c'};
        char[] for3 = {'d', 'e', 'f'};
        char[] for4 = {'g', 'h', 'i'};
        char[] for5 = {'j', 'k', 'l'};
        char[] for6 = {'m', 'n', 'o'};
        char[] for7 = {'p', 'q', 'r', 's'};
        char[] for8 = {'t', 'u', 'v'};
        char[] for9 = {'w', 'x', 'y', 'z'};

        char[][] c = {null,null,for2,for3, for4, for5, for6,for7,for8,for9};

        List<String> ans = new ArrayList<>();

        int n = digits.length();
        String[] s = new String[n];

        for(int i = 0; i < n ; i++){
            s[i] = String.valueOf(c[digits.charAt(i) - '0']);
        }

        combine(s,0, 0, new char[n],ans);

        return ans;
    }

    static void combine(String[] s, int i, int j, char[] p, List<String> list){
        if(i == s.length) {
            list.add(String.valueOf(p));
            return;
        }
        if(j == s[i].length()) {
            return;
        }

        p[i] = s[i].charAt(j);

        combine(s,i+1, 0, p, list);
        combine(s, i, j+1, p,list);
    }
}
