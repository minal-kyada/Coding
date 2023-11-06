// https://leetcode.com/problems/valid-palindrome/description/

class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int last = s.length()-1;
        while(start <= last) {
            char cs = s.charAt(start);
            char cl = s.charAt(last);
            if (!Character.isLetterOrDigit(cs))
                start++;
            else if (!Character.isLetterOrDigit(cl))
                last--;
            else {
                if (Character.toLowerCase(cs) != Character.toLowerCase(cl))
                    return false;
                start++;
                last--;
            }
        }
        return true;
    }
}