package SlidingWindow;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 0)
            return 0;
        
        int start = 0;
        int maxWindowSize = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        for (int end=0; end<n; end++) {
            char c = s.charAt(end);
            if (!set.add(c)) {
                while(set.contains(c)) {
                    set.remove(s.charAt(start));
                    start++;
                }
            }
            set.add(c);
            maxWindowSize = Math.max(maxWindowSize, set.size());
        }
        return maxWindowSize;
    }
}