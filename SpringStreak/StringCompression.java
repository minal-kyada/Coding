// https://leetcode.com/problems/string-compression/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int compress(char[] chars) {
        //2 pointer approach
        int ans = 0; //pointer 1
        // i is pointer 2
        for (int i=0; i<chars.length; ){
            final char letter = chars[i]; // current char
            int count = 0; // coutn for current char
            while (i<chars.length && chars[i] == letter) {
                count++; i++; 
            }
            chars[ans++] = letter; // input current char in chars
            //logic to append the count in chars
            if (count>1) {
                for (final char c : String.valueOf(count).toCharArray())
                    chars[ans++] = c;
            }
        }
        return ans; // index of 1st pointer which tracks the last input char in chars
    }
}