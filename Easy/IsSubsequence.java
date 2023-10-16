// https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public boolean isSubsequence(String s, String t) {
        //1. 2 pointer approach
        int i = 0, j= 0;
        while ( i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}