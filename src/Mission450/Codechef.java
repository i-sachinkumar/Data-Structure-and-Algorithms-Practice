package Mission450;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class Codechef {

    public static void main(String[] args) {

    }


    //Polo the Penguin and the Test
    // Qs: https://www.codechef.com/submit/PPTEST?
    public static void test() throws java.lang.Exception{
        //     1 t
        //     3 7 n w
        //     1 2 3
        //     2 3 5
        //     3 3 3
        // your code goes here
        // N Questions 1, 2, 3,...
        //tests: 1.1.1, 1.1.2.... c[i]
        //points: 1.2.1, 1.2.2.... p[i]
        //time ..........t[i]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int w = Integer.parseInt(line[1]);
            int[][] problems = new int[n][3];
            //  int[] points = new int[n];
            //  int[] time = new int[n];
            for(int i = 0 ; i < n ; i++){
                String[] linei = br.readLine().split(" ");
                problems[i][0] = Integer.parseInt(linei[0]);
                problems[i][1] = Integer.parseInt(linei[1]);
                problems[i][2] = Integer.parseInt(linei[2]);
            }

            //  Arrays.sort(problems, new Comparator<int[]>(){
            //      @Override
            //      public int compare(int[] o1, int[] o2){
            //          return -(o1[0]*o1[1]*o2[2]) + (o2[0]*o2[1]*o1[2]);
            //      }

            //  });
            int[][] dp = new int[n+1][w+1];
            for(int[] in : dp){
                Arrays.fill(in, -1);
            }
            pw.println(solve(n, problems, 0, w, dp));

        }
        br.close();
        pw.close();
    }
    static int solve(int n, int[][] problems, int i, int w, int[][] dp){
        if(i >= n) return 0;
        if(dp[i][w] != -1) return dp[i][w];

        int pick = 0;
        //TODO -> always remember why
        if(w >= problems[i][2]) pick = problems[i][0]*problems[i][1] + solve(n, problems, i+1, w - problems[i][2], dp);
        int notPick = solve(n, problems, i+1, w, dp);

        return dp[i][w] = Math.max(pick, notPick);
    }


    //Qs: https://www.codechef.com/submit/PIANO1
    public static void piano(String[] args) throws java.lang.Exception {
        //     2    -> t
        //     TTTT -> pattern
        //     1    -> num of octaves
        //     TTSTTTS
        //     3
        //     T : +2
        //     S : +1
        // your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            String pattern = br.readLine();
            int n = 12 * Integer.parseInt(br.readLine());
            int len = 0;
            for(char c : pattern.toCharArray()){
                if(c == 'T') len += 2;
                else len++;
            }
            int i = 1;
            int ans = 0;
            while(n - (i*len) > 0){
                ans += (n-(i*len));
                i++;
            }
            pw.println(ans);
        }
        br.close();
        pw.close();
    }


    public static void bulbInvention() throws java.lang.Exception{
        // your code goes here
        // 4 -> t
        // 10 5 5 -> n ,p , k
        //n = num of bulb, p : correct bulb, k: algo
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int p = Integer.parseInt(line[1]);
            int k = Integer.parseInt(line[2]);

            int day = 1;
            int ans = -1;
            for(int i = 0 ; i <= Math.min(n-1, k) ; i++){
                // if(i != (p%k)){
                //     day += ((n-i-1)/2  + 1);
                //     continue;
                // }
                for(int ind = i; ind < n ; ind += k){
                    if(ind == p) {
                        ans = day;
                        break;
                    }
                    day++;
                }
                if(ans != -1) break;
            }
            pw.println(ans);
        }
        br.close();
        pw.close();
    }


    // Qs: https://www.codechef.com/submit/INVYCNT
    public static void inversionRevisited(){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0 ; i < n ; i++) a[i] = sc.nextInt();
            int[] right_min = new int[n];
            int[] total_min = new int[n];
            for(int i = 0 ; i < n ;i++){
                for(int j = 0 ; j < n ; j++){
                    if(a[i] > a[j]){
                        total_min[i]++;
                        if(i < j) right_min[i]++;
                    }
                }
            }
            long ans = 0;
            for(int i = 0 ; i < n ; i++){
                ans += ((long) k *right_min[i] + total_min[i]*((long) k *(k-1))/2);
            }
            System.out.println(ans);
        }
    }


    //Qs: https://www.codechef.com/submit/CPLAY
    public static void penaltyShoots(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            char[] shoots = sc.nextLine().trim().toCharArray();
            int p1_score = 0;
            int p2_score = 0;
            for(int i = 0; i < 10; i++){
                if(i%2 == 0){
                    if(shoots[i] == '1'){
                        p1_score++;
                    }
                }
                else{
                    if(shoots[i] == '1'){
                        p2_score++;
                    }
                }
                int left = 9 - i;
                int left1 = left/2;
                int left2 = left - left1;
                if(p1_score < p2_score && p1_score + left1 < p2_score){
                    System.out.println("TEAM-B " + (i+1));
                    break;
                }
                if(p2_score < p1_score && p2_score + left2 < p1_score){
                    System.out.println("TEAM-A " + (i+1));
                    break;
                }
            }
            if(p1_score != p2_score) continue;
            for(int i = 5; i < 10 ; i++){
                if(shoots[2*i] == '1') p1_score++;
                if(shoots[2*i + 1] == '1') p2_score++;
                if(p1_score > p2_score){
                    System.out.println("TEAM-A " + 2*(i+1));
                    break;
                }
                else if(p2_score > p1_score){
                    System.out.println("TEAM-B " + 2*(i+1));
                    break;
                }
            }
            if(p1_score == p2_score) System.out.println("TIE");
        }
    }
}
