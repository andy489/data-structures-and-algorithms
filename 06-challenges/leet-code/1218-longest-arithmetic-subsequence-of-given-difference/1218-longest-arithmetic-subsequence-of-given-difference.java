// https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/

// Solution: Dynamic Programming with HashMap — O(n) time, O(n) space
// Solution: DP with HashMap — O(n) time, O(n) space
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int res = 1;
        for (int x : arr) {
            int len = dp.getOrDefault(x - difference, 0) + 1;
            dp.put(x, len);
            res = Math.max(res, len);
        }
        return res;
    }
}
