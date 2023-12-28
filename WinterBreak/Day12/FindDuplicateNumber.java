// https://leetcode.com/problems/find-the-duplicate-number/description/

public class Solution {
    public int findDuplicate(int[] nums) {

        //Approach1: BruteForce TC: O(n*n)
        //Approach2: Marking the visited index values as negative to catch the duplicate value - it modifies the existing array values
        //Approach3: using slow fast pointners to identify the duplicate
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}