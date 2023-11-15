// https://leetcode.com/problems/palindromic-substrings/
package TwoPointer;

class Solution {
    //Approach 1: DP
    public int countSubstrings(String s) {
        int count=0;
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        for(int gap=0; gap<n; gap++){
            for(int i=0, j=gap; i<n && j<n; i++, j++){
                if(gap==0){
                   dp[i][j]=true;
                }else if(gap==1){
                   dp[i][j]=(s.charAt(i)==s.charAt(j));
                }else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                       dp[i][j]=true;
                    }
                }
                if(dp[i][j]) count++;
            }
        }
        return count;
    }

/*  //Approach 2: Triangular Numbers / 2 pointers
    int result = 0;
    // Logic: Start traversing from inside to know the inner palindromes and move outwards.
    public int countSubstrings(String s) {
        for (int i=0; i<s.length(); i++) {
            //Consider i as the middle element and traverse left & right to check for palindrome
            expandFromMiddlle(s, i, i); // odd length
            expandFromMiddlle(s, i, i+1); // even length
        }
        return result;
    }

    private void expandFromMiddlle(String s, int start, int end) {
        while (start>=0 && end<s.length() && s.charAt(start) == s.charAt(end)) {
            result++;
            start--;
            end++;
        }
    } */
}
