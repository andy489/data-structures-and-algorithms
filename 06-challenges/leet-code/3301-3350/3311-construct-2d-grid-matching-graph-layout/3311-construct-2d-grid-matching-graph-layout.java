// https://leetcode.com/problems/construct-2d-grid-matching-graph-layout/

class Solution {
    public int[][] constructGridLayout(int n, int[][] edges) {
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int[] deg = new int[n];
        for (int i = 0; i < n; i++) {
            deg[i] = adj.get(i).size();
        }
        // Determine rows and cols
        // Find col count: a corner is a node with min degree
        int minDeg = Integer.MAX_VALUE;
        for (int d : deg) {
            minDeg = Math.min(minDeg, d);
        }
        // Start from a corner node
        int start = -1;
        for (int i = 0; i < n; i++) {
            if (deg[i] == minDeg) {
                start = i;
                break;
            }
        }
        // Build first row: greedy walk along nodes that have min degree neighbors
        // For the first row, the row ends when we can't extend with a node of same row degree
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(start);
        boolean[] inRow = new boolean[n];
        inRow[start] = true;
        // The row continues as long as the next node has degree <= minDeg+1 and is adjacent
        // Actually: determine cols by finding how long the first row is
        // First row nodes connect to: 1 or 2 horizontal neighbors + 0 or 1 vertical
        // A corner (minDeg=2 or 1) only connects to 1 horizontal + 1 vertical (or just 1 if single row)
        // For general case: build first row by picking neighbors that themselves have degree minDeg or minDeg+1
        // Check if this is a single-row case (minDeg == 1)
        if (minDeg == 1) {
            // Single row: just traverse the chain
            while (true) {
                int cur = firstRow.get(firstRow.size() - 1);
                boolean extended = false;
                for (int nb : adj.get(cur)) {
                    if (!inRow[nb]) {
                        firstRow.add(nb);
                        inRow[nb] = true;
                        extended = true;
                        break;
                    }
                }
                if (!extended) {
                    break;
                }
            }
            int[][] grid = new int[1][n];
            for (int i = 0; i < n; i++) {
                grid[0][i] = firstRow.get(i);
            }
            return grid;
        }
        // Multi-row case
        // Extend first row: a node belongs to the first row if it has a neighbor with degree == minDeg
        // or the previous node in the row
        // Simpler: continue the first row as long as next candidate has degree <= minDeg + 1
        while (true) {
            int cur = firstRow.get(firstRow.size() - 1);
            int next = -1;
            for (int nb : adj.get(cur)) {
                if (!inRow[nb] && deg[nb] <= minDeg + 1) {
                    next = nb;
                    break;
                }
            }
            if (next == -1) {
                break;
            }
            firstRow.add(next);
            inRow[next] = true;
        }
        int cols = firstRow.size();
        int rows = n / cols;
        int[][] grid = new int[rows][cols];
        for (int c = 0; c < cols; c++) {
            grid[0][c] = firstRow.get(c);
        }
        boolean[] placed = new boolean[n];
        for (int v : firstRow) {
            placed[v] = true;
        }
        for (int r = 1; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int above = grid[r - 1][c];
                for (int nb : adj.get(above)) {
                    if (!placed[nb]) {
                        if (c == 0 || adj.get(nb).contains(grid[r][c - 1])) {
                            grid[r][c] = nb;
                            placed[nb] = true;
                            break;
                        }
                    }
                }
            }
        }
        return grid;
    }
}
