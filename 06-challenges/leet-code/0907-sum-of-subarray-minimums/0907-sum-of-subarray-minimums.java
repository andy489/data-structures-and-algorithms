// https://leetcode.com/problems/sum-of-subarray-minimums/

// Solution: Monotonic Stack — O(n) time, O(n) space
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007, n = arr.length;
        int[] left = new int[n], right = new int[n];
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            while (top >= 0 && arr[stack[top]] >= arr[i]) {
                top--;
            }
            left[i] = top < 0 ? i + 1 : i - stack[top];
            stack[++top] = i;
        }
        top = -1;
        for (int i = n - 1; i >= 0; i--) {
            while (top >= 0 && arr[stack[top]] > arr[i]) {
                top--;
            }
            right[i] = top < 0 ? n - i : stack[top] - i;
            stack[++top] = i;
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long) arr[i] * left[i] * right[i]) % MOD;
        }
        return (int) ans;
    }
}
