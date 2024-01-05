// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

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
    int maxVal = Integer.MIN_VALUE;;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxVal;
    }

    private int solve(TreeNode root) {
        if(root == null)
            return 0;
        
        int l = solve(root.left);
        int r = solve(root.right);

        int lr_best = l+r+root.val;
        int root_best = root.val;
        int l_or_r_best = Math.max(l,r)+root.val;

        maxVal = Math.max(maxVal, lr_best);
        maxVal = Math.max(maxVal, root_best);
        maxVal = Math.max(maxVal, l_or_r_best);
        return Math.max(root_best, l_or_r_best);
    }
}
