// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/

// Solution: Monotonic Deques Sliding Window — O(n) time, O(n) space
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDq = new ArrayDeque<>(), minDq = new ArrayDeque<>();
        int left = 0, ans = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!maxDq.isEmpty() && nums[maxDq.peekLast()] <= nums[right]) maxDq.pollLast();
            while (!minDq.isEmpty() && nums[minDq.peekLast()] >= nums[right]) minDq.pollLast();
            maxDq.offerLast(right); minDq.offerLast(right);
            while (nums[maxDq.peekFirst()] - nums[minDq.peekFirst()] > limit) {
                left++;
                if (maxDq.peekFirst() < left) maxDq.pollFirst();
                if (minDq.peekFirst() < left) minDq.pollFirst();
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
