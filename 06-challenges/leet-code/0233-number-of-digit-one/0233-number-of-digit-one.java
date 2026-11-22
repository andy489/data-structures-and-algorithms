// https://leetcode.com/problems/number-of-digit-one/

// Solution: Digit DP — O(log n) time, O(1) space
class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        for (long factor = 1; factor <= n; factor *= 10) {
            long higher = n / (factor * 10);
            long current = (n / factor) % 10;
            long lower = n % factor;
            if (current == 0) {
                count += higher * factor;
            } else if (current == 1) {
                count += higher * factor + lower + 1;
            } else {
                count += (higher + 1) * factor;
            }
        }
        return count;
    }
}
