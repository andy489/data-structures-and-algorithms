// https://leetcode.com/problems/three-consecutive-odds/

// Solution: Linear Scan — O(n) time, O(1) space
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int x : arr) {
            if ((x & 1) == 1) {
                count++;
                if (count == 3) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }
}
