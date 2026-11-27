// https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/

// Solution: Greedy Check — O(n) time, O(1) space
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int ans = check(tops[0], tops, bottoms);
        if (ans != -1) {
            return ans;
        }
        return check(bottoms[0], tops, bottoms);
    }

    private int check(int v, int[] tops, int[] bottoms) {
        int rotTop = 0, rotBot = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != v && bottoms[i] != v) {
                return -1;
            }
            if (tops[i] != v) {
                rotTop++;
            }
            if (bottoms[i] != v) {
                rotBot++;
            }
        }
        return Math.min(rotTop, rotBot);
    }
}
