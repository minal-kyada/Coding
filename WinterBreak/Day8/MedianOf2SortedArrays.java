// https://leetcode.com/problems/median-of-two-sorted-arrays/description/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int p1 = 0, p2=0;
        int[] temp = new int[m+n];
        int i=0;
        while (p1<m && p2<n) {
            if (nums1[p1] < nums2[p2])
                temp[i++] = nums1[p1++];
            else 
                temp[i++] = nums2[p2++];
        }
        while (p1<m) temp[i++] = nums1[p1++];
        while (p2<n) temp[i++] = nums2[p2++];
        if (temp.length/2 == 0)
            return temp[temp.length/2];
        else 
            return (temp[(temp.length-1)/2] + temp[temp.length/2])/2.0;
    }
}