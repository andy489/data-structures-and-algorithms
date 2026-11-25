// https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/

// Solution: Prefix Sum + Running Max — O(n) time, O(n) space
class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        return Math.max(helper(pre, firstLen, secondLen), helper(pre, secondLen, firstLen));
    }

    private int helper(int[] pre, int l, int r) {
        int res = 0, maxL = 0;
        for (int i = l + r; i <= pre.length - 1; i++) {
            maxL = Math.max(maxL, pre[i - r] - pre[i - r - l]);
            res = Math.max(res, maxL + pre[i] - pre[i - r]);
        }
        return res;
    }
}
