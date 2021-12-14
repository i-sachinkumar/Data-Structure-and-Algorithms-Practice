package daily_test.Dec14;

// Qs Link = {https://leetcode.com/problems/range-sum-of-bst/}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class RangeSumBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10, new TreeNode(5), new TreeNode(15));
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.right = new TreeNode(18);

        /*

                        10
                      /    \
                     5      15
                   /  \       \
                  3    7      18


         */

        System.out.println(rangeSumBST(root, 7, 15));

    }



    static int sum = 0;
    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return sum;
        sum = rangeSumBST(root.left, low, high);
        if (root.val >= low && root.val <= high) sum += root.val;
        sum = rangeSumBST(root.right, low, high);
        return sum;
    }
}
