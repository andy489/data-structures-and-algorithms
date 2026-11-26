// https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/

// Solution: Prefix Sum Min — O(n) time, O(1) space
class Solution {
    public int minStartValue(int[] nums) {
        int prefix = 0, minPre = 0;
        for (int n : nums) { prefix += n; minPre = Math.min(minPre, prefix); }
        return Math.max(1, 1 - minPre);
    }
}
