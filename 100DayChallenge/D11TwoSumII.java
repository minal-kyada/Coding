// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

class Solution {
    public int[] twoSum(int[] num, int target) {
        int low = 0;
        int high = num.length-1;
        while(low<high){
            int sum = num[low]+num[high];
            if(sum==target) {
                return new int[]{low+1,high+1};
            }
            if(sum<target) {
                low++;
            } else {
                high--;
            }
        }
        return null;
    }
}