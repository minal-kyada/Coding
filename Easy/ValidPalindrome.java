// https://leetcode.com/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int last = s.length()-1;

        while (start <= last) {
            char currF = s.charAt(start);
            char currL = s.charAt(last);
            if(!Character.isLetterOrDigit(currF)) {
                start++;
            } else if (!Character.isLetterOrDigit(currL)) {
                last--;
            } else {
                if (Character.toLowerCase(currF) != Character.toLowerCase(currL)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }
}