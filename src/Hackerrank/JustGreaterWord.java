package Hackerrank;

import java.sql.Array;
import java.util.*;


/**
 * Qs.
 *
 * Find a just greater word ( which come after in dictionary) which have all same character as in given word
 * if possible otherwise "no answer"
 */

public class JustGreaterWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.next().charAt(0));
        System.out.println(sc.next().charAt(0));


//        List<Integer>[] c = new ArrayList[10];
//        Arrays.sort(c);
//
//        int[] a = {2,4 , 5, 4, 5};
//
//        Set<Integer> set = new HashSet<>();
//
//
//        System.out.println(biggerIsGreater("dkhc"));
//        System.out.println(biggerIsGreater("fedcbabcd"));
//        System.out.println(biggerIsGreater("abcd"));
//        System.out.println(biggerIsGreater("dcba"));
    }

    public static String biggerIsGreater(String w) {

        char[] c = w.toCharArray();
        boolean found = false;
        for(int i = w.length()-1 ; i>=0 ; i--){
            for(int j = i ; j >= 0 ; j--){
                if(c[j] < c[i]){
                    char temp = c[i];
                    c[i] = c[j];
                    c[j] = temp;

                    char[] middle = String.valueOf(c).substring(j+1,w.length()).toCharArray();
                    Arrays.sort(middle);

                    for(int k = j+1 ; k < w.length() ; k++){
                        c[k] = middle[k-j-1];
                    }
                    found = true;
                    break;
                }
            }
            if(found) break;
        }
        if(found) return String.valueOf(c);
        return "no answer";
    }

   public static String process(String str) {
       char[] chars = str.toCharArray();
       int i = chars.length - 1;
       while (i > 0) {
           if (chars[i - 1] >= chars[i]) {
               i--;
           } else {
               int j = i;
               while (j < chars.length && chars[j] > chars[i - 1]) {
                   j++;
               }
               char temp = chars[i - 1];
               chars[i - 1] = chars[j - 1];
               chars[j - 1] = temp;

               char[] newChar = new char[chars.length];
               for (int k = 0; k < i; k++) {
                   newChar[k] = chars[k];
               }
               int end = chars.length - 1;
               for (int k = i; k < chars.length; k++) {
                   newChar[k] = chars[end--];
               }
               return new String(newChar);
           }
       }
       return "no answer";
   }

}
