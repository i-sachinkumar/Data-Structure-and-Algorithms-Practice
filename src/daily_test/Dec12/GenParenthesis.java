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
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 * TODO "yet to solve";
 ******************* Not solved yet ***************************************************************************************************/

public class GenParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        gen(n, 0, 0, "",ans );
        return ans;
    }

    //

    public static void gen(int n, int i, int j, String s, List<String> ans){
        if(j>i || i>n) return;
        else if(i==n && j==n){
            ans.add(s);
            return;
        }
        else{
            gen(n, i+1, j, s+"(", ans);
            gen(n, i, j+1, s+")", ans);
        }
    }

}
