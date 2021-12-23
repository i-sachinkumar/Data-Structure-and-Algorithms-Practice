package Hackerrank;

import java.util.ArrayList;
import java.util.List;

public class PatternInGrid {
    public static void main(String[] args) {
        //List<String> G = new ArrayList<>(List.of("1234567890", "0987654321","1111111111","1111111111","2222222222"));
        List<String> P = new ArrayList<>(List.of("876543", "111111", "111111"));
        List<String> G = new ArrayList<>(List.of("876543", "111111", "111111"));

        //System.out.println(gridSearch(G,P));
        System.out.println(gridSearch(G, P));
    }

//    public static String gridSearch(List<String> G, List<String> P) {
//        List<Integer> ind = new ArrayList<>();
//
//        for(int i =0 ; i < G.size() ; i++){
//            if(G.get(i).contains(P.get(0))) ind.add(i);
//        }
//
//        if(ind.isEmpty()) return "NO";
//        String ans = "YES";
//        for(int i = 0 ; i < ind.size(); i++){
//            int curr_ind = ind.get(i);
//            for(int j = curr_ind+1; j < P.size() + curr_ind ; j++){
//                if(!G.contains(P.get(j - curr_ind))){
//                    ans = "NO";
//                    break;
//                }
//            }
//            if(ans.equals("YES")) return ans;
//        }
//        return "NO";
//    }


    // TODO "yet to solve"

    public static String gridSearch(List<String> G, List<String> P) {

        if(G.size() < P.size()) return "NO";

        for(int i = 0 ; i < G.size(); i++){
            for(int j = 0 ; j < P.size(); j++){
                if(G.get(i).charAt(j) == P.get(0).charAt(0)){
                    if(matchGrid(G, P, i, j, i+ P.size(), j + P.get(0).length())) return "YES";
                }
            }
        }
        return "NO";
    }

    public static boolean matchGrid(List<String> G, List<String> P, int i, int j , int m, int n){
        int p_r = 0;
        int g_r = i;

        while(g_r < m){
            int g_c = j;
            int p_c = 0;
            while(g_c < n){
                if(G.get(g_r).charAt(g_c) != P.get(p_r).charAt(p_c)) return false;
                g_c++;
                p_c++;
            }
            g_r++;
            p_r++;
        }
        return true;
    }


}
