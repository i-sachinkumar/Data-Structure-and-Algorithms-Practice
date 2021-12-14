package daily_test.Dec12;

/*************** Question *******************************************************************************************************
 *
 * link = {https://leetcode.com/problems/regular-expression-matching/}
 *
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 *
 * Example 2:
 *
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 *
 *
 * Example 3:
 *
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 *
 * Example 4:
 *
 * Input: s = "aab", p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 *
 * TODO "Optimize further"
 ***********************************************************************************************************************************/
public class MatchingExpression {
    public static void main(String[] args) {
        System.out.println(isMatch("aa","a"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("aa","a*"));
    }

    public static boolean isMatch(String s, String p) {
        java.util.regex.Pattern ptrn = java.util.regex.Pattern.compile(p);

        java.util.regex.Matcher m = ptrn.matcher(s);

        return m.matches();
    }



//    public static boolean isMatch2(String s, String p) {
//        int s_p = 0;
//        int p_p = 0;
//        while(p_p < p.length()){
//            if(p.charAt(p_p) == '.'){
//                if(p_p+1 < p.length() && p.charAt(p_p+1) == '*'){
//                    if(p_p + 2 >= p.length()) s_p = s.length();
//                    else{
//                        while(s.charAt(s_p) != p.charAt(p_p+2) && s_p < s.length()){
//                            s_p++;
//                        }
//                    }
//                }
//                else{
//                    s_p++;
//                    p_p++;
//                }
//            }
//
//            p_p++;
//        }
//    }
}
