// https://leetcode.com/problems/validate-stack-sequences/

// Solution: Simulation — O(n) time, O(n) space
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int[] stack = new int[pushed.length];
        int top = -1, j = 0;
        for (int x : pushed) {
            stack[++top] = x;
            while (top >= 0 && stack[top] == popped[j]) {
                top--;
                j++;
            }
        }
        return top == -1;
    }
}
