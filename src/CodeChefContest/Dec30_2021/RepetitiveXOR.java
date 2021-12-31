package CodeChefContest.Dec30_2021;

import java.util.Scanner;

// Qs Link = {https://www.codechef.com/CDRV21C/problems/KLXOR}

public class RepetitiveXOR {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("number of testcases");
        int t = sc.nextInt();

        while(t-- > 0){
            System.out.println("number of bits");
            int n = sc.nextInt();
            System.out.println("length of substring");
            int k = sc.nextInt();

            sc.nextLine();
            System.out.println("bits string");
            String s = sc.nextLine();

            String xored = s.substring(0, k);

            for(int i = 1 ; i+k <= n ; i++ ){
                xored = xor(xored, s.substring(i, i+k));
            }

            System.out.println(count(xored));

            sc.close();
        }
    }

    public static String xor(String s1, String s2){
        String result = "";
        for(int i = 0 ; i < s1.length(); i++){
            if(s1.charAt(i) == s2.charAt(i)) result = result + "0";
            else result = result + "1";
        }
        return result;
    }

    public static int count(String s){
        int count = 0;
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == '1') count++;
        }

        return count;
    }
}
