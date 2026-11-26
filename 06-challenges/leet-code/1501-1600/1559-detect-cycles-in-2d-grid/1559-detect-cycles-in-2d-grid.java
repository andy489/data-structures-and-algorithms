// https://leetcode.com/problems/detect-cycles-in-2d-grid/

// Solution: Union-Find — O(m * n * alpha) time, O(m * n) space
class Solution {
    private int[] parent, rank;

    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        parent = new int[m * n];
        rank = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            parent[i] = i;
        }
        int[][] dirs = {{0, 1}, {1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] d : dirs) {
                    int ni = i + d[0], nj = j + d[1];
                    if (ni < m && nj < n && grid[ni][nj] == grid[i][j]) {
                        int a = find(i * n + j), b = find(ni * n + nj);
                        if (a == b) {
                            return true;
                        }
                        union(a, b);
                    }
                }
            }
        }
        return false;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int a, int b) {
        if (rank[a] < rank[b]) {
            parent[a] = b;
        } else if (rank[a] > rank[b]) {
            parent[b] = a;
        } else {
            parent[b] = a;
            rank[a]++;
        }
    }
}
