// https://leetcode.com/problems/tiling-a-rectangle-with-the-fewest-squares/

// Solution: DFS with Backtracking — O(exponential, bounded) time, O(n*m) space
// Solution: DFS with Backtracking — O(exp) time, O(n*m) space
class Solution {
    int res;
    public int tilingRectangle(int n, int m) {
        res = n * m;
        dfs(new int[m], 0, n, m);
        return res;
    }
    private void dfs(int[] sky, int count, int n, int m) {
        if (count >= res) return;
        int minH = Integer.MAX_VALUE, pos = -1;
        for (int j = 0; j < m; j++) if (sky[j] < minH) { minH = sky[j]; pos = j; }
        if (minH == n) { res = count; return; }
        int maxSz = Math.min(n - minH, m - pos);
        for (int sz = maxSz; sz >= 1; sz--) {
            boolean valid = true;
            for (int j = pos; j < pos + sz; j++) if (sky[j] != minH) { valid = false; break; }
            if (valid) {
                int[] backup = sky.clone();
                for (int j = pos; j < pos + sz; j++) sky[j] += sz;
                dfs(sky, count + 1, n, m);
                sky = backup;
            }
        }
    }
}
