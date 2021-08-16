package Reccursion;

/**
 * 2D(m x n) grid is given we have to find no of possible path
 * to go from top-left corner to bottom-right corner
 * we can only move rightward or downward direction
 */

public class PossiblePath {
    public static void main(String[] args) {
        System.out.println(paths(1,7));

        System.out.println(paths(7,1));

        System.out.println(paths(2,7));

        System.out.println(paths(2,2));

        System.out.println(paths(3,3));

        System.out.println(paths(4,4));
    }

    static int paths(int m , int n){
        if(m==1 || n==1) return 1;
        return paths(m-1,n) + paths(m,n-1);
    }
}
