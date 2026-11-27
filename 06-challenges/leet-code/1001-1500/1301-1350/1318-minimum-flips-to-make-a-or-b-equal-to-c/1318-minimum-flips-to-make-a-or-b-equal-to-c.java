// https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/

// Solution: Bit manipulation — O(log n) time, O(1) space
class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        while (a > 0 || b > 0 || c > 0) {
            int ba = a & 1, bb = b & 1, bc = c & 1;
            if (bc == 1) { if (ba == 0 && bb == 0) flips++; }
            else { flips += ba + bb; }
            a >>= 1; b >>= 1; c >>= 1;
        }
        return flips;
    }
}
