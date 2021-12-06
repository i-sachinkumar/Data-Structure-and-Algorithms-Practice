package Hackerrank;

public class RepeatedString {
    public static void main(String[] args) {

        System.out.println(repeatedString("aba", 10));
    }


    public static long repeatedString(String s, long n) {
        int length = s.length();
        long ans = 0;

        if(length > n){
            for (int i = 0 ; i < n ; i++){
                if(s.charAt(i) == 'a') ans++;
            }
            return ans;
        }

        for(int i = 0 ; i < length ; i++){
            if(s.charAt(i) == 'a') ans++;
        }
        ans = ans*(n/length);

        for(int i = 0; i < (n%length); i++){
            if (s.charAt(i) == 'a') ans++;
        }

        return ans;
    }
}
