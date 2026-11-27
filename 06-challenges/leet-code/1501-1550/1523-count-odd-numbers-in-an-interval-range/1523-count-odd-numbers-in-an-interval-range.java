// https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/

// Solution: Math Prefix Count — O(1) time, O(1) space
class Solution {
    public int countOdds(int low, int high) {
        int count = (high - low) / 2;
        if (low % 2 == 1 || high % 2 == 1) {
            count++;
        }
        return count;
    }
}
