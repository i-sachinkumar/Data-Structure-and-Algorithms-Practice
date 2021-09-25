package Interesting;

import java.util.*;

public class all_about_random {
    public static void main(String[] args) {

        List<String> boxes = new ArrayList<>();
        List<String> color = new ArrayList<>();

        boxes.add("box1");
        boxes.add("box2");
        boxes.add("box3");
        boxes.add("box4");
        boxes.add("box5");
        boxes.add("box6");
        boxes.add("box7");
        boxes.add("box8");
        boxes.add("box9");


        color.add("gray");
        color.add("blue");
        color.add("purple");
        color.add("teal");
        color.add("brown");
        color.add("white");
        color.add("black");
        color.add("green");
        color.add("orange");

        Collections.shuffle(color);

        for(int i = 0; i<9 ; i++){
            System.out.println(boxes.get(i)+" -> " + color.get(i));
        }


        //Generating random integer with equal probability
        Random r = new Random();                 //random class
        int random_int = r.nextInt();            //random integer assigned to random_int
        System.out.println("Random int: " + random_int);

        //Generating random integer with equal probability with upper limit
        int random_limited_int = r.nextInt(10);  //random integer belong to [0,9] is assigned to random_int
        System.out.println("Random Num from [0,9]: " + random_limited_int);


        //If we want to make a virtual fair dice
        //We have to print random int form [1,6]
        int min = 1;
        int max = 6;
        int dice_points = min + r.nextInt(max-min+1);
        System.out.println("Dice Rolled: " + dice_points);

        /* To check validity uncomment this code and run
        while(dice_points >=1 && dice_points <=6) {
            System.out.println("Dice Rolled: " + dice_points);
            dice_points = min + r.nextInt(max-min+1);
        }*/



        //Now make a biased dice :P (Probability of getting any no. in Fair dice is 1/6)
        // now make a die with Probability of getting 6 is 1/4  =  5/20
        // remaining points have equal probability among themselves (1 - (1/4))/5  =  3/20
        /* 5 chances out of 20 is for six and remaining scores have 3 chances out of 20  */
        //generate 20 random number [0,19]
        int random = r.nextInt(19);
        int score;
        if(random >=15) score = 6;
        else{
            score = (random/3) + 1;
        }
        System.out.println("Biased dice rolled: " + score);

        // Verifying probability with 100000 cases
        int[] count_each_occurance = new int[7];

        for(int i = 0 ; i < 100000 ; i++){
            int random_temp = r.nextInt(19);
            int score_temp;
            if(random_temp >=15) score_temp = 6;
            else{
                score_temp = (random_temp/3) + 1;
            }

            count_each_occurance[score_temp]++;
        }
        for(int i = 1 ; i <=6 ; i++){
            System.out.println("No. of "+ i + ": " + count_each_occurance[i]);
        }

        /*
           One of the output
            No. of 1: 15930
            No. of 2: 15838
            No. of 3: 15665
            No. of 4: 15779
            No. of 5: 15839
            No. of 6: 20949              : as expected
         */

    }
}
