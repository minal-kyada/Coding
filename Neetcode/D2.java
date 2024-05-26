// https://neetcode.io/problems/find-target-in-rotated-sorted-array

class Solution {
    //TC: O(log n)
    private int findPivot(int[] nums, int n) {
        int l=0, r=n-1;
        while (l<r) {
            int mid = l+(r-l)/2;
            if (nums[mid]>nums[r])
                l = mid+1;
            else 
                r = mid;
        }
        return r;
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
        int index = -1;
        while (l<=r) {
            int mid = l+(r-l)/2;
            if (nums[mid]<target)
                l = mid+1;
            else if (nums[mid]>target)
                r = mid-1;
            else {
                index = mid; 
                break;
            }
        }
        return index;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivot = findPivot(nums, n);
        int index = binarySearch(nums, 0, pivot-1, target);
        if (index!=-1) return index;
        else index = binarySearch(nums, pivot, n-1, target);
        return index;
    }
}
