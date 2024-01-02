// https://leetcode.com/problems/binary-tree-right-side-view/

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
    public List<Integer> rightSideView(TreeNode root){
        
        List<Integer> list = new ArrayList<>();
        rightSideRecursiveSol(root, list,0);
        return list;
    }

    private void rightSideRecursiveSol(TreeNode root, List<Integer> list, int currDepth){
        if(root==null){
            return;
        }
        if(currDepth == list.size()){
            list.add(root.val);
        }
        rightSideRecursiveSol(root.right, list, currDepth+1);
        rightSideRecursiveSol(root.left, list, currDepth+1);
    }
}