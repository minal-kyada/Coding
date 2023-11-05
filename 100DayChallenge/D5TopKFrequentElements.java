// https://leetcode.com/problems/top-k-frequent-elements/

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        // Approach 1
        //1. Populate integer-frequency pair in map
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int i=0; i<n; i++) {
        //     map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        // }

        // //2. Create a list using map.entry to sort the elements based on frequency
        // List<Map.Entry<Integer, Integer>> freq = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        // Collections.sort(
        //     freq, new Comparator<Map.Entry<Integer, Integer>>() {
        //         public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        //             if (o1.getValue() == o2.getValue())
        //                 return o2.getKey() - o1.getKey();
        //             else   
        //                 return o2.getValue() - o1.getValue();
        //         }
        //     }
        // );

        // //3. Print K elements from the list
        // for (int i=0; i<k; i++) {
        //     ans[i] = freq.get(i).getKey();
        // }
        // return ans;

        // Approach 2
        //1. Populate integer-frequency pair in map
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int i=0; i<n; i++) {
        //     map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        // }
        // return map.entrySet().stream().sorted((e1,e2) -> e2.getValue().compareTo(e1.getValue())).limit(k).mapToInt(e -> e.getKey()).toArray();

        // Approach 3
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        List<Integer>[] bucket = new ArrayList[n+1];

        Iterator itr = map.entrySet().iterator();

        while (itr.hasNext()) {
            Map.Entry mapElement = (Map.Entry)itr.next();
            List<Integer> list = bucket[(int)mapElement.getValue()];
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add((int)mapElement.getKey());
            bucket[(int)mapElement.getValue()] = list;
        }

        for (int i=n; i>=0 && k>0; i--) {
            if (bucket[i] != null) {
                int m = bucket[i].size();
                while(m > 0 && k > 0) {
                    List<Integer> list = bucket[i];
                    ans[k-1] = list.get(m-1);
                    m--; k--;
                }
            }
        }
        return ans;
    }
}