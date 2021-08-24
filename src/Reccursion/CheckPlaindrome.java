package Reccursion;


import java.util.Arrays;

public class CheckPlaindrome {
    public static void main(String[] args) {
        System.out.println(isPlaindrome("rhar"));
    }

    static int isPlaindrome(String s) {
        return isPlaindrome(s, 0, s.length()-1);
    }

    static int isPlaindrome(String s, int left , int right) {
        if(s.charAt(left) != s.charAt(right)) return 0;

        else if(left < right) return isPlaindrome(s,left+1,right-1);

        return 1;
    }
}
