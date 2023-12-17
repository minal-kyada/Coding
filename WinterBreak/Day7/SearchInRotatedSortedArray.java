// https://leetcode.com/problems/search-in-rotated-sorted-array/

class Solution {
    private int findPivot(int[] nums, int n) {
        int left = 0, right = n-1;
        while (left<right) {
            int mid = left+(right-left)/2;
            if (nums[mid] > nums[right])
                left = mid+1;
            else
                right = mid;
        }
        return right;
    }

    private int binarySearch(int left, int right, int[] nums, int target) {
        int index = -1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (nums[mid] < target) {
                left = mid+1;
            } else if (nums[mid] > target){
                right = mid-1;
            } else {
                index=mid;
                break;
            }
        }
        return index;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivot = findPivot(nums, n);
        int index = binarySearch(0, pivot-1, nums, target);
        if (index!=-1)
            return index;
        else 
            index = binarySearch(pivot, n-1, nums, target);
        return index;
    }
}