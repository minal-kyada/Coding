// https://leetcode.com/problems/range-sum-of-bst/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        inorder(root, low, high);
        return sum;
    }

    private void inorder(TreeNode root, int l, int h) {
        if (root == null)
            return;
        if(root.val >= l && root.val <= h) {
            sum+=root.val;
        }
        if(root.val >= l)
            inorder(root.left, l, h);
        //visit
        if (root.val <= h)
            inorder(root.right, l, h);
    }
}