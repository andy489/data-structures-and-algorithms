// https://leetcode.com/problems/minimum-knight-moves/

// Solution: BFS — O(|x|*|y|) time, O(|x|*|y|) space
class Solution {
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x); y = Math.abs(y);
        int[][] dirs = {{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        Map<Long, Boolean> visited = new HashMap<>();
        visited.put(0L, true);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == x && cur[1] == y) return cur[2];
            for (int[] d : dirs) {
                int nx = cur[0]+d[0], ny = cur[1]+d[1];
                long key = (long)(nx+310)*1000+(ny+310);
                if (nx >= -2 && ny >= -2 && !visited.containsKey(key)) {
                    visited.put(key, true);
                    q.offer(new int[]{nx, ny, cur[2]+1});
                }
            }
        }
        return -1;
    }
}
