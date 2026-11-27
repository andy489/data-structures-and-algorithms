// https://leetcode.com/problems/clumsy-factorial/

// Solution: Stack Simulation — O(n) time, O(n) space
class Solution {
    public int clumsy(int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(n);
        n--;
        int op = 0;
        while (n > 0) {
            if (op == 0) {
                stack.push(stack.pop() * n);
            } else if (op == 1) {
                stack.push(stack.pop() / n);
            } else if (op == 2) {
                stack.push(n);
            } else {
                stack.push(-n);
            }
            op = (op + 1) % 4;
            n--;
        }
        int result = 0;
        for (int v : stack) {
            result += v;
        }
        return result;
    }
}
