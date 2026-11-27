// https://leetcode.com/problems/maximum-erasure-value/

// Solution: Sliding Window — O(n) time, O(n) space
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int[] lastSeen = new int[10001];
        Arrays.fill(lastSeen, -1);
        int maxSum = 0, windowSum = 0, l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (lastSeen[nums[r]] >= l) {
                while (l <= lastSeen[nums[r]]) {
                    windowSum -= nums[l++];
                }
            }
            windowSum += nums[r];
            lastSeen[nums[r]] = r;
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
}
