// https://leetcode.com/problems/design-a-stack-with-increment-operation/

// Solution: Lazy increment — O(1) all ops, O(maxSize) space
class CustomStack {
    int[] stack, inc;
    int top, maxSize;
    public CustomStack(int maxSize) { this.maxSize = maxSize; stack = new int[maxSize]; inc = new int[maxSize]; top = 0; }
    public void push(int x) { if (top < maxSize) stack[top++] = x; }
    public int pop() {
        if (top == 0) return -1;
        top--;
        int val = stack[top] + inc[top];
        if (top > 0) inc[top-1] += inc[top];
        inc[top] = 0;
        return val;
    }
    public void increment(int k, int val) { if (top > 0) inc[Math.min(top, k) - 1] += val; }
}
