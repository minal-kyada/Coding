// https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/

import java.util.*;

class Solution {
    public int reductionOperations(int[] nums) {
        int totalOperations = 0;
        Arrays.sort(nums);
        for (int i=nums.length-1; i>0; i--) {
            if (nums[i] != nums[i-1])
                totalOperations+= (nums.length-i);
        }
        return totalOperations;
    }
}