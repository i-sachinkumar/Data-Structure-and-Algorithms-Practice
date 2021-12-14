package daily_test.Dec14;

// Qs Link = {https://leetcode.com/problems/string-compression/}

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCompression {
    public static void main(String[] args) {
        char[] c = "aaabbcc".toCharArray();

        // simple method;
        int k = compress(c);
        for(int i = 0; i < k ; i++){
            System.out.print(c[i] +" ");
        }

        System.out.println();

        // regex method
        c = "aaabbcc".toCharArray();
        k = compress2(c);
        for(int i = 0; i < k ; i++){
            System.out.print(c[i] +" ");
        }

    }

    public static int compress(char[] chars) {

        int starting = 0; //starting pointer
        int searching = 0; //searching pointer
        int filling = 0;   //filling pointer
        while (starting < chars.length) {
            char c = chars[starting];
            int count = 0;
            for(; searching < chars.length; searching++){
                if(c == chars[searching]) count++;
                else break;
            }
            chars[filling] = chars[starting];
            filling++;
            if(count > 1){
                char[] cc = String.valueOf(count).toCharArray();
                for (char value : cc) {
                    chars[filling] = value;
                    filling++;
                }
            }
            if(searching >= chars.length) return filling;
            starting = searching;
        }
        return filling;
    }

    public static int compress2(char[] chars){

        Pattern p = Pattern.compile("(.)(\\1*)");
        Matcher m = p.matcher(String.valueOf(chars));

        int i = 0;
        while (m.find()){
            chars[i] = m.group().charAt(0);
            i++;
            int count = m.group().length();
            if(count > 1){
                char[] c = String.valueOf(count).toCharArray();
                for (char value : c) {
                    chars[i] = value;
                    i++;
                }
            }
        }
        return i;
    }
}
