// https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/
class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[] dp = new int[k + 1];
        for (List<Integer> pile : piles) {
            int[] prefix = new int[pile.size() + 1];
            for (int i = 0; i < pile.size(); i++) {
                prefix[i + 1] = prefix[i] + pile.get(i);
            }
            for (int j = k; j >= 0; j--) {
                for (int take = 1; take <= Math.min(pile.size(), j); take++) {
                    dp[j] = Math.max(dp[j], dp[j - take] + prefix[take]);
                }
            }
        }
        return dp[k];
    }
}
