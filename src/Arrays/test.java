package Arrays;

import java.util.*;

public class test {
    public static void main(String[] args) {
//        String s = "raceacr";
//
//        Map<Character, Integer> m = new HashMap<>();
//        for(int i = 0 ; i < s.length(); i++){
//            if(m.containsKey(s.charAt(i))) m.remove(s.charAt(i));
//            else m.put(s.charAt(i), 1);
//        }

        int[] a = new int[20];
        int n = 765;

        int i = a.length - 1;
        while (n > 0){
            a[i] = n%10;
            n = n/10;
            i--;
        }

        for(int in : a){
            System.out.print(in +  " ");
        }

        int j = a.length-1;
        for( ; j > 0 ; j--){
            if(a[j] <= a[j-1]);
            else {
                int temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
                break;
            }

        }
        if(j<a.length-1)Arrays.sort(a,j+1,a.length-1);

        System.out.println();
        for(int in : a){
            System.out.print(in +  " ");
        }
        int ans = 0;
        int mult = 1;

        j = a.length-1;
        for(; j>=0 ; j--){
            ans = ans + a[j]*mult;
            mult *= 10;
        }

        System.out.println(ans);
    }
}
