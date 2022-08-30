package CodeChefContest.CC2022_08_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        boolean[] bools = new boolean[n];
        List<List<Integer>> sub = new ArrayList<>();

        for(int i = 0, j = 0 ; i < q ; i++){
            int type = sc.nextInt();

            if(type ==0){
                sub.add(new ArrayList<>());
                sub.get(j).add(sc.nextInt(), sc.nextInt());
                j++;
            }
            else if(type == 1){
                int p = sc.nextInt();
                if(bools[p-1]) System.out.println(0);
                else{
                    bools[p-1] = true;

                }
            }
        }

    }
}