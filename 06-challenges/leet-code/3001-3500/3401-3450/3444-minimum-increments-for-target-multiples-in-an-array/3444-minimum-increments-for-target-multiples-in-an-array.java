// https://leetcode.com/problems/minimum-increments-for-target-multiples-in-an-array/
class Solution {
    public long minimumIncrements(int[] nums, int[] target) {
        int t = target.length;
        int masks = 1 << t;
        long[] lcms = new long[masks];
        lcms[0] = 1;
        for (int mask = 1; mask < masks; mask++) {
            int bit = Integer.numberOfTrailingZeros(mask);
            lcms[mask] = lcm(lcms[mask ^ (1 << bit)], target[bit]);
        }
        long[] dp = new long[masks];
        for (int i = 1; i < masks; i++) {
            dp[i] = Long.MAX_VALUE / 2;
        }
        for (int num : nums) {
            long[] ndp = dp.clone();
            for (int prev = 0; prev < masks; prev++) {
                if (dp[prev] == Long.MAX_VALUE / 2) {
                    continue;
                }
                for (int add = 1; add < masks; add++) {
                    if ((prev & add) != 0) {
                        continue;
                    }
                    long lcmVal = lcms[add];
                    long rem = num % lcmVal;
                    long cost = (rem == 0) ? 0 : lcmVal - rem;
                    int next = prev | add;
                    if (dp[prev] + cost < ndp[next]) {
                        ndp[next] = dp[prev] + cost;
                    }
                }
            }
            dp = ndp;
        }
        return dp[masks - 1];
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}
