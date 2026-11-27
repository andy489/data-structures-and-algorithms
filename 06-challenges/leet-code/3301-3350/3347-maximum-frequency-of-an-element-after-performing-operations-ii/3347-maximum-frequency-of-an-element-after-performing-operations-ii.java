// https://leetcode.com/problems/maximum-frequency-of-an-element-after-performing-operations-ii/

// Solution: Sort + Binary Search — O(n log n) time, O(1) space
class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            long v = nums[i];
            int lo = lowerBound(nums, v - k);
            int hi = upperBound(nums, v + k);
            int inRange = hi - lo;
            int exact = upperBound(nums, v) - lowerBound(nums, v);
            int needOps = inRange - exact;
            ans = Math.max(ans, exact + Math.min(needOps, numOperations));
        }
        return ans;
    }

    private int lowerBound(int[] a, long val) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a[mid] < val) lo = mid + 1; else hi = mid;
        }
        return lo;
    }

    private int upperBound(int[] a, long val) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a[mid] <= val) lo = mid + 1; else hi = mid;
        }
        return lo;
    }
}
