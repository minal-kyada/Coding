// https://leetcode.com/problems/longest-repeating-character-replacement/

class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        //Sliding window approach
        int l=0, topFreq=0, maxL=0;
        int n = s.length();
        int[] charCounts = new int[26];
        for (int r=0; r<n; r++) {
            charCounts[s.charAt(r)-'A']++;
            topFreq=Math.max(topFreq, charCounts[s.charAt(r)-'A']);
            while (r-l+1-topFreq > k) {
                charCounts[s.charAt(l)-'A']--;
                l++;
            }
            maxL = Math.max(maxL, r-l+1);
        }       
        return maxL; 
    }
}