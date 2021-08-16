package Reccursion;

public class PermuteString {
    public static void main(String[] args) {
        permute("abc", 0, 2);
    }

    static void permute(String s, int l , int r){
        if(l ==r) System.out.println(s);
        for(int i = l ; i<= r ; i++){
            s = exchangeChar(s, l , i);
            permute(s, l+1, r);
            s = exchangeChar(s, l, i);
        }
    }

    static String exchangeChar(String s, int i, int j){
        char[] c = s.toCharArray();
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        return String.valueOf(c);
    }
}
