// https://leetcode.com/problems/increasing-triplet-subsequence/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public boolean increasingTriplet(int[] nums) {
        //Subsequence - triplet doesn't have to be on contiguous location in array
        // Can be solved using DP too but the follow up question says use only O(1) space
        //TC: O(N) || O(1)
        if (nums.length < 3) return false;
        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;
        for (int num3 : nums) {
            // num1 < num2 < num3
            if (num3 <= num1) num1 = num3;
            else if (num3 <= num2) num2 = num3;
            else return true;
        }
        return false;
    }
}