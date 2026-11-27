// https://leetcode.com/problems/sorted-gcd-pair-queries/

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxVal = 0;
        for (int x : nums) {
            maxVal = Math.max(maxVal, x);
        }
        long[] cnt = new long[maxVal + 1];
        for (int x : nums) {
            cnt[x]++;
        }
        // cnt[g] = number of elements divisible by g
        for (int g = 1; g <= maxVal; g++) {
            for (int mult = 2 * g; mult <= maxVal; mult += g) {
                cnt[g] += cnt[mult];
            }
        }
        // pairs[g] = number of pairs with GCD exactly g (inclusion-exclusion)
        long[] pairs = new long[maxVal + 1];
        for (int g = maxVal; g >= 1; g--) {
            pairs[g] = cnt[g] * (cnt[g] - 1) / 2;
            for (int mult = 2 * g; mult <= maxVal; mult += g) {
                pairs[g] -= pairs[mult];
            }
        }
        // prefix sum
        long[] prefix = new long[maxVal + 2];
        for (int g = 1; g <= maxVal; g++) {
            prefix[g] = prefix[g - 1] + pairs[g];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long q = queries[i];
            int lo = 1, hi = maxVal;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (prefix[mid] > q) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            ans[i] = lo;
        }
        return ans;
    }
}
