package SpringStreak;
// https://leetcode.com/problems/maximum-product-subarray/

class Solution {
    public int maxProduct(int[] nums) {
        //TC: O(n) || SC: O(1)
        //Left and Right prefix product
        int n = nums.length;
        int lp = 1, rp=1; // left product, right product
        int ans = nums[0];
        for (int i=0; i<n; i++) {
            lp = lp == 0 ? 1 : lp; // if nums[i]=0 reset lp to 1
            rp = rp == 0 ? 1 : rp; // if nums[i]=0 reset rp to 1
            lp*=nums[i];
            rp*=nums[n-1-i];
            ans = Math.max(ans, Math.max(lp, rp));
        }
        System.gc();
        return ans;
    }
}