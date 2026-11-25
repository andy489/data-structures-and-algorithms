// https://leetcode.com/problems/grid-illumination/

// Solution: Hash Maps for Rows/Cols/Diagonals — O((L+Q)·9) time, O(L) space
class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        HashMap<Integer, Integer> row = new HashMap<>(), col = new HashMap<>(),
            diag = new HashMap<>(), anti = new HashMap<>();
        HashSet<Long> lit = new HashSet<>();
        for (int[] lamp : lamps) {
            long key = (long) lamp[0] * 1_000_000_007L + lamp[1];
            if (lit.add(key)) {
                row.merge(lamp[0], 1, Integer::sum);
                col.merge(lamp[1], 1, Integer::sum);
                diag.merge(lamp[0] - lamp[1], 1, Integer::sum);
                anti.merge(lamp[0] + lamp[1], 1, Integer::sum);
            }
        }
        int[] ans = new int[queries.length];
        int[][] dirs = {{0,0},{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        for (int q = 0; q < queries.length; q++) {
            int r = queries[q][0], c = queries[q][1];
            if (row.getOrDefault(r, 0) > 0 || col.getOrDefault(c, 0) > 0
                || diag.getOrDefault(r - c, 0) > 0 || anti.getOrDefault(r + c, 0) > 0) {
                ans[q] = 1;
            }
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    continue;
                }
                long key = (long) nr * 1_000_000_007L + nc;
                if (lit.remove(key)) {
                    row.merge(nr, -1, Integer::sum);
                    col.merge(nc, -1, Integer::sum);
                    diag.merge(nr - nc, -1, Integer::sum);
                    anti.merge(nr + nc, -1, Integer::sum);
                }
            }
        }
        return ans;
    }
}
