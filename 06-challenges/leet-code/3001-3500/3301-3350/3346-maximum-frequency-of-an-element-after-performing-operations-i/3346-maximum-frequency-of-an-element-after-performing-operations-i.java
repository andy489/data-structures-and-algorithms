// https://leetcode.com/problems/maximum-frequency-of-an-element-after-performing-operations-i/

// Solution: Sort + Binary Search — O(n log n) time, O(1) space
class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            // Skip duplicates — same target value already processed
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int v = nums[i];
            // Count elements in [v-k, v+k] using binary search
            int lo = lowerBound(nums, v - k);
            int hi = upperBound(nums, v + k);
            int inRange = hi - lo;
            // Count exact matches
            int exact = upperBound(nums, v) - lowerBound(nums, v);
            // Elements that need operations = inRange - exact
            int needOps = inRange - exact;
            ans = Math.max(ans, exact + Math.min(needOps, numOperations));
        }
        return ans;
    }

    private int lowerBound(int[] a, int val) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a[mid] < val) lo = mid + 1; else hi = mid;
        }
        return lo;
    }

    private int upperBound(int[] a, int val) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a[mid] <= val) lo = mid + 1; else hi = mid;
        }
        return lo;
    }
}
