// https://leetcode.com/problems/maximum-width-ramp/

// Solution: Monotonic Stack + Right Scan — O(n) time, O(n) space
class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        int ans = 0;
        for (int j = n - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                ans = Math.max(ans, j - stack.pop());
            }
        }
        return ans;
    }
}
