package Week1Arrays.T3TraverseFromRight;

import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temp) {
        // Approach 1: Brute force O(n*n)
        // Approach 2: Using Stack O(2n) = O(n)
        int n = temp.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i=n-1; i>=0; i--) {
            //Pop all the indices with <= current index temp
            while (!stack.isEmpty() && temp[i] >= temp[stack.peek()]) {
                stack.pop();
            }
            //If the stack is not Empty, it still has warmer temp.
            ans[i] = stack.isEmpty() ? 0 : stack.peek()-i;
            stack.push(i); // Insert current index to maintain monotonicity of stack
        }
        return ans;
    }
}
