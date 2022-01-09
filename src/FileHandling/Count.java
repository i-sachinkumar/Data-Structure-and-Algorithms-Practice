package FileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Count {



    public static void main(String[] args) {
        String[][] liked = null;
        String[][] disliked = null;

        Set<String> set = new HashSet<>();
        List<String> total_liked_items = new ArrayList<>();

        try {
            File myObj = new File("C:\\Users\\rjskg\\OneDrive\\Desktop\\input_data\\c_coarse.in.txt");
            Scanner sc = new Scanner(myObj);

            int c = sc.nextInt(); // num of customers
            liked  = new String[c][5];
            disliked  = new String[c][5];

            for (int i = 0 ; i < c ; i++){

                int l = sc.nextInt();       //num of liked items

                for(int j = 0 ; j < l ; j++){
                    String ingredient =  sc.next();
                    liked[i][j] = ingredient;
                    if(set.add(ingredient)) total_liked_items.add(ingredient);
                }


                int d = sc.nextInt();  // num of disliked item
                for(int j = 0 ; j < d ; j++){
                    String ingredient =  sc.next();
                    disliked[i][j] = ingredient;
                }
            }


            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        int numOfItems = 0;
        List<String> list = new ArrayList<>();

        try {
            File myObj = new File("C:\\Users\\rjskg\\OneDrive\\Desktop\\input_data\\c_coarse.out.txt");
            Scanner sc = new Scanner(myObj);

            numOfItems = sc.nextInt();

            for(int i = 0 ; i < numOfItems ; i++){
                list.add(sc.next());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        int count = 0;

        for(int i = 0 ; i< liked.length ; i++){
            if(canBuy(liked[i], disliked[i], list)) count++;
        }

        System.out.println(count);

    }


    static boolean canBuy(String[] buyerLikes, String[] buyerDislikes, List<String> target_items){
        for(String item : buyerLikes){
            if(item == null || item == "") break;
            if(!target_items.contains(item)) return false;
        }

        for (String item : buyerDislikes){
            if(item == null || item == "") break;
            else if(target_items.contains(item)) return false;
        }

        return true;
    }

}
