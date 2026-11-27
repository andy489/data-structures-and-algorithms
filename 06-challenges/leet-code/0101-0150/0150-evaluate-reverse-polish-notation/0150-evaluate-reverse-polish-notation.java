// https://leetcode.com/problems/evaluate-reverse-polish-notation/

// Solution: Stack — O(n) time, O(n) space
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String t : tokens) {
            switch (t) {
                case "+": stack.push(stack.pop() + stack.pop()); break;
                case "-": { int b = stack.pop(), a = stack.pop(); stack.push(a - b); break; }
                case "*": stack.push(stack.pop() * stack.pop()); break;
                case "/": { int b = stack.pop(), a = stack.pop(); stack.push(a / b); break; }
                default:  stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }
}
