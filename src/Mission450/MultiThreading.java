package Mission450;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiThreading {
//    public static void main(String[] args) throws InterruptedException {
//
//        int[] c = {2,2,2,2,2};
//        test(2, c, 4, 5, 6, 6, 2);
//        System.out.println(Arrays.toString(c));
//        Thread t = new Thread(() -> backg("t1"),"t1");
//        System.out.println(t.getName());
//        t.start();
//
//        Thread t2 = new Thread(() -> backg("t2"), "t2");
//        t2.start();
//
//
//    }

    class Par{
        int a;
        public void fun(){
            System.out.println("cndvkjev");
        }
    }

    class child extends Par{

    }

    interface A{
        public void hello();
        public void hello2();
    }
    interface B{
        public void hello3();
        public void hello4();
    }

    interface C extends A, B{

    }

    public static void test(int b, int[] c, int ...a){
        c[0] = 999;
        System.out.print(b + " " + Arrays.toString(c) + " ");
        for (int j : a)
            System.out.print(j + " ");
        System.out.println();
        c = new int[]{2,3,3,4,4,3};
        c[0] = 1000;
        System.out.println(Arrays.toString(c));
    }

    public static void backg(String thread){
        for(int i = 0; i < 10000; i++){
            System.out.println(thread +  " " + i);
        }
    }

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public static List<Integer> solve(int Q, int[][] queries){
        Node root = null;
        List<Integer> ans = new ArrayList<>();
        for(int[] query : queries){
            int x = query[0];
            int y = query[1];
            if(x == 0){
                root = insert(root, y);
            }
            else{
                if(search(root, y)){
                    ans.add(1);
                    delete(root, y);
                }
                else ans.add(0);
            }
        }
        return ans;
    }

//    static void insert(Node root, int y){
//        if(root)
//    }

    static Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        else if (key < root.data)
            root.left = insert(root.left, key);
        else if (key > root.data)
            root.right = insert(root.right, key);
        return root;
    }

    public static boolean search(Node root, int key) {
        if (root==null) return false;
        if(root.data==key) return true;
        if (root.data < key)
            return search(root.right, key);
        return search(root.left, key);
    }

    static Node delete(Node root, int key) {
        if (root == null)
            return null;
        if (key < root.data)
            root.left = delete(root.left, key);
        else if (key > root.data)
            root.right = delete(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.data = minValue(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }
    static int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

}


/**
 * SOLID PRINCIPLE
 */
// Interface segregation principle
interface parkingLot {
    int a = 0;
    void parkCar();	// Decrease empty spot count by 1
    void unparkCar(); // Increase empty spots by 1
    void getCapacity();	// Returns car capacity
}
interface FreeParkingLot extends parkingLot {
}

interface PaidParkingLot extends parkingLot {
    double calculateFee();
    void doPayment();
}


abstract class A{
    int a;
    int b;
    abstract void ff();

//    A(int a, int b){
//        this.a = a;
//        this.b = b;
//    }
}

class B extends A{
    int c;
    B(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    void ff() {

    }
}


interface Foo {
    String name = "Foo";

    void print();

}
class Bar implements Foo {
    String name = "Bar";

    public void print() {

        System.out.println(name); // Line 1
    }

    public static void main(String[] args) {
        int inp[] = {1, 1, 5, 5, 2, 2, 7};

        int x;

        int N = inp.length;

        for (int i = 1; i < N; i++) {

            int j = i;

            while (j > 0 && inp[j] < inp[j - 1]) {
                int k = inp[j];
                inp[j] = inp[j - 1];
                inp[j - 1] = k;
                j = j - 1;
            }
        }

        System.out.println(fun(16, 28));

    }

    static int fun(int a, int b){
        if(a==b) return a;
        if(a > b) return fun(a-b,  b);
        return fun(a, b-a);
    }
}