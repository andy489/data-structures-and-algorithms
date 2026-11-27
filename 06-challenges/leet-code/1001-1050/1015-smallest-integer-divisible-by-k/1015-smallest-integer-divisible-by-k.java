// https://leetcode.com/problems/smallest-integer-divisible-by-k/

// Solution: Modular Arithmetic — O(k) time, O(1) space
class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        int rem = 0;
        for (int len = 1; len <= k; len++) {
            rem = (rem * 10 + 1) % k;
            if (rem == 0) {
                return len;
            }
        }
        return -1;
    }
}
