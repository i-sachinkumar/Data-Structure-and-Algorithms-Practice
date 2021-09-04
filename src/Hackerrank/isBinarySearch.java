package Hackerrank;

/**
 *
 * Link of Question = https://www.hackerrank.com/challenges/is-binary-search-tree/problem
 *
 * Question:
 * For the purposes of this challenge, we define a binary tree to be a binary
 * search tree with the following ordering requirements:
 *
 * The  value of every node in a node's left subtree is less than the data value of that node.
 * The  value of every node in a node's right subtree is greater than the data value of that node.
 */

public class isBinarySearch {




    // declare universal var
    int temp = Integer.MIN_VALUE;
    boolean ans = true;


    // this is the function to implement
    boolean checkBST(Node root) {
        if(root == null) return ans;
        checkBST(root.left);
        if(temp >= root.data){
            ans = false;
            return false;
        }
        temp = root.data;
        checkBST(root.right);
        return ans;
    }

}


class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        left = right = null;
    }
}
