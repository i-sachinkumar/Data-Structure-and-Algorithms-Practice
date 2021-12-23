package Hackerrank;

// Qs Link = {https://www.hackerrank.com/challenges/bomber-man/problem}

import java.util.ArrayList;
import java.util.List;

public class BomberMan {
    public static void main(String[] args) {
        List<String> grid = new ArrayList<>();
        grid.add(".......");
        grid.add("...O...");
        grid.add("....O..");
        grid.add(".......");
        grid.add("OO.....");
        grid.add("OO.....");

        grid = bomberMan(3,grid);
        for( String s : grid){
            System.out.println(s);
        }
    }

    public static List<String> bomberMan(int n, List<String> grid) {
        // in 1st and 2nd sec nothing is happened so return as it is
        if (n == 0 || n == 1) return grid;

        // in sec 4, 6, 8,...... => grid will be completely filled with bomb as mentioned in Qs
        if (n%2 == 0) return fillAll(grid);

        // making a copy so that i can find where was previous bomb once it is filled completely
        List<String> grid_copy = List.copyOf(grid);

        // if n = 3, 7, 11,.....
        // we found that all are same so return same as in 3 sec(means after one blast)
        if((n/2)%2 == 1){
            fillAll(grid);
            detonate(grid, grid_copy);
            return grid;
        }

        // we also found that 5, 9, 13, 17 ..... are in same situation
        // so in these cases, return grid after 5 sec (means after 2 blast)
        fillAll(grid);
        detonate(grid, grid_copy);
        grid_copy = List.copyOf(grid);
        fillAll(grid);
        detonate(grid,grid_copy);
        return grid;
    }


    // making the blast, changing original grid,
    // grid_copy is the previous copy which has info of bomb to be blast right now
    public static void detonate(List<String> grid, List<String> grid_copy){
        char[][] c = new char[grid.size()][grid.get(0).length()];
        for(int p = 0 ; p < grid.size(); p++){
            c[p] = grid.get(p).toCharArray();
        }
        for(int i = 0 ; i < c.length ; i++){
            for(int j = 0 ; j < c[0].length; j++){
                if(grid_copy.get(i).charAt(j) == 'O'){
                    c[i][j] = '.';
                    if(i > 0) c[i-1][j] = '.';
                    if(i < c.length - 1) c[i+1][j] = '.';
                    if(j > 0) c[i][j-1] = '.';
                    if(j < c[0].length - 1) c[i][j+1] = '.';
                }
            }
        }
        for(int p = 0 ; p < grid.size(); p++){
            grid.set(p, String.valueOf(c[p]));
        }
    }


    // to fill all cell with bomb
    public static List<String> fillAll(List<String> grid){
        for(int i = 0 ; i < grid.size() ; i++){
            grid.set(i, grid.get(i).replaceAll("[.]","O"));
        }
        return grid;
    }

}
