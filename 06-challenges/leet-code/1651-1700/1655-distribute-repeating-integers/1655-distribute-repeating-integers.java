// https://leetcode.com/problems/distribute-repeating-integers/

// Solution: Bitmask DP on Customer Subsets — O(50 * 3^m) time, O(2^m) space
class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int x : nums) {
            countMap.merge(x, 1, Integer::sum);
        }
        int[] freqs = new int[countMap.size()];
        int idx = 0;
        for (int v : countMap.values()) {
            freqs[idx++] = v;
        }
        Arrays.sort(freqs);

        int m = quantity.length;
        int total = 1 << m;
        int[] need = new int[total];
        for (int mask = 1; mask < total; mask++) {
            for (int j = 0; j < m; j++) {
                if ((mask >> j & 1) == 1) {
                    need[mask] = need[mask ^ (1 << j)] + quantity[j];
                    break;
                }
            }
        }

        boolean[] dp = new boolean[total];
        dp[0] = true;

        for (int f : freqs) {
            // iterate satisfied masks in reverse to avoid reuse within same freq
            for (int s = total - 1; s >= 0; s--) {
                if (!dp[s]) {
                    continue;
                }
                int complement = (total - 1) ^ s;
                for (int t = complement; t > 0; t = (t - 1) & complement) {
                    if (need[t] <= f) {
                        dp[s | t] = true;
                    }
                }
            }
        }
        return dp[total - 1];
    }
}
