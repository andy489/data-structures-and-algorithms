// https://leetcode.com/problems/maximum-points-in-an-archery-competition/
class Solution {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int bestMask = 0;
        int bestScore = 0;
        for (int mask = 0; mask < (1 << 11); mask++) {
            int score = 0;
            int arrows = 0;
            for (int k = 1; k <= 11; k++) {
                if ((mask & (1 << k)) != 0) {
                    score += k;
                    arrows += aliceArrows[k] + 1;
                }
            }
            if (arrows <= numArrows && score > bestScore) {
                bestScore = score;
                bestMask = mask;
            }
        }
        int[] bob = new int[12];
        int used = 0;
        for (int k = 1; k <= 11; k++) {
            if ((bestMask & (1 << k)) != 0) {
                bob[k] = aliceArrows[k] + 1;
                used += bob[k];
            }
        }
        bob[0] = numArrows - used;
        return bob;
    }
}
