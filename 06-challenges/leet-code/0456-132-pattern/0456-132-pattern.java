// https://leetcode.com/problems/132-pattern/

// Solution: Monotonic Stack (Right to Left) — O(n) time, O(n) space
class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int third = Integer.MIN_VALUE; // the "2" in 132 (middle value)
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < third) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                third = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
