// https://leetcode.com/problems/minimum-operations-to-make-array-parity-alternating/

class Solution {
    public int[] minOperations(int[] nums) {
        int n = nums.length;
        // Count mismatches for pattern starting with even (0) and starting with odd (1)
        int mismatch0 = 0, mismatch1 = 0;
        for (int i = 0; i < n; i++) {
            int parity = Math.abs(nums[i]) % 2;
            int want0 = i % 2; // pattern0: even at even idx, odd at odd idx -> want parity == i%2
            if (parity != want0) {
                mismatch0++;
            }
            int want1 = 1 - i % 2; // pattern1: odd at even idx, even at odd idx
            if (parity != want1) {
                mismatch1++;
            }
        }
        int minOps = Math.min(mismatch0, mismatch1);
        int startPattern = mismatch0 <= mismatch1 ? 0 : 1;

        // Compute min range after adjustments
        long minVal = Long.MAX_VALUE, maxVal = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int want = (startPattern == 0) ? (i % 2) : (1 - i % 2);
            int parity = Math.abs(nums[i]) % 2;
            long v = nums[i];
            if (parity != want) {
                // Need to change parity: pick +1 or -1 to minimize range
                // We'll compute range for both choices and take optimal
                // Actually, we just need range; track all possible values
                long v1 = v + 1, v2 = v - 1;
                // Pick whichever is closer to existing range (greedy approximation):
                // For a true optimal we'd need more complex DP; but since only one of +1/-1 changes parity,
                // both options change parity. We pick the one minimizing max-min.
                // Track both endpoints:
                minVal = Math.min(minVal, Math.min(v1, v2));
                maxVal = Math.max(maxVal, Math.max(v1, v2));
            } else {
                minVal = Math.min(minVal, v);
                maxVal = Math.max(maxVal, v);
            }
        }

        // Recompute more carefully: for each changed element, pick +1 or -1
        // A proper approach: compute global min/max over best choices
        long lo = Long.MIN_VALUE, hi = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int want = (startPattern == 0) ? (i % 2) : (1 - i % 2);
            int parity = Math.abs(nums[i]) % 2;
            long v = nums[i];
            if (parity != want) {
                // Can choose v+1 or v-1
                lo = Math.max(lo, Math.min(v + 1, v - 1));
                hi = Math.min(hi, Math.max(v + 1, v - 1));
            } else {
                lo = Math.max(lo, v);
                hi = Math.min(hi, v);
            }
        }

        // Recompute range: max - min across array with optimal choices
        long rangeMin = Long.MAX_VALUE, rangeMax = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int want = (startPattern == 0) ? (i % 2) : (1 - i % 2);
            int parity = Math.abs(nums[i]) % 2;
            long v = nums[i];
            if (parity != want) {
                long chosen = (Math.abs(v + 1) < Math.abs(v - 1)) ? v + 1 : v - 1;
                rangeMin = Math.min(rangeMin, Math.min(v + 1, v - 1));
                rangeMax = Math.max(rangeMax, Math.max(v + 1, v - 1));
            } else {
                rangeMin = Math.min(rangeMin, v);
                rangeMax = Math.max(rangeMax, v);
            }
        }

        return new int[]{minOps, (int)(rangeMax - rangeMin)};
    }
}
