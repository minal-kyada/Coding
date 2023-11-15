// https://leetcode.com/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}