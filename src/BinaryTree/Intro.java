package BinaryTree;

import java.util.*;

public class Intro {
    public static void main(String[] args) {

        List<String> ids = new ArrayList<>();
        List<String> color = new ArrayList<>();

        ids.add("textView1");
        ids.add("textView2");
        ids.add("textView3");
        ids.add("textView4");
        ids.add("textView5");
        ids.add("textView6");
        ids.add("textView7");
        ids.add("textView8");
        ids.add("textView9");


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
            System.out.println(ids.get(i)+" -> " + color.get(i));
        }
    }
}
