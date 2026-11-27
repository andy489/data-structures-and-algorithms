// https://leetcode.com/problems/find-the-highest-altitude/

// Solution: Prefix Sum Maximum — O(n) time, O(1) space
class Solution {
    public int largestAltitude(int[] gain) {
        int altitude = 0, maxAlt = 0;
        for (int g : gain) {
            altitude += g;
            maxAlt = Math.max(maxAlt, altitude);
        }
        return maxAlt;
    }
}
