package daily_test.Dec12;

import java.util.ArrayList;
import java.util.List;

/*************** Question ******************************************************************************************************
 *
 * link = {https://leetcode.com/problems/generate-parentheses/}
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 *
 *
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 * TODO "yet to solve";
 ******************* Not solved yet ***************************************************************************************************/

public class GenParenthesis {
    public static void main(String[] args) {

    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        StringBuilder s = new StringBuilder();

        s.append("(".repeat(Math.max(0, n)));
        s.append(")".repeat(Math.max(0, n)));

        ans.add(s.toString());

        for(int i = 1 ; i < n ; i++){
            for(int j = n; j < 2*n-1 ; j++){
                ans.add(exchangeChar(s.toString(),i,j));
            }
        }
        return ans;
    }

    static String exchangeChar(String s, int i, int j){
        char[] c = s.toCharArray();
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        return String.valueOf(c);
    }
}
