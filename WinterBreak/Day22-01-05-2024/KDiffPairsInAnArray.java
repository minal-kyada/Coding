package WinterBreak.Day22-01-05-2024;

class Solution {
    public int findPairs(int[] nums, int k) {
        // TC: O(n) Using map
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int num : nums) {
        //     map.put(num, map.getOrDefault(num, 0)+1);
        // }

        // int result = 0;
        // for (int i : map.keySet()) {
        //     if ( k > 0 && map.containsKey(i+k) || map.get(i) > 1)
        //         result++;
        // }
        // return result;

        // TC:O(nlogn) Using sorting and set
        Set<Integer> uniquePair = new HashSet();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n-1; i++) {
            if (Arrays.binarySearch(nums, i+1, n, nums[i]+k) > 0)
                uniquePair.add(nums[i]);
        }
        return uniquePair.size();
    }
}