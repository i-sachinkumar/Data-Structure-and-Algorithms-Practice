package DynamicProgramming.Tabulation;


public class CanConstruct {
    public static void main(String[] args) {

        System.out.println(canConstruct("abcdef", new String[]{"ab", "cd", "abc", "ef", "def"}));
    }

    public static boolean canConstruct(String target, String[] wordBank){
        boolean[] dp  = new boolean[target.length()+1];
        dp[0] = true;

        for(int i = 0 ; i < dp.length; i++){
            if(dp[i]){
                for(String word: wordBank){
                    if(i+word.length() < dp.length && target.charAt(i) == word.charAt(0)){
                        dp[i+word.length()] = true;
                    }
                }
            }
        }

        return dp[target.length()];
    }
}
