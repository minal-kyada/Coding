// https://leetcode.com/problems/median-of-two-sorted-arrays/description/

// Approach 1 without BS 
// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int m = nums1.length;
//         int n = nums2.length;
//         int p1 = 0, p2=0;
//         int[] temp = new int[m+n];
//         int i=0;
//         while (p1<m && p2<n) {
//             if (nums1[p1] < nums2[p2])
//                 temp[i++] = nums1[p1++];
//             else 
//                 temp[i++] = nums2[p2++];
//         }
//         while (p1<m) temp[i++] = nums1[p1++];
//         while (p2<n) temp[i++] = nums2[p2++];
//         if (temp.length/2 == 0)
//             return temp[temp.length/2];
//         else 
//             return (temp[(temp.length-1)/2] + temp[temp.length/2])/2.0;
//     }
// }


// Approach 2 with BS
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // MAking sure that nums1 is the smallest always
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int m = nums1.length;
        int n = nums2.length;
        // Make sure to run the Binary search on smallest array i.e nums1
        int l = 0, r = m;
        while (l <= r) {
            int px = l+(r-l)/2; // mid from nums1
            int py = ((m+n+1)/2)-px ; // mid from nums2

            // Check for the correct set of nums from num1 and num2
            int x1 = (px == 0) ? Integer.MIN_VALUE : nums1[px-1];
            int x2 = (py == 0) ? Integer.MIN_VALUE : nums2[py-1];
            int x3 = (px == m) ? Integer.MAX_VALUE : nums1[px];
            int x4 = (py == n) ? Integer.MAX_VALUE : nums2[py];

            // Check for the sorted order after merging above 4 values
            if (x1 <= x4 && x2 <= x3) {
                // odd, middle no. is the median
                if ((m+n)%2 == 1) 
                    return Math.max(x1, x2);
                // even, middle-1 + middle number /2 is the median
                return (Math.max(x1,x2)+Math.min(x3,x4))/2.0;
            }
            
            // BS moving l and r conditions 
            // if x1 > x4: means left set has more elements, move the right pointer to mid-1
            if (x1 > x4)
                r = px-1;
            else 
                l = px+1;
        }
        return -1;
    }
}