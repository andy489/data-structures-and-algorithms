// https://leetcode.com/problems/airplane-seat-assignment-probability/

// Solution: Mathematical Insight — O(1) time, O(1) space
// Solution: Mathematical Insight — O(1) time, O(1) space
class Solution {
    public double nthPersonGetsNthSeat(int n) {
        return n == 1 ? 1.0 : 0.5;
    }
}
