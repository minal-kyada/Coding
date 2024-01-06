// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

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
    private int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) return null;
        if (inorder.length == 0) return null;
        idx = inorder.length-1;
        return solve(inorder, postorder, 0, idx);
    }

    private TreeNode solve(int[] inorder, int[] postorder, int start, int end) {
        if (start>end) return null;
        TreeNode node = new TreeNode(postorder[idx--]);
        if(start==end) return node;
        int i=start;
        for (; i<=end; i++) {
            if (inorder[i] == node.val)
                break;
        }
        node.right = solve(inorder, postorder, i+1, end);
        node.left = solve(inorder, postorder, start, i-1);
        return node;
    }
}