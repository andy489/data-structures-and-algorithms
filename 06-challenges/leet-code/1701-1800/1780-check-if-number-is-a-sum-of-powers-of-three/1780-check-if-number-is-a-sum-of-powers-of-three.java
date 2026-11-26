// https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/

// Solution: Base-3 Representation — O(log n) time, O(1) space
class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
