// https://leetcode.com/problems/best-sightseeing-pair/

// Solution: One Pass — O(n) time, O(1) space
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxI = values[0], ans = 0;
        for (int j = 1; j < values.length; j++) {
            ans = Math.max(ans, maxI + values[j] - j);
            maxI = Math.max(maxI, values[j] + j);
        }
        return ans;
    }
}
