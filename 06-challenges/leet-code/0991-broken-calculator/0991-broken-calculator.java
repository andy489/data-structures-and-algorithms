// https://leetcode.com/problems/broken-calculator/

// Solution: Work Backwards — O(log target) time, O(1) space
class Solution {
    public int brokenCalc(int startValue, int target) {
        int ops = 0;
        while (target > startValue) {
            if (target % 2 == 1) { target++; }
            else { target /= 2; }
            ops++;
        }
        return ops + startValue - target;
    }
}
