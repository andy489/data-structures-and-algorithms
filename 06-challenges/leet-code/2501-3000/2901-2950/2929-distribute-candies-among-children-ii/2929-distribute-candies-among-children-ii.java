// https://leetcode.com/problems/distribute-candies-among-children-ii/

// Solution: Inclusion-Exclusion — O(1) time, O(1) space
class Solution {
    private long f(long x) {
        if (x < 0) {
            return 0;
        }
        return (x + 1) * (x + 2) / 2;
    }

    public long distributeCandies(int n, int limit) {
        return f(n) - 3 * f(n - limit - 1) + 3 * f(n - 2L * (limit + 1)) - f(n - 3L * (limit + 1));
    }
}
