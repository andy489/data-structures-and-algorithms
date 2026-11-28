// https://leetcode.com/problems/count-of-sub-multisets-with-bounded-sum/

// Solution: Bounded Knapsack DP with Frequency Map — O(r * distinct) time, O(r) space
class Solution {
    public int countSubMultisets(List<Integer> nums, int l, int r) {
        final int MOD = 1_000_000_007;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.merge(x, 1, Integer::sum);
        }

        int zeroCount = freq.getOrDefault(0, 0);
        freq.remove(0);

        long[] dp = new long[r + 1];
        dp[0] = 1;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int v = entry.getKey();
            int c = entry.getValue();
            if (v > r) {
                continue;
            }
            // Bounded knapsack using prefix sum sliding window
            long[] prefix = new long[r + 2];
            for (int s = 0; s <= r; s++) {
                prefix[s + 1] = (prefix[s] + dp[s]) % MOD;
            }
            long[] ndp = new long[r + 1];
            for (int s = 0; s <= r; s++) {
                int lo = Math.max(0, s - (long) v * c > Integer.MIN_VALUE ? s - v * c : 0);
                // window: [s - v*c .. s] stepping by v
                // we want sum of dp[s], dp[s-v], dp[s-2v], ... dp[s-c*v]
                // using prefix sums over residues
                int rem = s % v;
                int hi = s / v; // number of multiples fitting
                int take = Math.min(c, hi);
                // prefix indices in multiples-of-v: positions rem, rem+v, ..., rem+hi*v
                // map: index i -> prefix[(i*v)+rem+1] - prefix[0]
                // We want prefix over {rem, rem+v, ..., rem+(hi)*v}
                // narrowed to window of size (take+1)
                // This requires a separate prefix over same-residue positions
                ndp[s] = 0; // will recalculate below
            }
            // Proper sliding window per residue class
            for (int rem = 0; rem < v && rem <= r; rem++) {
                long windowSum = 0;
                int countInWindow = 0;
                // Deque for window of size c+1
                // positions: rem, rem+v, rem+2v, ...
                // For each position p = rem + t*v, we add dp[p] and remove dp[p - (c+1)*v]
                for (int t = 0; rem + (long) t * v <= r; t++) {
                    int p = rem + t * v;
                    windowSum = (windowSum + dp[p]) % MOD;
                    if (t > c) {
                        int old = rem + (t - c - 1) * v;
                        windowSum = (windowSum - dp[old] + MOD) % MOD;
                    }
                    ndp[p] = windowSum;
                }
            }
            dp = ndp;
        }

        long ans = 0;
        for (int s = l; s <= r; s++) {
            ans = (ans + dp[s]) % MOD;
        }
        ans = ans * (zeroCount + 1) % MOD;
        return (int) ans;
    }
}
