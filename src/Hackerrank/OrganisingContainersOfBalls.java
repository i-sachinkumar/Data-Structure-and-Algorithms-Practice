package Hackerrank;

/**
 *
 * link of qs on hackerrank : {@https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem}
 *
 *
 * David has several containers, each with a number of balls in it.
 * He has just enough containers to sort each type of ball he has into its own container.
 * David wants to sort the balls using his sort method.
 *
 * David wants to perform some number of swap operations such that:
 *
 * Each container contains only balls of the same type.
 * No two balls of the same type are located in different containers.
 */


import java.util.List;

public class OrganisingContainersOfBalls {
    public static void main(String[] args) {
        System.out.println(organizingContainers(List.of(
                List.of(0, 2, 1),
                List.of(1, 1, 1),
                List.of(2, 0, 0)
        )));    //possible
    }

    public static String organizingContainers(List<List<Integer>> container) {
        /*
        {
                  row => box no. => each row show each box
                  e.g. if row0 = {2, 3, 1}, then in box_0, then
                  no. of ball_0 in box_0 is 2, no. of ball_1 is 3 and no. of ball_2 is 1
         }

         */

        // col => ball type
        int n = container.size();

        int[] total_no_of_each_ball = new int[n];

        int[] no_of_ball_in_each_box = new int[n];

        /**
         * @Logic
         *
         * we have to segregate each type of ball in different box by swapping only.
         *
         * if we swap 2 balls from two boxes, total number of balls in respective boxes remains same
         * So, we can't change capacity of any box
         *
         * if total no. 0 type ball is x, then there must be a box with capacity x.
         * similarly there must be a respective box for each type (remember, if box with capacity is reserved
         * for type 0 balls then this box should not be used for others.
         *
         * If we found distinct boxes with capacity of each type balls,
         *  then definitely there will be a way to segregate balls mean "Possible".
         *
         *  otherwise "Impossible".
         */
        for(int i = 0 ; i < n ; i++){
            int row_sum = 0;
            int col_sum = 0;
            for(int j = 0; j < n ; j++){
                row_sum += container.get(i).get(j);
                col_sum += container.get(j).get(i);
            }
            total_no_of_each_ball[i] = row_sum;
            no_of_ball_in_each_box[i] = col_sum;
        }


        for(int i = 0; i < n ; i++){
            boolean contain = false;
            for(int j = 0 ; j < n ; j++){
                if(total_no_of_each_ball[i] == no_of_ball_in_each_box[j]){
                    contain = true;
                    no_of_ball_in_each_box[j] = -1; // container is reserved so making capacity negative.
                    break;
                }
            }
            if(!contain) return "Impossible";
        }

        return "Possible";
    }

}
