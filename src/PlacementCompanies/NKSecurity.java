package PlacementCompanies;


import java.util.List;

public class NKSecurity {
    public static void main(String[] args) {
        solve(List.of("1AU", "3SK", "2LB"));


//        System.out.println(passwordReset(11, "aaabbbzzzcccddd"));
//        dominoColor(new String[]{"acc", "abb"});
    }


    public static void dominoColor(String[] domino){
        int N = domino[0].length();
        char[] S1 = domino[0].toCharArray();
        char[] S2 = domino[1].toCharArray();

        long ans = 0;
        boolean isVertical = false;
        int start = 0;
        if (S1[0] == S2[0]) {
            ans = 3;
            isVertical = true;
            start = 1;
        } else if (N > 1) {
            ans = 3*2;
            start = 2;
        }

        for (int i = start; i < N; i++) {
            if (S1[i] == S2[i]) {
                if (isVertical) {
                    ans*=2;
                }
                isVertical = true;
            } else {
                if (isVertical) {
                    ans*=2;
                } else {
                    ans*=3;
                }
                isVertical=false;
                i++;
            }
        }

        System.out.println(ans%1000000007);

    }
    static int mod = 100000007;
    public static long solve(int n, char[] str1, char[] str2){
        long[] dp = new long[n];
        if(str1[0]==str2[0]){
            dp[0] = (long)3;
            int i=1;
            while(i<n){
                if(str1[i]==str2[i]){
                    if(str1[i-1]==str2[i-1]){
                        dp[i] = (dp[i-1]*(long)2)%mod;
                    }
                    else{
                        dp[i] = dp[i-1];
                    }
                    i++;
                }
                else{
                    if(str1[i-1]==str2[i-1]){
                        dp[i] = (dp[i-1]*(long)2)%mod;
                    }
                    else{
                        dp[i] = (dp[i-1]*(long)3)%mod;
                    }
                    dp[i+1] = dp[i];
                    i+=2;
                }
            }
        }
        else{
            dp[1]=(long)6;
            int i=2;
            while(i<n){
                if(str1[i]==str2[i]){
                    if(str1[i-1]==str2[i-1]){
                        dp[i] = (dp[i-1]*(long)2)%mod;
                    }
                    else{
                        dp[i] = dp[i-1];
                    }
                    i++;
                }
                else{
                    if(str1[i-1]==str2[i-1]){
                        dp[i] = (dp[i-1]*(long)2)%mod;
                    }
                    else{
                        dp[i] = (dp[i-1]*(long)3)%mod;
                    }
                    dp[i+1] = dp[i];
                    i+=2;
                }
            }
        }
        return dp[n-1];
    }

    public static String passwordReset(int n, String s){
        char[] chars = s.toCharArray();
        int[] freq = new int[26];
        for(char c : chars){
            freq[c - 'a']++;
        }
        //System.out.println(Arrays.toString(freq));
        for(int i = 0; i < 26; i++){
            if(freq[i]%2 == 0) continue;
            for(int j = 25; j > i; j--){
                if(freq[j]%2 != 0){
                    freq[j]--;
                    freq[i]++;
                    break;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        String odd = "";
        for(char c = 'a'; c <= 'z'; c++){
            if (freq[c-'a'] % 2 != 0) {
                odd += c;
            }
            freq[c-'a'] /= 2;
            while (freq[c-'a']-- > 0){
                ans.append(c);
            }
        }
        String half = ans.toString();
        //System.out.println(Arrays.toString(freq));
        return half + odd + ans.reverse();
    }


    public static void solve(List<String> pass){
        if(pass.isEmpty()) return;
        for(int i = 1 ; i < pass.get(0).length(); i++){
            char[] ans = new char[pass.size()];
            for(int j = 0  ; j < pass.size(); j++){
                ans[pass.get(j).charAt(0) - '1'] = pass.get(j).charAt(i);
            }
            System.out.println(String.valueOf(ans));
        }
    }
}