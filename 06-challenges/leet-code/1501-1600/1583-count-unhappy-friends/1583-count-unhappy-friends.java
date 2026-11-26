// https://leetcode.com/problems/count-unhappy-friends/

// Solution: Rank Preprocessing — O(n^2) time, O(n^2) space
class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] rank = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                rank[i][preferences[i][j]] = j;
            }
        }
        int[] paired = new int[n];
        for (int[] pair : pairs) {
            paired[pair[0]] = pair[1];
            paired[pair[1]] = pair[0];
        }
        int count = 0;
        for (int x = 0; x < n; x++) {
            int y = paired[x];
            for (int u = 0; u < n; u++) {
                if (u == x || u == y) continue;
                int v = paired[u];
                if (rank[x][u] < rank[x][y] && rank[u][x] < rank[u][v]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
