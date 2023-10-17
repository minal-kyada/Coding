// https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/description/?envType=daily-question&envId=2023-10-15
// Refer https://www.youtube.com/watch?v=NqhmQQlVhTE

class Solution {

    int mod = 1000000007;

    public int numWays(int steps, int arrLen) {
        arrLen = Math.min(arrLen, steps);
        int[][] dp = new int[arrLen][steps+1];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);
        return move(0, steps, arrLen, dp);
    }
    
    private int move(int idx, int steps, int arrLen, int[][] dp) {
        if (idx < 0 || idx >= arrLen)
            return 0;

        if (steps == 0) {
            return (idx == 0) ? 1 : 0;
        }

        if (dp[idx][steps] != -1)
            return dp[idx][steps];

        int ans = move(idx, steps-1, arrLen, dp); //STAY
        ans = (ans+ move(idx-1, steps-1, arrLen, dp)) % mod; //LEFT
        ans = (ans+ move(idx+1, steps-1, arrLen, dp)) % mod; //RIGHT

        return dp[idx][steps] = ans;

    }
}



