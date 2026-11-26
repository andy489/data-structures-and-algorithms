// https://leetcode.com/problems/shortest-path-to-get-all-keys/

// Solution: BFS with State (Position + Keys Bitmask) — O(m*n*2^k) time, O(m*n*2^k) space
class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        int startR = 0, startC = 0, allKeys = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = grid[r].charAt(c);
                if (ch == '@') { startR = r; startC = c; }
                else if (ch >= 'a' && ch <= 'f') allKeys |= (1 << (ch - 'a'));
            }
        }
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new int[]{startR, startC, 0});
        visited.add(startR + "," + startC + ",0");
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int q = 0; q < size; q++) {
                int[] cur = queue.poll();
                int r = cur[0], c = cur[1], keys = cur[2];
                if (keys == allKeys) { return steps; }
                for (int[] d : dirs) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) { continue; }
                    char ch = grid[nr].charAt(nc);
                    if (ch == '#') { continue; }
                    if (ch >= 'A' && ch <= 'F' && (keys & (1 << (ch - 'A'))) == 0) { continue; }
                    int nkeys = keys;
                    if (ch >= 'a' && ch <= 'f') { nkeys |= (1 << (ch - 'a')); }
                    String state = nr + "," + nc + "," + nkeys;
                    if (!visited.contains(state)) {
                        visited.add(state);
                        queue.offer(new int[]{nr, nc, nkeys});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
