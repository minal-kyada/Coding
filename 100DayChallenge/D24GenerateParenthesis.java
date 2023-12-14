// https://leetcode.com/problems/generate-parentheses/description/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, String currStr, int open, int close, int max) {
        // Base condition
        if (currStr.length() == max*2) {
            res.add(currStr);
            return;
        }
        //Decision making
        if (open<max) backtrack(res, currStr+"(", open+1, close, max);
        if (close<open) backtrack(res, currStr+")", open, close+1, max);
    }
}

