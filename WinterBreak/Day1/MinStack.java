package WinterBreak.Day1;

import java.util.Stack;

//// https://leetcode.com/problems/min-stack/

class MinStack {
    long min = Integer.MAX_VALUE;
    Stack<Long> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        long v = (long) val;
        if (stack.isEmpty()) {
            stack.push(v);
            min = v;
        } else {
            if (v<min) {
                stack.push((2*v)-min);
                min = v;
            } else 
                stack.push(v);
        }
        
    }
    
    public void pop() {
        if (stack.isEmpty())
            return;
        long popElement = (long) stack.pop();
        if (popElement < min)
            min = (2 * min) - popElement;
    }

    
    public int top() {
        if (stack.isEmpty())
            return -1;
        long topElement = (long) stack.peek(); 
        return topElement < min ? (int) min : (int)topElement;
    }
    
    public int getMin() {
        return (int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
