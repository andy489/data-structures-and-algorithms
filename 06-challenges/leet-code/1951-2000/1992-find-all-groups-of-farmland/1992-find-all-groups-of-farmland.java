// https://leetcode.com/problems/find-all-groups-of-farmland/
class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length, n = land[0].length;
        List<int[]> result = new ArrayList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (land[r][c] == 1) {
                    int r2 = r, c2 = c;
                    while (r2 + 1 < m && land[r2 + 1][c] == 1) {
                        r2++;
                    }
                    while (c2 + 1 < n && land[r][c2 + 1] == 1) {
                        c2++;
                    }
                    result.add(new int[]{r, c, r2, c2});
                    for (int i = r; i <= r2; i++) {
                        for (int j = c; j <= c2; j++) {
                            land[i][j] = 0;
                        }
                    }
                }
            }
        }
        return result.toArray(new int[0][]);
    }
}
