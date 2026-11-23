// https://leetcode.com/problems/next-greater-element-ii/

// Solution: Monotonic Stack — O(n) time, O(n) space
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * n; i++) {
            int val = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < val) {
                result[stack.pop()] = val;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return result;
    }
}
