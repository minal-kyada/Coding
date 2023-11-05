// https://leetcode.com/problems/longest-consecutive-sequence/

import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        //approach 1: Nested loops: TC: O(n^3) SC: O(1)
        //Approach 2: Sort and single loop: TC: O(n log n) SC: O(1)
        Arrays.sort(nums);
        int maxlen = 1;
        int n = nums.length;
        int smaller = Integer.MIN_VALUE;
        int count=0;
        if (n==0) return 0;

        for(int i = 0 ; i<n; i++){
            if(nums[i]-1==smaller){
                count++;
                smaller = nums[i];
            }
            else if(nums[i]!=smaller){
                count=1;
                smaller = nums[i];
            }
            maxlen = Math.max(count, maxlen);
        }
        return maxlen;  

        //Approach 3: TC: O(n) and SC: O(n)
        // int n = nums.length;
        // HashSet<Integer> set = new HashSet<>();
        // for (int i=0; i<n; i++)
        //     set.add(nums[i]);

        // int ll = 0;
        // for (int i=0; i<n; i++) {
        //     if (set.contains(nums[i]-1) == false) {
        //         int cl = 1;
        //         int ce = nums[i];
        //         while (set.contains(ce+1)) {
        //             cl+=1;
        //             ce+=1;
        //         }
        //     ll = Math.max(ll, cl);
        //     }
        // }
        // System.gc();
        // return ll;
    }
}