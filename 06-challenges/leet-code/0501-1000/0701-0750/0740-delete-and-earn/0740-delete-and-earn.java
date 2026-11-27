// https://leetcode.com/problems/delete-and-earn/

// Solution: House Robber DP — O(n + max) time, O(max) space
class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int n : nums) {
            maxVal = Math.max(maxVal, n);
        }
        int[] earn = new int[maxVal + 1];
        for (int n : nums) {
            earn[n] += n;
        }
        int prev2 = 0, prev1 = 0;
        for (int i = 1; i <= maxVal; i++) {
            int cur = Math.max(prev1, prev2 + earn[i]);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}
