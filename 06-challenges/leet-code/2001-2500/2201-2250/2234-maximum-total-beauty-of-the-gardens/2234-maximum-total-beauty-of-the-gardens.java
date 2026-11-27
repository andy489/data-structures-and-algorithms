// https://leetcode.com/problems/maximum-total-beauty-of-the-gardens/

class Solution {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        int n = flowers.length;
        Arrays.sort(flowers);

        // Cap at target
        for (int i = 0; i < n; i++) {
            flowers[i] = Math.min(flowers[i], target);
        }

        // Prefix sum of flowers
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + flowers[i];
        }

        long ans = 0;
        // Cost to complete the last c gardens (from right)
        // Try complete = 0..n
        long costToComplete = 0;
        // We'll iterate c from n down to 0
        // For c complete gardens: they are the rightmost c gardens
        // We need them all to reach target
        // But some may already be >= target

        // Recompute: iterate number of complete gardens from 0 to n
        // complete gardens are always chosen from those closest to target
        // After sort, it's cheapest to complete the ones with the most flowers first (rightmost)

        long remaining = newFlowers;
        for (int c = 0; c <= n; c++) {
            if (c > 0) {
                // Add cost to make flowers[n - c] reach target
                long cost = target - flowers[n - c];
                if (cost < 0) {
                    cost = 0;
                }
                remaining -= cost;
            }
            if (remaining < 0) {
                break;
            }

            // Among the first (n - c) gardens, maximize min using remaining flowers
            int incomplete = n - c;
            long minVal = 0;
            if (incomplete > 0) {
                // Binary search for the highest min we can achieve
                int lo = 0, hi = target - 1;
                while (lo < hi) {
                    int mid = (lo + hi + 1) / 2;
                    // Cost to raise all first `incomplete` gardens to at least mid
                    // For each garden i (0..incomplete-1), cost = max(0, mid - flowers[i])
                    // Find leftmost index where flowers[idx] >= mid
                    int idx = lowerBound(flowers, 0, incomplete, mid);
                    // Gardens 0..idx-1 need topping up
                    long needed = (long) mid * idx - prefix[idx];
                    if (needed <= remaining) {
                        lo = mid;
                    } else {
                        hi = mid - 1;
                    }
                }
                minVal = lo;
            }

            long beauty = (long) c * full + minVal * partial;
            ans = Math.max(ans, beauty);
        }

        return ans;
    }

    private int lowerBound(int[] arr, int from, int to, int val) {
        int lo = from, hi = to;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] < val) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
