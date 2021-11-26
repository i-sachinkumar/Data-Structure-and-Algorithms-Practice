package Hackerrank;


// Hackerrank question

/* link: https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
 */

import java.util.*;

public class ClimbTheLeaderBoard {
    public static void main(String[] args) {

        List<Integer> ranked = new ArrayList<>(List.of(100, 100, 50, 40, 40, 20, 10));
        List<Integer> player = new ArrayList<>(List.of(5, 25, 50, 120));

        for(int i : climbingLeaderboard(ranked, player)){
            System.out.println(i);
        }

    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {

        Set<Integer> lb = new HashSet<>();
        Stack<Integer> lbs = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        for(int i : ranked){
            if(lb.add(i)) lbs.push(i);
        }
        int player_rank = lb.size()+1;

        for(int i : player){
            while(!lbs.empty() && i >= lbs.peek()) {
                lbs.pop();
                player_rank--;
            }
            ans.add(player_rank);
        }
        return ans;

    }
}
