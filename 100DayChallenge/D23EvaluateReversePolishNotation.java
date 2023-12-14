// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int n1, n2;
        for (int i=0; i<tokens.length; i++) {
            switch(tokens[i]) {
                case "+" -> stack.push(stack.pop()+stack.pop());
                case "*" -> stack.push(stack.pop()*stack.pop());
                case "-" -> {
                    n2 = stack.pop();
                    n1 = stack.pop(); 
                    stack.push(n1-n2);
                }
                case "/" -> {
                    n2 = stack.pop();
                    n1 = stack.pop();
                    stack.push(n1/n2);
                }
                default -> stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}