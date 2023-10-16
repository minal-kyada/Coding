// https://leetcode.com/problems/ransom-note/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        //1. Using Hashmap
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : magazine.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        for (Character c : ransomNote.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c)-1);
            } else {
                return false;
            }
        }
        return true;

        //2. Using normal array

        if (ransomNote.length() > magazine.length()) return false;
        int[] alpha = new int[26];

        for (char c : magazine.toCharArray())
            alpha[c-'a']++;

        for (char c : ransomNote.toCharArray()) {
            if (alpha[c-'a'] == 0) return false;
            alpha[c-'a']--;
        }

        return true;
    }
}