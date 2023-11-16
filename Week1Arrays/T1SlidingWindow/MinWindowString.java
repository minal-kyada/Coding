package Week1Arrays.T1SlidingWindow;

// https://leetcode.com/problems/minimum-window-substring/submissions/1093049139/
// https://www.youtube.com/watch?v=3Bp3OVD1EGc

class Solution {
    public String minWindow(String s, String t) {
        // Approach SLiding Window problem

        int ns = s.length();
        int ts = t.length();

        //1. BaseCasecheck
        if (ts > ns)
            return "";

        //2. Populate array
        int[] map = new int[128];
        for (int i=0; i<ts; i++)
            map[t.charAt(i)]++;

        int requiredCount = ts;
        int start = 0, end = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int minStart = 0;
        //3. check occurence of t in map
        while (end < ns) {
            char c = s.charAt(end);
            if (map[c] > 0)
                requiredCount--;
            map[c]--;

            //4. Shrink the window
            while (requiredCount == 0) {
                int currWindowSize = end-start+1;
                if (minWindowSize > currWindowSize) {
                    minWindowSize = currWindowSize;
                    minStart = start;
                }
                final char c2 = s.charAt(start);
                map[c2]++;
                if (map[c2] > 0) 
                    requiredCount++;
                start++;
            }
            end++;
        }
        //Return min window size string
        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart+minWindowSize);
    }
}