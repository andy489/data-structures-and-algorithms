// https://leetcode.com/problems/count-good-integers-on-a-grid-path/
class Solution {
    private int[] pathPos;
    private long[] memo;

    public long countGoodIntegers(long l, long r, String directions) {
        pathPos = computePath(directions);
        memo = new long[16 * 2 * 10 * 8];
        java.util.Arrays.fill(memo, -1);
        return countUpTo(r) - countUpTo(l - 1);
    }

    private int[] computePath(String directions) {
        int[] pos = new int[7];
        int row = 0, col = 0;
        pos[0] = row * 4 + col;
        for (int i = 0; i < 6; i++) {
            if (directions.charAt(i) == 'D') {
                row++;
            } else {
                col++;
            }
            pos[i + 1] = row * 4 + col;
        }
        return pos;
    }

    private long countUpTo(long n) {
        if (n <= 0) {
            return 0;
        }
        String s = String.format("%016d", n);
        java.util.Arrays.fill(memo, -1);
        return dp(s, 0, true, -1, 0);
    }

    private long dp(String s, int pos, boolean tight, int lastPathVal, int pathIdx) {
        if (pos == 16) {
            return pathIdx == 7 ? 1 : 0;
        }
        int key = pos * (2 * 10 * 8) + (tight ? 1 : 0) * (10 * 8) + (lastPathVal + 1) * 8 + pathIdx;
        if (!tight && memo[key] != -1) {
            return memo[key];
        }
        int limit = tight ? (s.charAt(pos) - '0') : 9;
        long res = 0;
        for (int d = 0; d <= limit; d++) {
            boolean isPathPos = (pathIdx < 7 && pathPos[pathIdx] == pos);
            if (isPathPos) {
                if (lastPathVal == -1 || d >= lastPathVal) {
                    res += dp(s, pos + 1, tight && (d == limit), d, pathIdx + 1);
                }
            } else {
                res += dp(s, pos + 1, tight && (d == limit), lastPathVal, pathIdx);
            }
        }
        if (!tight) {
            memo[key] = res;
        }
        return res;
    }
}
