// https://leetcode.com/problems/zigzag-grid-traversal-with-skip/

class Solution {
    public int[] zigzagTraversal(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<Integer> result = new ArrayList<>();
        int skip = 0;
        for (int i = 0; i < m; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    if (skip % 2 == 0) {
                        result.add(grid[i][j]);
                    }
                    skip++;
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    if (skip % 2 == 0) {
                        result.add(grid[i][j]);
                    }
                    skip++;
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
