// https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/

// Solution: Memoized Recursion — O(log^2 n) time, O(log^2 n) space
class Solution {
    private java.util.Map<Integer, Integer> memo = new java.util.HashMap<>();

    public int minDays(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int res = 1 + Math.min(
            n % 2 + minDays(n / 2),
            n % 3 + minDays(n / 3)
        );
        memo.put(n, res);
        return res;
    }
}
