package CodeChefContest.CC2022_07_31;

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class HighFreq
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0 ; i < n ; i++){
                int key = sc.nextInt();
                if(map.containsKey(key)){
                    map.replace(key, map.get(key)+1);
                }
                else map.put(key, 1);
            }

            List<Integer> list = new ArrayList<>(map.values());

            Collections.sort(list);

            int first = list.get(list.size()-1);
            int sec = 0;
            if(list.size()>=2) sec = list.get(list.size()-2);

            if(sec > first/2) System.out.println(sec);
            else if(first%2 ==0) System.out.println(first/2);
            else System.out.println((first/2) + 1);

        }
    }
}
