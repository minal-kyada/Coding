// https://leetcode.com/problems/longest-common-prefix/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        StringBuilder ans = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];

        for (int i=0;i<first.length();i++){
            if(first.charAt(i) != last.charAt(i)) {
                break;
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
}