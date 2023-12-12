package WinterBreak.Day2;

//https://leetcode.com/problems/sliding-window-maximum/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //1. for new element nums[i], make space as window size can't exceed k
        //2. pop all small elements than curr nums[i]
        //3. push i in deque for nums[i]
        //4. if i>= k-1 then deque.front has our ans for that window size

        int n = nums.length, i=0;
        Deque<Integer> deque = new ArrayDeque<> ();
        int[] result = new int[n-k+1];
        for (; i<n; i++) {
            //step1: make space for nums[i]
            while (deque.size()>0 && deque.getFirst() <= i-k)
                deque.pollFirst();
            //step2: pop all small elements than curr nums[i]
            while (deque.size()>0 && nums[i] > nums[deque.getLast()])
                deque.pollLast();
            //step3: push i in deque
            deque.addLast(i);
            //step4: deque.front is the ans if i>=k-1
            if (i >= k-1){
                result[i-k+1]=nums[deque.getFirst()];
            }
        }
        return result;
    }
}