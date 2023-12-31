package WinterBreak.Day16;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

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

    int count = 0;
    int result = Integer.MIN_VALUE;

    private void inorder(TreeNode root, int k) {
        if (root == null)
            return;
        int i=0, j=0;
        inorder(root.left, k);
        count++;
        if (count==k) {
            result = root.val;
            return;
        }
        inorder(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }
}
