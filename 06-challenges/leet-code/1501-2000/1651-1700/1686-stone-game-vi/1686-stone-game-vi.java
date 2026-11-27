// https://leetcode.com/problems/stone-game-vi/

// Solution: Greedy Sort by Combined Value — O(n log n) time, O(n) space
class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[][] combined = new int[n][2];
        for (int i = 0; i < n; i++) {
            combined[i][0] = aliceValues[i] + bobValues[i];
            combined[i][1] = i;
        }
        Arrays.sort(combined, (a, b) -> b[0] - a[0]);
        int aliceScore = 0, bobScore = 0;
        for (int t = 0; t < n; t++) {
            int idx = combined[t][1];
            if (t % 2 == 0) {
                aliceScore += aliceValues[idx];
            } else {
                bobScore += bobValues[idx];
            }
        }
        return Integer.compare(aliceScore, bobScore);
    }
}
