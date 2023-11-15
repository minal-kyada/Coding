// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int p1=0, p2=nums.length-1;
        while (p1<p2) {
            int sum = nums[p1]+nums[p2];
            if (sum == target) {
                return new int[]{p1+1, p2+1};
            }
            if (sum > target)
                p2--;
            else 
                p1++;
        }
        return null;
    }
}