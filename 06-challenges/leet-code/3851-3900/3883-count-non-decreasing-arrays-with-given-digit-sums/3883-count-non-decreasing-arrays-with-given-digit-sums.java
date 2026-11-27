// https://leetcode.com/problems/count-non-decreasing-arrays-with-given-digit-sums/

class Solution {
    private static final int MOD = 1_000_000_007;

    private int digitSum(int x) {
        int s = 0;
        while (x > 0) {
            s += x % 10;
            x /= 10;
        }
        return s;
    }

    public int countArrays(int[] digitSum) {
        int n = digitSum.length;
        // precompute numbers by digit sum
        List<List<Integer>> bySum = new ArrayList<>();
        for (int s = 0; s <= 50; s++) {
            bySum.add(new ArrayList<>());
        }
        for (int x = 0; x <= 5000; x++) {
            int s = digitSum(x);
            if (s <= 50) {
                bySum.get(s).add(x);
            }
        }

        List<Integer> cur = bySum.get(digitSum[0]);
        long[] dp = new long[cur.size()];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            List<Integer> prev = cur;
            long[] prevDp = dp;
            // prefix sum of prevDp
            long[] prefix = new long[prev.size() + 1];
            for (int j = 0; j < prev.size(); j++) {
                prefix[j + 1] = (prefix[j] + prevDp[j]) % MOD;
            }

            cur = bySum.get(digitSum[i]);
            dp = new long[cur.size()];
            for (int j = 0; j < cur.size(); j++) {
                int val = cur.get(j);
                // binary search: count prev values <= val
                int lo = 0, hi = prev.size();
                while (lo < hi) {
                    int mid = (lo + hi) / 2;
                    if (prev.get(mid) <= val) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }
                dp[j] = prefix[lo];
            }
        }

        long ans = 0;
        for (long v : dp) {
            ans = (ans + v) % MOD;
        }
        return (int) ans;
    }
}
