// https://leetcode.com/problems/maximum-coins-from-k-consecutive-bags/
class Solution {
    public long maximumCoins(int[][] coins, int k) {
        Arrays.sort(coins, (a, b) -> a[0] - b[0]);
        int n = coins.length;
        // prefix sum of coins per segment: prefixCoins[i] = total coins in coins[0..i-1]
        long[] prefixCoins = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixCoins[i + 1] = prefixCoins[i] + (long)(coins[i][1] - coins[i][0] + 1) * coins[i][2];
        }

        long ans = 0;

        // Try window starting at left endpoint of each segment
        for (int i = 0; i < n; i++) {
            long L = coins[i][0];
            long R = L + k - 1;
            ans = Math.max(ans, coinsInRange(coins, prefixCoins, L, R, n));
        }

        // Try window ending at right endpoint of each segment
        for (int i = 0; i < n; i++) {
            long R = coins[i][1];
            long L = R - k + 1;
            ans = Math.max(ans, coinsInRange(coins, prefixCoins, L, R, n));
        }

        return ans;
    }

    private long coinsInRange(int[][] coins, long[] prefixCoins, long L, long R, int n) {
        // Find first segment with right >= L
        int lo = 0, hi = n;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (coins[mid][1] < L) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        int start = lo;

        // Find last segment with left <= R
        lo = 0; hi = n;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (coins[mid][0] <= R) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        int end = lo - 1;

        if (start > end) {
            return 0;
        }

        // Sum of full segments from start+1 to end-1 (0-indexed: segments start..end)
        // Partial left segment: coins[start] overlaps [L, R]
        // Partial right segment: coins[end] overlaps [L, R]
        long total = prefixCoins[end + 1] - prefixCoins[start];

        // Subtract portions outside [L, R]
        // Left segment: portion with index < L
        if (coins[start][0] < L) {
            total -= (L - coins[start][0]) * coins[start][2];
        }
        // Right segment: portion with index > R
        if (coins[end][1] > R) {
            total -= (coins[end][1] - R) * coins[end][2];
        }

        return total;
    }
}
