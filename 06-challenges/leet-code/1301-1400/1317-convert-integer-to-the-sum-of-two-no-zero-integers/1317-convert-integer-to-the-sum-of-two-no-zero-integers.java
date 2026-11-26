// https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/

// Solution: Brute Force — O(n log n) time, O(1) space
class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int a = 1; a < n; a++) {
            int b = n - a;
            if (!hasZero(a) && !hasZero(b)) return new int[]{a, b};
        }
        return new int[]{};
    }
    private boolean hasZero(int x) {
        while (x > 0) {
            if (x % 10 == 0) return true;
            x /= 10;
        }
        return false;
    }
}
