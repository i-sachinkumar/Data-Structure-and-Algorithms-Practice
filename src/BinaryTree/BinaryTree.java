package BinaryTree;

import java.util.Scanner;

public class BinaryTree {
    Node root;
    Scanner sc = new Scanner(System.in);

    public Node createTree(){
        Node root = null;
        System.out.print("Enter data: ");
        int data = sc.nextInt();
        if(data == -1) return root;
        root = new Node(data);
        System.out.print("For left of " + data + ", ");
        root.left = createTree();
        System.out.print("For right of "+ data+ ", ");
        root.right = createTree();


        return root;
    }

//    public Node createTree(int[] arr, int startP){
//        Node root = null;
//        startP++;
//        int data = arr[startP];
//        if(data == -1) return root;
//        root = new Node(data);
//        root.left = createTree(arr, startP);
//
//
//
//        root.right = createTree(arr, startP);
//
//
//        return root;
//    }

    public void printNLR(Node root){
        if(root == null) return;
        System.out.print(root.data+ " ");
        printNLR(root.left);
        printNLR(root.right);
    }

    public void printLNR(Node root){
        if(root == null) return;
        printLNR(root.left);
        System.out.print(root.data+" ");
        printLNR(root.right);
    }

    public void printRNL(Node root){
        if(root == null) return;
        printRNL(root.right);
        System.out.print(root.data+" ");
        printRNL(root.left);
    }
}
