// https://leetcode.com/problems/rank-transform-of-a-matrix/

// Solution: Sort + Union-Find by Value — O(m*n*log(m*n)*α(m+n)) time, O(m*n) space
class Solution {
    private int[] parent;

    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] ans = new int[m][n];
        int[] rowRank = new int[m], colRank = new int[n];

        TreeMap<Integer, List<int[]>> grouped = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grouped.computeIfAbsent(matrix[i][j], k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        for (Map.Entry<Integer, List<int[]>> entry : grouped.entrySet()) {
            List<int[]> cells = entry.getValue();
            parent = new int[m + n];
            for (int i = 0; i < m + n; i++) {
                parent[i] = i;
            }
            for (int[] cell : cells) {
                union(cell[0], m + cell[1]);
            }
            Map<Integer, Integer> rootMax = new HashMap<>();
            for (int[] cell : cells) {
                int root = find(cell[0]);
                int cur = Math.max(rowRank[cell[0]], colRank[cell[1]]);
                rootMax.merge(root, cur, Math::max);
            }
            for (int[] cell : cells) {
                int r = cell[0], c = cell[1];
                int rank = rootMax.get(find(r)) + 1;
                ans[r][c] = rank;
                rowRank[r] = Math.max(rowRank[r], rank);
                colRank[c] = Math.max(colRank[c], rank);
            }
        }
        return ans;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int px = find(x), py = find(y);
        if (px != py) {
            parent[px] = py;
        }
    }
}
