// https://leetcode.com/problems/container-with-most-water/

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int lp = 0, rp = n-1;
        int maxWater = 0;
        while (lp < rp) {
            int h = Math.min(height[lp], height[rp]);
            int w = rp-lp;
            int area = h*w;
            maxWater = Math.max (area, maxWater);
            //Note: optimisation by skipping many cols which are greater than the current min height
            while (lp<rp && height[lp] <= h) lp++;
            while (lp<rp && height[rp] <= h) rp--;
        }
        System.gc();
        return maxWater;
    }
}