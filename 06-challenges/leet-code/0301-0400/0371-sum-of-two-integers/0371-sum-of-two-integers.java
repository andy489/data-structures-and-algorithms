// https://leetcode.com/problems/sum-of-two-integers/

// Solution: Bit Manipulation — O(1) time, O(1) space
class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
