package CodeChefContest.Dec30_2021;

// Qs Link = {https://www.codechef.com/CDRV21C/problems/CHEFFAV}

import java.util.Scanner;

public class FavouriteString {

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter no. of testcase");
        int t = sc.nextInt();

        while(t-- > 0){
            System.out.println("size of string");
            int n = sc.nextInt();

            System.out.println("enter string");
            sc.nextLine();
            String s = sc.next();

            if(isFavourite(s)) System.out.println("AC");
            else System.out.println("WA");
        }
    }

    public static boolean isFavourite(String s){
        if(!s.contains("code") || !s.contains("chef")) return false;
        while (!s.isEmpty()){
            int code_index = s.indexOf("code");
            int chef_index = s.indexOf("chef");
            if(code_index < 0 && chef_index >= 0) return false;
            if(code_index >= 0 && chef_index >= 0 && chef_index < code_index) return false;
            if(!s.contains("code") || !s.contains("chef")) break;
            s = s.substring(Math.max(chef_index, code_index)+1);
        }

        return true;
    }

}
