package CodeChefContest.Dec30_2021;

// Qs Link = {https://www.codechef.com/CDRV21C/problems/EVOFWEIRDSUM}

import java.util.Scanner;

public class SumThisUp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("num of testcases");
        int t = sc.nextInt();

        while(t-- > 0){
            System.out.println("num of element");
            int n = sc.nextInt();


            int[] a = new int[n+2];

            System.out.println("space separated elements");
            for(int i = 1 ;i < n+1 ; i++){
                a[i] = sc.nextInt();
            }

            System.out.println(sum(a,n));
        }

    }

    public static int sum(int[] a, int n){
        int result = 0;
        for(int i = 1 ; i < n+1 ; i++){
            result += (a[i-1] + a[i+1] - 2*a[i]);
        }

        return Math.abs(result/2);
    }
}
