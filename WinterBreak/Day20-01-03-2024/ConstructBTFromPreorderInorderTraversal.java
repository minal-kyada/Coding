// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int idx = 0;
        int n = preorder.length;
        return build(preorder, inorder, 0, n-1, idx);
    }

    private TreeNode build(int[] preorder, int[] inorder, int start, int end, int idx) {
        if (start>end)
            return null;
        int rootVal = preorder[idx];
        int i = start;
        for (; i<=end; i++) {
            if (inorder[i] == rootVal)
                break;
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, inorder, start, i-1, idx+1);
        root.right = build(preorder, inorder, i+1, end, idx+i-start+1);
        return root;
    }
}
