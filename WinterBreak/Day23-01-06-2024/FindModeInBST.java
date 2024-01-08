// https://leetcode.com/problems/find-mode-in-binary-search-tree/

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
    // Approach 1: Inorder with O(n) SC using Map and O(n) TC
    Map<Integer, Integer> map;
    
    public int[] findMode(TreeNode root) {
        map = new HashMap<>();
        inorder(root);
        List<Integer> result = new ArrayList<>();
        int maxVal = Integer.MIN_VALUE;
        for (int i : map.keySet()) {
            if (map.get(i) > maxVal) {
                maxVal = map.get(i);
                result = new ArrayList<>();
                result.add(i);
            } else if (map.get(i) == maxVal) {
                result.add(i);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        map.put(root.val, map.getOrDefault(root.val, 0)+1);
        inorder(root.right);
    }
    // Approach 2: Inorder with O(1) SC and O(n) TC
    // int currNo=0, currFreq=0, maxFreq=0;
    // List<Integer> result;
    // public int[] findMode(TreeNode root) {
    //     inorder(root);
    //     return result.stream().mapToInt(Integer::intValue).toArray();
    // }

    // private void inorder(TreeNode root) {
    //     if (root == null)
    //         return;
    //     inorder(root.left);
    //     if(currNo != root.val) {
    //         currNo = root.val;
    //         currFreq = 1;
    //     } else {
    //         currFreq++;
    //     }
    //     if (currFreq > maxFreq) {
    //         result = new ArrayList<>();
    //         maxFreq = currFreq;
    //     } 
    //     if (currFreq == maxFreq)
    //         result.add(currNo);
    //     inorder(root.right);
    // }
}
