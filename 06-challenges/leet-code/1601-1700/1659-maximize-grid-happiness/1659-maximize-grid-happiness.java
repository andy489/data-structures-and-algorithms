// https://leetcode.com/problems/maximize-grid-happiness/

// Solution: DP with Row State Encoding — O(m * n * 3^n * in * ex) time
class Solution {
    private static final int INTRO_BASE = 120;
    private static final int EXTRO_BASE = 40;
    private static final int INTRO_COST = -30;
    private static final int EXTRO_GAIN = 20;

    private int m, n;
    private int[][][][] memo;
    // prevRow encoded as base-3 int of length n: digit[i] in {0,1,2}

    private int interaction(int t1, int t2) {
        if (t1 == 0 || t2 == 0) {
            return 0;
        }
        int my = (t1 == 1) ? INTRO_COST : EXTRO_GAIN;
        int nb = (t2 == 1) ? INTRO_COST : EXTRO_GAIN;
        return my + nb;
    }

    // powers[i] = 3^i
    private int[] powers;

    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        this.m = m;
        this.n = n;
        powers = new int[n + 1];
        powers[0] = 1;
        for (int i = 1; i <= n; i++) {
            powers[i] = powers[i - 1] * 3;
        }
        int states = powers[n];
        memo = new int[m * n][introvertsCount + 1][extrovertsCount + 1][states];
        for (int[][][] a : memo) {
            for (int[][] b : a) {
                for (int[] c : b) {
                    Arrays.fill(c, Integer.MIN_VALUE);
                }
            }
        }
        int[] curRow = new int[n];
        return solve(0, introvertsCount, extrovertsCount, 0, curRow, new int[n]);
    }

    private int solve(int pos, int intro, int extro, int prevMask, int[] curRow, int[] prevRowArr) {
        if (pos == m * n || (intro == 0 && extro == 0)) {
            return 0;
        }
        int col = pos % n;
        // Encode curRow as base-3
        int curMask = 0;
        for (int i = 0; i < n; i++) {
            curMask += curRow[i] * powers[i];
        }
        if (memo[pos][intro][extro][prevMask] != Integer.MIN_VALUE && col == 0) {
            return memo[pos][intro][extro][prevMask];
        }

        int top = prevRowArr[col];
        int left = (col > 0) ? curRow[col - 1] : 0;

        // Option 0: empty
        int best = solve(pos + 1, intro, extro, prevMask, curRow, prevRowArr);

        // Option 1: introvert
        if (intro > 0) {
            int delta = INTRO_BASE + interaction(1, top) + interaction(1, left);
            curRow[col] = 1;
            int next;
            if (col == n - 1) {
                // start new row
                int newPrevMask = curMask + curRow[col] * powers[col];
                // but curRow[col] already set
                int nm = 0;
                for (int i = 0; i < n; i++) {
                    nm += curRow[i] * powers[i];
                }
                next = solve(pos + 1, intro - 1, extro, nm, new int[n], curRow);
            } else {
                next = solve(pos + 1, intro - 1, extro, prevMask, curRow, prevRowArr);
            }
            best = Math.max(best, delta + next);
            curRow[col] = 0;
        }

        // Option 2: extrovert
        if (extro > 0) {
            int delta = EXTRO_BASE + interaction(2, top) + interaction(2, left);
            curRow[col] = 2;
            int next;
            if (col == n - 1) {
                int nm = 0;
                for (int i = 0; i < n; i++) {
                    nm += curRow[i] * powers[i];
                }
                next = solve(pos + 1, intro, extro - 1, nm, new int[n], curRow);
            } else {
                next = solve(pos + 1, intro, extro - 1, prevMask, curRow, prevRowArr);
            }
            best = Math.max(best, delta + next);
            curRow[col] = 0;
        }

        if (col == 0) {
            memo[pos][intro][extro][prevMask] = best;
        }
        return best;
    }
}
