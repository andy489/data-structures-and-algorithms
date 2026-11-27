// https://leetcode.com/problems/sort-matrix-by-diagonals/
class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        Map<Integer, List<Integer>> diags = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                diags.computeIfAbsent(key, x -> new ArrayList<>()).add(grid[i][j]);
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : diags.entrySet()) {
            List<Integer> vals = entry.getValue();
            if (entry.getKey() >= 0) {
                vals.sort(Collections.reverseOrder());
            } else {
                Collections.sort(vals);
            }
        }
        Map<Integer, Integer> idx = new HashMap<>();
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                int pos = idx.getOrDefault(key, 0);
                res[i][j] = diags.get(key).get(pos);
                idx.put(key, pos + 1);
            }
        }
        return res;
    }
}
