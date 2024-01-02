// https://leetcode.com/problems/binary-tree-level-order-traversal/

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result; // return an empty list
        }
        // keep track of processed nodes so far
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
          int levelSize = queue.size();
          List<Integer> currentLevel = new ArrayList<>();
          for (int i = 0 ; i < levelSize; i++) {
            // add nodes in the same level to currentLevel list
            TreeNode node = queue.poll();
            currentLevel.add(node.val);
            if (node.left != null) {
              queue.add(node.left);
            }
            if (node.right != null) {
              queue.add(node.right);
            }
          }
          // add list of nodes in each level to the result list
          result.add(currentLevel);
        }
        return result;
    }

    // time: O(n), n is number of nodes
    // space: O(h), h is height of tree
}