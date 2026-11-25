// https://leetcode.com/problems/soup-servings/

// Solution: Memoized DP — O(n²/625) time, O(n²/625) space
class Solution {
    private Map<Long, Double> memo = new HashMap<>();

    public double soupServings(int n) {
        if (n >= 4800) {
            return 1.0;
        }
        return dp((n + 24) / 25, (n + 24) / 25);
    }

    private double dp(int a, int b) {
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (a <= 0) {
            return 1.0;
        }
        if (b <= 0) {
            return 0.0;
        }
        long key = (long) a * 200 + b;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        double val = 0.25 * (dp(a - 4, b) + dp(a - 3, b - 1) + dp(a - 2, b - 2) + dp(a - 1, b - 3));
        memo.put(key, val);
        return val;
    }
}
