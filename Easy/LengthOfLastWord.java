// https://leetcode.com/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int lengthOfLastWord(String s) {
        int c = 0;
        int j = 0;
        for (int i = s.length()-1; i>=0;i--) {
            if (s.charAt(s.length()-1-j) == ' ') {
                j++;
                continue;
            } else {
                if (s.charAt(i) != ' ') {
                    c++;
                } else {
                    break;
                }
            }
        }
        return c;
    }
}