package Hackerrank;

// press ctrl + left_click  on link below
// Qs. Link:   {https://www.hackerrank.com/challenges/java-1d-array/problem}

import java.math.BigInteger;

public class ArrayGame {
    public static void main(String[] args) {
        int leap = 5;
        int[] game = {0, 0, 0, 1, 1, 1};
        //            '--'--------------->winner
        //             +1         +leap

        System.out.println(canWin(leap, 0, game));

    }

    static boolean canWin(int leap, int i, int[] game){
        if(i >= game.length) return true;
        if(i < 0 || game[i] == 1) return false;
        game[i] = 1;
        return canWin(leap, i+1, game) || canWin(leap, i-1, game) || canWin(leap, i+leap, game);
    }

}
