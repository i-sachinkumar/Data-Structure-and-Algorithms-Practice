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
 ******************* solved ***************************************************************************************************/

public class GenParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(10));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        genPar(n, 0, 0, "",ans );
        return ans;
    }

    //


    public static void genPar(int n, int i, int j, String s, List<String> ans){
        if(i < j) return; //return where num of closing bracket is more, because no way we can balance it [Ex. ), ()), (()()))]
        if(i > n) return; //can't be balanced

        if(i == j && i == n) {
            ans.add(s); //got what u wanted
        }

        genPar(n, i+1, j, s+"(", ans); //first add open bracket
        genPar(n, i, j+1, s+")", ans); //then close it

    }





















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
