// https://leetcode.com/problems/3sum/

import java.util.*;

class Solution {
    List<List<Integer>> result = new ArrayList<>();

    //3. 2 sum for n2 n3 with target as -n1 on remaining nums and avoid duplicates
    private void twoSum(int[] nums, int target, int i, int j) {
        while (i < j) {
            if (nums[i] + nums[j] > target) j--;
            else if (nums[i] + nums[j] < target) i++;
            else {
                while (i<j && nums[i] == nums[i+1]) i++;
                while (i<j && nums[j] == nums[j-1]) j--;
                result.add(Arrays.asList(-target, nums[i], nums[j]));
                i++; j--;
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if (n<3) return result;
       //1. Sort nums
       Arrays.sort(nums);
       //2. Set n1 as target and avoid duplicates 
       for (int i=0; i<=n-3; i++) {
           if (i>0 && nums[i] == nums[i-1]) continue;
            int n1 = nums[i];
            int target = -n1;
            twoSum(nums, target, i+1, n-1);
       }
       return result;
    }
}