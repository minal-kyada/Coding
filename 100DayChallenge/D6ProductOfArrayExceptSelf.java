// https://leetcode.com/problems/product-of-array-except-self/

import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Approach 1: TC O(n) SC O(1)
        int n = nums.length;
        int currVal = 1;
        int[] ans = new int[n];

        Arrays.fill(ans, 1);
        for (int i=0; i<n; i++) {
            ans[i]*=currVal;
            currVal*=nums[i];
        }

        currVal = 1;
        for (int i=n-1; i>=0; i--) {
            ans[i]*=currVal;
            currVal*=nums[i];
        }
        return ans;
    }
}