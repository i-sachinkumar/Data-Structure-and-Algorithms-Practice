package BinarySearchTree;

import java.util.Scanner;

public class BST {
    public static void main(String[] args) {
        Node root = new Node(12);
        insert(root, 3);
        insert(root, 7);
        insert(root, 14);
        insert(root, 17);
        insert(root, 13);

        /**
         *                              12
         *                             /   \
         *                           5      14
         *                          /  \    / \
         *                        3     7  13  17
         *
         * Delete Node containing 14
         **/
        print(root);
        System.out.println();

//        insert(root, 15);
//
//        deleteLowest(root);
//
//


        delete(root, 14);

        print(root);
    }


    public static void insert(Node root, int element) {
        if (root == null) {
            root = new Node(element);
            return;
        }
        if (root.data > element) {
            if (root.left == null) {
                root.left = new Node(element);
                return;
            }
            insert(root.left, element);
        }
        if (root.data < element) {
            if (root.right == null) {
                root.right = new Node(element);
                return;
            }
            insert(root.right, element);
        }
    }

    public static void print(Node root) {
        if (root == null) return;
        print(root.left);
        System.out.print(root.data + " ");
        print(root.right);
    }


    public static Node delete(Node root, int element){

        /* Base Case: If the tree is empty */
        if (root == null) return root;

        /* Otherwise, recur down the tree */
        if (element < root.data)
            root.left = delete(root.left, element);
        else if (element > root.data)
            root.right = delete(root.right,element);

            // if key is same as root's
            // key, then This is the
            // node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.data = findLowest(root.right);

            // Delete the inorder successor
            root.right = delete(root.right, root.data);
        }

        return root;
    }


    public static int findLowest(Node root){
        if(root.left == null) return root.data;
        return findLowest(root.left);
    }

}


class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }


}
