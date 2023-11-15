// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length() - needle.length() +1;
        for (int i=0; i<n; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if(haystack.substring(i, needle.length()+i).equals(needle)){
                    return i;
                }
            }
        }        
        return -1;
    }
}