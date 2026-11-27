// https://leetcode.com/problems/nth-digit/

// Solution: Math — O(log n) time, O(1) space
class Solution {
    public int findNthDigit(int n) {
        long digits = 1, start = 1, count = 9;
        while (n > digits * count) {
            n -= digits * count;
            digits++;
            start *= 10;
            count *= 10;
        }
        long num = start + (n - 1) / digits;
        int digitIndex = (int) ((n - 1) % digits);
        return Long.toString(num).charAt(digitIndex) - '0';
    }
}
