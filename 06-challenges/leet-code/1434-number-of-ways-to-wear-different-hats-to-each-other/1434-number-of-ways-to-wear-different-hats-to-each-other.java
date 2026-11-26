// https://leetcode.com/problems/number-of-ways-to-wear-different-hats-to-each-other/

// Solution: Bitmask DP — O(2^n * 40) time, O(2^n) space
class Solution {
    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();
        long MOD = 1_000_000_007;
        Map<Integer, List<Integer>> hatPeople = new HashMap<>();
        for (int p = 0; p < n; p++)
            for (int h : hats.get(p))
                hatPeople.computeIfAbsent(h, x -> new ArrayList<>()).add(p);
        long[] dp = new long[1 << n];
        dp[0] = 1;
        for (int h = 1; h <= 40; h++) {
            for (int mask = (1<<n)-1; mask >= 0; mask--) {
                for (int p : hatPeople.getOrDefault(h, Collections.emptyList())) {
                    if ((mask & (1<<p)) == 0)
                        dp[mask|(1<<p)] = (dp[mask|(1<<p)] + dp[mask]) % MOD;
                }
            }
        }
        return (int) dp[(1<<n)-1];
    }
}
