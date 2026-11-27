// https://leetcode.com/problems/maximum-building-height/

// Solution: Two-Pass Restriction Propagation — O(r log r) time, O(r) space
class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int m = restrictions.length;
        int[][] r = new int[m + 2][2];
        r[0] = new int[]{1, 0};
        for (int i = 0; i < m; i++) {
            r[i + 1] = restrictions[i];
        }
        r[m + 1] = new int[]{n, n - 1};
        Arrays.sort(r, (a, b) -> a[0] - b[0]);

        int len = r.length;
        // Left pass
        for (int i = 1; i < len; i++) {
            r[i][1] = Math.min(r[i][1], r[i - 1][1] + r[i][0] - r[i - 1][0]);
        }
        // Right pass
        for (int i = len - 2; i >= 0; i--) {
            r[i][1] = Math.min(r[i][1], r[i + 1][1] + r[i + 1][0] - r[i][0]);
        }

        int ans = 0;
        for (int i = 1; i < len; i++) {
            int a = r[i - 1][0], ha = r[i - 1][1];
            int b = r[i][0], hb = r[i][1];
            int peak = (ha + hb + b - a) / 2;
            ans = Math.max(ans, peak);
        }
        return ans;
    }
}
