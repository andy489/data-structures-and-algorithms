// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

// Solution: Bit counting — O(log n) time, O(1) space
class Solution {
    public int numberOfSteps(int num) {
        return num == 0 ? 0 : Integer.bitCount(num) + Integer.SIZE - Integer.numberOfLeadingZeros(num) - 1;
    }
}
