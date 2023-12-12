package WinterBreak.Day2;

// https://leetcode.com/problems/permutation-in-string/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 == 0) return true;
        if (n1 > n2) return false;
        int[] c1 = new int[26];
        int[] c2 = new int[26];

        for (int i=0; i<n1; i++) {
            c1[s1.charAt(i) - 'a']++;
            c2[s2.charAt(i) - 'a']++;
        }

        if (matches(c1, c2)) return true;
        for (int i=n1; i<n2; i++) {
            c2[s2.charAt(i) - 'a']++;
            c2[s2.charAt(i-n1)- 'a']--;
            if (matches(c1, c2)) return true;
        }
        return matches(c1, c2);
    }

    private boolean matches(int[] c1, int[] c2) {
        for (int i=0; i<26; i++)
            if (c1[i] != c2[i]) return false;
        return true;
    }
}