package WinterBreak.Day15;

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
    public int minDepth(TreeNode root) {
        if ( root == null)
            return 0;
        else {
            int lDepth = root.left == null ? 0 : minDepth(root.left);
            int rDepth = root.right == null ? 0 : minDepth(root.right);
            return (lDepth==0||rDepth==0)?lDepth+rDepth+1: Math.min(lDepth, rDepth)+1;
        }
    }
}
