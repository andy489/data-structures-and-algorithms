// https://leetcode.com/problems/get-equal-substrings-within-budget/

// Solution: Sliding Window — O(n) time, O(n) space
// Solution: Sliding Window — O(n) time, O(n) space
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length(), l = 0, cost = 0, res = 0;
        for (int r = 0; r < n; r++) {
            cost += Math.abs(s.charAt(r) - t.charAt(r));
            while (cost > maxCost) cost -= Math.abs(s.charAt(l++) - t.charAt(l - 1));
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
