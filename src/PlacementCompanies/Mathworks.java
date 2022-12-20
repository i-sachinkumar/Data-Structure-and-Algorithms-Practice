package PlacementCompanies;

import java.util.*;

public class Mathworks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] words = new String[n];
        for(int i = 0; i < n ; i++){
            words[i] = sc.nextLine();
        }
        System.out.println(longestStrChain(words));
    }

    public static int longestStrChain(String[] words) {
        ArrayList<Set<String>> W = new ArrayList<>(61);
        for (int i = 0; i < 61; i++)
            W.add(new HashSet<>());
        for (String word : words)
            W.get(word.length()).add(word);
        Map<String, Integer> dp = new HashMap<>();
        int best = 1;
        for (int i = 60; i > 0; i--) {
            if (W.get(i-1).isEmpty()) continue;
            for (String word : W.get(i)) {
                int chainVal = dp.getOrDefault(word, 1);
                for (int j = 0; j < word.length(); j++) {
                    String pred = word.substring(0,j) + word.substring(j+1);
                    if (W.get(i-1).contains(pred) && chainVal >= dp.getOrDefault(pred,1)) {
                        dp.put(pred, chainVal + 1);
                        best = Math.max(best, chainVal + 1);
                    }
                }
            }
        }
        return best;
    }
}
