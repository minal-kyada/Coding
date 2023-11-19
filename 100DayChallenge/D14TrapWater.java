// https://leetcode.com/problems/trapping-rain-water/

class Solution {
    public int trap(int[] height) {
        //Approach 1: Brute force O(n*n)
        //Approach 2: O(n), O(n)
        // int n = height.length;
        // int[] lMax = new int[n];
        // int[] rMax = new int[n];
        // int res = 0;
        // lMax[0] = height[0];
        // rMax[n-1] = height[n-1];
        // for(int i=1; i<n; i++) {
        //     lMax[i] = Math.max(lMax[i-1], height[i]);
        // }
        // for (int i=n-2; i>=0; i--) {
        //     rMax[i] = Math.max(rMax[i+1], height[i]);
        // }
        // for (int i=0; i<n; i++) {
        //     int h = Math.min(lMax[i], rMax[i]) - height[i];                    
        //     res += h;                
        // }
        // return res;

        //Approach 3: O(n), O(1) - most optimised
        int n = height.length;
        int lp = 0, rp = n-1;
        int maxL = 0, maxR = 0;
        int res = 0;
        while (lp <= rp) {
            if (height[lp] <= height[rp]) {
                if (height[lp] > maxL) {
                    maxL = height[lp];
                } else {
                    res += (maxL - height[lp]);
                }
                lp++;
            } else {
                if (height[rp] > maxR) {
                    maxR = height[rp];
                } else {
                    res += (maxR - height[rp]);
                }
                rp--;
            }
        }
        System.gc();
        return res;
    }
}