// https://leetcode.com/problems/rotated-digits/

// Solution: Digit Check — O(n log n) time, O(log n) space
class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isGood(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isGood(int x) {
        boolean different = false;
        while (x > 0) {
            int d = x % 10;
            if (d == 3 || d == 4 || d == 7) {
                return false;
            }
            if (d == 2 || d == 5 || d == 6 || d == 9) {
                different = true;
            }
            x /= 10;
        }
        return different;
    }
}
