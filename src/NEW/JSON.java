package NEW;


import java.util.ArrayList;

public class JSON {
    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(8);
        l.add(5);
        l.add(19);
        reverse(l,2);
        for (int i : l){
            System.out.println(i);
        }
    }
    public static ArrayList<Integer> reverse(ArrayList<Integer> al, int n){
        if(n==0) return al;
        int temp = al.remove(0);
        reverse(al, n-1);
        al.add(temp);
        return al;
    }
}
