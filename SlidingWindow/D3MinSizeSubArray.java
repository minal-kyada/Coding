package SlidingWindow;

// https://leetcode.com/problems/minimum-size-subarray-sum/submissions/1094940942/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0, sum = 0;
        int res = Integer.MAX_VALUE;
        while(end<nums.length) {
            sum+=nums[end++];
            while (sum>=target) {
                res = Math.min(res, end-start+1);
                sum-=nums[start++];
            }
        }
        System.gc();
        return res==Integer.MAX_VALUE?0:res;
    }
}