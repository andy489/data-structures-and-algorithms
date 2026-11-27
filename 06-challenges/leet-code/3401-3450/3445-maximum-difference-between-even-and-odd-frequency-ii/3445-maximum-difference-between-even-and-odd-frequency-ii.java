// https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-ii/
class Solution {
    public int maxDifference(String s, int k) {
        int n = s.length();
        int res = Integer.MIN_VALUE;
        for (int a = 0; a <= 4; a++) {
            for (int b = 0; b <= 4; b++) {
                if (a == b) {
                    continue;
                }
                int[] prefA = new int[n + 1];
                int[] prefB = new int[n + 1];
                for (int i = 0; i < n; i++) {
                    int d = s.charAt(i) - '0';
                    prefA[i + 1] = prefA[i] + (d == a ? 1 : 0);
                    prefB[i + 1] = prefB[i] + (d == b ? 1 : 0);
                }
                // best[pa][pb] = min(prefA[l] - prefB[l]) for valid l's (l+k <= r) with prefB[l] < prefB[r]
                int[][] best = new int[2][2];
                for (int[] row : best) {
                    java.util.Arrays.fill(row, Integer.MAX_VALUE / 2);
                }
                for (int r = k; r <= n; r++) {
                    int l = r - k;
                    int paL = prefA[l] % 2;
                    int pbL = prefB[l] % 2;
                    if (prefB[l] < prefB[r]) {
                        int val = prefA[l] - prefB[l];
                        if (val < best[paL][pbL]) {
                            best[paL][pbL] = val;
                        }
                    }
                    int paR = prefA[r] % 2;
                    int pbR = prefB[r] % 2;
                    int neededPa = 1 - paR;
                    int neededPb = pbR;
                    int bv = best[neededPa][neededPb];
                    if (bv < Integer.MAX_VALUE / 2) {
                        int candidate = (prefA[r] - prefB[r]) - bv;
                        if (candidate > res) {
                            res = candidate;
                        }
                    }
                }
            }
        }
        return res;
    }
}
