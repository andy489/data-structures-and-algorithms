// https://leetcode.com/problems/minimum-degree-of-a-connected-trio-in-a-graph/

// Solution: Adjacency Matrix Enumeration — O(n^3) time, O(n^2) space
class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        boolean[][] adj = new boolean[n + 1][n + 1];
        int[] deg = new int[n + 1];
        for (int[] e : edges) {
            adj[e[0]][e[1]] = true;
            adj[e[1]][e[0]] = true;
            deg[e[0]]++;
            deg[e[1]]++;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (!adj[i][j]) continue;
                for (int k = j + 1; k <= n; k++) {
                    if (adj[i][k] && adj[j][k]) {
                        ans = Math.min(ans, deg[i] + deg[j] + deg[k] - 6);
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
