package Reccursion;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReverseWithoutSpace {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();

        DecimalFormat f = new DecimalFormat("0.00");
        String d = f.format(737.3761471764);
        System.out.println(d);

        long t = System.currentTimeMillis();

        Date date = new Date(t);

        SimpleDateFormat df = new SimpleDateFormat("MMM dd yyyy, HH:mm");

        String dates = df.format(date);

        System.out.println(dates);


        ArrayList<Integer> l = new ArrayList<>();
        l.add(8);
        l.add(5);
        l.add(19);
        l.add(7);
        l.add(0);
        l.add(76);
        reverse(l);
        for (int i : l){
            System.out.print(i + " ");
        }
        System.out.println();
        int[] a = { 2, 3, 4, 8, 0, 6};
        reverse(a,0,5);
        for(int i : a){
            System.out.print(i+ " ");
        }
    }
    public static void reverse(ArrayList<Integer> al){
        if(al.size()==0) return;
        int temp = al.remove(0); // decrease size by 1
        reverse(al);
        al.add(temp);
    }

    public static void reverse(int[] a, int l, int r){
        if(r==-1) {
            return;
        }
        int temp = a[l];
        reverse(a,l+1,r-1);
        a[r] = temp;
    }
}
