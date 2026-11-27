// https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/

// Solution: Sliding Window + Left/Right Best Index Arrays — O(n) time, O(n) space
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length, m = n - k + 1;
        int[] sums = new int[m];
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        sums[0] = windowSum;
        for (int i = 1; i < m; i++) {
            windowSum += nums[i + k - 1] - nums[i - 1];
            sums[i] = windowSum;
        }
        int[] left = new int[m];
        int best = 0;
        for (int i = 0; i < m; i++) {
            if (sums[i] > sums[best]) {
                best = i;
            }
            left[i] = best;
        }
        int[] right = new int[m];
        best = m - 1;
        for (int i = m - 1; i >= 0; i--) {
            if (sums[i] >= sums[best]) {
                best = i;
            }
            right[i] = best;
        }
        int[] result = new int[]{-1, -1, -1};
        int maxSum = 0;
        for (int mid = k; mid < m - k; mid++) {
            int l = left[mid - k], r = right[mid + k];
            int total = sums[l] + sums[mid] + sums[r];
            if (total > maxSum) {
                maxSum = total;
                result = new int[]{l, mid, r};
            }
        }
        return result;
    }
}
