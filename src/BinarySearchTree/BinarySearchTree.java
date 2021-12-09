package BinarySearchTree;


import java.util.List;
import java.util.NoSuchElementException;

public class BinarySearchTree {


    public static void main(String[] args) throws Exception {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert( 12);
        bst.insert(7);
        bst.insert(14);
        bst.insert(17);
        bst.insert(13);
        bst.insert(5);
        bst.insert(3);

        // printing inOrder(LNR)
        bst.print(bst.root);
        System.out.println();


        /* Given Tree
         *                              12
         *                             /   \
         *                            5     14
         *                          /  \    / \
         *                         3    7  13  17
         *
         */

        //find an element
        System.out.println(bst.find(14, bst.root));


        // Suppose we have to delete 14 from above tree
        bst.delete(bst.root, 14);

        bst.print(bst.root);
        System.out.println();

        // inserting multiple element
        bst.insertAll(new int[]{100, 10, 1, -20, 80, 101, -2});
        bst.insertAll(List.of(60, 55, 30, -30, -1000, 1000, Integer.MIN_VALUE, Integer.MAX_VALUE));

        bst.print(bst.root);
        System.out.println();


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

    Node root;
    BinarySearchTree(){
        this.root = null;
    }

/*************** Insert a single data *********************************************************************************************************************/
    public void insert(int data){
        root = insert(root, data);
    }
    public Node insert(Node root, int data){
        if(root == null){
            root = new Node(data);
        }
        else if(root.data > data) root.left = insert(root.left, data);
        else root.right = insert(root.right, data);

        return root;
    }
//************* End of Insert ***********************************************************************************************************************/



/*************** InsertAll from array *********************************************************************************************************************/
    //if an array is parameter
    public void insertAll(int[] datas){
        for (int data : datas) {
            insert(data);
        }
    }

    //if a List<Integer> is parameter
    public void insertAll(List<Integer> datas){
        for (int data : datas) {
            insert(data);
        }
    }
//************* End of InsertAll ***********************************************************************************************************************/


/************** Find ***************************************************************************************************************/
    public boolean find(int data, Node root){
            if(root!= null ) {
                if (data < root.data) return find(data, root.left);
                else if(data > root.data) return find(data, root.right);
                else return true;
            }
            else return false;
    }
//************* End of Find **********************************************************************************************************


/*********** Print Inorder ********************************************************************************************************************/
    public void print(Node root){
        if(root == null) return;

        print(root.left);
        System.out.print(root.data + " ");
        print(root.right);
    }
//*********** End of Print *************************************************************************************************************************


/******************** Delete ***************************************************************************************************************************/
    public Node delete(Node root, int data) throws Exception{
        // case 1 : if root is the only data
        if(root.left == null && root.right == null){
            if(root.data == data) {
                return null;
            }
            else throw new NoSuchElementException("The data you want to delete is not found in tree");
        }

        // case 2 : Leaf node
        Node parent = root;
        Node tree = root;
        while(root != null){
            if(root.data > data) {
                parent = root;
                root = root.left;
            }
            else if(root.data < data){
                parent = root;
                root = root.right;
            }
            else break;
        }
        if(root == null) throw new NoSuchElementException("The data you want to delete is not found in tree");
        else if(root.left == null && root.right==null){
            if(parent.left != null && parent.left.data == data) {
                parent.left = null;
                return tree;
            }
            else if(parent.right != null && parent.right.data == data){
                parent.right = null;
                return tree;
            }
        }

        // case 3 middle node which has at least a child
        else{
            if(root.left != null){ // if left child is there
                int high = 0;
                Node temp = root.left;
                while (temp != null){
                    high = temp.data;
                    temp = temp.right;
                }
                root.data = high;
                root.left = delete(root.left, high);
            }
            else {// if right is there
                int low = 0;
                Node temp = root.right;
                while (temp != null){
                    low = temp.data;
                    temp = temp.left;
                }
                root.data = low;
                root.right = delete(root.right, low);
            }
        }
        return tree;
    }
//*********************** End of Delete ****************************************************************************************************

}
